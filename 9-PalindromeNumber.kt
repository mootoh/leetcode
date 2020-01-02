class Solution {
    fun isPalindrome(x: Int): Boolean {
        val xs = x.toString()
        var i=0
        var j=xs.length-1
        while (i<j) {
            if (xs[i] != xs[j])
                return false
            i += 1
            j -= 1
        }
        return true
    }
}

fun main() {
    println(Solution().isPalindrome(121))
    println(Solution().isPalindrome(-121))
    println(Solution().isPalindrome(10))
    println(Solution().isPalindrome(0))
}