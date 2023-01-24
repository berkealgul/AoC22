import scala.io.Source
import scala.math

object Main {
	def main(args: Array[String]) = {
		var filename = "../inputs/input1.txt"
		var max = 0
		var sum = 0

		for (line <- Source.fromFile(filename).getLines) {
			if (line.trim == "") { // another elf
				max = (math.max(max, sum))
				sum = 0
			} else {
				sum += line.toInt
			}
		}

		println(max)
	}
}