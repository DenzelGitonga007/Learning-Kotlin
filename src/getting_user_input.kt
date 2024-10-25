// Design a simple program which will accept user's
// 1. First Name, Middle Name and last Name.
// 2. Let the program accept the year of birth and get it to automatically calculate the age
// of the individual as of the current date.
// 3. Enter the Time worked
// 4. Enter the Rate of Pay
// 5. Calculate Total Pay based on the Rate * Time to get the Gross Total
// 6. Deduction the VAT at 18%
// 7.Deduct the PAYE and get the Net Pay total


import java.time.LocalDate

fun main(){
//    Ask user to input their name
    print("Enter your first name: ")
    val firstName = readLine()

    print("Enter your middle name: ")
    val middleName = readLine()

    print("Enter your last name: ")
    val lastName = readLine()

//    Get the current year
    val currentYear = LocalDate.now().year

//    Get the user's year of birth
    print("Enter your year of birth: ")

    val year_of_birth = readLine()?.toIntOrNull()
    if (year_of_birth != null) {
        val age = currentYear - year_of_birth
        print("Hello, $firstName $middleName, you are $age years old")
    } else{
        print("Ooops! Invalid input")
    }


}