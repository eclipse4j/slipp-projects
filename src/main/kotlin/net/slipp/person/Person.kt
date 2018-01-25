package net.slipp.person

data class Person(var name: String, var age: Int? =null)

fun getOOOOOldAgePerson(): Person {
    var persons = listOf<Person>(Person("장진달", age = 46), Person("박재성", age = 45), Person("김현기", age = 45))
    return persons.sortedWith(compareByDescending( { it.age })).first()
}