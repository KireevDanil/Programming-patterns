class Student(
    private var id: Int,
    private var lastName: String,
    private var firstName: String,
    private var middleName: String?,
    private var phone: String? = null,
    private var telegram: String? = null,
    private var email: String? = null,
    private var git: String? = null
) {
    constructor(id: Int, lastName: String, firstName: String, middleName: String) : this(
        id, lastName, firstName, middleName, null, null, null, null
    )
    fun getId() = id
    fun setId(value: Int) {
        id = value
    }

    fun getLastName() = lastName
    fun setLastName(value: String) {
        lastName = value
    }

    fun getFirstName() = firstName
    fun setFirstName(value: String) {
        firstName = value
    }

    fun getMiddleName() = middleName
    fun setMiddleName(value: String?) {
        middleName = value
    }

    fun getPhone() = phone
    fun setPhone(value: String?) {
        phone = value
    }

    fun getTelegram() = telegram
    fun setTelegram(value: String?) {
        telegram = value
    }

    fun getEmail() = email
    fun setEmail(value: String?) {
        email = value
    }

    fun getGit() = git
    fun setGit(value: String?) {
        git = value
    }
}
