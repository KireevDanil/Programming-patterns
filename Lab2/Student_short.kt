class Student_short:StudentBase {
    constructor(student: Student) : super(
        ID = student.ID,
        surnameInitials = student.surnameInitials,
        git = student.git,
        contact = student.contact
    )

    constructor(ID: Int, data: String) : super(
        ID = ID,
        surnameInitials = parseData(data, 0),
        git = parseData(data, 1),
        contact = parseData(data, 2)
    )

    companion object {
        private fun parseData(data: String, index: Int): String {
            val parts = data.split("|").map { it.trim() }
            return parts.getOrNull(index) ?: throw ParsingException("Ошибка парсинга данных")
        }
    }
}
