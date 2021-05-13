import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

class Solution {
  HashMap<String,HashMap<String,Double>> leftToRightToValueMapMap = new HashMap<String,HashMap<String,Double>>();

  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    int eqIdx=0;
    for(List<String> leftRight:equations){
      String left = leftRight.get(0);
      String right = leftRight.get(1);
      double v = values[eqIdx];
      putLeftToRightToValueMapMap(left,right,v);
      putLeftToRightToValueMapMap(right,left,1d/v);
      ++eqIdx;
    }
    
    double[] retAry=new double[queries.size()];
    int qIdx = 0;
    for(List<String> leftRight:queries){
      String left = leftRight.get(0);
      String right = leftRight.get(1);
      retAry[qIdx] = cal(left, right);
      ++qIdx;
    }
    
    return retAry;
  }
  
  public double cal(String left,String right){
    if(!leftToRightToValueMapMap.containsKey(left))return -1d;
    if(!leftToRightToValueMapMap.containsKey(right))return -1d;
    if(left.equals(right)){return 1d;}

    LinkedList<String> leftQueue=new LinkedList<>();
    HashMap<String,Double> leftToValueMap = new HashMap<>();
    leftQueue.addLast(left);
    leftToValueMap.put(left,1d);
    while(leftQueue.size()>0){
      String leftt = leftQueue.removeFirst();
      double value = leftToValueMap.get(leftt);
      HashMap<String,Double> rightToValueMap = leftToRightToValueMapMap.get(leftt);
      for(Map.Entry<String,Double> rightToValueEntry : rightToValueMap.entrySet()){
        String rightt = rightToValueEntry.getKey();
        if(leftToValueMap.containsKey(rightt))continue;
        double valuee = value * rightToValueEntry.getValue();
        if(rightt.equals(right)){return valuee;}
        leftQueue.addLast(rightt);
        leftToValueMap.put(rightt,valuee);
      }
    }
    return -1;
  }
  
  public void putLeftToRightToValueMapMap(String left,String right,double value){
    if(!leftToRightToValueMapMap.containsKey(left)){
      leftToRightToValueMapMap.put(left,new HashMap<String,Double>());
    }
    HashMap<String,Double> rightToValueMap = leftToRightToValueMapMap.get(left);
    rightToValueMap.put(right, value);
  }
}
