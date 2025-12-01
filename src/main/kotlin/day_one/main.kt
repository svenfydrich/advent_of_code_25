import day_one.list

fun main() {
    val instructions = list().instructions
    val totalZeroHits = runDial(instructions)
    println("The dial hit position 0 exactly $totalZeroHits times.")
}

fun runDial(instructions: List<String>, size: Int = 100): Int {
    var position = 50
    var zeroHits = 0

    for (instr in instructions) {
        val direction = instr.first()
        val amount = instr.drop(1).toInt()

        val delta = when (direction) {
            'L' -> -amount
            'R' -> amount
            else -> error("Invalid instruction: $instr")
        }

        val newPosition = position + delta
        val start = position
        val end = newPosition
        val step = if (delta > 0) 1 else -1

        var current = start
        while (current != end) {
            current += step
            if (current % size == 0) zeroHits++
        }

        position = wrap(newPosition, size)
    }

    return zeroHits
}

fun wrap(value: Int, size: Int): Int {
    val r = value % size
    return if (r >= 0) r else r + size
}