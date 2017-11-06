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
    }.foreach(println)
  }
}
