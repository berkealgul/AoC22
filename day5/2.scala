import scala.io.Source
import scala.collection.mutable.Stack
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.ArrayBuffer

object Main {
    def main(args: Array[String]) = {
        var filename = "../inputs/input5.txt"

        var stacks: ArrayBuffer[Stack[Char]] = ArrayBuffer()

        var tops = ""
        var input_parsed = false

        var lines = new ListBuffer[String]()

        for (line <- Source.fromFile(filename).getLines) {
            if(line.trim != "") {
                if(input_parsed) {
                    var args = line.split(" ")
                
                    var amount = args(1).toInt
                    var src = args(3).toInt - 1
                    var des = args(5).toInt - 1 

                    var crates = new ListBuffer[Char]()

                    for(i <- 0 until amount) {
                        crates += stacks(src).pop()
                    }

                    for (crate <- crates.reverse) {
                        stacks(des).push(crate)
                    }
                }
                else {
                    lines += line
                }
            }
            else {
                if(!input_parsed) {

                    var n_stacks = lines.last.split(" ").last.toInt   

                    for(i <- 0 until n_stacks) {
                        stacks += new Stack[Char]()
                    }

                    var i = 0

                    while(i < lines.length - 1) {
                        
                        var stack_idx = 0
                        var j = 1

                        while(j < lines(i).length) {
                            var c = lines(i)(j)

                            if (c != ' ') {
                                stacks(stack_idx) += c
                            }

                            j += 4
                            stack_idx += 1
                        }

                        i += 1;
                    }

                    
                    // for(stack <- stacks) {
                    //     println(stack)
                    // }

                    input_parsed = true
                }
            }
        }

        for(stack <- stacks) {
            tops += stack.top
        }

        println(tops)
    }
}
