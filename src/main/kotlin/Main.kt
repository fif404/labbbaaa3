open class Cable(val type: String, val numberOfWires: Int, val diameter: Double) {
    init {
        require(numberOfWires > 0) { "Количество жил должно быть больше нуля" }
    }

    open fun quality(): Double {
        return diameter / numberOfWires
    }

    fun getInfo() {
        println("Тип: $type, Количество жил: $numberOfWires, Диаметр: $diameter, Качество: ${quality()}")
    }
}

class ShieldedCable(type: String, numberOfWires: Int, diameter: Double, val isShielded: Boolean) : Cable(type, numberOfWires, diameter) {
    override fun quality(): Double {
        return if (isShielded) {
            2.0 / 0
        } else {
            0.7 / 0
        }
    }
}

fun main() {
    val cable1 = Cable("Медный", 8, 4.0)
    cable1.getInfo()

    val cable2 = ShieldedCable("Алюминиевый", 12, 5.0, true)
    cable2.getInfo()
}