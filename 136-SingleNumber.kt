class Solution {
    fun singleNumber(nums: IntArray): Int {
        val visited = mutableSetOf<Int>()
        nums.forEach {
            if (visited.contains(it)) {
                visited.remove(it)
            } else {
                visited.add(it)
            }
        }

        return visited.first()
    }
}

fun main(args: Array<String>) {
    println(Solution().singleNumber(intArrayOf(2,2,1)))
    println(Solution().singleNumber(intArrayOf(4,1,2,1,2)))
}