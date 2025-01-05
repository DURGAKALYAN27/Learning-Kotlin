fun sayHello(greeting: String, vararg items: String)  { //variable no of args
    items.forEach { item ->
        println("$greeting $item")
    }
}

fun greetPerson(greeting: String, name: String = "test") = println("$greeting $name")


fun main() {
    val person = Person()
    person.nickName = "Shades"
    person.nickName = null
    println(person.nickName)
    person.printInfo()
}