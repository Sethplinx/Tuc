package List_Classes;

import All_Classes.Owner;

public class List_Item_Owner extends List_Item {
	private Owner owner;
	
///////////////////////CONSTRUCTORS////////////////////////
	
	public List_Item_Owner(Owner o) {
		owner = o;
	}

/////////////////////////GETTERS///////////////////////////
	
	@Override
	public Long getNumb() {								//Returns the owners afm				
		return owner.getAFM();
	}

	@Override
	public boolean equals(List_Item item) {
		if(owner.getAFM() == item.getNumb())
			return true;
		else
			return false;
	}

	@Override
	public boolean less(List_Item item) {
		if(owner.getAFM() < item.getNumb())
			return true;
		else
			return false;
	}

	@Override
	public Object getItem() {
		return owner;
	}

}
