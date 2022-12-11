package codethieunhi;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if( list1 == null)
            return list2;
        if( list2 == null)
            return list1;
        ListNode head;
        ListNode temp;
        if( list1.val < list2.val){
            temp = new ListNode(list1.val);
            head = temp;
            list1 = list1.next;
        }else {
            temp = new ListNode(list2.val);
            head = temp;
            list2 = list2.next;
        }
        while ( list1 != null && list2 != null){
            if( list1.val < list2.val){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        while ( list1 != null){
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }

        while ( list2 != null){
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
