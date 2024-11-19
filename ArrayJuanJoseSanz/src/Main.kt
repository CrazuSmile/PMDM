/*
 * Progama de matrices del ejercicio 5
 * @author Juan Jose Sanz
 * @version 1
 */

fun main() {
    var array: Array<Int> = arrayOf()
    do {
        array += inputArray(array)

        println("Numeros pares del Array: ")
        pair(array)

        print(
            ("""|¿Quieres terminar el programa?
        | 1. Si.
        | 2. No.
        |Respuesta: """.trimMargin())
        )
        val respond = readln().toInt()

    } while (respond == 2)

    println("Adios")
}

// Añadir nuevos datos al Array
fun inputArray(array: Array<Int>): Array<Int> {
    var newArray = array
    while (true) {
        println("Introduzca un numero (introduzca 'fin' para finalizar el Array)")
        val input = readln()

        if (input == "fin") {
            break
        }

        val number = input.toInt()
        newArray += number

    }
    return newArray
}

// Comprueba cuales son pares
fun pair(array: Array<Int>) {
    for (i in array.indices) {
        if (array[i] % 2f == 0f) {
            println("${array[i]}")
        }
    }
}