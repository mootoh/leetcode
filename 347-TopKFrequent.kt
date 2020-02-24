import java.util.PriorityQueue

data class Num(val m: Int, val freq: Int) : Comparable<Num> {
    override fun compareTo(other: Num) : Int {
        if (this.freq > other.freq) return -1
        if (this.freq == other.freq) return 0
        return 1
    }
}

class Solution {
    val pq = PriorityQueue<Num>()
    val freqs: MutableMap<Int, Int> = mutableMapOf()

    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        nums.forEach {
            val cur = freqs.get(it)
            if (cur == null)
                freqs.put(it, 1)
            else
                freqs.set(it, cur+1)
        }

        freqs.forEach {
            pq.add(Num(it.key, it.value))
        }

        val result = mutableListOf<Int>()
        for (i in 1..k) {
            val num = pq.poll()
            result.add(num.m)
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(Solution().topKFrequent(intArrayOf(1,1,1,2,2,3), 2))
    println(Solution().topKFrequent(intArrayOf(1), 1))
    println(Solution().topKFrequent(intArrayOf(4,1,-1,2,-1,2,3), 2))
}