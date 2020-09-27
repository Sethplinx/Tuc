package List_Classes;

import All_Classes.Property;

public class List_Item_Property extends List_Item{
	private Property property;
	
///////////////////////CONSTRUCTORS////////////////////////
	
	public List_Item_Property(Property pr) {
		property = pr;
	}

/////////////////////////GETTERS///////////////////////////
	
	@Override
	public Long getNumb() {							//Returns the properties code
		return property.getCode();
	}

	@Override
	public boolean equals(List_Item item) {
		if(property.getCode() == item.getNumb())
			return true;
		else
			return false;
	}

	@Override
	public boolean less(List_Item item) {
		if(property.getCode() < item.getNumb())
			return true;
		else
			return false;
	}

	@Override
	public Object getItem() {
		return property;
	}

}
