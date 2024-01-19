//Use nullable variables

fun main() {
    val favoriteActor = null
    println(favoriteActor)
}

var favoriteActor: String = "Sandra Oh"
favoriteActor = "Meryl Streep"

fun main() {
    var favoriteActor: String = "Sandra Oh"
    println(favoriteActor)
}

fun main() {
    var favoriteActor: String = "Sandra Oh"
    favoriteActor = null
}

fun main() {
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor)

    favoriteActor = null
    println(favoriteActor)
}

fun main() {
    var number: Int? = 10
    println(number)
}

fun main() {
    var number: Int? = 10
    println(number)
    
    number = null
    println(number)
}

//handle nullable variables
fun main() {
    var favoriteActor: String = "Sandra Oh"
    println(favoriteActor.length)
}

fun main() {
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor.length)
}

fun main() {
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor?.length)
}

fun main() {
    var favoriteActor: String? = null
    println(favoriteActor?.length)
}

fun main() {
    var favoriteActor: String? = "Sandra Oh"
    println(favoriteActor!!.length)
}

fun main() {
    var favoriteActor: String? = null
    println(favoriteActor!!.length)
}

fun main() {
    var favoriteActor: String? = "Sandra Oh"

    if (favoriteActor != null) {
      println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    }
}

fun main() {
    var favoriteActor: String? = null

    if(favoriteActor != null) {
      println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
    } else {
      println("You didn't input a name.")
    }
}

fun main() {
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = if (favoriteActor != null) {
      favoriteActor.length
    } else {
      0
    }

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}

//elvis operator
fun main() {
    var favoriteActor: String? = "Sandra Oh"

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}


