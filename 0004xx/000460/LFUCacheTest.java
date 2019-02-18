import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class LFUCache {

    // ring shape, bidirectional linkedlist
    public static class LinkedListNode<T>{
        public T value;
        public LinkedListNode left;
        public LinkedListNode right;
        
        public LinkedListNode(){
            left=this;
            right=this;
        }
        
        void insertRight(T newValue){
            LinkedListNode newNode = new LinkedListNode();
            newNode.value=newValue;

            LinkedListNode oldRight = right;

            right = newNode;
            newNode.left = this;

            oldRight.left = newNode;
            newNode.right = oldRight;
        }
        
        void pop(){
            left.right = right;
            right.left = left;
        }
    }
    
    public static class FreqInfo{
        public int freq;
        public LinkedListNode<FreqTimeInfo> freqTimeNode=new LinkedListNode<>(); // new <-> old
    }
    
    public static class FreqTimeInfo{
        public LinkedListNode<FreqInfo> parentFreqNode; // parent pointer
        public int key;
    }

    public LinkedListNode<FreqInfo> rootFreqNode=new LinkedListNode<>(); // less <-> more
    public HashMap<Integer,LinkedListNode<FreqTimeInfo> > freqTimeDict=new HashMap<>();
    public HashMap<Integer,Integer> keyValueDict=new HashMap<>();
    int capacity;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(capacity<=0)return -1;
        if(keyValueDict.containsKey(key)){
            upFreq(key);
            return keyValueDict.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity<=0)return;
        if(keyValueDict.containsKey(key)){
            upFreq(key);
            keyValueDict.put(key,value);
            return;
        }
        while(keyValueDict.size()>=capacity){
            pop();
        }
        LinkedListNode<FreqInfo> freqNode = rootFreqNode.right;
        if((freqNode.value==null)||(freqNode.value.freq!=1)){
            FreqInfo newFreqInfo = new FreqInfo();
            newFreqInfo.freq = 1;
            rootFreqNode.insertRight(newFreqInfo);
            freqNode = rootFreqNode.right;
        }
        
        FreqTimeInfo freqTimeInfo = new FreqTimeInfo();
        freqTimeInfo.parentFreqNode = freqNode;
        freqTimeInfo.key = key;
        freqNode.value.freqTimeNode.insertRight(freqTimeInfo);
        LinkedListNode<FreqTimeInfo> freqTimeNode = freqNode.value.freqTimeNode.right;
        
        keyValueDict.put(key,value);
        freqTimeDict.put(key,freqTimeNode);
    }
    
    public void upFreq(int key){
        // get current llu
        LinkedListNode<FreqTimeInfo> freqTimeNode = freqTimeDict.get(key);
        LinkedListNode<FreqInfo> parentFreqNode = freqTimeNode.value.parentFreqNode;
        
        // find or create +1 freq
        LinkedListNode<FreqInfo> parentFreqNode1 = parentFreqNode.right;
        if((parentFreqNode1.value==null)||(parentFreqNode1.value.freq!=parentFreqNode.value.freq+1)){
            FreqInfo newFreqInfo = new FreqInfo();
            newFreqInfo.freq = parentFreqNode.value.freq+1;
            parentFreqNode.insertRight(newFreqInfo);
            parentFreqNode1 = parentFreqNode.right;
        }
        
        // pop from old freq
        freqTimeNode.pop();
        
        // insert to new freq
        FreqTimeInfo newFreqTimeInfo = new FreqTimeInfo();
        newFreqTimeInfo.parentFreqNode = parentFreqNode1;
        newFreqTimeInfo.key = key;
        parentFreqNode1.value.freqTimeNode.insertRight(newFreqTimeInfo);
        
        // if old freq empty, remove old freq
        if(parentFreqNode.value.freqTimeNode.right == parentFreqNode.value.freqTimeNode){
            parentFreqNode.pop();
        }

        // update dict
        freqTimeDict.put(key,parentFreqNode1.value.freqTimeNode.right);
    }
    
    public void pop(){
        // get info
        LinkedListNode<FreqInfo> lastFreqNode = rootFreqNode.right;
        LinkedListNode<FreqTimeInfo> lastFreqTimeNode = lastFreqNode.value.freqTimeNode.left;
        int key = lastFreqTimeNode.value.key;
        
        // pop FreqTimeInfo
        lastFreqTimeNode.pop();
        
        // pop FreqInfo if empty
        if(lastFreqNode.value.freqTimeNode.right == lastFreqNode.value.freqTimeNode){
            lastFreqNode.pop();
        }
        
        // remove key from dict
        freqTimeDict.remove(key);
        keyValueDict.remove(key);
        
        //System.out.println(String.format("pop %d",key));
    }

    public static void main(String[] argv){
        LFUCache cache = new LFUCache(2);
        cache.tput(1,1);
        cache.tput(2,2);
        cache.tget(1,1);
        cache.tput(3,3);
        cache.tget(2,-1);
        cache.tget(3,3);
        cache.tput(4,4);
        cache.tget(1,-1);
        cache.tget(3,3);
        cache.tget(4,4);
        
        System.out.println("==========");
        
        Random random=new Random();
        cache = new LFUCache(5);
        for(int i=0;i<10000;++i){
            int rand=Math.abs(random.nextInt())%2;
            if(rand==0){
                rand=Math.abs(random.nextInt())%10;
                cache.ttput(rand,rand);
            }else{
                rand=Math.abs(random.nextInt())%10;
                cache.ttget(rand);
            }
        }
    }
    
    public void tput(int k,int v){
        System.out.println(String.format("put %d %d",k,v));
        put(k,v);
    }
    
    public void tget(int k,int v){
        System.out.println(String.format("get %d=%d",k,v));
        int vv = get(k);
        System.out.println(String.format("result %d",vv));
        aassert(v==vv);
    }
    
    static public class TestMem implements Comparable<TestMem>{
        public int freq;
        public int time;
        public int key;
        public int compareTo(TestMem other){
            if(freq<other.freq)return -1;
            if(freq>other.freq)return 1;
            if(time<other.time)return -1;
            if(time>other.time)return 1;
            if(key<other.key)return -1;
            if(key>other.key)return 1;
            return 0;
        }
    }
    
    public TreeSet<TestMem> testMemSet = new TreeSet<>();
    public HashMap<Integer,Integer> testMap = new HashMap<>();
    public HashMap<Integer,TestMem> testMemMap = new HashMap<>();
    public int ttime = 1;
    
    public void ttput(int k,int v){
        System.out.println(String.format("put %d %d",k,v));
        put(k,v);
        
        if(testMap.containsKey(k)){
            testMap.put(k,v);
            TestMem tm = testMemMap.remove(k);
            testMemSet.remove(tm);
            tm.freq++;
            tm.time = ttime++;
            testMemSet.add(tm);
            testMemMap.put(k,tm);
        }else{
            while(testMap.size()>=capacity){
                TestMem tm=testMemSet.pollFirst();
                testMap.remove(tm.key);
                testMemMap.remove(tm.key);
            }
            TestMem tm = new TestMem();
            tm.freq = 1;
            tm.time = ttime++;
            tm.key = k;
            testMap.put(k,v);
            testMemSet.add(tm);
            testMemMap.put(k,tm);
        }
        
        ttp();
    }
    
    public void ttget(int k){
        System.out.println(String.format("get %d",k));
        int actual = get(k);
        int expected = -1;
        
        if(testMap.containsKey(k)){
            expected = testMap.get(k);
            TestMem tm = testMemMap.remove(k);
            testMemSet.remove(tm);
            tm.freq++;
            tm.time = ttime++;
            testMemSet.add(tm);
            testMemMap.put(k,tm);
        }
        
        ttp();

        System.out.println(String.format("actual=%d, expected=%d",actual,expected));
        
        aassert(actual==expected);
    }
    
    public void ttp(){
        int[] ttf = new int[10];
        int[] ttt = new int[10];

        int[] taf = new int[10];

        for(int i=0;i<10;++i){
            if(testMemMap.containsKey(i)){
                ttf[i] = testMemMap.get(i).freq;
            }else{
                ttf[i] = 0;
            }
            if(testMemMap.containsKey(i)){
                ttt[i] = testMemMap.get(i).time;
            }else{
                ttt[i] = 0;
            }
            if(freqTimeDict.containsKey(i)){
                taf[i] = freqTimeDict.get(i).value.parentFreqNode.value.freq;
            }
        }

        System.out.println(String.format("f %s",Arrays.toString(ttf)));
        System.out.println(String.format("a %s",Arrays.toString(taf)));
        System.out.println(String.format("t %s",Arrays.toString(ttt)));
        
        LinkedListNode<FreqInfo> freqNode = rootFreqNode;
        rootFreqNode=rootFreqNode.right;
        while(rootFreqNode.value!=null){
            System.out.println(String.format("freq=%d",rootFreqNode.value.freq));
            LinkedListNode<FreqTimeInfo> freqTimeNode = rootFreqNode.value.freqTimeNode;
            freqTimeNode=freqTimeNode.right;
            while(freqTimeNode.value!=null){
                System.out.println(String.format("  node=%d",freqTimeNode.value.key));
                freqTimeNode=freqTimeNode.right;
            }
            rootFreqNode=rootFreqNode.right;
        }
        
        aassert(Arrays.equals(ttf,taf));
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
