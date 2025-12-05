package day_three

fun main() {
    val block = Joltage().block
//    val extracted = extract(block.lines())
    val extracted = extractMaxJoltage12(block.lines())
    val result = extracted.sum()
    println(result)
}

//fun extract(lines: List<String>): List<Int> {
//    return lines.map { line ->
//        val digits = line.map { it.digitToInt() }
//        var max = 0
//        for (i in digits.indices) {
//            for (j in i + 1 until digits.size) {
//                val num = digits[i] * 10 + digits[j]
//                if (num > max) max = num
//            }
//        }
//        max
//    }
//}

fun extractMaxJoltage12(lines: List<String>): List<Long> {
    return lines.map { line ->
        val digits = line.map { it.digitToInt() }
        val n = digits.size
        val k = 12
        var result = ""
        var start = 0
        for (i in 0 until k) {
            val end = n - (k - i)
            val maxDigit = digits.subList(start, end + 1).maxOrNull()!!
            val idx = digits.subList(start, end + 1).indexOf(maxDigit) + start
            result += maxDigit.toString()
            start = idx + 1
        }
        result.toLong()
    }
}