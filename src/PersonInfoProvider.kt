interface PersonInfoProvider {
    val providerInfo: String

    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
} //default implementation

interface SessionInfoProvider {
    fun getSessionId(): String
}

open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override fun getSessionId(): String {
        return sessionIdPrefix
    }

    protected open val sessionIdPrefix = "Session" //protected to only give access to fancy

    override val providerInfo: String
        get() = "BasicInfoProvider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }
}//error cuz it don't implement that method/ must override (this time there is default)

fun main() {
    val provider = object : PersonInfoProvider {
        override val providerInfo: String
            get() = "New info provider"

        fun getSessionId() = "id"
    }

    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
}

fun checkTypes(infoProvider: PersonInfoProvider) {
    if (infoProvider is SessionInfoProvider) {
        println("Is a session info provider")
        //(infoProvider as SessionInfoProvider).getSessionId() //type casting, access specific to ses
        infoProvider.getSessionId()
    }
    else {
        println("Is not a session info provider")
    }
}