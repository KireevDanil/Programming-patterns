class Data_list_student_short(elements: List<Student_short>) :
    Data_list<Student_short>(elements) {

    override fun get_names(): List<String> {
        return listOf("Фамилия", "Git", "Контакт")
    }

    // Извлечение атрибутов из объекта Student_short
    override fun extractAttributes(element: Student_short): Array<Any> {
        return arrayOf(element.surnameInitials, element.git, element.contact)
    }
}
