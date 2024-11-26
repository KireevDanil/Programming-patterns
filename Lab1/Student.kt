class Student(
    var id: Int,
    var lastName: String,
    var firstName: String,
    var middleName: String?,
    var phone: String? = null,
    var telegram: String? = null,
    var email: String? = null,
    var git: String? = null
) {
    init {
        // Проверяем обязательные поля
        require(lastName.isNotBlank() && firstName.isNotBlank()) { "Фамилия и имя не могут быть пустыми" }
    }

    fun printInfo() {
        println(
            """
            ID: $id
            ФИО: $lastName $firstName ${middleName ?: ""}
            Телефон: ${phone ?: "не указан"}
            Telegram: ${telegram ?: "не указан"}
            Почта: ${email ?: "не указана"}
            Git: ${git ?: "не указан"}
            """.trimIndent()
        )
    }
}
