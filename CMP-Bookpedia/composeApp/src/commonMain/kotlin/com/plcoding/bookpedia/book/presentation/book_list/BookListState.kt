package com.plcoding.bookpedia.book.presentation.book_list

import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "",
    val books: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: UiText? = null,
    val selectedIndex:Int  =  0,
)
