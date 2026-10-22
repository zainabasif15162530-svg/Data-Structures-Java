
//

public class Q2Demo {

    public static void main(String[] args) {

        // question 2:a
        System.out.println("===== Question 2.a: mergeDescending =====");
        SingleLinkedList<Integer> listA = new SingleLinkedList<Integer>();
        SingleLinkedList<Integer> listB = new SingleLinkedList<Integer>();
        listA.add(10); listA.add(30); listA.add(50); listA.add(70);
        listB.add(20); listB.add(40); listB.add(60); listB.add(80);

        System.out.println("Before calling the method:");
        System.out.println("List A: " + listA);
        System.out.println("List B: " + listB);

        SingleLinkedList.mergeDescending(listA, listB);

        System.out.println("After calling the method:");
        System.out.println("List A: " + listA);
        System.out.println("List B: " + listB);

        // question 2:b
        System.out.println("\n===== Question 2.b: insertUnique =====");
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.add(10); list.add(20); list.add(30); list.add(40); list.add(50);
        System.out.println("Original list:");
        System.out.println(list);

        System.out.println("\nInsert 25: " + list.insertUnique(25));
        System.out.println("List after Insertion");
        System.out.println(list);

        System.out.println("\nInsert 30: " + list.insertUnique(30));
        System.out.println("List after Insertion");
        System.out.println(list);

        System.out.println("\nInsert 5: " + list.insertUnique(5));
        System.out.println("List after Insertion");
        System.out.println(list);

        System.out.println("\nInsert 60: " + list.insertUnique(60));
        System.out.println("List after Insertion");
        System.out.println(list);

        System.out.println("\nFinal size: " + list.size());

        // question 2:c
        System.out.println("\n===== Question 2.c: insertAfterGreater =====");
        SingleLinkedList<Integer> list2 = new SingleLinkedList<Integer>();
        list2.add(10); list2.add(20); list2.add(30); list2.add(40);
        System.out.println("Original list:");
        System.out.println(list2);
        System.out.println("Call the method: list.insertAfterGreater(25, 99)");

        boolean ok = list2.insertAfterGreater(25, 99);

        System.out.println("\nList after calling the method:");
        System.out.println(list2);
        System.out.println("Insertion successful: " + ok);

        // question 2:d
        System.out.println("\n===== Question 2.d: moveToEnd =====");
        SingleLinkedList<Integer> list3 = new SingleLinkedList<Integer>();
        list3.add(3); list3.add(7); list3.add(2); list3.add(3);
        list3.add(5); list3.add(3); list3.add(8);
        System.out.println("Original List");
        System.out.println(list3);
        System.out.println("List size: " + list3.size());
        System.out.println("\nCall the method: list.moveToEnd(3)");

        int moved = list3.moveToEnd(3);

        System.out.println("\nList after the method call");
        System.out.println(list3);
        System.out.println("\nNumber of nodes moved: " + moved);
        System.out.println("List size: " + list3.size());
    }
}