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
        if (head == null) return null
        if (head.next == null) return head

        if (head.`val` != head.next?.`val`) {
            head.next = deleteDuplicates(head.next)
            return head
        }
            
        var p = head
        while (p?.next != null && p.`val` == p.next?.`val`) {
            p = p.next
        }
        return deleteDuplicates(p?.next)
    }
}

fun main(args: Array<String>) {
    println(Solution().deleteDuplicates(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    }
                }
            }
        }
    }))

    println(Solution().deleteDuplicates(ListNode(3)))

    println(Solution().deleteDuplicates(ListNode(1).apply {
        next = ListNode(1).apply {
            next = ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3)
                }
            }
        }
    }))
}