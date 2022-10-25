package pro.tambovtsev.kmmnotes.data.di

import pro.tambovtsev.kmmnotes.data.local.DatabaseDriverFactory
import pro.tambovtsev.kmmnotes.data.note.SqlDelightNoteDataSource
import pro.tambovtsev.kmmnotes.domain.NoteDataSource
import pro.tambovtsev.notekmm.database.NoteDatabase

class DatabaseModule {
    private val factory by lazy {DatabaseDriverFactory()}
     val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}