import scala.io.Source
import scala.collection.mutable.Map
import util.control.Breaks._

object Main {
    def main(args: Array[String]) = {
        var filename = "../inputs/input3.txt"
        var sum = 0

        for (line <- Source.fromFile(filename).getLines) {
            var p1 = 0
            var p2 = line.length - 1
            var priority = 'x'

            var map1 : Map[Char, Int] = Map()
            var map2 : Map[Char, Int] = Map()

            breakable {
                while(p2 > p1) {
                    var c1 = line(p1)
                    var c2 = line(p2)
                    
                    if(!map1.contains(c1)) {
                        map1 += (c1 -> 1)
                        if(map2.contains(c1)) {
                            priority = c1
                            break
                        }
                    } 

                    if(!map2.contains(c2)) {
                        map2 += (c2 -> 1)
                        if(map1.contains(c2)) {
                            priority = c2
                            break
                        }
                    } 

                    p2-=1
                    p1+=1
                }
            }

            //38 uc 96 lc
            if(priority.isUpper) {
                sum+=priority-38
            } else {
                sum+=priority-96
            }
        }

        println(sum)
    }
}