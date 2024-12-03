class Student(
    val id: Int,
    val lastName: String,
    val firstName: String,
    val middleName: String?
) {
    var telegram: String? = null
    var email: String? = null
    var git: String? = null
    var phone: String? = null
        set(value) {
            if (value != null && !isPhoneNumberValid(value)) {
                throw IllegalArgumentException("У студента с id=${id} неверный формат номера телефона: $value")
            }
            field = value
        }

    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        middleName: String?,
        phone: String
    ) : this(id, lastName, firstName, middleName) {
        this.phone = phone
    }
    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        middleName: String?,
        phone: String,
        telegram: String
    ) : this(id, lastName, firstName, middleName, phone) {
        this.telegram = telegram
    }
    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        middleName: String?,
        phone: String?,
        telegram: String?,
        email: String?,
        git: String?
    ) : this(id, lastName, firstName, middleName) {
        this.phone = phone
        this.telegram = telegram
        this.email = email
        this.git = git
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

    companion object {
        fun isPhoneNumberValid(phone: String): Boolean {
            val regex = Regex("^\\+7\\d{10}$")
            return regex.matches(phone)
        }
    }
}
