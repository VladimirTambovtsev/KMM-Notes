package pro.tambovtsev.kmmnotes.data.note

import pro.tambovtsev.kmmnotes.domain.DateTimeUtil
import pro.tambovtsev.kmmnotes.domain.Note
import pro.tambovtsev.kmmnotes.domain.NoteDataSource
import pro.tambovtsev.notekmm.database.NoteDatabase

class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {
    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(note.id, note.title, note.content, note.colorHex, DateTimeUtil.toEpochMillis(note.created))
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries.getNoteById(id).executeAsOneOrNull()?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes().executeAsList().map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        return queries.deleteNoteById(id)
    }

}