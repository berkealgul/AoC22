import scala.io.Source
import scala.collection.mutable.Map

object Main {
    def main(args: Array[String]) = {
        var filename = "../inputs/testcase.txt"
        var input = Source.fromFile(filename).getLines.next()
        var marker = findMarker(input, 3)
        var result = findMsgStart(input, marker+15)
        println(result-marker-1)
    }

    def findMsgStart(input: String, idx: Int) : Int = {
        if(idx >= input.length) { return -1 }

        var chars : Map[Char, Int] = Map()

        for (i <- idx-15 until idx+1) {
            var c = input(i)
            if (chars.contains(c)) {
                return findMsgStart(input, idx+1)
            }
            else {
                chars += (c -> 1)
            }
        }

        return idx
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