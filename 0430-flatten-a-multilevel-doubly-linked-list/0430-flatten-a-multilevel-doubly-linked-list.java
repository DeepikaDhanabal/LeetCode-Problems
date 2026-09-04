class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node child = curr.child;
                
                // Find the tail of the child list
                Node childTail = child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                
                // Connect curr to child
                curr.next = child;
                child.prev = curr;
                
                // Connect tail of child list to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                
                // Clear child reference
                curr.child = null;
            }
            curr = curr.next;
        }
        
        return head;
    }
}