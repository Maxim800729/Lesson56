import java.util.LinkedList;
import java.util.NoSuchElementException;

class Node {
    String value;
    Node next;

    public Node(String value) {
        this.value = value;
    }
}

class MyLinkedList {
    Node head;

    public void addLast(String value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            Node newNode = new Node(value);
            tmp.next = newNode;
        }
    }

    public void addStart(String value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }


    public void print() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public int indexOf(String value) {//Farid
        Node tmp = head;
        int index = 0;
        while (tmp != null) {
            if (tmp.value.equals(value)) {
                return index;
            }
            tmp = tmp.next;
            index++;
        }

        return -1;
    }

    public int size() {
        Node tmp = head;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }


    public String removeLast() {
        if (head == null) return null;
        if (head.next == null) {
            String removed = head.value;
            head = null;
            return removed;
        }

        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        String removed = tmp.next.value;
        tmp.next = null;
        return removed;
    }

    //-10
    public void add(int index, String value) throws Exception {
        int size = size();

        if (index < 0 || index > size)
            throw new Exception("Index bolse size libo mense 0");

        if (index == 0) {
            addStart(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        Node tmp = head;
        for (int i = 0; i < index - 1; i++) {
            tmp = tmp.next;
        }

//        Node node = new Node();//1
//        Node node = new Node(value);//2
        Node node = new Node(value);
        node.next = tmp.next;//999-> 20
        tmp.next = node;

    }

    public boolean contains(String value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value.equals(value)) {
                return true;
            }
            temp = temp.next;

        }
        return false;
    }

    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range" + index);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;

        }
        return temp.value;
    }

    public String removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Spisok pust");
        }
        String removedValue = head.value;
        head = head.next;

        return removedValue;
    }

    public String getFirst() {
        if (head == null) {
            throw new NoSuchElementException("Spisok pust");

        }
        return head.value;
    }

    public String getLast() {
        if (head == null) {
            throw new NoSuchElementException("Spisok pust");
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.value;

    }

    public String remove(String value) {
        if (head == null) {
            throw new NoSuchElementException("Spisok pust");
        }
        if (head.value.equals(value)) {
            String removedValue = head.value;
            head = head.next;
            return removedValue;
        }
        Node temp = head;
        while (temp.next != null && temp.next.value.equals(value)) {
            temp = temp.next;
        }
        if (temp.next == null) {
            throw new NoSuchElementException("Value not found" + value);
        }
        String removedValue = temp.next.value;
        temp.next = temp.next.next;
        return removedValue;
    }

    public void set(int index, String value) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index out of range" + index);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp.next == null) {
                throw new IndexOutOfBoundsException("Index out of range" + index);
            }
            temp = temp.next;

        }
        temp.value = value;

    }

    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node prev = null;
            while (current != null && current.next != null) {
                if (current.value.compareTo(current.next.value) > 0) {
                    String temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                prev = current;
                current = current.next;
            }
        } while (swapped);

    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head=prev;
    }

    public void clear() {
        head = null;


    }

    public boolean isEmpty() {

        return size() == 0;
    }


//  +  public void addLast(String value);  DOBAV V KONEC
//  +  public void print();  NAPECATAY VES LINKEDLIST
//  +  public void addStart(String value); DOBAV V NACALO

    //---------------------------------------------------------------------------

//  +  public int size(); VERNI RAZMER (SKOLKO NODE)
//  -  public boolean contains(String value); // ESLI EST VERNET TRUE ESLI NET FALSE
//  +  public int indexOf(String value);  VOZVRAWAET INDEX DANNOQO ELEMENTA ELSI NETU -1
//  -  public String get(int index); VOZVRAWAET SAM ELEMENT  ELSI NETU THROW NEW EXCEPTION(VI VISLI ZA RAZMER)
//  +  public void add(int index , String value);// DOBAVIT NODE V UKAZANNIY INDEX

    //---------------------------------------------------------------------------

