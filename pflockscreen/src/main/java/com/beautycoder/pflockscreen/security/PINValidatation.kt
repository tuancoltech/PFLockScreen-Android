package com.beautycoder.pflockscreen.security

fun String.isValidPin(): Boolean {

    // Check if all digits are the same
    if (this.toSet().size == 1) return false

    // Check for consecutive ascending or descending digits
    if (this.isConsecutive()) {
        return false
    }

    // Passed all checks, PIN is valid
    return true
}

// Extension function to check for consecutive digits
private fun String.isConsecutive(): Boolean {
    var isAscending = true
    var isDescending = true

    for (i in 0 until this.length - 1) {
        val current = this[i].digitToInt()
        val next = this[i + 1].digitToInt()

        if (next != current + 1) isAscending = false
        if (next != current - 1) isDescending = false
    }

    return isAscending || isDescending
}