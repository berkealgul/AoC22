import scala.io.Source
import scala.math
import scala.collection.mutable.PriorityQueue


object Main {
    def main(args: Array[String]) = {
        var filename = "../inputs/day1/input1.txt"
        val que : PriorityQueue[Int] = PriorityQueue()
        var sum = 0
        for (line <- Source.fromFile(filename).getLines) {
            if (line.trim == "") { // another elf
                que += sum
                sum = 0   
            } else {
                sum += line.toInt
            }
        }
        que += sum
        println(que.dequeue() + que.dequeue() + que.dequeue())
    }
}