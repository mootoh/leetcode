class Solution {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size-1
        while (left < right) {
            var buf = s[left]
            s[left] = s[right]
            s[right] = buf
            left += 1
            right -= 1
        }
        println(s)
    }
}

fun main(args: Array<String>) {
    Solution().reverseString("abc".toCharArray())
}