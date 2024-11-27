package com.plcoding.bookpedia

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.bookpedia.book.presentation.book_list.components.BookSearchBar

@Preview
@Composable
fun BookSearchBarPreview() {
    MaterialTheme {
        BookSearchBar(
            searchQuery = "kotlin",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}