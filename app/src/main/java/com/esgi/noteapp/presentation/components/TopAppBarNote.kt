package com.esgi.noteapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.esgi.noteapp.theme.Pink30

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun TopAppBarNote(
    onDeleteAllListener: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Pink30
        ),
        title = {
            Text(
                text = "Notes",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.ExtraBold
            )
        },
        actions = {
            IconButton(
                onClick = { onDeleteAllListener() }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}