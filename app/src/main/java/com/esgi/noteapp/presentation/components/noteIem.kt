package com.esgi.noteapp.presentation.components

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
