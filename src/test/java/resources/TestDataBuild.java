package resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.location;

public class TestDataBuild {
	
	
	
	public AddPlace AddPlacePayload(String name, String language, String address)
	{
		
		
		AddPlace ap = new AddPlace();
	    ap.setAccuracy(60);
	    ap.setName(name);
	    ap.setPhone_number("9594312007");
	    ap.setAddress(address);
	    ap.setWebsite("https://bholachola.com");
	    ap.setLanguage(language);
	    
	    List<String> types = new ArrayList<String>();
	    types.add("Shoe park");
	    types.add("shop");
	    ap.setTypes(types);
	    
	    location l = new location();
	    l.setLat(-38.383494);
	    l.setLng(33.427362);
	    
	    
	    ap.setLocation(l);
	    
	    return ap;
	}
	
	public String DeletePlacePayload(String place_Id)
	{
		
		return "{\n"
				+ "    \"place_id\": \""+place_Id+"\"\n"
				+ "}";
		
	}

}
