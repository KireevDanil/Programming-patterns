import java.io.File
import java.io.IOException

class ParsingException(message: String) : Exception(message)
class ValidationException(message: String) : Exception(message)

class Student(ID: Int,
              private val name: String,
              git: String,
              private val phone: String): StudentBase(
    ID = ID,
    surnameInitials = formatName(name),
    git = git,
    contact = phone
) {


    init {
        if (name.isBlank()) throw ValidationException("Имя не должно быть пустым")
        if (!git.contains(Regex("^github\\.com/[a-zA-Z0-9_-]+/?$"))) throw ValidationException("Неверный формат гита")
        if(!phone.contains(Regex("^\\+7\\d{10}$"))) throw ValidationException("Неверный формат номера телефона")
    }

    fun getPhoneInfo(): String = contact
    fun getShortInfo(): String {
        return "ФИО: $surnameInitials, Контакт: $contact"
    }
    companion object {
        private fun formatName(name: String): String {
            val parts = name.split(" ")
            val surname = parts[0]
            val initials = parts.drop(1).joinToString("") { it.take(1).uppercase() + "." }
            return "$surname $initials"
        }
        fun read_from_txt(filePath: String): Array<Student> {
            val file = File(filePath)
            if (!file.exists() || !file.isFile) {
                throw IOException("Неверный путь или файл не существует")
            }

            val students = mutableListOf<Student>()
            try {
                file.forEachLine { line ->
                    val data = line.split(",") 
                    if (data.size != 4) throw ParsingException("Неверное количество данных в строке: $line")

                    val ID = data[0].toIntOrNull() ?: throw ParsingException("Неверный формат ID: ${data[0]}")
                    val name = data[1]
                    val git = data[2]
                    val phone = data[3]
                    students.add(Student(ID, name, git, phone))
                }
            } catch (e: Exception) {
                throw ParsingException("Ошибка при чтении или парсинге файла: ${e.message}")
            }

            return students.toTypedArray()
        }

        fun write_to_txt(filePath: String, students: List<Student>) {
            val file = File(filePath)
            try {
                file.printWriter().use { out ->
                    students.forEach { student ->
                        out.println("${student.ID},${student.surnameInitials},${student.git},${student.contact}")
                    }
                }
            } catch (e: IOException) {
                throw IOException("Ошибка при записи в файл: ${e.message}")
            }
        }

    }
}
