//functions that return other functions or take functions as parameters
fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {
    list.forEach {
        if(predicate(it)) {
            println(it)
        }
    }
}

val predicate: (String) -> Boolean = {it.startsWith("K")} //defining functions as variables

fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("J") }
}

fun main() {
    val list = listOf("Kotlin", "Java", "C++")
    printFilteredStrings(list, predicate)
    printFilteredStrings(list, getPrintPredicate())
}