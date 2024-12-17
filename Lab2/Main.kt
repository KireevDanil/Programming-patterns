fun main() {
    val validString = "Киреев Данил Максимович|21|github.com/kireev"
    val invalidString = "Киреев Данил Максимович|210|github.com/kireev"

    try {
        val student1 = Student(validString)
        println("Студент успешно создан $student1")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }

    try {
        val person = Student(invalidString)
        println("Студент успешно создан: $person")
    } catch (e: ParsingException) {
        println("Ошибка парсинга: ${e.message}")
    } catch (e: ValidationException) {
        println("Ошибка валидации: ${e.message}")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}
