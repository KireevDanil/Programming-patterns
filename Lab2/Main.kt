fun main() {
    val student = Student(1, "Иванов Иван Иванович", "github.com/ivan", "+79181231212")
    println(student) 

    val shortStudent = Student_short(student)
    println(shortStudent) 

    val shortStudent2 = Student_short(2, "Петров П.В.|github.com/petr|+79603213485")
    println(shortStudent2) 
}
