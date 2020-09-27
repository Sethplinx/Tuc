package All_Classes;

public abstract class Plot extends Property{

///////////////////////CONSTRUCTORS////////////////////////

	public Plot(String district, String city, float area, float price, float zonePrice, Long code) {
		super(district,city,area,price,zonePrice,code);
	}

    public Plot(){
        super();
    }

/////////////////////////GETTERS///////////////////////////

	public String toString() {
        return (super.toString()  + "\n");
    }

}
