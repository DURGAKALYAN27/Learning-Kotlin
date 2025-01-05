fun main() {
    val list = listOf("Kotlin", "Java", "C++", "Javascript", null, null)
    list
        .filterNotNull()
        .filter {
            it.startsWith("J")
        }
        .associate { it to it.length }
        .forEach {
            println("${it.value} is ${it.key}")
        }
}