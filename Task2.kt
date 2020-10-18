data class Data(val number: Int, val name: String)

fun main() {
    val listOfTestData = mutableListOf<Data>()
    listOfTestData.add(Data(1, "C"))
    listOfTestData.add(Data(1, "A"))
    listOfTestData.add(Data(2, "D"))
    listOfTestData.add(Data(1, "E"))
    listOfTestData.add(Data(2, "B"))

    val resultOfFirstSort = sortedByNumber(listOfTestData)
    println(sortListByName(resultOfFirstSort))
}

private fun sortedByNumber(data: List<Data>): List<Data> = data.sortedWith(compareBy { it.number })
private fun sortedByName(data: List<Data>): List<Data> = data.sortedWith(compareBy { it.name })

private fun sortListByName(data: List<Data>): List<Data> {
    val groupsOfNumbers = mutableListOf<Int>()
    val resultingList = mutableListOf<Data>()

    data.forEach {
        if (!groupsOfNumbers.contains(it.number)) {
            groupsOfNumbers.add(it.number)
        }
    }

    groupsOfNumbers.forEach { group ->
        val subList = getGroupSubList(data, group)
        resultingList.addAll(sortedByName(subList))
    }
    return resultingList
}

private fun getGroupSubList(data: List<Data>, group: Int): List<Data> {
    val first = data.indexOfFirst { it.number == group }
    val last = data.indexOfLast { it.number == group }
    return data.subList(first, last + 1)
}