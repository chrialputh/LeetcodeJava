package No2两数相加;


public class Main {
    public static void main(String[] args) {
        final int[] ints = {2, 3, 5, 0};
        final int[] intsTow = {7, 3, 5};
        //创建数据链表
        ListNode listNode1 = new ListNode(ints[ints.length - 1]);
        ListNode listNode2 = new ListNode(intsTow[intsTow.length - 1]);
        /*
        分别在栈内创建ListNode类型 的 Next NextTow
        分别指向 listNode1.next listNode2.next所指的堆空间
         */
        listNode1.next = new ListNode();  //这里必须要让listNode1.next有所指向，下条语句才能通过
        ListNode Next = listNode1.next;
        for (int i = ints.length - 2; i >= 0; i--) {
            Next.val = ints[i];    //当前指针所指的区块val值为ints[i]
            if (i > 0) {
                Next.next = new ListNode();
                Next = Next.next;
            }
        }

        listNode2.next = new ListNode();
        ListNode NextTow = listNode2.next;  //ListNode是引用类型，可以指向空
        for (int i = intsTow.length - 2; i >= 0; i--) {
            NextTow.val = intsTow[i];
            if (i > 0) {
                NextTow.next = new ListNode();
                NextTow = NextTow.next;
            }
        }
        /*
        检测链表是否赋值成功
        while (listNode2 != null) {
            System.out.print(listNode2.val);
            listNode2 = listNode2.next;
        }
        System.out.println("\n");
        */
        final Solution solution = new Solution();
        ListNode end = solution.addTwoNumbers(listNode1, listNode2);
        while (end != null) {
            System.out.print(end.val);
            end = end.next;
        }

    }
}
