package beleg1

abstract class IntSet {
	
	def insert(x: Int): IntSet
	def contains(x: Int): Boolean
	def map(f:Int=>Int):IntSet

}

case object Empty extends IntSet {
	def contains(x: Int): Boolean = false
	def insert(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
	def map(f:Int=>Int)= ???
}

case class NonEmpty(val elem: Int, val left: IntSet, val right: IntSet) extends IntSet {
	def contains(x: Int): Boolean =
		if (x < elem) left contains x
			else if (x > elem) right contains x
				else true

def insert(x: Int): IntSet =
	if (x < elem) NonEmpty(elem, left insert x, right)
		else if (x > elem) NonEmpty(elem, left, right insert x)
			else this

def map(f:Int=>Int)= ???

}




object Aufgabe2{
  
  def list2Tree(l:List[Int]):IntSet = ???
	
		  
  def tree2List(t:IntSet):List[Int]= ???
  
  def isBinaryTree(t:IntSet):Boolean= ???
}
