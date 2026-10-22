
//

public class SingleLinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E data) {
            this.data = data;
        }

        private Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public SingleLinkedList() {
        head = null;
        size = 0;
    }

    private void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    public void add(int index, E item) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        if (index == 0)
            addFirst(item);
        else
            addAfter(getNode(index - 1), item);
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String s = "";
        Node<E> cur = head;
        while (cur != null) {
            s = s + cur.data + " ";
            cur = cur.next;
        }
        return s.trim();
    }
    // Bulid a new list by combining two lists in descending order
    // question 2:a
    public static void mergeDescending(SingleLinkedList<Integer> listA,
                                       SingleLinkedList<Integer> listB) {
        Node<Integer> a = listA.head;
        Node<Integer> b = listB.head;
        Node<Integer> result = null;
        while (a != null || b != null) {
            Node<Integer> pick;
            if (b == null || (a != null && a.data <= b.data)) {
                pick = a;
                a = a.next;
            } else {
                pick = b;
                b = b.next;
            }
            pick.next = result;
            result = pick;
        }

        listA.head = result;
        listA.size = listA.size + listB.size;
        listB.head = null;
        listB.size = 0;
    }
    // Adds a unique value to the list while maintaining sorted order
    // question 2:b
    public boolean insertUnique(E number) {
        Node<E> prev = null;
        Node<E> cur = head;
        while (cur != null) {
            if (((Comparable<E>) cur.data).compareTo(number) == 0) {
                return false;
            }

            if (((Comparable<E>) cur.data).compareTo(number) > 0) {
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        Node<E> newNode = new Node<E>(number, cur);
        if (prev == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
        return true;
    }
    // Adds item right after finding the first node that is strictly greater than target
    // question 2:c
    public boolean insertAfterGreater(E target, E item) {
        Node<E> cur = head;
        while (cur != null) {
            if (((Comparable<E>) cur.data).compareTo(target) > 0) {
                cur.next = new Node<E>(item, cur.next);
                size++;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    // shift every node containing the specified value to the tail of the list
    // question 2:d
    public int moveToEnd(E item) {
        Node<E> keepHead = null, keepTail = null, movedHead = null, movedTail = null;
        int count = 0;

        Node<E> cur = head;
        while (cur != null) {
            Node<E> nextNode = cur.next;
            cur.next = null;

            boolean same;
            if(item==null){
                if(cur.data == null){
                    same = true;
                }else{
                    same=false;
                }
            }else{
                same=item.equals(cur.data);
            }
            if (same) {
                if (movedHead == null) {
                    movedHead = cur;
                } else {
                    movedTail.next = cur;
                }
                movedTail = cur;
                count++;
            } else {
                if (keepHead == null) {
                    keepHead = cur;
                } else {
                    keepTail.next = cur;
                }
                keepTail = cur;
            }
            cur = nextNode;
        }

        if (keepHead == null) {
            head = movedHead;
        } else {
            head = keepHead;
            keepTail.next = movedHead;
        }
        return count;
    }
}