import java.io.IOException
fun main() {
    val filePath = "students.txt"

    try {
        val students = Student.read_from_txt(filePath)
        println("Список студентов:")
        students.forEach { println(it) }
    } catch (e: IOException) {
        println("Ошибка при работе с файлом: ${e.message}")
    } catch (e: ParsingException) {
        println("Ошибка при парсинге данных: ${e.message}")
    } catch (e: ValidationException) {
        println("Ошибка валидации данных: ${e.message}")
    }
}
