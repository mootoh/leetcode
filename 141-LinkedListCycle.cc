/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
#include <iostream>
#include <set>

struct ListNode {
     int val;
     ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool hasCycle_naive(ListNode *head) {
        std::set<ListNode *> visited;
        for (ListNode *cur = head; cur != NULL; cur = cur->next) {
            if (visited.find(cur) != visited.end()) {
                return true;
            }
            visited.insert(cur);
        }

        return false;
    }

    bool hasCycle(ListNode *head) {
        if (head == NULL || head->next == NULL)
            return false;

        ListNode *slow = head;
        ListNode *fast = head->next;
        while (slow != fast) {
            if (fast == NULL || fast->next == NULL)
                return false;
            slow = slow->next;
            fast = fast->next->next;
        }
        return true;
    }
};

bool test1() {
    ListNode first(3);
    ListNode second(2);
    ListNode third(0);
    ListNode fourth(-4);
    first.next = &second;
    second.next = &third;
    third.next = &fourth;
    fourth.next = &second;
    Solution sol;
    return sol.hasCycle(&first);
}


bool test3() {
    ListNode first(1);
    Solution sol;
    return sol.hasCycle(&first);
}

int main(int argc, char **argv) {
    std::cout << test1() << std::endl;
    std::cout << test3() << std::endl;
    return 0;
}