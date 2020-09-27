package List_Classes;

public class SortedList extends List{

///////////////////////CONSTRUCTORS////////////////////////

	public SortedList() {
		super();
	}

/////////////////////////METHODS/////////////////////////	

	public Node addNode(List_Item item) {
			Node tmp = new Node(item);
			length ++;
			Node n1 = head, n2 = head;
			
			while((n1 != null) && (n1.getInfo().less(item))) {
				n2 = n1; 
				n1 = n1.getNext();
			}
			
			if (n1 == head) {
				tmp.setNext(head);
				head = tmp;
			} else {
				n2.setNext(tmp);
				tmp.setNext(n1);
			}
			
			return head;
	}

	
}