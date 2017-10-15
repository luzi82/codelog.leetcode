import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Test {

    public static void main(String[] argv){
        // question sample
        NumMatrix numMatrix=new NumMatrix(new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        });
        
        int actual,expected;

        actual = numMatrix.sumRegion(2, 1, 4, 3);
        expected = 8;
        System.out.println(String.format("expected=%d, actual=%d",expected,actual));
        aassert(actual == expected);

        numMatrix.update(3, 2, 2);

        actual = numMatrix.sumRegion(2, 1, 4, 3);
        expected = 10;
        System.out.println(String.format("expected=%d, actual=%d",expected,actual));
        aassert(actual == expected);
        
        // monkey test
        Random random=new Random();
        for(int c=0;c<100;++c){
            int[][] mirror = new int[5][5];
            int[][] matrix = new int[5][5];
            for(int i=0;i<5;++i)for(int j=0;j<5;++j){
                int rand=random.nextInt(201)-100;
                mirror[i][j]=rand;
                matrix[i][j]=rand;
            }
            numMatrix=new NumMatrix(matrix);
            for(int d=0;d<100;++d){
                int x0=random.nextInt(5);
                int x1=random.nextInt(5);
                int y0=random.nextInt(5);
                int y1=random.nextInt(5);
                int minX=Math.min(x0,x1);
                int maxX=Math.max(x0,x1);
                int minY=Math.min(y0,y1);
                int maxY=Math.max(y0,y1);
                expected = 0;
                for(int i=minX;i<=maxX;++i)for(int j=minY;j<=maxY;++j){
                    expected+=mirror[i][j];
                }
                actual = numMatrix.sumRegion(minX,minY,maxX,maxY);
                System.out.println(String.format("expected=%d, actual=%d",expected,actual));
                aassert(actual==expected);
                
                x0=random.nextInt(5);
                y0=random.nextInt(5);
                int v=random.nextInt(201)-100;
                mirror[x0][y0] = v;
                numMatrix.update(x0, y0, v);
            }
        }
    }
    
    public static void aassert(boolean cond){
        if(!cond)throw new AssertionError();
    }
}
