class Solution {

  fun maxNiceDivisors(primeFactors: Int): Int {
    val BIG: Long = 1000000000+7
    if(primeFactors==1)return 1
    if(primeFactors==2)return 2

    val pfd3: Int = primeFactors/3
    val pfm3: Int = primeFactors%3

    if(pfm3==0){
      return pow(3,pfd3,BIG)
    }else if(pfm3==1){
      var ret:Long = pow(3,pfd3-1,BIG).toLong()
      ret*=4
      ret%=BIG
      return ret.toInt()
    }else if(pfm3==2){
      var ret:Long = pow(3,pfd3,BIG).toLong()
      ret*=2
      ret%=BIG
      return ret.toInt()
    }
    throw Error()
  }

  fun pow(base: Int, ind: Int, mod: Long):Int {
    var ii:Int = ind
    var ret: Long = 1
    var p3: Long = base.toLong()
    while(true){
      if(ii==0)return ret.toInt()
      if(ii%2==1){
        ret*=p3
        ret%=mod
      }
      ii/=2
      p3*=p3
      p3%=mod
    }
  }
}
