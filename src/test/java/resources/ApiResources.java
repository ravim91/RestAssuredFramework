package resources;

public enum ApiResources {
	
	addPlaceApi("/maps/api/place/add/json"),
	getPlaceApi("/maps/api/place/get/json"),
	deletePlaceApi("/maps/api/place/delete/json");
	private String resource;

	ApiResources(String resource) {
		
		this.resource= resource;
		// TODO Auto-generated constructor stub
		
	}
	
	public String getresource()
	{
		
		return resource;
	}

}
