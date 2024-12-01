package com.composablecode.coroutinesflow.sections.coroutine_basics

suspend fun fetchData(
    peopleDao: PeopleDao,
    client: HttpClient
) {
    val response = client.get("/people/1")
    peopleDao.insertPerson(Person(name = "John Doe"))
}