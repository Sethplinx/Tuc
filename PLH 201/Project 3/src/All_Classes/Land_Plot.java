package All_Classes;

public class Land_Plot extends Plot{
	
///////////////////////CONSTRUCTORS////////////////////////
	
	public Land_Plot(String district, String city, float area, float price, float zonePrice, Long code) {
	super(district, city, area, price, zonePrice, code);
	}
	
	public Land_Plot() {
	super();
	}

/////////////////////////GETTER///////////////////////////
	
	public String toString() {
		return (super.toString() + "Type: Land plot" + "\n");
	}

	@Override
	float calculateEnfia() {
	    return(getZonePrice() * getArea());
	}
	
}
