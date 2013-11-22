package beleg1

object Klammerung {

  def balance(chars: List[Char]): Boolean = {
    var openBraces = 0
    def traverse(list: List[Char]): Boolean = {
      if (list.isEmpty)
        openBraces == 0
      else if (openBraces < 0)
        false
      else {
        check(list.head)
        traverse(list.tail)
      }
    }

    def check(head: Char) = {
      if (head == '(')
        openBraces = openBraces + 1
      else if (head == ')')
        openBraces = openBraces - 1
    }
    traverse(chars)
  }
}