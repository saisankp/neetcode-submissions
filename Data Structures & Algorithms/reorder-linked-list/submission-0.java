/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // [2, 4, 6, 8]
        List<ListNode> listOfNodes = new ArrayList<>();
        // step 1: turn singly linked list into array of nodes
        ListNode currNode = head;
        while(currNode != null) {
            listOfNodes.add(currNode);
            currNode = currNode.next;
        }


        List<ListNode> reorderedListOfNodes = new ArrayList<>();
        // step 2: turn array of nodes into correct ordering of array of nodes
        int pointerA = 0;
        int pointerB = listOfNodes.size()-1;
        while(pointerA <= pointerB) {
            if(pointerA == pointerB) {
                reorderedListOfNodes.add(listOfNodes.get(pointerA));
                break;
            }
            reorderedListOfNodes.add(listOfNodes.get(pointerA));
            reorderedListOfNodes.add(listOfNodes.get(pointerB));
            pointerA++;
            pointerB--;

        }
        // Input: head = [2,4,6,8,10]
        // Output: [2,10,4,8,6]
        // [2,10]

        currNode = head;
        int index = 0;
        while(index < reorderedListOfNodes.size()-1) {
            currNode.next = reorderedListOfNodes.get(index+1);
            currNode = currNode.next;
            index++;
        }
        currNode.next = null;

        // step 3: iterate from original head and set .next as what is the currindex + 1. We can start with currIndex = 0 and the first value is always set the same anyways. End condition is when we reach a point where .next is null and we stop. At each iteration we increase currIndex by doing currIndex++ for list of nodes and currNode = currNode.next (after .next is set).





        // [2, 6]
        // [4, 8]
        // [2, 8, 4, 6]

        //[2,4,6,8,10]
        // [2, 6, 10]
        // [4, 8]
        // [2, ]

















        // [2,4,6,8]

        // ArrayList<Integer> result = new ArrayList<>();
        // int j=0;
        // for(int i=0; i<head.length; i=i+2, j++) {
        //     result.set(i, head[j]);
        // }

        // int z = getEndStartingIndex();
        // for(; z >= 0; z=z-2) {
        //     result.set(z, head[j]);
        // }

        // return result
        //[ 2, _, 4, _]
    }
}
