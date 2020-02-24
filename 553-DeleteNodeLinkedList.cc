#import <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

void printList(ListNode *head) {
    if (head == NULL) {
        cout << endl;
    } else {
        cout << head->val << ' ';
        printList(head->next);
    }
}
class Solution {
public:
    void deleteNode(ListNode* node) {
        node->val = node->next->val;
        ListNode *nn = node->next;
        node->next = node->next->next;
        delete nn;
    }
};

int main() {
    Solution s;

    ListNode head = ListNode(4);
    head.next = new ListNode(5);
    head.next->next = new ListNode(1);
    head.next->next->next = new ListNode(9);

    printList(&head);
    s.deleteNode(head.next);
    printList(&head);

    return 0;
}