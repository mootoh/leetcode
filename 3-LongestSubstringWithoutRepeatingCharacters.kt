import kotlin.math.max

class Solution {
    fun helper(seq: CharSequence): Int {
        val appeared = mutableMapOf<Char, Boolean>()
        var str = ""
        run loop@ {
            seq.forEach {
                if (appeared.get(it) != null) {
                    return@loop
                }
                appeared.put(it, true)
                str += it
            }
        }
        return str.length
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        for (i in 0..(s.length-1)) {
            result = max(helper(s.subSequence(i, s.length)), result)
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(Solution().lengthOfLongestSubstring("abcabcbb"))
    println(Solution().lengthOfLongestSubstring("bbbbbb"))
    println(Solution().lengthOfLongestSubstring("pwwkew"))
}