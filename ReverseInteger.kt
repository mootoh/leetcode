import kotlin.math.pow

// https://leetcode.com/problems/reverse-integer/
class Solution {
    fun reverse(x: Int): Int {
        val stack = mutableListOf<Int>()
        var cur = x
        while (cur != 0) {
            stack.add(cur % 10)
            cur = cur / 10
        }

        println(stack)
        println(Int.MAX_VALUE)

        var ret = 0
        stack.forEach {
            println("$it, $ret")
            ret = ret + it
            if (ret > Int.MAX_VALUE/10 || ret < Int.MIN_VALUE/10) {
                return 0
            }
            ret = ret * 10
        }

        ret = ret/10
        if (ret > 2.toDouble().pow(31)) {
            return 0
        }
        return ret
    }
}

fun main() {
    println(Solution().reverse(123))
    println(Solution().reverse(7))
    println(Solution().reverse(-123))
    println(Solution().reverse(120))
    println(Solution().reverse(1534236469))
    println(Solution().reverse(-2147483412))
}