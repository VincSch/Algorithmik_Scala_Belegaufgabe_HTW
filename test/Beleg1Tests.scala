package test
import beleg1._
import org.scalacheck._
import org.scalacheck.Prop.{forAll, BooleanOperators}

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalacheck.Properties

@RunWith(classOf[JUnitRunner])
class Beleg1Tests extends Properties("IntSet") with FunSuite {

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(Klammerung.balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(Klammerung.balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!Klammerung.balance(":-)".toList))
  }
  
  test("Klammerung leere Liste"){
    
    val result=Klammerung.balance(List())
    assert(result===true)
  }
  test("Klammerung einfacher Test"){
    
    val result=Klammerung.balance(List('(','(',')',')'))
    assert(result===true)
  }
  
  test("Fehlende schlussklammerung"){
    
    val result=Klammerung.balance(List('(','?','(','b',')','a'))
    assert(result===false)
  }
  
  test("Verletzung der Balance"){
    
    val result=Klammerung.balance(List('(','?',')','b',')','('))
    assert(result===false)
  }
  
  test("Wechselgeld Leere Liste"){
    
    val result=Wechselgeld.berechneMoeglicheWerte(List())
    assert(result===List(0))
    
  }
  
  test("Wechselgeld mit einem Wert"){
    
    val result=Wechselgeld.berechneMoeglicheWerte(List(1))
    assert(result===List(0,1))
  }
  
  test("Wechselgeld mit einem Wert als Basis"){
    
    val result=Wechselgeld.berechneMoeglicheWerte(List(1,1,1,1,1,1,1,1))
    assert(result===List(0,1,2,3,4,5,6,7,8))
  }
  
  test("Wechselgeld mit kleiner Liste"){
    
    val result=Wechselgeld.berechneMoeglicheWerte(List(1,1,2,10))
    assert(result===List(0,1,2,3,4,10,11,12,13,14))
  }
  
  test("Binary Tree insert"){
    
    val result=Aufgabe2.list2Tree(List(3,6,2,5,9,1))
    assert(List(1,2,3,5,6,9)===Aufgabe2.tree2List(result))
  }
  test("Binary Tree insert mit Doppelten"){
    
    val result=Aufgabe2.list2Tree(List(3,6,2,5,9,1,2,9))
    assert(List(1,2,3,5,6,9)===Aufgabe2.tree2List(result))
  }
  
  test("Binary Tree map Funktion"){
    
    val result=Aufgabe2.list2Tree(List(3,1,2,9)) map (X=>X*X)
    assert(List(1,4,9,81)===Aufgabe2.tree2List(result))
  }
  
    test("Binary Tree isBinaryTree-Funktion"){
    
    val result=Aufgabe2.list2Tree(List(3,1,2,9)) map (X=>X*X)
    assert(Aufgabe2.isBinaryTree(result))
  }
    
  test("Binary Tree isBinaryTree-Funktion mit Verletzung"){
    
    val result=Aufgabe2.list2Tree(List(2,3,4,5)) map (X=>if (X % 2 ==0) X else 2*X)
    assert(Aufgabe2.isBinaryTree(result))
  }
  
}