import scala.io.Source
import scala.collection.mutable.Stack
import util.control.Breaks._

object Main {

    def main(args: Array[String]) = {
        var filename = "../inputs/input5-adjusted.txt"

        var stacks: Array[Stack[Char]] = Array(
            Stack('F', 'G', 'V', 'R', 'J', 'L', 'D'),
            Stack('S', 'J', 'H', 'V', 'B', 'M', 'P', 'T'),
            Stack('P'))

        var tops = ""
        var input_parsed = false

        for (line <- Source.fromFile(filename).getLines) {
            if(line.trim != "") {
                var args = line.split(" ")
            
                var amount = args(1).toInt
                var src = args(3).toInt - 1
                var des = args(5).toInt - 1 


                for(stack <- stacks) {
                    println(stack)
                }
                println("---")

                for(i <- 0 until amount) {
                    var top = stacks(src).pop()
                    stacks(des).push(top)
                }
            }
            else {

            }
        }

        for(stack <- stacks) {
            tops += stack.top
        }

        println(tops)
    }
}
