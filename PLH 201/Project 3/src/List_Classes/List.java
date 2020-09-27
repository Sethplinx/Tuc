package List_Classes;

public class List {
	protected Node head;
	protected int length;

///////////////////////CONSTRUCTORS////////////////////////
	
	public List() {
		head = null;
		length = 0;
	}
	
/////////////////////////METHODS/////////////////////////	
	
	public Node addNode(List_Item itm) {
        head = new Node(itm,head);
        length++;
        return head;
    }

	public Node getHead() {
		return head;
	}

	public Object findInList(Long code){													//Function that searches the list and checks if the number give is different from the one returned from getNumb(afm or property code)
		for(Node currNode =  head; currNode != null; currNode = currNode.getNext()) {
			if(currNode.getInfo().getNumb().equals(code))
				return currNode.getInfo().getItem();        	
        }
		return null;
    }
	
	public void pritnAllList(){																//Functing that prints every item in the list
		for(Node currNode =  head; currNode != null; currNode = currNode.getNext()) 
			System.out.println(currNode.getInfo().getItem());
    }

	public int getLength() {
		return length;
	}
	
}
