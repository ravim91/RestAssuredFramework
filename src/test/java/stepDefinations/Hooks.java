package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@deleteplace")
	public void beforeScenario() throws IOException
	{
		
		StepDefinations steps = new StepDefinations();
		
		if(StepDefinations.place_Id==null)
		{
		
		steps.add_place_payload_with("Sonu", "Hindi", "SangharshNagar");
		steps.user_calls_with_http_request("addPlaceApi","POST");
		steps.verify_place_id_created_maps_to_using("Sonu","getPlaceApi");
		
	}
	}
	
	
}
