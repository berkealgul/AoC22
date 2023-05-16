import scala.io.Source
import scala.collection.mutable.Map
import util.control.Breaks._

object Main {
    def main(args: Array[String]) = {
        var filename = "../inputs/input6.txt"
        var input = Source.fromFile(filename).getLines.next()
        var result = findMsgStart(input, 13)
        println(result)
    }

    def findMsgStart(input: String, id: Int) : Int = {
        var idx = id

        while(idx < input.length) {
            var chars : Map[Char, Int] = Map()
            var suc = true;

            breakable {
                for (i <- idx-13 until idx+1) {
                    var c = input(i)
                    if (chars.contains(c)) {
                        suc = false;
                        break
                    }
                    else {
                        chars += (c -> 1)
                    }
                }
            }

            if(suc) {
                return idx+1
            } else {
                idx = idx + 1
            }
        }

        return -1;
    }
}