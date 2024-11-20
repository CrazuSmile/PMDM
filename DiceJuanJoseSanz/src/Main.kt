/*
* Ejercicio para juego de un dado
* @author Juan Jose Sanz
* @version 1
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

    var dice = Dice(nFaces)

    do {
        var i: Int = 1
        println("En la ${i}ª tirada sale un ${dice.throwDice()}")
        i++

        println("""|¿La siguiente tirada sera?
            | 1.- Mayor
            | 2.- Menor
            |Respuesta: 
        """.trimMargin())


    } while ()

}