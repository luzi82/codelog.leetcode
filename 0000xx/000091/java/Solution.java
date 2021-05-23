class Solution {
    public int numDecodings(String s) {
        int[] cDoneToCnt = new int[s.length()+1];
        cDoneToCnt[0] = 1;
        for(int start=0;start<s.length();++start){
            if(s.charAt(start)=='0'){continue;}
            if(cDoneToCnt[start]==0)continue;
            for(int len=1;len<=2;++len){
                int end = start+len;
                if(end>s.length())break;
                String subStr = s.substring(start,end);
                int v = Integer.parseInt(subStr);
                if(v<1)continue;
                if(v>26)continue;
                cDoneToCnt[end]+=cDoneToCnt[start];
            }
        }
        return cDoneToCnt[cDoneToCnt.length-1];
    }
}
