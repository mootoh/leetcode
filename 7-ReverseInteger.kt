// https://leetcode.com/problems/reverse-integer/
class Solution {
    fun reverse(x: Int): Int {
        val stack = mutableListOf<Int>()
        var cur = x
        while (cur != 0) {
            stack.add(cur % 10)
            cur = cur / 10
        }

        var ret = 0
        stack.forEach {
            if (Int.MAX_VALUE/10 < ret)
                return 0
            if (Int.MAX_VALUE/10 == ret && Int.MAX_VALUE%10 < it)
                return 0

            if (Int.MIN_VALUE/10 > ret)
                return 0
            if (Int.MIN_VALUE/10 == ret && Int.MIN_VALUE%10 > it)
                return 0
 
                ret = ret * 10
            ret = ret + it
        }

        return ret
    }
}

fun main(args: Array<String>) {
    println(Int.MIN_VALUE)
    println(Int.MAX_VALUE)
    println(Solution().reverse(123))
    println(Solution().reverse(-123))
    println(Solution().reverse(120))
    println(Solution().reverse(1201))
    println(Solution().reverse(1200))
    println(Solution().reverse(-2147483412)) // -2143847412
    println(Solution().reverse(Int.MAX_VALUE)) // 0 (2147483647 -> 7463847412)
}
