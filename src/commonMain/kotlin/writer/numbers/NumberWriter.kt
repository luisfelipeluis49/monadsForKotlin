package writer.numbers

import numbers.NumberWithLogs

class NumberWriter(override val number: Number, override val log: String) : NumberWithLogs {

    fun wrapWithLogs(x: Number): NumberWithLogs {
        return NumberWriter(x, "")
    }

    fun runWithLogs(
        input: NumberWithLogs,
        transform: (_: Number) -> NumberWithLogs
    ): NumberWithLogs {
        val middleNumberWithLogs = transform(input.number)
        return NumberWriter(
            middleNumberWithLogs.number,
            input.log + middleNumberWithLogs.log
        )
    }
}