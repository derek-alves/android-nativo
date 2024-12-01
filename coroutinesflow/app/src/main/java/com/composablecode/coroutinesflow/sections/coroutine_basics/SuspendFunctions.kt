package com.composablecode.coroutinesflow.sections.coroutine_basics

import com.composablecode.coroutinesflow.utils.db.PeopleDao
import com.composablecode.coroutinesflow.utils.db.Person
import io.ktor.client.HttpClient
import io.ktor.client.request.get

suspend fun fetchData(
    peopleDao: PeopleDao,
    client: HttpClient
) {
    val response = client.get("/people/1")
    peopleDao.insertPerson(Person(name = "John Doe"))
}