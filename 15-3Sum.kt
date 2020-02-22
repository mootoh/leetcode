class Solution {
    fun threeSum_cube(nums: IntArray): List<List<Int>> {
        var ret: MutableSet<List<Int>> = mutableSetOf()

        for (i in 0..nums.size-1) {
            for (j in (i+1)..nums.size-1) {
                for (k in (j+1)..nums.size-1) {
                    if (nums[i] + nums[j] + nums[k] == 0)
                        ret.add(listOf(nums[i], nums[j], nums[k]).sorted())
                }
            }
        }
        return ret.toList()
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        return threeSum_cube(nums)
    }
}

fun main(args: Array<String>) {
    println(Solution().threeSum(intArrayOf(-1,0,1,2,-1,-4)))
}