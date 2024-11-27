package com.plcoding.bookpedia.book.presentation.book_list.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cmp_bookpedia.composeapp.generated.resources.Res
import cmp_bookpedia.composeapp.generated.resources.search_hint
import com.plcoding.bookpedia.core.presentation.DarkBlue
import com.plcoding.bookpedia.core.presentation.SandYellow
import org.jetbrains.compose.resources.stringResource


@Composable
fun BookSearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    onImeSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = onSearchQueryChange,
        shape = RoundedCornerShape(100),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = DarkBlue,
            focusedBorderColor = SandYellow,
        ),
        placeholder = {
            Text(stringResource(Res.string.search_hint))
        }
    )
}