public class Node {
    int key, val;
    Node next, prev;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}


class LRUCache {
    int capacity, size;
    Map<Integer, Node> map;
    Node head, tail, dummy;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        dummy = new Node(-1, -1);
        head = dummy;
        tail = dummy;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){ //if key is present - return the value and move it to the tail
            Node temp = map.get(key);
            if(temp == tail) return temp.val;

            //Removing the element
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            //Appending the element and moving the tail forward
            temp.prev = tail;
            temp.next = null;
            tail.next = temp;
            tail = tail.next;

            //Returning the value
            return temp.val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)){ //if key is missing - add the element to the end, if over capacity - delete the first element
            if(size == capacity){
                head = head.next;
                map.remove(head.key);
            }
            else size++;

            tail.next = new Node(key, value);
            tail.next.prev = tail;

            tail = tail.next;
            map.put(key, tail);
        }
        else{ //if key is already present - move it to the tail
            Node temp = map.get(key);
            temp.val = value;
            if(temp == tail) return;

            //Removing the element
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            //Appending the element and moving the tail forward
            temp.prev = tail;
            temp.next = null;
            tail.next = temp;
            tail = tail.next;
        }
    }
}
