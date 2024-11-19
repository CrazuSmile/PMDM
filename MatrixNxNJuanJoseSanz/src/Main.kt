/*
* Programa de matrices NxN de añadir por teclado tamaño de matriz y añadir valores aleatorios
* @author Juan Jose Sanz
* @version 1
*/

fun main(){
    print("Introduzca el valor de N para la matriz: ")
    var n = readln().toInt()

    var matrix = Array(n){Array(n) {""} }

    do {
        println(("""|¿Que desea hacer?
            | 1.-Rellenar matriz.
            | 2.-Mostrar.
            | 3.-Buscar numero.
            | 4.-Añadir uno.
            | 0.-Salir
        """.trimMargin()).trimMargin())
        val option = readln().toInt()

        when(option){
            1 -> fillMatrix()
            2 -> showMatrix()
            3 -> findInMatrix()
            4 -> addOne()
            0 -> println("Adios")
        }

    } while (option != 0)
}

fun fillMatrix(){

}

fun showMatrix(){

}

fun findInMatrix(){

}

fun addOne(){

}