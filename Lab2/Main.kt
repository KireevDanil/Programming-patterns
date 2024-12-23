import java.io.IOException
fun main() {
    val filePath = "students.txt"

    val students = listOf(
        Student(1, "Иванов Иван Иванович", "github.com/ivan", "+71234567890"),
        Student(2, "Петров Петр Петрович", "github.com/petr", "+79876543210")
    )

    try {
        Student.write_to_txt(filePath, students)
        println("Данные успешно записаны в файл.")

        val studentsFromFile = Student.read_from_txt(filePath)
        println("Данные, считанные из файла:")

        studentsFromFile.forEach { println(it.getShortInfo()) }
    } catch (e: IOException) {
        println("Ошибка при работе с файлом: ${e.message}")
    } catch (e: ParsingException) {
        println("Ошибка при парсинге данных: ${e.message}")
    } catch (e: ValidationException) {
        println("Ошибка валидации данных: ${e.message}")
    }
}
