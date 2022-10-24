package pro.tambovtsev.kmmnotes.android.note_list

import pro.tambovtsev.kmmnotes.domain.Note

data class NoteListState(val notes: List<Note> = emptyList(),
                         val searchText: String = "",
                         val isSearchActive: Boolean = false)