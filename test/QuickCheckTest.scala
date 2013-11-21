package test
import beleg1._
import org.scalacheck._
import org.scalacheck.Prop.forAll
import org.junit.runner.RunWith
import org.scalacheck.Properties

//@RunWith(classOf[JUnitRunner])
class QuickCheckTest extends Properties("IntSet") {

  property("jsdsddssudiu")= forAll { l:List[Int] => val result= Aufgabe2.list2Tree(l); Aufgabe2.tree2List(result)!=l.sorted}
    
  property("jsudiu")=forAll { (a: String, b: String, c: String) => (a+b+c).substring(a.length, a.length+b.length) == b}
  
  

}