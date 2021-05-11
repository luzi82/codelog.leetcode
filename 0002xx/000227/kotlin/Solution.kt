class Solution {
    
    fun calculate(s: String): Int {
        var v = 0
        var i = 0
        val ss = s.replace(" ","")
        val cAry = ss.toCharArray()
        while(i<cAry.size){
            val parse0Ret = parse0(cAry,i)
            v += parse0Ret.v
            i = parse0Ret.i
        }
        return v
    }
    
    fun parse0(cAry:CharArray, ii:Int):Ret{
        var i = ii
        var p1 = parse1(cAry, i)
        var v = p1.v
        i = p1.i

        while(true){
            if(i>=cAry.size){return Ret(i,v)}
            if(cAry[i]=='+'){return Ret(i,v)}
            if(cAry[i]=='-'){return Ret(i,v)}
            p1 = parse1(cAry,i+1)
            if(cAry[i]=='*'){
                v = v*p1.v
            }else{
                v = v/p1.v
            }
            i = p1.i
        }
    }
    
    fun parse1(cAry:CharArray, ii:Int):Ret{
        var i = ii
        var m = 1
        var v = 0
        if(cAry[i]=='+'){i++}
        if(cAry[i]=='-'){
            m=-1
            i++
        }
        while(true){
            if(i>=cAry.size){return Ret(i,v*m)}
            if(cAry[i]<'0'){return Ret(i,v*m)}
            if(cAry[i]>'9'){return Ret(i,v*m)}
            v *= 10
            v += cAry[i]-'0'
            ++i
        }
    }
 
 data class Ret(val i:Int,val v:Int)
 
}
