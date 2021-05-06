class Solution {
    fun connect(root: Node?): Node? {
        if(root==null){return root}
        connect(root.right)
        connect(root.left,root.right)
        connect(root.left)
        return root
    }

    fun connect(left:Node?,right:Node?){
      if(left==null)return
      if(right==null)return

      left.next=right

      var left2:Node? = null
      if(left.right!=null){
        left2 = left.right
      }else{
        left2 = left.left
      }
      if(left2==null)return

      var right2 = nextRight(right)
      connect(left2,right2)
    }

    fun nextRight(pp:Node?):Node?{
      var p=pp
      while(p!=null){
        if(p.left!=null){return p.left}
        if(p.right!=null){return p.right}
        p=p.next
      }
      return null
    }
    
}
