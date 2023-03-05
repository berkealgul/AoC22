import scala.io.Source
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

class Node {
    var v: Int = 0
    var i: Int = 0

}

object Main {
    def main(args: Array[String]) = {
        var filename = "../inputs/testcase.txt"

        var stack: Queue[Node] = Queue()
        var array: ArrayBuffer[Node] = ArrayBuffer()
        var i = 0

        for(line <- Source.fromFile(filename).getLines) {
            if(line.trim != "") {
                var n: Node = Node();
                n.v = line.toInt
                n.i = i
                i += 1

                stack += n
                array += n
            }
        }

        while(stack.length > 0) {
            for(nx <- array) {
                print(nx.v)
                print(" ")
            }

            println()

            var n: Node = stack.dequeue()
            var id = n.i
            var v = n.v

            //println(v)

            var j = id + v
            j = ((j % array.length) + array.length) % array.length

            var nt: Node = array(j)
            array(j) = n
            array(id) = nt
            n.i = j
            nt.i = id


        }

        for(nx <- array) {
            print(nx.v)
            print(" ")
        }

        println()
    }
}