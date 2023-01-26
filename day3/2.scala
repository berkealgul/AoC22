import scala.io.Source
import scala.collection.mutable.Map

object Main {

    def process_indivicual(elf : String, p : Int, m : Map[Char, Int], m1_ : Map[Char, Int], m2_ : Map[Char, Int]) : Char = {
        if(p < elf.length) {
            var c = elf(p)
            if(!m.contains(c)) {
                m += (c -> 1)
                if(m1_.contains(c) && m2_.contains(c)) { 
                    return c
                } 
            }
        }

        return '#'
    }

    def process_group(elves : Array[String], p1 : Int, p2 : Int, p3 : Int, m1 : Map[Char, Int], m2 : Map[Char, Int], m3 : Map[Char, Int]) : Char = {

        var c1 = process_indivicual(elves(0), p1, m1, m2, m3);
        var c2 = process_indivicual(elves(1), p2, m2, m1, m3);
        var c3 = process_indivicual(elves(2), p3, m3, m1, m2);

        if(c1 != '#') { return c1 }
        if(c2 != '#') { return c2 }
        if(c3 != '#') { return c3 }

        return process_group(elves, p1+1, p2+1, p3+1, m1, m2, m3) 
    }

    def main(args: Array[String]) = {
        var filename = "../inputs/input3.txt"
        var sum = 0
        var n = 0
        var elves : Array[String] = new Array[String](3)

        for (line <- Source.fromFile(filename).getLines) {
            if(line.trim != "") {
                elves(n) = line
                n += 1

                if(n == 3) {
                    n = 0
                    
                    var priority = process_group(elves, 0, 0, 0, Map(), Map(), Map())

                    //38 uc 96 lc
                    if(priority.isUpper) {
                        sum+=priority-38
                    } else {
                        sum+=priority-96
                    }
                }
            }
        }

        println(sum)
    }
}
