class DynamicList {

  private DynamicNode head;

  public DynamicList() {
    head = null;
  }

  public DynamicList(DynamicNode head) {
    this.head = head;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public void insertFirst(Object x) {
    DynamicNode q = new DynamicNode(x, null);
    if (!isEmpty()) {
      q.setNext(head);
    }
    head = q;
  }

  public void print() {
    if (head == null) {
      System.out.println("null");
    }
    DynamicNode p = head;
    while (p != null) {
      System.out.print(p.getInfo() + ((p.getNext() != null) ? "->" : ""));
      p = p.getNext();
    }
    System.out.println();
  }

  // other methods here ...

  public boolean appendList(DynamicList othrList) {

    if(this.isEmpty() || othrList.isEmpty()) {
      System.out.println("Could not append.");
      return false;
    }

    System.out.println("Appending...");

    DynamicNode dn = this.head; //setting pointer to head of list being appended

    //crawling through the list until the end is hit
    while (dn.getNext() != null) {
      dn = dn.getNext();
    }

    //from the last node of the list being appended, point to the head of the list to append
    dn.setNext(othrList.head);

    System.out.println("Finished appending.");

    return true;

  }

  public void reverse() {

    if(this.isEmpty()) {
      System.out.println("List is empty.");
      return;
    }

    //Initialization of nodes
    DynamicNode fast = this.head.getNext(); //setting fast ahead of other nodes
    DynamicNode medium = this.head;
    DynamicNode slow = this.head; //will be one place behind medium after second iteration

    System.out.println("Reversing...");

    //First iteration
    medium.setNext(null); //setting the list's original head to null
    medium = fast;
    fast = fast.getNext();

    //Middle iteration(s)
    while (fast.getNext() != null) {
      medium.setNext(slow); //setting current pointer to previous node
      //moving nodes
      slow = medium;
      medium = fast;
      fast = fast.getNext();
    }

    //Last iteration
    medium.setNext(slow);
    slow = medium;
    medium = fast;
    medium.setNext(slow); //setting the final pointer the penultimate node

    head = medium; //setting head to end of list

    System.out.println("Reversed.");

  }

  public static void main(String[] args) {
    DynamicList myList = new DynamicList();

    myList.insertFirst(3);
    myList.insertFirst(5);
    myList.insertFirst(8);
    myList.insertFirst(13);
    myList.insertFirst(11);

    DynamicList othrList = new DynamicList();

    othrList.insertFirst(0);
    othrList.insertFirst(2);
    othrList.insertFirst(6);


    //myList.appendList(othrList);
    //myList.reverse();
    myList.print();
    //myList.printList();
  }
}

