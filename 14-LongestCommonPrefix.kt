class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val len = strs.map { it.length }.sorted().get(0)
        var prefix = ""
        for (i in 0..len-1) {
            val ch = strs[0].get(i)
            var ok = true
            for (j in 1..strs.size-1) {
                if (ch != strs[j].get(i)) {
                    ok = false
                    break
                }
            }
            if (! ok) break
            prefix += ch
        }

        return prefix
    }
}

fun main(args: Array<String>) {
    println(Solution().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(Solution().longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}