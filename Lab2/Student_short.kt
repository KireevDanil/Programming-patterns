class Student_short {
    val ID: Int
    val surnameInitials: String
    val git: String
    val contact: String

    constructor(student: Student) {
        this.ID = student.ID
        this.surnameInitials = student.getShortName()
        this.git = student.fetchGit()
        this.contact = student.getPhoneInfo()
    }

    constructor(ID: Int, data: String) {
        this.ID = ID

        val parts = data.split("|").map { it.trim() }
        if (parts.size < 3) throw ParsingException("Ошибка парсинга строки: недостаточно данных")
        this.surnameInitials = parts[0]
        this.git = parts[1]
        this.contact = parts[2]
    }

    override fun toString(): String {
        return "ID: $ID, ФИО: $surnameInitials, Git: $git, Контакт: $contact"
    }
}
