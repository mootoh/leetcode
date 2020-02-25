class Solution {
    fun helper(x: Double, n: Int): Double {
        if (n == 1)
            return x.toDouble()

        val half = helper(x, n/2)
        if (n%2 == 0)
            return half*half
        return x * half*half
    }

    fun myPow(x: Double, n: Int): Double {
        if (n > 0)
            return helper(x, n)
        if (n == 0)
            return 1.0
        return 1.0 / helper(x, -n)
    }
}

fun main(args: Array<String>) {
    println(Solution().myPow(2.0, 10))
    println(Solution().myPow(2.1, 3))
    println(Solution().myPow(2.0, -2))
    println(Solution().myPow(0.00001, 2147483647))
}