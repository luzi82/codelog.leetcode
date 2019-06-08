import java.lang.AssertionError;
import java.util.*;
import java.util.regex.*;

public class NestedIterator implements Iterator<Integer> {
    
    LinkedList<Iterator<NestedInteger>> itrStack;
    
    NestedInteger _next = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        itrStack = new LinkedList<>();
        itrStack.addLast(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if(_next==null){_next=findNext();}
        if(_next!=null){
            Integer ret = _next.getInteger();
            _next = null;
            return ret;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(_next!=null)return true;
        _next = findNext();
        return _next!=null;
    }
    
    private NestedInteger findNext(){
        while(true){
            if(itrStack.size()==0)return null;
            Iterator<NestedInteger> itr = itrStack.getLast();
            if(itr.hasNext()){
                NestedInteger nextNestedInteger = itr.next();
                if(nextNestedInteger.isInteger()){
                    return nextNestedInteger;
                }else{
                    itrStack.addLast(nextNestedInteger.getList().iterator());
                    continue;
                }
            }else{
                itrStack.removeLast();
                continue;
            }
        }
    }
}
