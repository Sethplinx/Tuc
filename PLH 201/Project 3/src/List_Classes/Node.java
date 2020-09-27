package List_Classes;

public class Node {
    private List_Item info;
    private Node next;
    
///////////////////////CONSTRUCTORS////////////////////////
    
    public Node(List_Item info,Node next) {
		this.info = info;
		this.next = next;
	}
    
	public Node(List_Item info) {
		this.info = info;
	}

/////////////////////////GETTERS/////////////////////////

	public List_Item getInfo() {
	        return info;
	    }

	    public Node getNext() {
	        return next;
	    }

		public void setNext(Node next) {
			this.next = next;
		}


}
