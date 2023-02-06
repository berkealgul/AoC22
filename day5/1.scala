import scala.io.Source
import scala.collection.mutable.Stack
import util.control.Breaks._

object Main {

    def main(args: Array[String]) = {
        var filename = "../inputs/input4.txt"

        // define array of stacks

        var stacks = Array[Stack[Char]] = new Array[Stack[Char]](3)
        stacks(0) = new Stack[Char]('Z', 'N')
        stacks(1) = new Stack[Char]('M', 'C', 'D')
        stacks(2) = new Stack[Char]('P')   

        for (line <- Source.fromFile(filename).getLines) {
            
            var args = line.split(" ")

            var amount = args(1).toInt
            var src = args(3).toInt
            var des = args(5).toInt
        }
    
    }
}

//    [D]    
//[N] [C]    
//[Z] [M] [P]
// 1   2   3 
