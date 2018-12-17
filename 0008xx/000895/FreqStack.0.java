import java.util.*;

class FreqStack {

    TreeMap<Integer,HashSet<Integer>> sizeToIdSetMap = new TreeMap<>();
    HashMap<Integer,TreeSet<Integer>> idToElementSetMap = new HashMap<>();
    
    int nextElement = 0;

    public FreqStack() {
    }
    
    public void push(int id) {
        TreeSet<Integer> idElementSet = idToElementSetMap.get(id);
        if(idElementSet==null){
            idElementSet = new TreeSet<>();
            idToElementSetMap.put(id,idElementSet);
        }

        int oldSize = idElementSet.size();
        if(oldSize>=1){
            HashSet<Integer> oldSizeIdSet = sizeToIdSetMap.get(oldSize);
            oldSizeIdSet.remove(id);
            if(oldSizeIdSet.size()<=0){
                sizeToIdSetMap.remove(oldSize);
            }
        }

        idElementSet.add(nextElement++);

        int newSize = idElementSet.size();
        HashSet<Integer> newSizeIdSet = sizeToIdSetMap.get(newSize);
        if(newSizeIdSet==null){
            newSizeIdSet = new HashSet<>();
            sizeToIdSetMap.put(newSize, newSizeIdSet);
        }
        
        newSizeIdSet.add(id);
    }
    
    public int pop() {
        int oldSize = sizeToIdSetMap.lastKey();
        HashSet<Integer> oldSizeIdSet = sizeToIdSetMap.get(oldSize);

        int maxElement = -1;
        int popId = -1;
        for(int id: oldSizeIdSet){
            int lastElement = idToElementSetMap.get(id).last();
            if(lastElement>maxElement){
                maxElement = lastElement;
                popId = id;
            }
        }

        oldSizeIdSet.remove(popId);
        if(oldSizeIdSet.isEmpty()){
            sizeToIdSetMap.remove(oldSize);
        }

        TreeSet<Integer> popIdElementSet = idToElementSetMap.get(popId);
        popIdElementSet.remove(maxElement);
        if(popIdElementSet.isEmpty()){
            idToElementSetMap.remove(popId);
        }

        int newSize = popIdElementSet.size();
        if(newSize>=1){
            HashSet<Integer> newSizeIdSet = sizeToIdSetMap.get(newSize);
            if(newSizeIdSet==null){
                newSizeIdSet = new HashSet<>();
                sizeToIdSetMap.put(newSize, newSizeIdSet);
            }
            newSizeIdSet.add(popId);
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
