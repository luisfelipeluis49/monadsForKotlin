package writer.booleans

import booleans.BooleanWithLogs

class BooleanWriter(override val boolean: Boolean, override val log: String) : BooleanWithLogs {

    fun wrapWithLogs(x: Boolean): BooleanWithLogs {
        return BooleanWriter(x, "")
    }

    fun runWithLogs(
        input: BooleanWithLogs,
        transform: (_: Boolean) -> BooleanWithLogs
    ): BooleanWithLogs {
        val middleBooleanWithLogs = transform(input.boolean)
        return BooleanWriter(
            middleBooleanWithLogs.boolean,
            input.log + middleBooleanWithLogs.log
        )
    }
}