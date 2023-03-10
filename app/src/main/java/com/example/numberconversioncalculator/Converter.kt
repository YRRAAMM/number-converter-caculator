package com.example.numberconversioncalculator

// number, from, to
class Converter() {

    fun getNumber(from: Type, to: Type, number: String): String {
        if (number.isEmpty() || !number.matches("[0-9A-Fa-f]+".toRegex())){
            return ";)"
        }
        val x: String = when (from) {
            Type.DEC -> Dec(to, number.toInt())
            Type.BIN -> Bin(to, number)
            Type.HEX -> Hex(to, number)
            Type.OCT -> Oct(to, number)
        }
        return x
    }

    fun Dec(to: Type, decNumber: Int): String {
        return when (to) {
            Type.BIN -> Integer.toBinaryString(decNumber)
            Type.OCT -> Integer.toOctalString(decNumber)
            Type.HEX -> Integer.toHexString(decNumber)
            else -> { decNumber.toString()}
        }
    }

    fun Oct(to: Type, octNumber: String): String {
        if (octNumber.matches("[0-7]+".toRegex())) {
            val dec = Integer.parseInt(octNumber, 8)

            return when (to) {
                Type.DEC -> dec.toString()
                Type.BIN -> Integer.toBinaryString(dec)
                Type.HEX -> Integer.toHexString(dec)
                else -> {
                    octNumber
                }
            }
        }
        return ";)"
    }

    fun Hex(to: Type, hexNumber: String): String {
        val dec = Integer.parseInt(hexNumber, 16)

        return when (to) {
            Type.DEC -> dec.toString()
            Type.BIN -> Integer.toBinaryString(dec)
            Type.OCT -> Integer.toOctalString(dec)
            else -> { hexNumber}
        }
    }

    fun Bin(to: Type, binNumber: String): String {
        val dec = Integer.parseInt(binNumber, 2)

        return when (to) {
            Type.DEC -> dec.toString()
            Type.HEX -> Integer.toHexString(dec)
            Type.OCT -> Integer.toOctalString(dec)
            else -> { binNumber }
        }
    }
}