package writer.arrays

import arrays.ArrayWithLogs

class ArrayWriter(override val array: Array<Any>, override val log: String) : ArrayWithLogs {

    fun wrapWithLogs(x: Array<Any>): ArrayWithLogs {
        return ArrayWriter(x, "")
    }

    fun runWithLogs(
        input: ArrayWithLogs,
        transform: (_: Array<Any>) -> ArrayWithLogs
    ): ArrayWithLogs {
        val middleArrayWithLogs = transform(input.array)
        return ArrayWriter(
            middleArrayWithLogs.array,
            input.log + middleArrayWithLogs.log
        )
    }
}