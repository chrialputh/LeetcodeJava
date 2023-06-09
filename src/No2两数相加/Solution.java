package No2两数相加;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个新链表伪指针，用来指向头指针，返回结果
        ListNode prev = new ListNode(0);
        //定义一个进位数的指针，用来存储当两数之和大于10的时候，需要进位的数
        int carry = 0;
        //定义一个可移动的指针，用来指向存储的每一位数
        ListNode cur = prev;
        //当l1不等于null  或  l2 等于空时，就进入循环
        while(l1!=null || l2!=null){
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int x= l1 !=null ? l1.val : 0;
            //如果l1 不等于null时，就取他的值，等于null时，就赋值0，保持两个链表具有相同的位数
            int y = l2 !=null ? l2.val : 0;
            //将两个链表的值，进行相加，并加上进位数（进位数出初始为0）——>相加规则
            int sum = x + y + carry;
            //计算进位数
            carry = sum / 10;
            //计算两个数的和，此时排除超过10的请况（大于10，取余数）
            sum = sum % 10;
            /*将求和数赋值给新链表的节点，
              注意这个时候不能直接将sum赋值给cur.next = sum。这时候会报，类型不匹配。
              cur.next是一个ListNode类型的指针，未初始化，需要给他开辟一个内存空间，
              让其指向一个新的节点，通过ListNode构造器将值赋予节点的val*/
            cur.next = new ListNode(sum);
            //将新链表的节点后移 ，cur 与 cur.next 指向同一个地址
            cur = cur.next;

            //以下是数据链表的处理，与上面的新建结果链表无关
            // 当链表不等于null的时候，将当前链表的节点后移
            if(l1 !=null){
                l1 = l1.next;
            }

            if(l2 !=null){
                l2 = l2.next;
            }
        }   //while循环结束


        //如果最后两个数，相加的时候有进位数的时候，就将进位数，赋予链表的新节点。
        //两数相加最多小于20，所以的的值最大只能时1
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        //返回链表的头节点
        return prev.next;
    }
}
