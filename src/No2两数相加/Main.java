package No2两数相加;


public class Main {
    public static void main(String[] args) {
        final int[] ints = {2, 3, 5, 6};
        final int[] intsTow = {4, 6, 7};
        ListNode listNode1 = new ListNode(ints[ints.length-1]);
        ListNode listNode2 = new ListNode(intsTow[intsTow.length-1]);
        ListNode Next = listNode1.next;  //ListNode是引用类型可以指向空
        ListNode NextTow = listNode2.next;
        for (int i = ints.length-2; i >= 0; i--) {
            Next.val = ints[i];
            Next.next = new ListNode();
            Next = Next.next;
        }
        for (int i = intsTow.length-2; i >= 0; i--) {
            Next = listNode1.next;
            Next.val = ints[i];
        }
    }
}
