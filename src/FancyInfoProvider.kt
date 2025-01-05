class FancyInfoProvider : BasicInfoProvider() {
    override val providerInfo: String
        get() = "Fancy Info Provider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }

    override val sessionIdPrefix: String
        get() = "Fancy Session"
}//explicitly mark as open to extend