class ParkingSystem(big: Int, medium: Int, small: Int) {

  var big: Int = big
  var medium: Int = medium
  var small: Int = small

  fun addCar(carType: Int): Boolean {
    if(carType==1){
      if(this.big<=0)return false
      this.big = this.big - 1
      return true
    }
    if(carType==2){
      if(this.medium<=0)return false
      this.medium = this.medium - 1
      return true
    }
    if(carType==3){
      if(this.small<=0)return false
      this.small = this.small - 1
      return true
    }
    throw AssertionError()
  }

}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */
 