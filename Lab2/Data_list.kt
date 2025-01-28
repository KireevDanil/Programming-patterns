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

    // Получить объект класса Data_table
    abstract fun get_data(): Data_table<Any>

    fun getElement(index: Int): T {
        require(index in elements.indices) { "Индекс выходит за пределы списка" }
        return elements[index]
    }

    fun toList(): List<T> = elements.toList()

    fun getSize(): Int = elements.size
}
