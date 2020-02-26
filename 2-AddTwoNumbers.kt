class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString() : String {
        var ret = "${`val`} "
        if (next != null)
            ret += next.toString()
        return ret
    }
}

class Solution {
    fun helper(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        if (l1 == null && l2 == null) {
            if (carry > 0)
                return ListNode(1)
            return null
        }
        if (l1 == null) {
            val n = l2!!.`val` + carry
            val node = ListNode(n % 10)
            node.next = helper(null, l2.next, n / 10)
            return node
        } else if (l2 == null) {
            val n = l1.`val` + carry
            val node = ListNode(n % 10)
            node.next = helper(l1.next, null, n / 10)
            return node
        }

        val n = l1.`val` + l2.`val` + carry
        val node = ListNode(n % 10)
        node.next = helper(l1.next, l2.next, n / 10)
        return node
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return helper(l1, l2, 0)
    }
}

fun main(args: Array<String>) {
    println(Solution().addTwoNumbers(
        ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }
    , ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }))
    println(Solution().addTwoNumbers(
        ListNode(5), ListNode(5)
    ))
}