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
    companion object {
        private fun formatName(name: String): String {
            val parts = name.split(" ")
            val surname = parts[0]
            val initials = parts.drop(1).joinToString("") { it.take(1).uppercase() + "." }
            return "$surname $initials"
        }

    }
}
