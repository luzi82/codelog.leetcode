import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int accCnt = accounts.size();
        int[] accIdToSetId = new int[accCnt];
        for(int accId=0;accId<accCnt;++accId){
            accIdToSetId[accId] = accId;
        }
        
        String[] accIdToName = new String[accCnt];
        HashMap<String,Integer> emailToAccIdMap = new HashMap<>();
        HashSet<String>[] accIdToEmailSetAry = new HashSet[accCnt];
        for(int accId=0;accId<accCnt;++accId){
            accIdToEmailSetAry[accId] = new HashSet<String>();
        }
        
        {
            int accId=0;
            for(List<String> acc:accounts){
                int myAccId = accId;
                boolean nameDone = false;
                for(String str:acc){
                    if(!nameDone){
                        accIdToName[accId] = str;
                        nameDone=true;
                        continue;
                    }
                    if(emailToAccIdMap.containsKey(str)){
                        int tarAccId = emailToAccIdMap.get(str);
                        myAccId = joinSet(myAccId,tarAccId,accIdToSetId);
                    }
                    emailToAccIdMap.put(str,myAccId);
                    accIdToEmailSetAry[myAccId].add(str);
                }
                ++accId;
            }
        }
        
        LinkedList<List<String>> retAccList = new LinkedList<>();
        for(int accId=accCnt-1;accId>=0;--accId){
            int tarSetId = getSetId(accId,accIdToSetId);
            if(tarSetId==accId){
                LinkedList<String> acc = new LinkedList<>();
                acc.add(accIdToName[accId]);
                String[] emailAry = accIdToEmailSetAry[accId].toArray(new String[0]);
                Arrays.sort(emailAry);
                for(String email:emailAry){
                    acc.add(email);
                }
                retAccList.add(acc);
            }else{
                accIdToEmailSetAry[tarSetId].addAll(accIdToEmailSetAry[accId]);
            }
        }
        
        return retAccList;
    }
    
    public int getSetId(int accId,int[] accIdToSetId){
        if(accIdToSetId[accId]==accId)return accId;
        int ret = getSetId(accIdToSetId[accId],accIdToSetId);
        accIdToSetId[accId] = ret;
        return ret;
    }
    
    public int joinSet(int aSetId, int bSetId, int[] accIdToSetId){
        int aaSetId = getSetId(aSetId,accIdToSetId);
        int bbSetId = getSetId(bSetId,accIdToSetId);
        if(aaSetId==bbSetId){return aaSetId;}
        int setId = Math.min(aaSetId,bbSetId);
        accIdToSetId[aSetId]=setId;
        accIdToSetId[aaSetId]=setId;
        accIdToSetId[bSetId]=setId;
        accIdToSetId[bbSetId]=setId;
        return setId;
    }
}
