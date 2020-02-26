/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
    fun tail(head: ListNode?): ListNode? {
        if (head == null) return null

        var p = head
        var q = p.next
        while (q != null) {
            p = q
            q = q.next
        }
        return p
    }

    fun helper(cur: ListNode?, next: ListNode?): ListNode? {
        if (cur == null)
            return next
        val tmp = cur.next
        cur.next = next
        return helper(tmp, cur)
    }

    fun reverseList(head: ListNode?): ListNode? {
        return helper(head, null)
    }
}

fun main(args: Array<String>) {
    val src = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    println(Solution().reverseList(src))
    println(Solution().reverseList(ListNode(3)))
}