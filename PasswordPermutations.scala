object Test {
  def run(wordList: List[String], replacements: Map[Char, String]) {
    wordList.map { word =>
      word.foldLeft(List.empty[String]) {
        (list, letter) =>
          if (list.isEmpty) {
            if (replacements.contains(letter)) {
              List(s"$letter") ++ List(s"${replacements(letter)}")
            } else {
              List(s"$letter")
            }
          } else {
            if (replacements.contains(letter)) {
              list.map(_ + letter) ++ list.map(_ + replacements(letter))
            } else {
              list.map(_ + letter)
            }
          }
      }
    }.foreach(e => {
      println(e)
    })
  }
}

Test.run(List("hello", "world", "asvardsa"), Map('a' -> "@", 'e' -> "3", 'l' -> "1", 'o' -> "0", 'h' -> "|-|"))
/*
 * List(hello, |-|ello, h3llo, |-|3llo, he1lo, |-|e1lo, h31lo, |-|31lo, hel1o, |-|el1o, h3l1o, |-|3l1o, he11o, |-|e11o, h311o, |-|311o, hell0, |-|ell0, h3ll0, |-|3ll0, he1l0, |-|e1l0, h31l0, |-|31l0, hel10, |-|el10, h3l10, |-|3l10, he110, |-|e110, h3110, |-|3110)
 * List(world, w0rld, wor1d, w0r1d)
 * List(asvardsa, @svardsa, asv@rdsa, @sv@rdsa, asvards@, @svards@, asv@rds@, @sv@rds@)
 *
 */

