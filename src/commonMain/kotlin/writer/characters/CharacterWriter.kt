package writer.characters

import characters.CharacterWithLogs

class CharacterWriter(override val character: Char, override val log: String) : CharacterWithLogs {

    fun wrapWithLogs(x: Char): CharacterWithLogs {
        return CharacterWriter(x, "")
    }

    fun runWithLogs(
        input: CharacterWithLogs,
        transform: (_: Char) -> CharacterWithLogs
    ): CharacterWithLogs {
        val middleCharacterWithLogs = transform(input.character)
        return CharacterWriter(
            middleCharacterWithLogs.character,
            input.log + middleCharacterWithLogs.log
        )
    }
}