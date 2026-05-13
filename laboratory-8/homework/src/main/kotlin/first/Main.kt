package first

import first.builder.AndGateBuilder

fun main() {
    val and2 = AndGateBuilder(2)
        .addInput(true)
        .addInput(true)
        .build()

    val and3 = AndGateBuilder(3)
        .addInput(true)
        .addInput(false)
        .addInput(true)
        .build()

    val and4 = AndGateBuilder(4)
        .addInput(true)
        .addInput(true)
        .addInput(true)
        .addInput(true)
        .build()

    val and8 = AndGateBuilder(8)
        .addInput(true)
        .addInput(true)
        .addInput(true)
        .addInput(true)
        .addInput(true)
        .addInput(true)
        .addInput(true)
        .addInput(false)
        .build()

    println("AND(2 intrari) = ${and2.evaluate()}")
    println("AND(3 intrari) = ${and3.evaluate()}")
    println("AND(4 intrari) = ${and4.evaluate()}")
    println("AND(8 intrari) = ${and8.evaluate()}")
}