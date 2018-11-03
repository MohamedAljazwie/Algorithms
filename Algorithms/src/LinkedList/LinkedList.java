/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author M.Aljazwiee
 */
public class LinkedList<T> {

    transient private Node<T> head;
    transient private Node<T> first;
    transient private Node<T> last;
    transient private int size;
    private String listData;

    public LinkedList() {
    }

    public void add(T value, int index) {
        Node newNode = new Node(value, null, null);
        if (head == null) {
            head = newNode;
            last = first = head;
            size++;

        } else if (index < 0) {
            throw new IndexOutOfBoundsException("index " + index + " , Size " + size());
        } else if (index == 0) {
            newNode.next = first;
            head = first = newNode;
            size++;

        } else if (index > 0) {
            if (index > size()) {
                throw new IndexOutOfBoundsException("index " + index + " , Size " + size());
            } else {

                Node<T> currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                newNode.previous = currentNode;
                if (index == size) {
                    last = newNode;
                }
                size++;
            }
        }
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node(value, null, null);
        if (head == null) {
            head = newNode;
            last = first = head;
            size++;
        } else {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
            first = head;
            size++;
        }
    }

    public void addLast(T value) {
        add(value);
    }

    public <T> LinkedList<T> reverse() {
        LinkedList reverse = new LinkedList();
        Node currentNode = last;
        while (currentNode != null) {
            reverse.add(currentNode.value);
            currentNode = currentNode.previous;

        }
        return reverse;
    }

    public <T> LinkedList<T> reverse(int index) {
        LinkedList reverse = new LinkedList();
        if (index < 0) {
            throw new IndexOutOfBoundsException("  Size " + size());
        }
        if (index == 0) {
            reverse.add(head.value);
            return reverse;
        }
        int currentIndex = (index % 2 == 0) ? index : index + 1;
        Node currentNode = last;
        for (int i = size - 2; i >= currentIndex; i--) {
            reverse.add(currentNode.value);
            currentNode = currentNode.previous;

        }
        return reverse;
    }

    public boolean isPalindrome() {
        if (head == null) {
            return false;
        }
        if (size == 1) {
            return true;
        }
        int haf = (size % 2 == 0) ? size / 2 : size / 2 + 1;
        Node rigthList = head;
        Node leftList = last;
        if (!rigthList.value.equals(leftList.value)) {
            return false;
        }
        for (int i = 1; i < haf; i++) {
            rigthList = rigthList.next;
            leftList = leftList.previous;
            if (!rigthList.value.equals(leftList.value)) {
                return false;
            }
        }

        return true;
    }

