import java.util.*

class Solution {
    fun braceExpansionII(expression: String): List<String> {
        val parseResult:ParseResult = parse(expression.toCharArray(),0)
        var stringList = parseResult.stringList
        stringList = LinkedList<String>(stringList.toSet())
        stringList.sort()
        return stringList
    }
    
    fun parse(cAry:CharArray, start:Int): ParseResult{
        var stringBuilderList:LinkedList<StringBuilder> = LinkedList<StringBuilder>()
        stringBuilderList.add(StringBuilder())
        var i=start
        while(true){
            if(i>=cAry.size)break
            if(cAry[i]==',')break
            if(cAry[i]=='}')break
            if(cAry[i]=='{'){
                val parseResult:ParseResult = parseBarce(cAry,i+1)
                val stringBuilderList0:LinkedList<StringBuilder> = LinkedList<StringBuilder>()
                for(stringBuilder in stringBuilderList){
                    val stringBuilderStr = stringBuilder.toString()
                    for(str in parseResult.stringList){
                        val sb:StringBuilder=StringBuilder()
                        sb.append(stringBuilderStr)
                        sb.append(str)
                        stringBuilderList0.add(sb)
                    }
                }
                stringBuilderList = stringBuilderList0
                i=parseResult.end+1
                continue
            }else{
                for(stringBuilder in stringBuilderList){
                    stringBuilder.append(cAry[i])
                }
                i+=1
            }
        }
        var stringList:LinkedList<String> = LinkedList<String>()
        for(stringBuilder in stringBuilderList){
            stringList.add(stringBuilder.toString())
        }
        stringList = LinkedList<String>(stringList.toSet())
        
        return ParseResult(i,stringList)
    }
    
    fun parseBarce(cAry:CharArray, start:Int): ParseResult{
        var stringList:LinkedList<String> = LinkedList<String>()
        var i=start
        while(true){
            val parseResult:ParseResult = parse(cAry,i)
            stringList.addAll(parseResult.stringList)
            i = parseResult.end
            if(cAry[i]==','){
                i+=1
                continue
            }
            if(cAry[i]=='}'){
                break
            }
        }
        stringList = LinkedList<String>(stringList.toSet())
        
        return ParseResult(i,stringList)
    }
    
}

class ParseResult(val end:Int,val stringList:LinkedList<String>){}
