import java.util.*;

class Solution {
    public int minSwapsCouples(int[] row) {
        
        Map< Integer, Map < Integer, Integer> > linkCountMapMap = new HashMap<>();
        for(int i=0;i<row.length;i+=2){
            int c0 = row[i];
            int c1 = row[i+1];
            
            c0/=2;c1/=2;
            
            add(linkCountMapMap,c0,c1,1);
            add(linkCountMapMap,c1,c0,1);
        }
        
        int ret = 0;
        while(!linkCountMapMap.isEmpty()){
            Map.Entry< Integer, Map < Integer, Integer> > linkCountMapME = linkCountMapMap.entrySet().iterator().next();
            int start = linkCountMapME.getKey();
            int next = linkCountMapME.getValue().entrySet().iterator().next().getKey();
            remove(linkCountMapMap,start,next,1);
            remove(linkCountMapMap,next,start,1);
            while(next!=start){
                int next0 = linkCountMapMap.get(next).entrySet().iterator().next().getKey();
                remove(linkCountMapMap,next,next0,1);
                remove(linkCountMapMap,next0,next,1);
                next = next0;
                ++ ret;
            }
        }
        
        return ret;
    }
    
    void add(Map< Integer, Map < Integer, Integer> > linkCountMapMap, int k0, int k1, int v){
        if(!linkCountMapMap.containsKey(k0)){
            linkCountMapMap.put(k0, new HashMap<Integer, Integer>());
        }
        
        Map<Integer, Integer> linkCountMap = linkCountMapMap.get(k0);
        if(!linkCountMap.containsKey(k1)){
            linkCountMap.put(k1,0);
        }
        
        linkCountMap.put(k1,linkCountMap.get(k1)+v);
    }

    void remove(Map< Integer, Map < Integer, Integer> > linkCountMapMap, int k0, int k1, int v){
        int vv = linkCountMapMap.get(k0).get(k1);
        vv -= v;
        if(vv>0){
            linkCountMapMap.get(k0).put(k1,vv);
            return;
        }
        
        linkCountMapMap.get(k0).remove(k1);
        
        if(!linkCountMapMap.get(k0).isEmpty())return;
        
        linkCountMapMap.remove(k0);
    }

}