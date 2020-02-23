class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val memo: MutableMap<Int, Int> = mutableMapOf()
        nums.forEachIndexed { idx, value ->
            val found = memo.get(target-value)
            if (found != null) {
                return intArrayOf(found, idx)
            }
            memo.put(value, idx)
         }

        val ret = intArrayOf(0,1000)
        return ret
    }
}

fun main(args: Array<String>) {
    val result = Solution().twoSum(intArrayOf(2,7,11,15), 17)
    println("${result[0]}, ${result[1]}")
}