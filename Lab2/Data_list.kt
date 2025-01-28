class Data_list<T : Comparable<T>> private constructor(private val elements: List<T>) {

    fun getElement(index: Int): T {
        require(index in elements.indices) { "Индекс выходит за пределы списка" }
        return elements[index]
    }
    // Получение кол-ва элементов
    fun getSize(): Int = elements.size
    // Получение списка
    fun toList(): List<T> = elements.toList()

    companion object {
        fun <T : Comparable<T>> create(elements: List<T>): Data_list<T> {
            return Data_list(elements.sorted())
        }
    }

}
