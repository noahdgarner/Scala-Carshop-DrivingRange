package Carshop

case class Gas(gasType:String) { //ammo created by seller will be either a .45, a grenade, or a


  val name = gasType //defined by the car created


  var gasPrice = 0
    name match {
      case "Expensive" => var gasPrice = 10 //in credits
      case "Cheap" => var gasPrice = 5 //in credits
      case _ => 999 //something bad happened
    }


  override def toString = "Vehicle created with gas type: "+name+"\nAnd a gas cost of: "+gasPrice+"."
}
