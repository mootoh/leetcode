class Solution {
    val lookup: Map<Char, Int> = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
        )
    val prefixes: Map<Char, Char> = mapOf(
        'V' to 'I',
        'X' to 'I',
        'L' to 'X',
        'C' to 'X',
        'D' to 'C',
        'M' to 'C'
    )

    fun romanToInt(s: String): Int {
        if (s.length == 0) return 0

        var result = lookup.getOrDefault(s.get(0), 0)
        if (s.length == 1) return result

        var i = 1
        var j = 0

        while (i < s.length) {
            val cur = s.get(i)
            var prev = s.get(j)

            result += lookup.getOrDefault(cur, 0)

            if (prefixes[cur] == prev)
                result -= 2 * lookup.getOrDefault(prev, 0)

            i += 1
            j += 1
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(Solution().romanToInt("I"))
    println(Solution().romanToInt("II"))
    println(Solution().romanToInt("III"))
    println(Solution().romanToInt("IV"))
    println(Solution().romanToInt("V"))
    println(Solution().romanToInt("VI"))
    println(Solution().romanToInt("VII"))
    println(Solution().romanToInt("VIII"))
    println(Solution().romanToInt("IX"))
    println(Solution().romanToInt("X"))
    println(Solution().romanToInt("XV"))
    println(Solution().romanToInt("LVIII"))
    println(Solution().romanToInt("MCMXCIV"))
}