/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package edu.uw.complexkotlin

class Library {
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15).
// use map() to return a list with "", "FIZZ" (for 3s) or "BUZZ" (for 5s).
// use fold() to compress the array of strings down into a single string.
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ for 0..15.
// store this lambda into 'fizzbuzz' so that the tests can call it
//
// fizzbuz is a function that takes and IntRange and returns a String
val fizzbuzz : (IntRange) -> String = {nums ->
    nums.map {n -> 
        if (n == 0) {
            ""
        } else if (n % 15 == 0) {
            "FIZZBUZZ"
        } else if (n % 3 == 0) {
            "FIZZ"
        } else if (n % 5 == 0) {
            "BUZZ"
        } else {
            ""
        }
    }.fold("") {sum, element -> sum + element}
}

// Example usage
/*
if (fizzbuzz(0..1) == "")
    println("Success!")
if (fizzbuzz(0..3) == "FIZZ")
    println("Success!")
if (fizzbuzz(0..5) == "BUZZ")
    println("Success!")
*/

// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

// Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}

// Create r1 as a lambda that calls process() with message "FOO" and a block that returns "BAR"
val r1 : () -> String = {process("FOO", {"BAR"})}

// Create r2 as a lambda that calls process() with message "FOO" and a block that upper-cases 
// r2_message, and repeats it three times with no spaces: "WOOGAWOOGAWOOGA"
val r2_message = "wooga"
val r2 : () -> String = {process("FOO", {r2_message.repeat(3).toUpperCase()})}

// write an enum-based state machine between talking and thinking
enum class Philosopher {
    THINKING {
        override fun signal() = TALKING
        override fun toString() = "Deep thoughts...."
    },

    TALKING {
        override fun signal() = THINKING
        override fun toString() = "Allow me to suggest an idea..."
    };

    abstract fun signal(): Philosopher
}

// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when invoked, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
    operator fun invoke(message: String) = prompt + message
}
