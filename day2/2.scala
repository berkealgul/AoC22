import scala.io.Source
import util.control.Breaks._

object Main {
    def main(args: Array[String]) = {
        val filename = "../inputs/input2.txt"
        var score = 0

        // A-X rock B-Y paper C-Z scissors
        val points = Map('X' -> 1, 'Y' -> 2, 'Z' -> 3)
        val results = Map('X' -> 0, 'Y' -> 3, 'Z' -> 6)

        val wins = Map('C' -> 'X', 'A' -> 'Y', 'B' -> 'Z')
        val loses = Map('B' -> 'X', 'A' -> 'Z', 'C' -> 'Y')
        val equals = Map('A' -> 'X', 'B' -> 'Y', 'C' -> 'Z') 

        for (line <- Source.fromFile(filename).getLines) {
            breakable {
                if (line.trim.length == 0) {
                    break
                }

                var rival = line(0)
                var player = line(2)
                val result = results(player)

                score += result

                if (result == 6) { // win
                    score += points(wins(rival))
                } else if(result == 3) { // draw
                    score += points(equals(rival))
                } else { // lose
                    score += points(loses(rival))
                }
            }
        }

        println(score)
    }
}