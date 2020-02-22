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
}

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var cur1 = l1
        var cur2 = l2
        var ret: ListNode? = ListNode(-1)
        var head = ret

        if (cur1 == null && cur2 == null) return null

        while (cur1 != null && cur2 != null) {
            if (cur1.`val` < cur2.`val`) {
                ret?.next = ListNode(cur1.`val`)
                cur1 = cur1.next
            } else {
                ret?.next = ListNode(cur2.`val`)
                cur2 = cur2.next
            }
            ret = ret?.next
        }

        while (cur1 != null) {
            ret?.next = ListNode(cur1.`val`)
            cur1 = cur1.next
            ret = ret?.next
        }

        while (cur2 != null) {
            ret?.next = ListNode(cur2.`val`)
            cur2 = cur2.next
            ret = ret?.next
        }

        return head?.next
    }
}

fun main(args: Array<String>) {
    val input1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(4)
        }
    }
    val input2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }
    var ret = Solution().mergeTwoLists(input1, input2)
    while (ret != null) {
        println(ret.value)
        ret = ret.next
    }
}