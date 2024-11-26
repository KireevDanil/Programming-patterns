fun main() {
    val student1 = Student(1, "Киреев", "Данил", "Максимович")
    student1.setPhone("89184444444")
    student1.setTelegram("@danil")
    student1.setEmail("kireev@gmail.com")
    student1.setGit("github.com/kireev")
    val student2 = Student(2, "Петров", "Петр", "Петрович")
    student2.setPhone("89604567101")
    student2.setTelegram("@petr")
    val student3 = Student(3, "Иванов", "Алексей", "Сергеевич")
    student3.setTelegram("@ivanov")
    student3.setGit("github.com/ivanov")

    println("Информация о студентах:")
    student1.printInfo()
    student2.printInfo()
    student3.printInfo()
}
