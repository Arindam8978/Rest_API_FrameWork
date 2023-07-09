package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void beforeSuit() throws IOException
	{
		StepDefination sd = new StepDefination();
		if (sd.place_id==null)
		{
			sd.add_place_payload_with("Das", "UAE", "Asia");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			sd.verify_place_id_created_maps_to_using("Das", "getPlaceAPI");	
		}
	}

}
