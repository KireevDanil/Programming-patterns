import java.io.IOException
fun main() {
    fun dataTableTest() {
        val students = listOf(
            Student_short(1, "Иванов|https://github.com/ivanov/Patterns|+7-123-456-7890"),
            Student_short(2, "Петров|https://github.com/petrov/Patterns|+7-987-654-3210"),
            Student_short(3, "Сидоров|https://github.com/sidorov/Patterns|+7-456-789-0123"),
            Student_short(4, "Андреев | https://github.com/andreev | +7-918-789-0000")
        )
        val studentList = Data_list_student_short(students)
        println("Названия столбцов: ${studentList.get_names()}")
        studentList.select(0)
        studentList.select(2)
        println("Выбранные элементы: ${studentList.get_selected()}")
        val dataTable = studentList.get_data()
        println("Количество строк: ${dataTable.getRowCount()}")
        println("Количество столбцов: ${dataTable.getColumnCount()}")
        // Вывод данных таблицы
        for (i in 0 until dataTable.getRowCount()) {
            for (j in 0 until dataTable.getColumnCount()) {
                print("${dataTable.getElement(i, j)} ")
            }
            println()
        }
    }
    dataTableTest()

}
