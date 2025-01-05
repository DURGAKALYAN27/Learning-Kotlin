import java.util.*

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.toLowerCase().capitalize()
}

object EntityFactory {
    fun create(type: EntityType): Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> type.name //matches exactly how class name defined
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        return when (type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

sealed class Entity constructor() {
    object Help: Entity() {
        val name = "Help"
    }

    data class Easy(val id: String, val name: String): Entity()
    data class Medium(val id: String, val name: String): Entity()
    class Hard(val id: String, val name: String, val Multiplier: Float): Entity() //extend frm entity
}

//fun main() {
//    val entity = EntityFactory.create(EntityType.EASY) //companion object has access
//    val msg = when (entity) {
//        Entity.Help -> "help class"
//        is Entity.Easy -> "Easy class"
//        is Entity.Medium -> "Medium class"
//        is Entity.Hard -> "Hard class"
//    }
//
//    println(msg)
//}

//sealed classes allow class hierarchies extending base type

fun Entity.Medium.printInfo() {
    println("Medium class: $id")
} //class function extension

fun main() {
    Entity.Medium("id", "name").printInfo()

    val entity = EntityFactory.create(EntityType.MEDIUM)

    if (entity is Entity.Medium) {
        entity.printInfo()
    }
}