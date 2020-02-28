class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle == "") return 0

        for (i in 0..(haystack.length-1)) {
            var found = true
            for (j in 0..(needle.length-1)) {
                if (j+i >= haystack.length) {
                    found = false
                    break
                }
                if (haystack[j+i] != needle[j]) {
                    found = false
                    break
                }
            }
            if (found)
                return i
        }
        return -1
    }
}

fun main(args: Array<String>) {
    println(Solution().strStr("hello", "ll"))
    println(Solution().strStr("aaaaa", "bba"))
}