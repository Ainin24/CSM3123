fun main() {
    val trickFunction = trick
}

fun trick() {
    println("No treats!")
}

fun main() {
    val trickFunction = ::trick
}

fun trick() {
    println("No treats!")
}

fun main() {
    val trickFunction = trick
    trick()
}

val trick = {
    println("No treats!")
}

fun main() {
    val trickFunction = trick
    trick()
    trickFunction()
}

val trick = {
    println("No treats!")
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}

fun main() {
    val trickFunction = trick
    trick()
    trickFunction()
    treat()
}

fun main() {
    
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}

fun trickOrTreat(isTrick: Boolean): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        return treat
    }
}

fun main() {
    val treatFunction = trickOrTreat(false)
    val trickFunction = trickOrTreat(true)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat(5))
        return treat
    }
}

fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    treatFunction()
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

fun main() {
    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

val coins: (Int) -> String = {
    "$it quarters"
}

fun main() {
    val treatFunction = trickOrTreat(false, { "$it quarters" })
    val trickFunction = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
}

val treatFunction = trickOrTreat(false) { "$it quarters" }

//use repeat function
fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    repeat(4) {
        treatFunction()
    }
    trickFunction()
}