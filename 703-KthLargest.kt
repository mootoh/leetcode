import java.util.PriorityQueue

class KthLargest(k: Int, nums: IntArray) {
    val pq = PriorityQueue<Int>()
    val K = k

    init {
        nums.forEach {
            pq.add(it)
        }
    }

    fun add(`val`: Int): Int {
        pq.add(`val`)
        while (K < pq.size) {
            pq.remove()
        }
        return pq.peek()
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */

fun main(args: Array<String>) {
    val obj = KthLargest(3, intArrayOf(4,5,8,2))
    println(obj.add(3))
    println(obj.add(5))
    println(obj.add(10))
    println(obj.add(9))
    println(obj.add(4))

}