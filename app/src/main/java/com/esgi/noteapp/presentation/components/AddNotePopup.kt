package com.esgi.noteapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esgi.noteapp.domain.model.Note

@Composable
fun AddNotePopup(
    modifier: Modifier = Modifier,
    onDismissClick: () -> Unit = {},
    onConfirmClick: (Note) -> Unit = {}
) {

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    val onTitleChange = { text: String ->
        title = text
    }

    val onContentChange = { text: String ->
        content = text
    }

    AlertDialog(
        modifier = modifier,
        onDismissRequest = { /*TODO*/ },
        title = {
            Text(text = "Add Note")
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = onTitleChange,
                    label = { Text(text = "Title") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = content,
                    onValueChange = onContentChange,
                    label = { Text(text = "Content") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            Button(onClick = { onConfirmClick(Note(
                title = title,
                content = content
            )) }) {
                Text(text = "Add note")
            }
        },
        dismissButton = {
            Button(onClick = { onDismissClick() }) {
                Text(text = "Cancel")
            }
        },
        shape = RoundedCornerShape(10.dp)
    )
}

@Preview
@Composable
private fun AddNotePopupPreview() {
    AddNotePopup()
}