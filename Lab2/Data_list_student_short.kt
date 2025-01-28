class Data_list_student_short(elements: List<Student_short>) :
    Data_list<Student_short>(elements) {

    // Переопределяем метод get_names
    override fun get_names(): List<String> {
        return listOf("Фамилия", "Git", "Контакт")
    }

    // Переопределяем метод get_data
    override fun get_data(): Data_table<Any> {
        val tableData = elements.mapIndexed { index, student ->
            // Генерируем строку для Data_table: индекс, Фамилия, Git, контакт
            listOf(index + 1, student.surnameInitials, student.git, student.contact)
        }
        // Возвращаем объект Data_table с подготовленными данными
        return Data_table.create(tableData)
    }
}
