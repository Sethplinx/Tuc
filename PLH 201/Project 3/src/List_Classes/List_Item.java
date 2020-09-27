package List_Classes;

public abstract class List_Item {
	abstract public Long getNumb();									//Returns some important long number
	abstract public boolean equals(List_Item item);
	abstract public boolean less(List_Item item);
	abstract public Object getItem();
}