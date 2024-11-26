/*
* Ejercicio para juego de un dado
* @author Juan Jose Sanz
* @version 2
*/

fun main() {
    var nFaces: Int

    do {
        try {
            print("Di el numero de caras para el dado entre 4 y 20: ")
            nFaces = readln().toInt()

            if (nFaces < 4 || nFaces > 20) println("No es un valor aceptable") else break
        } catch (e: IllegalArgumentException) {
            println("No es un valor valido: ${e.message}")
        }
    } while (true)

    val dice = Dice(nFaces)
    var previousThrow = dice.throwDice()
    var i = 1
    println("En la ${i}ª tirada sale un $previousThrow")
    var checkThrow = 0
    do {
        i++
        var answer: Int
        var newThrow = dice.throwDice()
        if (newThrow == previousThrow) {
            newThrow = dice.throwDice()
        }
        do {
            try {
                println(
                    """|¿La siguiente tirada sera?
                    | 1.- Mayor
                    | 2.- Menor
                    |Respuesta: 
                    """.trimMargin()
                )
                answer = readln().toInt()
                if (answer < 1 || answer > 2) println("No es un valor aceptable") else break
            } catch (e: IllegalArgumentException) {
                println("No es un valor valido: ${e.message}")
            }
        } while (true)
        when (answer) {
            1 -> checkThrow = comprobarMayor(newThrow, previousThrow, i)
            2 -> checkThrow = comprobarMenor(newThrow, previousThrow, i)
        }
        previousThrow = checkThrow
    } while (checkThrow != 0)
    println("Adios")
}

fun comprobarMayor(newThrow: Int, previousThrow: Int, i: Int): Int {
    var originalThrow: Int = previousThrow
    if (newThrow > originalThrow) {
        originalThrow = newThrow
        println("En la ${i}ª tirada sale un $originalThrow")
        println("Correcto")
    } else {
        originalThrow = newThrow
        println("En la ${i}ª tirada sale un $originalThrow")
        println("Has fallado")
        return 0
    }
    return originalThrow
}

fun comprobarMenor(newThrow: Int, previousThrow: Int, i: Int): Int {
    var originalThrow: Int = previousThrow
    if (newThrow < originalThrow) {
        originalThrow = newThrow
        println("En la ${i}ª tirada sale un $originalThrow")
        println("Correcto")
    } else {
        originalThrow = newThrow
        println("En la ${i}ª tirada sale un $originalThrow")
        println("Has fallado")
        return 0
    }
    return originalThrow
}