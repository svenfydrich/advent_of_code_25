package day_two

fun main() {

    val idRanges = ID_ranges().list
//    val result = countSymmetricNumbers(splitAndMap(idRanges))
    val result = countRepeatedPatternIDs(splitAndMap(idRanges))
    println(result)
}

fun splitAndMap(ranges: String): List<List<Long>> {
    val splitRanges = ranges.split(",")
    val result = mutableListOf<List<Long>>()
    for (range in splitRanges) {
        val parts = range.split("-")
        if (parts.size == 2) {
            val start = parts[0].toLong()
            val end = parts[1].toLong()
            result.add(listOf(start, end))
        }
    }
    return result
}


//fun countSymmetricNumbers(ranges: List<List<Long>>): Long {
//    var result = 0L
//    for (range in ranges) {
//        val start = range[0]
//        val end = range[1]
//        for (num in start..end) {
//            val s = num.toString()
//            if (s.length % 2 == 0) {
//                val mid = s.length / 2
//                if (s.substring(0, mid) == s.substring(mid)) {
//                    result += num
//                }
//            }
//        }
//    }
//    return result
//}

fun countRepeatedPatternIDs(ranges: List<List<Long>>): Long {
    var result = 0L
    for (range in ranges) {
        val start = range[0]
        val end = range[1]
        for (num in start..end) {
            val s = num.toString()
            val len = s.length
            for (l in 1..(len / 2)) {
                if (len % l == 0) {
                    val pattern = s.substring(0, l)
                    val repeated = pattern.repeat(len / l)
                    if (repeated == s) {
                        result += num
                        break
                    }
                }
            }
        }
    }
    return result
}
