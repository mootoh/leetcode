class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size-1
        var med = 0
        while (left <= right) {
            med = left + (right-left)/2
            val cur = nums[med]
            if (target == cur) return med
            if (target < cur)
                right = med-1
            else
                left = med+1
        }
        return left
    }
}

fun main(args: Array<String>) {
    println(Solution().searchInsert(intArrayOf(1,3,5,6), 5))
    println(Solution().searchInsert(intArrayOf(1,3,5,6), 2))
    println(Solution().searchInsert(intArrayOf(1,3,5,6), 7))
    println(Solution().searchInsert(intArrayOf(1,3,5,6), 0))
    println(Solution().searchInsert(intArrayOf(1,3), 2))
}
