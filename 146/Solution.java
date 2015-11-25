import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static class LRUCache {

        private int cap;

        private int cnt;

        private Map<Integer, Integer> valueMap;

        private Map<Integer, Node> nodeMap;

        private Node head;

        private Node tail;

        private class Node {
            int key;
            Node prev;
            Node next;
            public Node(int key) {
                this.key = key;
                prev = null;
                next = null;
            }
        }

        private void update(int key) {
            Node node = nodeMap.get(key);
            if (node == tail) return;
            if (node == head) {
                head = head.next;
                head.prev = null;
                node.next = null;
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
        }

        private void addLast(int key) {
            Node node = new Node(key);
            nodeMap.put(key, node);
            if (cnt == 0) {
                head = tail = node;
                return;
            }
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        private int removeFirst() {
            int first = head.key;
            head = head.next;
            head.prev = null;
            nodeMap.remove(first);
            return first;
        }

        public LRUCache(int capacity) {
            this.cap = capacity;
            cnt = 0;
            valueMap = new HashMap<>(capacity * 2, 0.5f);
            nodeMap = new HashMap<>(capacity * 2, 0.5f);
            head = null;
            tail = null;
        }

        public int get(int key) {
            if (valueMap.containsKey(key)) {
                update(key);
                return valueMap.get(key);
            }
            else return -1;
        }

        public void set(int key, int value) {
            if (valueMap.containsKey(key)) {
                valueMap.put(key, value);
                update(key);
            }
            else {
                valueMap.put(key, value);
                addLast(key);
                if (cnt < cap) cnt++;
                else {
                    int old = removeFirst();
                    valueMap.remove(old);
                }
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.set(1,1);
        cache.set(2,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        cache.set(4,4);
        cache.set(5,5);
        System.out.println(cache.get(2));
        System.out.println(cache.get(5));
    }
}
