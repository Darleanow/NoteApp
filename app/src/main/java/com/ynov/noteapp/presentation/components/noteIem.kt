package com.ynov.noteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynov.noteapp.domain.model.Note
import com.ynov.noteapp.ui.theme.PurpleGrey40
import com.ynov.noteapp.ui.theme.PurpleGrey80

/*
@Composable
fun NoteItem(
    note: Note = Note(title = "Titre", content = "Contenu"),
    onClickDelete: () -> Unit = {}) {
    Card(
        modifier = Modifier.fillMaxWidth().height(200.dp),
        border = CardDefaults.outlinedCardBorder(),
        colors = CardDefaults.cardColors(containerColor = PurpleGrey40)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = note.title,
                fontSize = 20.sp,
                maxLines = 1,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace,
                modifier = Modifier.weight(1f).fillMaxWidth()
            )

            Text(
                text = note.content,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.Monospace,
                maxLines = 6,
                fontSize = 10.sp,
                modifier = Modifier.weight(3f).fillMaxWidth()
            )

            HorizontalDivider(
                color = PurpleGrey80,
                thickness = 0.5.dp
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.End
            ) {

                IconButton(
                    onClick = { },
                    modifier = Modifier.background(
                        color = PurpleGrey80,
                        shape = CircleShape
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(5.dp))

                IconButton(
                    onClick = { onClickDelete() },
                    modifier = Modifier.background(
                        color = PurpleGrey80,
                        shape = CircleShape
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun NoteItemPreview() {
    NoteItem()
}*/
