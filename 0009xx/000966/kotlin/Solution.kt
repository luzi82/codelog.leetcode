import java.util.*

class Solution {
    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val wordSet=HashSet<String>()
        val wordLowToWordMap=HashMap<String,String>()
        val wordVowToWordMap=HashMap<String,String>()
        
        for(word in wordlist){
            wordSet.add(word)
            val wordLow = word.toLowerCase()
            if(!wordLowToWordMap.containsKey(wordLow)){
                wordLowToWordMap.put(wordLow,word)
            }
            var wordVow = toVow(wordLow)
            if(!wordVowToWordMap.containsKey(wordVow)){
                wordVowToWordMap.put(wordVow,word)
            }
        }
        
        val retAry = Array<String>(queries.size){""}
        for(i in queries.indices){
            val q=queries[i]
            if(wordSet.contains(q)){
                retAry[i] = q
                continue
            }
            val qLow = q.toLowerCase()
            if(wordLowToWordMap.containsKey(qLow)){
                retAry[i] = wordLowToWordMap.get(qLow)!!
                continue
            }
            val qVow = toVow(qLow)
            if(wordVowToWordMap.containsKey(qVow)){
                retAry[i] = wordVowToWordMap.get(qVow)!!
                continue
            }
        }
        return retAry
    }
    
    fun toVow(s:String):String{
        var ret=s
        ret=ret.replace('a','*')
        ret=ret.replace('e','*')
        ret=ret.replace('i','*')
        ret=ret.replace('o','*')
        ret=ret.replace('u','*')
        return ret
    }
}
