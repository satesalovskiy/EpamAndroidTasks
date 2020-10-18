fun main() {
    println("Enter two strings to check permutations")
    val str1 = readLine() ?: ""
    val str2 = readLine() ?: ""
    println (isStringsContentEqual(str1, str2))
}

private fun isStringsContentEqual(firstString: String, secondString: String): Boolean {
    val charMap1 = mutableMapOf<Char, Int>()
    val charMap2 = mutableMapOf<Char, Int>()

    if (firstString.isBlank() && secondString.isBlank()) {
        println("Strings are empty")
        return false
    }

    firstString.forEach {
        increaseValueIfExistsOrPutDefault(charMap1, it)
    }
    secondString.forEach {
        increaseValueIfExistsOrPutDefault(charMap2, it)
    }
    return charMap1 == charMap2
}

private fun increaseValueIfExistsOrPutDefault(
    charMap1: MutableMap<Char, Int>,
    it: Char
) {
    val result = charMap1.getOrPut(it) { 1 }
    if (result >= 1) charMap1[it] = result + 1
}