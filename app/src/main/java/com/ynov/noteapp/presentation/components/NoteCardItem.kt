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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ynov.noteapp.domain.model.Note

@Composable
fun NoteCardItem(
    note: Note,
    onClickDelete: () -> Unit = {},
    onClickEdit: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                maxLines = 1,
                text = note.title,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp).weight(1f))

            Text(
                maxLines = 5,
                text = note.content,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp).weight(3f))
            Row(
                modifier = Modifier.fillMaxWidth().weight(1f),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.End)
            ) {
                IconButton(
                    modifier = Modifier.background(
                        color = Color.Black,
                        shape = CircleShape
                    ),
                    onClick = { onClickEdit() },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Black)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "",
                        tint = Color.White)
                }

                IconButton(
                    modifier = Modifier.background(
                        color = Color.Black,
                        shape = CircleShape),
                    onClick = { onClickDelete() },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.DarkGray)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
