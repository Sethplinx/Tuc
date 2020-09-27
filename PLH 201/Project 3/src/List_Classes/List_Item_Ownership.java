package List_Classes;

import All_Classes.Ownership;

public class List_Item_Ownership extends List_Item{
	private Ownership ownership;
	
///////////////////////CONSTRUCTORS////////////////////////

	public List_Item_Ownership(Ownership own) {
		ownership = own;
	}

/////////////////////////GETTERS///////////////////////////
	
	@Override
	public Long getNumb() {
		return ownership.getCode();
	}

	@Override
	public boolean equals(List_Item item) {
		if(ownership.getAfm() == item.getNumb())
			return true;
		else
			return false;
	}

	@Override
	public boolean less(List_Item item) {
		if(ownership.getAfm() < item.getNumb())
			return true;
		else
			return false;
	}

	@Override
	public Object getItem() {
		return ownership;
	}

}
