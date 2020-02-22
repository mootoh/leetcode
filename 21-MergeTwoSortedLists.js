/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    var c1 = l1;
    var c2 = l2;
    var ret = new ListNode(-1);
    var head = ret;

    if (c1 == null && c2 == null) return null;

    while (c1 != null && c2 != null) {
        if (c1.val < c2.val) {
            ret.next = new ListNode(c1.val);
            c1 = c1.next;
        } else {
            ret.next = new ListNode(c2.val);
            c2 = c2.next;
        }
        ret = ret.next;
    }
    
    while (c1 != null) {
        ret.next = new ListNode(c1.val);
        c1 = c1.next;
        ret = ret.next;
    }

    while (c2 != null) {
        ret.next = new ListNode(c2.val);
        c2 = c2.next;
        ret = ret.next;
    }

    return head.next;
};

var input1_3 = new ListNode(4);
var input1_2 = new ListNode(2);
var input1_1 = new ListNode(1);
input1_1.next = input1_2;
input1_2.next = input1_3;

var input2_3 = new ListNode(4);
var input2_2 = new ListNode(3);
var input2_1 = new ListNode(1);
input2_1.next = input2_2;
input2_2.next = input2_3;

console.log(mergeTwoLists(input1_1, input2_1));