package com.xc.study.likou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bryant
 * @date 2025/8/22
 **/
public class Task21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(6);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode listNode = mergeTwoLists1(listNode1, listNode4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode pre = new ListNode(0);
        List<ListNode> nodeList = new ArrayList<>();
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    nodeList.add(new ListNode(list1.val, null));
                    list1 = list1.next;
                } else {
                    nodeList.add(new ListNode(list2.val, null));
                    list2 = list2.next;
                }

            }
            if (list1 == null && list2 != null) {
                nodeList.add(new ListNode(list2.val, null));
                list2 = list2.next;
            }
            if (list1 != null && list2 == null) {
                nodeList.add(new ListNode(list1.val, null));
                list1 = list1.next;
            }
        }
        for (int i = 0; i < nodeList.size(); i++) {
            if (i == 0) {
                pre.next = nodeList.get(i);
            } else {
                nodeList.get(i - 1).next = nodeList.get(i);
            }
        }
        return pre.next;
    }


    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }

}
