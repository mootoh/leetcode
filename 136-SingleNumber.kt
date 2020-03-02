class Solution {
    fun singleNumber(nums: IntArray): Int {
        val visited = mutableMapOf<Int, Boolean>()
        nums.forEach {
            if (visited.get(it) != null) {
                visited.remove(it)
            } else {
                visited.put(it, true)
            }
        }

        return visited.keys.first()
    }
}

fun main(args: Array<String>) {
    println(Solution().singleNumber(intArrayOf(2,2,1)))
    println(Solution().singleNumber(intArrayOf(4,1,2,1,2)))
}