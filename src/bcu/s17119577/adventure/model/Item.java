package bcu.s17119577.adventure.model;

public class Item {
	// TODO: declare fields
	private String name;
	private String description;
    private Location location;
    private boolean portable;

	public Item(String name, String description) {
		// TODO: implement constructor
        this.name = name;
        this.description = description;
        this.location = null;
        this.portable = false;
	}
	
	public String getName() {
		// TODO: implement getName method
		return name;
	}
	
	public String getDescription() {
		// TODO: implement getDescription method
		return description;
	}
	
	public Location getLocation() {
		// TODO: implement getLocation method
		return location;
	}
	
	public void setLocation(Location location) {
		// TODO: implement setLocation method
        this.location = location;
	}
	
	public boolean isPortable() {
		// TODO: implement isPortable method
		return portable;
	}
	
	public void setPortable(boolean portable) {
		// TODO: implement setPortable method
	    this.portable = portable;
	}
}
