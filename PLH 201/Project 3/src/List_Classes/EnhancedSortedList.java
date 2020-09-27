package List_Classes;

public class EnhancedSortedList extends SortedList{

	public EnhancedSortedList() {
		super();
	}
	
	public void printItemsInHierarchy(String ClassName) throws ClassNotFoundException {
		for(Node currNode =  head; currNode != null; currNode = currNode.getNext()) {
			if(Class.forName(ClassName).isInstance(currNode.getInfo().getItem()))
				System.out.println(currNode.getInfo().getItem());
		}		
	}
		
}
