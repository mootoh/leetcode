import java.util.Arrays

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { idx, value ->
            val target2 = target-value
            val nums2 = nums.takeLast(nums.size-idx-1)
            val found = nums2.indexOfFirst { it == target2 }

            if (found != -1) {
                return@twoSum intArrayOf(idx, found+idx+1)
            }
        }
    
        return intArrayOf(-1, -1)
    }
}

fun main() {
    val nums = intArrayOf(3,3)
    val target = 6
    val ans = Solution().twoSum(nums, target)
    println(Arrays.toString(ans))
}

