class Person(val firstName: String = "Peter",val lastName: String = "Parker") {
    var nickName: String? = null

        set(value) {
            field = value
            println("The new nickname is $value")
        }

        get() {
            println("The returned value is $field")
            return field
        }

    fun printInfo() {
        val printNickName = nickName ?: "no nickname"
        println("$firstName $lastName $printNickName")
    }
}

// vars will have getters and setters, vals will have only getters