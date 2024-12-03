fun main() {
    try {
        val student1 = Student(
            id = 1,
            lastName = "Киреев",
            firstName = "Данил",
            middleName = "Максимович",
            phone = "+79184444444",
            telegram = "@danil",
            email = "kireev@gmail.com",
            git = "github.com/kireev"
        )
        student1.printInfo()
        student1.validate()
    }catch (e: IllegalArgumentException){
        println("Ошибка: ${e.message}")
    }catch (e: IllegalStateException) {
        println("Ошибка: ${e.message}")
    }
    try {
        val student2 = Student(
            id = 2,
            lastName = "Петров",
            firstName = "Петр",
            middleName = "Петрович",
            phone = "89604567101"
        )
        student2.printInfo()
        student2.validate()
    }catch (e: IllegalArgumentException){
        println("Ошибка: ${e.message}")
    }

    try {
        val student3 = Student(
            id = 3,
            lastName = "Сидоров",
            firstName = "Алексей",
            middleName = "Сергеевич",
            phone = "+78005553535",
            telegram = "@sidorov"
        )
        student3.printInfo()
        student3.validate()
    }catch (e: IllegalArgumentException){
        println("Ошибка: ${e.message}")
    }
    try {
        val student4 = Student(
            id = 4,
            lastName = "Иванов",
            firstName = "Аркадий",
            middleName = "Пупкович"
        )
        student4.printInfo()
        student4.validate()
    }catch (e: IllegalArgumentException){
        println("Ошибка: ${e.message}")
    }
}
