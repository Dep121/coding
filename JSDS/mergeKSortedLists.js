
//  Definition for singly-linked list.
class ListNode {
    val
    next
    constructor(val, next) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}


 function mergeKLists(lists) {

    if (lists.length === 1) {
        return lists[0];
    }
    let mid = Math.floor(lists.length/2);
    let l1 = mergeKLists(lists.slice(0, mid));
    let l2 = mergeKLists(lists.slice(mid, lists.length));

    return mergeTwoSortedLists(l1, l2);
};

function mergeTwoSortedLists(l1, l2) {
    
    let dummy = new ListNode();
    let tail = dummy;

    while (l1 && l2) {
        if (l1.val < l2.val) {
            tail.next = l1;
            l1.next = l1;
        } else {
            tail.next = l2;
            l2.next = l2;
        }
        tail = tail.next;
    }
    if (l1) {
        tail.next = l1;
    } else {
        tail.next = l2;
    }
    return dummy.next;
}

mergeKLists()