import scala.io.Source
import scala.collection.mutable.Map

object Main {
    def main(args: Array[String]) = {
        var filename = "../inputs/input6.txt"
        var input = Source.fromFile(filename).getLines.next()
        var result = findMarker(input, 3)
        println(result)
    }

    def findMarker(input: String, idx: Int) : Int = {
        if(idx == input.length) { return -1 }

        var chars : Map[Char, Int] = Map()

        for (i <- idx-3 until idx+1) {
            var c = input(i)

            if (chars.contains(c)) {
                return findMarker(input, idx+1)

            }
            else {
                chars += (c -> 1)
            }
        }

        return idx+1
    }
}