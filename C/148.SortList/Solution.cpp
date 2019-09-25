//
// Created by mac on 2019/9/2.
//

//归并
//#define MERGE_SORT
//快速排序
#define QUICK_SORT

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    //归并排序处理链表排序
    ListNode *sortList(ListNode *head) {
#ifdef MERGE_SORT
        return mergeSortList(head);
#endif

#ifdef QUICK_SORT
        return quickSortList(head);
#endif
    }

private:
#ifdef MERGE_SORT
    //归并排序主函数
    ListNode *mergeSortList(ListNode *head) {
        if (head == nullptr || head->next == nullptr)
            return head;
        else {
            ListNode *fast = head, *slow = head;
            while (fast->next != nullptr && fast->next->next != nullptr) {
                fast = fast->next->next;
                slow = slow->next;
            }
            ListNode *preHead = head;
            ListNode *postHead = slow->next;
            //截断
            slow->next = nullptr;
            preHead = mergeSortList(preHead);
            postHead = mergeSortList(postHead);
            return merge(preHead, postHead);
        }
    }

    //归并操作
    ListNode *merge(ListNode *pre, ListNode *post) {
        if (pre == nullptr)
            return post;
        if (post == nullptr)
            return pre;
        ListNode *result, *p;
        //let pre to be the head
        if (pre->val < post->val) {
            result = pre;
            pre = pre->next;
        } else {
            result = post;
            post = post->next;
        }
        p = result;
        while (pre != nullptr && post != nullptr) {
            if(pre->val < post->val){
                p->next = pre;
                pre=pre->next;
            } else{
                p->next = post;
                post = post->next;
            }
            p=p->next;
        }
        if(pre == nullptr){
            p->next = post;
        } else {
            p->next = pre;
        }

        return result;
    }
#endif
#ifdef QUICK_SORT

    //插入排序
    ListNode *quickSortList(ListNode *head) {
        return nullptr;
    }

#endif
};

