class Data_table<T> private constructor(private val data: Array<Array<T>>) {
    fun getElement(rowIndex: Int, colIndex: Int): T {
        if (rowIndex < 0 || rowIndex >= data.size || colIndex < 0 || colIndex >= data[rowIndex].size) {
            throw IndexOutOfBoundsException("Индексы выходят за пределы таблицы")
        }
        return data[rowIndex][colIndex]
    }

    // Метод для получения количества строк
    fun getRowCount(): Int = data.size

    // Метод для получения количества столбцов
    fun getColumnCount(): Int {
        return if (data.isNotEmpty()) data[0].size else 0
    }
    companion object {
        fun <T> create(data: Array<Array<T>>): Data_table<T> {
            return Data_table(data)
        }
    }
}
