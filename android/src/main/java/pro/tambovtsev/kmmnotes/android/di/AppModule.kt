package pro.tambovtsev.kmmnotes.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pro.tambovtsev.kmmnotes.data.local.DatabaseDriverFactory
import pro.tambovtsev.kmmnotes.data.note.SqlDelightNoteDataSource
import pro.tambovtsev.kmmnotes.domain.NoteDataSource
import pro.tambovtsev.notekmm.database.NoteDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDatasSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}