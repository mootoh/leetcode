class Solution {
    fun isPalindrome_withString(x: Int): Boolean {
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

    fun isPalindrome(x: Int): Boolean {
        if (x < 0)
            return false
        
        val stack = mutableListOf<Int>()
        var t = x
        while (t != 0) {
            val y = t % 10
            stack.add(y)
            t = t / 10
        }

        var i=0
        var j=stack.size-1
        while (i < j) {
            if (stack[i] != stack[j])
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