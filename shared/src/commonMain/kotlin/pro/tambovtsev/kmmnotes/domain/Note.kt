package pro.tambovtsev.kmmnotes.domain

import kotlinx.datetime.LocalDateTime
import pro.tambovtsev.kmmnotes.presentation.PrimaryColor
import pro.tambovtsev.kmmnotes.presentation.SecondaryColor
import pro.tambovtsev.kmmnotes.presentation.TertiaryColor
import pro.tambovtsev.kmmnotes.presentation.WarningColor

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime
) {
    companion object {
        private val colors = listOf(PrimaryColor, SecondaryColor, TertiaryColor, WarningColor)

        fun generateColor() = colors.random()
    }
}

