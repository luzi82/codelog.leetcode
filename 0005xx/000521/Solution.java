class Solution {
    public int findLUSlength(String a, String b) {
        // longer string is not subseq of any shorter subseq
        if(a.length()!=b.length())return Math.max(a.length(),b.length());
        
        // if a=b, -1 
        if(a.equals(b))return -1;
        
        // full a is not subseq of b, full b is not subseq of a
        return a.length();
    }
}