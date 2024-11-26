fun main() {

    val student1 = Student(
        id = 1,
        lastName = "Киреев",
        firstName = "Данил",
        middleName = "Максимович",
        phone = "89184444444",
        telegram = "@danil",
        email = "kireev@gmail.com",
        git = "github.com/kireev"
    )
    val student2 = Student(
        id = 2,
        lastName = "Петров",
        firstName = "Петр",
        middleName = "Петрович",
        phone = "89604567101"
    )
    val student3 = Student(
        id = 3,
        lastName = "Сидоров",
        firstName = "Алексей",
        middleName = "Сергеевич",
        telegram = "@sidorov",
        git = "github.com/sidorov"
    )


    // Вывод информации о каждом студенте
    println("Информация о студентах:")
    student1.printInfo()
    student2.printInfo()
    student3.printInfo()
}
