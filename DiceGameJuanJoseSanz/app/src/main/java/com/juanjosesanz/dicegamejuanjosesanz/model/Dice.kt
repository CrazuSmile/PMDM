package com.juanjosesanz.dicegamejuanjosesanz.model/*
* Clase para el dado
* @author Juan Jose Sanz
* @version 1
*/

class Dice(faces: Int) {
    var faces = faces
        private set
    var quantityOfThrows = 0
        private set

    constructor() : this(faces = 6)

    fun throwDice(): Int {
        quantityOfThrows++
        return (1..faces).random()
    }

    companion object{
        fun throwDiceNFaces(face : Int): Int {
            return (1..face).random()
        }
    }

    override fun toString(): String {
        return "Numero de caras: $faces y veces lanzadas: $quantityOfThrows"
    }
}