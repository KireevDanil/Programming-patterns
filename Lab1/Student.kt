class Student(
    val id: Int,
    val lastName: String,
    val firstName: String,
    val middleName: String?
) {
    var telegram: String? = null
        set(value) {
            if (value != null && !isTelegramValid(value)) {
                throw IllegalArgumentException("У студент с ID $id неверный формат Telegram: $value")
            }
            field = value
        }

    var email: String? = null
        set(value) {
            if (value != null && !isEmailValid(value)) {
                throw IllegalArgumentException("У студента с ID $id неверный формат email: $value")
            }
            field = value
        }

    var git: String? = null
        set(value) {
            if (value != null && !isGitUrlValid(value)) {
                throw IllegalArgumentException("У студент с ID $id неверный формат Git: $value")
            }
            field = value
        }
    var phone: String? = null
        set(value) {
            if (value != null && !isPhoneNumberValid(value)) {
                throw IllegalArgumentException("У студента с id=${id} неверный формат номера телефона: $value")
            }
            field = value
        }

    // Вторичный конструктор с телефоном
    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        middleName: String?,
        phone: String
    ) : this(id, lastName, firstName, middleName) {
        this.phone = phone // Проверка номера через сеттер
    }
    //Вторичный конструктор для дбавления телефона и телеграмма
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
    // Вторичный конструктор для всех полей
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
    fun setContacts(
        phone: String? = null,
        telegram: String? = null,
        email: String? = null,
        git: String? = null
    ) {
        if (phone != null) this.phone = phone
        if (telegram != null) this.telegram = telegram
        if (email != null) this.email = email
        if (git != null) this.git = git
    }
    // Метод для вывода информации о студенте
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
    // Метод validate: проверяет наличие Git и хотя бы одного контакта
    fun validate() {
        if (!hasGit()) {
            println("У студента с ID $id отсутствует ссылка на Git.")
        }
        if (!hasAnyContact()) {
            println("У студента с ID $id должен быть хотя бы один контактный способ связи.")
        }
    }

    // Проверка наличия Git
    private fun hasGit(): Boolean {
        return !git.isNullOrBlank()
    }

    // Проверка наличия хотя бы одного контакта
    private fun hasAnyContact(): Boolean {
        return !phone.isNullOrBlank() || !telegram.isNullOrBlank() || !email.isNullOrBlank()
    }

    companion object {
        // Метод для проверки корректности номера телефона
        fun isPhoneNumberValid(phone: String): Boolean {
            val regex = Regex("^\\+7\\d{10}$")
            return regex.matches(phone)
        }
        fun isTelegramValid(telegram: String): Boolean {
            val regex = Regex("^@[a-zA-Z0-9_]{5,32}$")
            return regex.matches(telegram)
        }

        fun isEmailValid(email: String): Boolean {
            val regex = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
            return regex.matches(email)
        }

        fun isGitUrlValid(git: String): Boolean {
            val regex = Regex("^github\\.com/[a-zA-Z0-9_-]+/?$")
            return regex.matches(git)
        }
    }
}
