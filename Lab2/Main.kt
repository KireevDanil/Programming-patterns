fun main() {
    val validString = "Киреев Данил Максимович|21|github.com/kireev|+79186666666"
    val invalidString = "Иванов Иван Иванович|21|github.com/kireev|+796086634122"

    try {
        val student1 = Student(validString)
        println("Студент успешно создан $student1")
        println("Инфа: ${student1.getInfo()}")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }

    try {
        val student2 = Student(invalidString)
        println("Студент успешно создан: $student2")
        println("Info: ${student2.getInfo()}")
    } catch (e: ParsingException) {
        println("Ошибка парсинга: ${e.message}")
    } catch (e: ValidationException) {
        println("Ошибка валидации: ${e.message}")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}
