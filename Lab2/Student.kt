import java.lang.Exception

class ParsingException(message: String) : Exception(message)

class ValidationException(message: String) : Exception(message)

class Student(val name: String, val age: Int, val git: String, val phone: String) {
    
    override fun toString(): String {
        return "$name|$age|$git|$phone"
    }
    
    constructor(data: String) : this(
        name = parseName(data),
        age = parseAge(data),
        git = parseGit(data),
        phone = parsePhone(data)
    ) {
        validate()
    }
    
    private fun validate() {
        if (name.isBlank()) throw ValidationException("Имя не должно быть пустым")
        if (age !in 1..100) throw ValidationException("Значение возраста должно быть от 1 до 100")
        if (!git.contains(Regex("^github\\.com/[a-zA-Z0-9_-]+/?$"))) throw ValidationException("Неверный формат гита")
        if(!phone.contains(Regex("^\\+7\\d{10}$"))) throw ValidationException("Неверный формат номера телефона")
    }
    // Метод для получения краткой информации о студенте
    fun getInfo(): String {
        return "${getShortName()} | ${fetchGit()} | ${getPhoneInfo()}"
    }
    //Фамилия и инициалы
    private fun getShortName(): String {
        val parts = name.split(" ")
        val surname = parts.getOrNull(0) ?: "Unknown"
        val initials = parts.drop(1).joinToString("") { it.take(1).uppercase() + "." }
        return "$surname $initials"
    }

    private fun fetchGit(): String {
        return git
    }
 
    private fun getPhoneInfo(): String {
        return phone
    }
    companion object {

        private fun parseName(data: String): String {
            return data.split("|").getOrNull(0)?.trim()
                ?: throw ParsingException("Ошибка парсинга имени")
        }

        private fun parseAge(data: String): Int {
            return data.split("|").getOrNull(1)?.trim()?.toIntOrNull()
                ?: throw ParsingException("Ошибка парсинга возраста")
        }

        private fun parseGit(data: String): String {
            return data.split("|").getOrNull(2)?.trim()
                ?: throw ParsingException("Ошибка парсинга гита")
        }

        private fun parsePhone(data: String): String {
            return data.split("|").getOrNull(3)?.trim()
                ?: throw ParsingException("Ошибка парсинга телефона")
        }

    }
}
