abstract class Data_list<T : Comparable<T>>(protected val elements: List<T>) {
    private val selectedIndices = mutableSetOf<Int>()
    init {
        elements.sorted()
    }

    // Выделить элемент по номеру
    fun select(number: Int) {
        require(number in elements.indices) { "Индекс выходит за пределы списка" }
        selectedIndices.add(number)
    }

    // Получить массив id выделенных элементов
    fun get_selected(): List<Int> = selectedIndices.toList()

    // Получить массив наименований атрибутов, кроме ID
    abstract fun get_names(): List<String>

    fun get_data(): Data_table<Any> {
        val tableData = elements.mapIndexed { index, element ->
            listOf(index + 1) + extractAttributes(element).toList()
        }
        return Data_table.create(tableData)
    }

    // Шаблонный метод: извлечение атрибутов объекта
    protected abstract fun extractAttributes(element: T): Array<Any>

    // Получение элемента по индексу (дополнительный метод)
    fun getElement(index: Int): T {
        require(index in elements.indices) { "Индекс выходит за пределы списка" }
        return elements[index]
    }

    // Получение всех элементов
    fun toList(): List<T> = elements.toList()

    // Получение размера списка
    fun getSize(): Int = elements.size
}
