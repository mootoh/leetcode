class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows <= 1)
            return s
        
        val N = numRows -1
        val M = 2 * N
        val rows = List<MutableList<Char>>(numRows, { mutableListOf<Char>() } )

        s.toCharArray().forEachIndexed { x, ch ->
            val y = if (x % M < N)
                x - M * (x / M)
            else
                -x + M * (x/M + 1)

            rows.get(y).add(ch)
        }

        return rows.map {
            it.joinToString("")
        }.joinToString("")
    }
}

fun main(args: Array<String>) {
    println(Solution().convert("PAYPALISHIRING", 3))
    println(Solution().convert("PAYPALISHIRING", 4))
}