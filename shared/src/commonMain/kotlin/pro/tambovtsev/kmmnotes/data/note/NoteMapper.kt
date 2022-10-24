package pro.tambovtsev.kmmnotes.data.note

import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import pro.tambovtsev.kmmnotes.domain.Note

fun NoteEntity.toNote(): Note {
    return Note(id, title, content, colorHex = color, created = Instant.fromEpochMilliseconds(created).toLocalDateTime(TimeZone.currentSystemDefault()))
}