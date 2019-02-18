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
      System.out.println("Empty List: ");
      return;
    }
    DynamicNode p = head;
    System.out.print("List: ");
    while (p != null) {
      System.out.print(p.getInfo() + ((p.getNext() != null) ? "->" : ""));
      p = p.getNext();
    }
    System.out.println();
  }

  // other methods here ...

  public boolean appendList(DynamicList othrList) {

    if (this.isEmpty() || othrList.isEmpty()) {
      System.out.println("Could not append.");
      return false;
    }

    System.out.println(" Appending...");

    DynamicNode dn = this.head; //setting pointer to head of list being appended

    //crawling through the list until the end is hit
    while (dn.getNext() != null) {
      dn = dn.getNext();
    }

    //from the last node of the list being appended, point to the head of the list to append
    dn.setNext(othrList.head);

    //System.out.println("Finished appending.");

    return true;

  }

  public void reverse() {

    if (this.isEmpty()) {
      System.out.println("Error: List is empty.");
      return;
    }

    //Initialization of nodes
    DynamicNode fast = this.head.getNext(); //setting fast ahead of other nodes
    DynamicNode medium = this.head;
    DynamicNode slow = this.head; //will be one place behind medium after second iteration

    System.out.println(" Reverse list...");

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

    //System.out.println("Reversed.");

  }

  public Object deleteMid() {
    //Initialization of nodes
    DynamicNode subSlow = this.head;
    DynamicNode slow = this.head;
    DynamicNode fast = this.head;

    if (this.isEmpty()) {
      System.out.println("Error: The list is empty");
      return null;
    }

    System.out.println(" Delete mid...");

    while (fast.getNext().getNext() != null) {

      //traversing list such that a middle is always found

      //fast moves twice as fast as slow, resulting in a middle after full traversal when
      //number of nodes is odd
      fast = fast.getNext().getNext();
      subSlow = slow;
      slow = slow.getNext();

      if (fast.getNext() == null) {
        subSlow.setNext(slow.getNext()); //skipping over the "slow" or middle node
        //System.out.println(slow.getInfo());
        return slow.getInfo();
      }

    }

    //only accessible if number of nodes is even
    System.out.println("Error: The list is even, no middle node to remove.");
    return null;

  }

  public static void main(String[] args) {

    DynamicList myList1 = new DynamicList();

    myList1.insertFirst(7);
    myList1.insertFirst(2);
    myList1.insertFirst(1);

    DynamicList myList2 = new DynamicList();

    myList2.insertFirst(4);
    myList2.insertFirst(5);

    DynamicList emptyList = new DynamicList();

    myList1.print();
    myList2.print();
    emptyList.print();

    System.out.println();

    myList1.appendList(myList2);
    myList1.print();

    System.out.println();

    myList1.print();
    myList1.reverse();
    myList1.print();

    System.out.println();

    System.out.println("Reverse Empty list...");
    emptyList.reverse();
    emptyList.print();

    System.out.println();

    myList1.print();
    myList1.deleteMid();
    myList1.print();

    System.out.println();

    myList1.print();
    myList1.deleteMid();
    myList1.print();

    System.out.println();

    System.out.println("Delete mid in Empty List...");
    emptyList.deleteMid();
    emptyList.print();

  }
}