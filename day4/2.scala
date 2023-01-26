import scala.io.Source
import util.control.Breaks._

object Main {

    def parseLine(line: String, arr : Array[Int]) : Boolean = {
        if(line.trim == "") { return false }

        var ss = line.split(',')
        var ss1 = ss(0).split('-')
        var ss2 = ss(1).split('-')

        arr(0) = ss1(0).toInt
        arr(1) = ss1(1).toInt
        arr(2) = ss2(0).toInt
        arr(3) = ss2(1).toInt

        return true
    }

    def main(args: Array[String]) = {
        var filename = "../inputs/input4.txt"
        var n_overlaps = 0
        var arr = new Array[Int](4)

        for (line <- Source.fromFile(filename).getLines) {
            if(parseLine(line, arr)) { 
                var i = 1
                // arr = { fl, fr, sl, sr }
                // fr >= sl
                if(!(arr(2) == arr(0) || arr(3) == arr(1))) {  
                    if(arr(2) < arr(0)) { i *= -1}
                    if(arr(3) > arr(1)) { i *= -1}
                }
                
                if(i == 1) { n_overlaps += 1 }
            }
        }
    
        println(n_overlaps)
    }
}