    public void add(T value) {
        Node<T> newNode = new Node(value, null, null);
        if (head == null) {
            head = newNode;
            last = first = head;
            size++;
        } else {
            Node<T> currentNode = head;
            int length = this.size;
            for (int i = 0; i < length - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            last = currentNode.next = newNode;
            newNode.previous = currentNode;

            this.size++;
        }
    }

    public int size() {
//        Node currentNode = head;
//
//        int size = 0;
//        while (currentNode != null) {
//            size++;
//            currentNode = currentNode.next;
//        }
        // System.out.println(size);
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isValueFound(T t) {
        Node valueNode = new Node(t, null);
        Node<T> currentNode = head;
        if (currentNode.value.equals(valueNode.value)) {
            return true;
        }
        int length = this.size;
        for (int i = 0; i < length - 1; i++) {
            currentNode = currentNode.next;
            if (currentNode.value.equals(valueNode.value)) {
                return true;
            }
        }
        return false;
    }

    public LinkedList<T> removeDublicateValues() {
        if (this == null) {
            return null;
        }

        Node<T> currentNode = head;
        Node<T> prevNode = null;
        int length = this.size;
        int curentindex = 0;
        for (int i = 1; i < length; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
            curentindex++;
            if (isValueFoundBeforeIndex(currentNode.value, curentindex)) {
                prevNode.next = currentNode.next;
                currentNode.next = null;
                currentNode = prevNode;
                size--;
                curentindex--;

            }

        }
        last = currentNode;
        return this;
    }

    public boolean deleteMiddleNode() {
        if (this == null) {
            return false;
        }
        if (size == 1 || size == 2) {
            return false;
        }

        if (remove(size / 2) != null) {
            return true;
        }

        return false;
    }

    public boolean isValueFoundAfterIndex(T t, int index) {
        Node valueNode = new Node(t, null);
        Node<T> currentNode = get(index);
        if (currentNode.value.equals(valueNode.value)) {
            return true;
        }
        int length = this.size;
        for (int i = index; i < length - 1; i++) {
            currentNode = currentNode.next;
            if (currentNode.value.equals(valueNode.value)) {
                return true;
            }
        }
        return false;

    }

    public boolean isValueFoundBeforeIndex(T t, int index) {
        Node valueNode = new Node(t, null);
        Node<T> currentNode = head;
        if (currentNode.value.equals(valueNode.value)) {
            return true;
        }
        int length = this.size;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
            if (currentNode.value.equals(valueNode.value)) {
                return true;
            }
        }
        return false;
    }

    public Node remove(int index) {
        checkElementIndex(index);
        Node currentNode = head;
        Node deletedNode = null;
        if (index == 0) {
            deletedNode = remove();
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            deletedNode = currentNode.next;

            currentNode.next = deletedNode.next;
              size--;
            if (size == index) {
                last = currentNode;
            }

            deletedNode.next = null;
          
        }
        return deletedNode;

    }

    public Node<T> remove() {
        Node<T> deletedNode = null;
        if (head == null) {
            throw new IndexOutOfBoundsException("  Size " + size());
        } else {
            deletedNode = head;
            first = head = deletedNode.next;

            deletedNode.next = null;
            size--;
        }
        return deletedNode;
    }

    public Node removeFirst() {
        return remove();
    }

    public Node removLast() {
        return remove(size - 1);
    }
 public LinkedList<T> reorderList1() {
       if (isEmpty()) {
            return null;
        }
        if (size == 2) {
            return this;
        }
        Node<T> currentNode = head;
        int currIndex=1;
        while(currIndex<size)
        {
            Node<T> deelteNode=removLast();
            add(deelteNode.value, currIndex);
            currentNode=currentNode.next.next;
            currIndex+=2;
        }
        return this;
 }
 @Deprecated
    public LinkedList<T> reorderList() {
        if (isEmpty()) {
            return null;
        }
        if (size == 2) {
            return this;
        }
        Node<T> currentNode = head, temp1 = head;
        LinkedList<T> reorderList=new LinkedList<>();
        
       Node<T> lastNode=last, temp2 = last;
        while (currentNode != last) {
            if(currentNode.next==last)
            {
                reorderList.add(currentNode.value);
                reorderList.add(last.value);
                break;
            }
            reorderList.add(currentNode.value);
            reorderList.add(last.value);
            currentNode=currentNode.next;
            last=last.previous;
            
//            temp1 = temp1.next;
//            if (temp1 == temp2) {
//                currentNode.next = lastNode;
//                break;
//            }
//            temp2 = temp2.previous;
//            currentNode.next = lastNode;
//            lastNode.next = temp1;
//           // last.previous=currentNode;
//
//            lastNode = temp2;
//            currentNode = temp1;
         // currentNode.previous=last;

        }
        System.out.println(reorderList);
        head=reorderList.head;
        last=reorderList.last;
        return this;

    }

    private static Integer convertLinkedListToNumber(LinkedList<Integer> list) {
        if (list == null) {
            return null;
        }
        LinkedList.Node<Integer> currentNode = (Node<Integer>) list.head;
        StringBuffer buffer = new StringBuffer();
        buffer.append(currentNode.value);
        for (int i = 1; i < list.size; i++) {
            currentNode = currentNode.next;
            buffer.append(currentNode.value);
        }
        Integer convert = Integer.valueOf(buffer.reverse().toString());
        return convert;
    }

    private static LinkedList<Integer> convertNumberToLinkedList(Integer value) {
        if (value == null || value.equals(0)) {
            return new LinkedList<>();
        }

        StringBuffer buffer = new StringBuffer();
        char[] reverseValue = buffer.append(value).reverse().toString().toCharArray();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < reverseValue.length; i++) {

            list.add(Integer.parseInt(String.valueOf(reverseValue[i])));
        }
        return list;
    }

    public static LinkedList<Integer> sumLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Integer list1Value = convertLinkedListToNumber(list1);
        Integer list2Value = convertLinkedListToNumber(list2);
        Integer SumListes = list1Value + list2Value;
        return convertNumberToLinkedList(SumListes);
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("index " + index + " , Size " + size());
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size();
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public Node get(int index) {
        checkElementIndex(index);
        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;

        }
        return currentNode;
    }

    public void print() {
        Node currentNode = head;
        listData = "[ ";

        while (currentNode != null) {
            listData += currentNode.value + " ,";
            currentNode = currentNode.next;
        }
        listData = listData.substring(0, listData.length() - 1) + "]";
        //System.out.println(listData);
    }

    public static class Node<T> {

        public T value;
        public Node<T> next;
        private Node<T> previous;
        public  T min;

        public Node(T value, Node node) {
            this.next = node;
            this.value = value;
        }

        public Node(T value, Node next, Node previous) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    public Node(T value, Node next, Node previous,T min) {
            this.next = next;
            this.previous = previous;
            this.value = value;
            this.min=min;
        }
        public T getValue() {
            return value;
        }

        public T getMin() {
            return min;
        }

        public void setMin(T min) {
            this.min = min;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

    }

    @Override
    public String toString() {
        print();
        return listData;
    }

}
