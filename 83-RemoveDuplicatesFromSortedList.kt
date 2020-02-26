/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head
        var p = head
        var q = head.next

        while (q != null) {
            while (q != null && p?.`val` == q.`val`) {
                q = q.next
                p.next = q
            }
            q = q?.next
            p = p?.next

        }
        return head
    }
}

fun main(args: Array<String>) {
    val src = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(2)
        }
    }
    Solution().deleteDuplicates(src)
    println(src)

    val src2 = ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(3)
                }
            }
        }
    }
    Solution().deleteDuplicates(src2)
    println(src2)
}