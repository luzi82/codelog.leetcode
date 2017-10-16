import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;
import java.io.*;

class Test {

    public static void main(String[] argv){
        try{
            Random random = new Random();
            for(int ttt=0;ttt<100;++ttt){
                System.out.println(String.format("case %d",ttt));
                int len=(ttt<5)?ttt:random.nextInt(100);
                char[] content = new char[len];
                for(int i=0;i<len;++i){
                    content[i] = (char)('a'+random.nextInt(26));
                }
                Solution solution = new Solution();
                solution._contentAry = content;
                
                char[] buf0=new char[20];
                char[] buf1=new char[20];
                CharArrayReader sampleReader = new CharArrayReader(content);
                int done = 0;
                while(done < len){
                    int readLen = random.nextInt(10);
                    int ret0 = sampleReader.read(buf0,0,readLen);
                    int ret1 = solution.read(buf1,readLen);
                    aassert(ret0 == ret1);
                    for(int i=0;i<ret0;++i){
                        aassert(buf0[i]==buf1[i]);
                    }
                    done += readLen;
                }
                int readLen = random.nextInt(10);
                int ret1 = solution.read(buf1,readLen);
                aassert(0 == ret1);
            }
            
            char[] buf=new char[100];
            Solution solution = new Solution();
            solution._contentAry = "ab".toCharArray();
            solution.read(buf,0);
            solution.read(buf,1);
            solution.read(buf,2);
            solution.read(buf,1);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
