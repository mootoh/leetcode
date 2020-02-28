class Solution {
    fun sortColors(nums: IntArray): Unit {
        val counts = mutableMapOf<Int, Int>(0 to 0, 1 to 0, 2 to 0)
        nums.forEach {
            counts.put(it, counts.get(it)!!+1)
        }

        var j = 0
        for (k in (0..2)) {
            for (i in 1..(counts.get(k)!!)) {
                nums[j] = k
                j += 1
            }
        }
    }
}

fun main(args: Array<String>) {
    val src = intArrayOf(2,0,2,1,1,0)
    Solution().sortColors(src)
    println(src.map {
        it.toString()
    })
}