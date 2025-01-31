import kotlin.system.exitProcess

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswer: Int
)

fun main() {
    val questions = listOf(
        Question(
            "In which year was Kotlin first released?",
            listOf("2010", "2011", "2016", "2017"),
            11
        ),
        Question(
            "What is the primary platform Kotlin is designed for?",
            listOf("Android", "iOS", "Web", "Desktop"),
            0
        ),
        Question(
            "Which company developed Kotlin?",
            listOf("Google", "JetBrains", "Microsoft", "Oracle"),
            1
        ),
        Question(
            "What is Kotlin's file extension?",
            listOf(".java", ".kt", ".kot", ".kts"),
            1
        ),
        Question(
            "Which of these is NOT a Kotlin keyword?",
            listOf("when", "val", "object", "instanceof"),
            3
        )
    )

    var score = 0
    val totalQuestions = questions.size

    println("Welcome to the Kotlin Quiz Game!")
    println("You will be asked $totalQuestions questions about Kotlin. Let's begin!\n")

    questions.forEachIndexed { index, question ->
        println("Question ${index + 1}: ${question.text}")
        question.options.forEachIndexed { i, option ->
            println("${i + 1}. $option")
        }

        var answer: Int?
        do {
            print("\nYour answer (1-${question.options.size}): ")
            answer = readlnOrNull()?.toIntOrNull()

            if (answer == null || answer !in 1..question.options.size) {
                println("Please enter a valid number between 1 and ${question.options.size}")
            }
        } while (answer == null || answer !in 1..question.options.size)

        if (answer - 1 == question.correctAnswer) {
            println("✅ Correct!\n")
            score++
        } else {
            println("❌ Incorrect! The correct answer was ${question.correctAnswer + 1}\n")
        }
    }

    println("Quiz complete!")
    println("Your final score: $score/$totalQuestions")
    println("Thanks for playing! Goodbye!")
}