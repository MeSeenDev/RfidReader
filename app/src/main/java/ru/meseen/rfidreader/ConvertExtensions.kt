package ru.meseen.rfidreader

import java.math.BigInteger
import java.nio.charset.StandardCharsets

/**
 * @author Vyacheslav Doroshenko
 */


/**
 * Convert byte array to a string of the specified format.
 * Format value corresponds to the pref radio button sequence.
 * @param bytes Bytes to convert.
 * @param fmt Format (0=Hex; 1=DecBE; 2=DecLE).
 * @return The bytes in the specified format.
 */
fun ByteArray.byte2FmtString(fmt: Int): String {
    when (fmt) {
        2 -> {
            val revBytes = copyOf()
            revBytes.reverse()
            return revBytes.bytes2Hex.hex2Dec
        }
        1 -> return bytes2Hex.hex2Dec
    }
    return bytes2Hex
}

/**
 * Convert a hexadecimal string to a decimal string.
 * Uses BigInteger only if the hexadecimal string is longer than 7 bytes.
 * @param hex The hexadecimal value to convert.
 * @return String representation of the decimal value of hexString.
 */
val String.hex2Dec: String
    get() {
        if (!(length % 2 == 0 && matches("[0-9A-Fa-f]+".toRegex()))) {
            return "null"
        }
        val ret: String = if (isEmpty()) {
            "0"
        } else if (length <= 14) {
            toLong(16).toString()
        } else {
            val bigInteger = BigInteger(this, 16)
            bigInteger.toString()
        }
        return ret
    }


/**
 * Convert an array of bytes into a string of hex values.
 * @param bytes Bytes to convert.
 * @return The bytes in hex string format.
 */
val ByteArray.bytes2Hex: String
    get() = joinToString(separator = "") { String.format("%02X", it.toInt() and 0xFF) }


/**
 * Convert a string of hex data into a byte array.
 * Original author is: Dave L. (http://stackoverflow.com/a/140861).
 * @param hex The hex string to convert
 * @return An array of bytes with the values of the string.
 */
val String.hex2Bytes: ByteArray
    get() {
        if (!(this.length % 2 == 0 && this.matches("[0-9A-Fa-f]+".toRegex()))) {
            return byteArrayOf()
        }
        val len = this.length
        val data = ByteArray(len / 2)
        try {
            var i = 0
            while (i < len) {
                data[i / 2] = ((((this[i].digitToIntOrNull(16)
                    ?: (-1 shl 4)) + this[i + 1].digitToIntOrNull(16)!!) ?: -1)).toByte()
                i += 2
            }
        } catch (e: Exception) { /*ignore */
        }
        return data
    }

/**
 * Convert a hex string to ASCII string.
 * @param hex Hex string to convert.
 * @return Converted ASCII string. Null on error.
 */
val String.hex2Ascii: String
    get() {
        if (!(this.length % 2 == 0 && this.matches("[0-9A-Fa-f]+".toRegex()))) {
            return "null"
        }
        val bytes = this.hex2Bytes
        // Replace non printable ASCII with ".".
        for (i in bytes.indices) {
            if (bytes[i] < 0x20.toByte() || bytes[i] == 0x7F.toByte()) {
                bytes[i] = 0x2E.toByte()
            }
        }
        // Hex to ASCII.
        return String(bytes, StandardCharsets.US_ASCII)
    }

/**
 * Convert a ASCII string to a hex string.
 * @param ascii ASCII string to convert.
 * @return Converted hex string.
 */
val String.ascii2Hex: String
    get() =
        takeIf { isNotBlank() }?.map { String.format("%02X", it.code) }
            ?.joinToString(separator = "") ?: "null"


/**
 * Convert a hex string to a binary string (with leading zeros).
 * @param hex Hex string to convert.
 * @return Converted binary string.
 */
val String.hex2Bin: String
    get() {
        if (!(length % 2 == 0 && matches("[0-9A-Fa-f]+".toRegex()))) {
            return "null"
        }
        var bin = BigInteger(this, 16).toString(2)
        // Pad left with zeros (have not found a better way...).
        if (bin.length < length * 4) {
            val diff = length * 4 - bin.length
            val pad = StringBuilder()
            for (i in 0 until diff) {
                pad.append("0")
            }
            pad.append(bin)
            bin = pad.toString()
        }
        return bin
    }

val String.bin2Hex: String
    get() {
        if (!(length % 8 == 0 && matches("[0-1]+".toRegex()))) {
            return "null"
        }
        var hex = BigInteger(this, 2).toString(16)
        if (hex.length % 2 != 0) {
            hex = "0$hex"
        }
        return hex
    }