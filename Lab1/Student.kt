class Student(
    val id: Int,
    val lastName: String,
    val firstName: String,
    val middleName: String?
) {
    var phone: String? = null
    var telegram: String? = null
    var email: String? = null
    var git: String? = null
    // Вторичный конструктор для добавления телефона
    constructor(
        id: Int,
        lastName: String,
        firstName: String,
        middleName: String?,
        phone: String
    ) : this(id, lastName, firstName, middleName) {
        this.phone = phone
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
