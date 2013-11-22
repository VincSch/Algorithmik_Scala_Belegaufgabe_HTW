package beleg1

object Klammerung {

  def balance(chars: List[Char]): Boolean = {
    def traverse(list: List[Char], openBraces: Int): Boolean = {
      if (list.isEmpty)
        openBraces == 0
      else if (openBraces < 0)
        false
      else {
        traverse(list.tail, check(list.head, openBraces))
      }
    }
    def check(head: Char, openBraces: Int) = {
      if (head == '(')
        openBraces + 1
      else if (head == ')')
        openBraces - 1
      else
        openBraces
    }
    traverse(chars,0)
  }
}