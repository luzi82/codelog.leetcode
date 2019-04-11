import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
    public static Random random = new Random();

    public void wiggleSort(int[] nums) {
        // quick ret for short input
        if(nums.length<=1)return;
    
        // define median idx
        int medianIdx = (nums.length-1)/2;
    
        // divide nums into 2 parts, less/more than median, O(n)
        medianSort(nums, medianIdx);
        //System.err.println(String.format("medianSort     %s",Test.join(nums)));
        
        // get median
        int median = nums[medianIdx];
        
        // put small num to even idx
        // big nums to odd idx
        wiggle(nums, medianIdx);
        //System.err.println(String.format("wiggle         %s",Test.join(nums)));
        
        // in even idx, put median to left
        medianEvenLeft(nums, median);
        //System.err.println(String.format("medianEvenLeft %s",Test.join(nums)));
        
        // in odd idx, put median to right
        medianOddRight(nums, median);
        //System.err.println(String.format("medianOddRight %s",Test.join(nums)));
    }
    
    public static void medianSort(int[] nums, int medianIdx){
        int start = 0;
        int end = nums.length;
        
        while(true){
            if(end-start==1)break;
            if(end-start==2){
                if(nums[start]>nums[start+1]){
                    swap(nums,start,start+1);
                }
                break;
            }
        
            // random pick number to right most
            int randIdx = start + random.nextInt(end-start);
            swap(nums, randIdx, end-1);
            int pivotVal = nums[end-1];
            int i=start;
            int j=end-2;
            
            //System.err.println(String.format("pivotVal=%d, i=%d, j=%d",pivotVal,i,j));
            
            // divide 2 part
            while(i<j){
                // left: nums[i] < pivotVal
                while((i<j)&&(nums[i]<pivotVal))++i;
                // right: nums[j] >= pivotVal
                while((i<j)&&(nums[j]>=pivotVal))--j;
                
                if(i>=j)break;
                swap(nums, i, j);
            }
            
            //System.err.println(String.format("divide %s",Test.join(nums)));
            
            // put back pivotVal
            while(true){
                if(j>=end-1)break;
                if(nums[j]>=pivotVal)break;
                ++j;
            }
            swap(nums, j, end-1);
            
            //System.err.println(String.format("pivot back %s",Test.join(nums)));

            i = j;
            ++j; // end of pivot group
            
            if(i==medianIdx)return;

            if(i>medianIdx){
                end = i;
                continue;
            }

            // collect pivotVal
            int k = j;
            while(true){
                if(k>=end)break;
                if(nums[k]>pivotVal){++k;continue;}
                swap(nums,j,k);
                ++k;++j;
            }

            //System.err.println(String.format("pivot collect %s",Test.join(nums)));

            if(j>medianIdx)return;

            start = j;
        }
    }
    
    public static void swap(int[] nums, int i, int j){
        if(i==j)return;
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    public static void wiggle(int[] nums, int medianIdx){
        int inputIdx = medianIdx;
        int outputIdx = nums.length-1;
        
        if(outputIdx%2==1)--outputIdx;
        
        while(outputIdx>inputIdx){
            swap(nums,outputIdx,inputIdx);
            --inputIdx;
            outputIdx-=2;
        }
    }
    
    public static void medianEvenLeft(int[] nums, int median){
        int inputIdx = 0;
        int outputIdx = 0;
        
        while(inputIdx<nums.length){
            if(nums[inputIdx]==median){
                swap(nums,inputIdx,outputIdx);
                outputIdx+=2;
            }
            inputIdx+=2;
        }
    }
    
    public static void medianOddRight(int[] nums, int median){
        int inputIdx = nums.length-1;
        if(inputIdx%2==0)--inputIdx;
        int outputIdx = inputIdx;
        while(inputIdx >= 0){
            if(nums[inputIdx]==median){
                swap(nums,inputIdx,outputIdx);
                outputIdx-=2;
            }
            inputIdx-=2;
        }
    }
}