//  -  public void clear();                        ocisaet linked list
//  -  public boolean isEmpty();                   vozvrasaet true esli linked list pustoy inace false
//  -  public String removeFirst();                udalyayet perviy element i vozvrasaet eqo
//  +  public String removeLast();                 udalyayet posledniy element i vozvrasaet eqo
//  -  public String getFirst();                   vernut perviy element
//  -  public String getLast();                    vernut posledniy element
//  -  public String remove(int index);            udalyayet po indeksu i vozvrasaet udalyayemiy obyekt
//  -  public String remove(String value);         udalyayet po znaceniyu i vozvrasaet udalyayemiy obyekt
//  -  public void set(int index,String value);    zameni znacenie ukazannoqo index na value

    //****  ---------------------------------------------------------------------------

//  -  public void sort();                         sortiruet elementi po (vozrastaniyu / ubbivaniyu)
//  -  public void reverse();                      povoracivaet elementi naoborot

    //---------------------------------------------------------------------------
}

public class Main {
    public static void main(String[] args) {

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast("Farid");
        myLinkedList.addLast("David");
        myLinkedList.addLast("Oleq");
        myLinkedList.addLast("Mawa");
        myLinkedList.print();
        myLinkedList.reverse();
        myLinkedList.print();
        myLinkedList.sort();
        myLinkedList.print();
        myLinkedList.set(1, "Max");
        myLinkedList.print();
        myLinkedList.set(0, "Ivan");
        myLinkedList.print();
//        try {
//            myLinkedList.add(2, "999");
//        } catch (Exception e) {
//            System.out.println("Ne dobavil " + e.getMessage());
//        }
//        myLinkedList.print();
        System.out.println("Contains 'Farid'?" + myLinkedList.contains("Farid"));
        System.out.println("Contains 'Max'?" + myLinkedList.contains("Max"));
        System.out.println("Element at index 1 :" + myLinkedList.get(1));
        System.out.println("Removed" + myLinkedList.removeFirst());
        myLinkedList.print();
        myLinkedList.removeFirst();
        System.out.println("Pervii element = " + myLinkedList.getFirst());
        System.out.println("Last element " + myLinkedList.getLast());

//        myLinkedList.addLast("Dima");
//        myLinkedList.addLast("BTC");
//        myLinkedList.addLast("COIN");
//        myLinkedList.addStart("999");
//        myLinkedList.addStart("1000");
//        myLinkedList.addStart("00");
//        myLinkedList.print();//Farid
//        System.out.println(myLinkedList.size());//10
        // System.out.println(myLinkedList.removeLast());////Farid
        System.out.println(myLinkedList.size());//9
        myLinkedList.print();
        System.out.println("Removed" + myLinkedList.remove("David"));
        myLinkedList.print();
////        System.out.println(myLinkedList.indexOf("00"));
//        System.out.println(myLinkedList.size());//10
//        System.out.println(myLinkedList.size());//0
//        myLinkedList.clear();
//        myLinkedList.print();
//        System.out.println("Size after clear = " + myLinkedList.size());
//        System.out.println("MyLinkedList Pustoi ? " +myLinkedList.isEmpty());

//        LinkedList<String> linkedList = new LinkedList<>();
////        linkedList.addFirst("1");
////        linkedList.addFirst("2");
////        linkedList.addFirst("3");
////        linkedList.addLast("1");
////        linkedList.addLast("2");
////        linkedList.addLast("3");
////        linkedList.add("4");
////        linkedList.add(0,"999");
//        linkedList.remove(0);
//        linkedList.remove("Farid");
//        linkedList.removeFirst();
//        linkedList.removeLast();
//        linkedList.contains("999");
//        linkedList.get(0);
//        linkedList.getFirst();
//        linkedList.getLast();
//        linkedList.clear();
//        linkedList.isEmpty();


//        for (String value : linkedList){
//            System.out.print(value + " ");
//        }

    }
}