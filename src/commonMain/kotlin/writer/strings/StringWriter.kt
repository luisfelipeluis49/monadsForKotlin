package writer.strings

import strings.StringWithLogs

class StringWriter(override val string: String, override val log: String) : StringWithLogs {

    fun wrapWithLogs(x: String): StringWithLogs {
        return StringWriter(x, "")
    }

    fun runWithLogs(
        input: StringWithLogs,
        transform: (_: String) -> StringWithLogs
    ): StringWithLogs {
        val middleStringWithLogs = transform(input.string)
        return StringWriter(
            middleStringWithLogs.string,
            input.log + middleStringWithLogs.log
        )
    }
}