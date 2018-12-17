import java.util.*;

class FreqStack {

    TreeMap<Integer,LinkedList<Integer>> levelToIdListMap = new TreeMap<>();
    HashMap<Integer,Integer> idToCountMap = new HashMap<>();

    public FreqStack() {
    }
    
    public void push(int id) {
        // idToCountMap[id] ++
        Integer idCount = idToCountMap.get(id);
        if(idCount==null)idCount = 0;
        ++idCount;
        idToCountMap.put(id,idCount);

        // levelToIdListMap[level] += id
        LinkedList<Integer> levelIdList = levelToIdListMap.get(idCount);
        if(levelIdList==null){
            levelIdList = new LinkedList<>();
            levelToIdListMap.put(idCount, levelIdList);
        }
        levelIdList.push(id);
    }
    
    public int pop() {
        // level[max] -= level
        int maxLevel = levelToIdListMap.lastKey();
        LinkedList<Integer> maxLevelIdList = levelToIdListMap.get(maxLevel);
        int popId = maxLevelIdList.pop();
        if(maxLevelIdList.size()==0){
            levelToIdListMap.remove(maxLevel);
        }
        
        // idToCountMap[id] --
        Integer idCount = idToCountMap.get(popId);
        --idCount;
        if(idCount==0){
            idToCountMap.remove(popId);
        }else{
            idToCountMap.put(popId,idCount);
        }
        
        return popId;
    }
    
    public static void main(String[] argv){
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        assertTrue(fs.pop()==5);
        assertTrue(fs.pop()==7);
        assertTrue(fs.pop()==5);
        assertTrue(fs.pop()==4);
    }

    public static void assertTrue(boolean v){
        if(!v)throw new Error();
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
