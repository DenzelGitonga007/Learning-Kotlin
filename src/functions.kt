import java.util.*
fun main() {
    //Predefined functions
    println("Hello Glory")

    var squareroot=Math.sqrt(256.0)
    println(squareroot)

    var roundoff=Math.round(34.56)
    println(roundoff)

    var number=Math.ceil(45.67)
    println(number)

    myFun()
    add()
    details("", 31)
    details("", 18)
    details("", 17)


}


//User-defined Functions
fun myFun(){
    println("Today is Friday")
}

fun add(){
    var number1=5
    var number2=10
    println(number1+number2)
}

fun details(my_name:String, age:Int){
    var reader = Scanner(System.`in`)
    println("Enter name : ")
    var my_name = readln()

    println("$my_name is $age years old")
}