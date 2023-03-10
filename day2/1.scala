import scala.io.Source
import util.control.Breaks._

object Main {
    def main(args: Array[String]) = {
        val filename = "../inputs/input2.txt"
        var score = 0

        // A-X rock B-Y paper C-Z scissors
        val points = Map('X' -> 1, 'Y' -> 2, 'Z' -> 3)

        // i counters map[i]
        val counters = Map('A' -> 'Z', 'B' -> 'X', 'C' -> 'Y', 
                           'X' -> 'C', 'Y' -> 'A', 'Z' -> 'B')

        for (line <- Source.fromFile(filename).getLines) {
            breakable {
                if (line.trim.length == 0) {
                    break
                }

                var rival = line(0)
                var player = line(2)

                score += points(player)

                if (counters(player) == rival) {
                    score += 6
                } else if(counters(rival) == player) {
                    break
                } else {
                    score += 3
                }
            }
        }

        println(score)
    }
}