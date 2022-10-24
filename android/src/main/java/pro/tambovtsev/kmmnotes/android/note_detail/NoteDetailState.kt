package pro.tambovtsev.kmmnotes.android.note_detail

data class NoteDetailState(
    val noteTitle: String = "",
    val isNoteTitleHintVisible: Boolean = false,
    val noteContent: String = "",
    val isNoteContentVisisble: Boolean = false,
    val noteColor: Long = 0xFFFFFF
)
