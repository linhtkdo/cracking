/* 
unsorted linked list
Time:   O(n) / n elts 
*/

void deleteDups(Node n) {
    HashSet<Integer> set = new HashSet<Integer>();
    Node prev = null;
    
    // iterate thru linked list and add each elt to set
    while (n != null) {
        // if discover dup, remove elt and continue
        if  (set.contains(n.data)) prev.next = n.next; 
        else {
            set.add(n.data);
            prev = n;
        }
        n = n.next;
    }
}

