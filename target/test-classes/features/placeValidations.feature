Feature: Validating Place API's

@Addplace @regression @smoke
Scenario Outline: Verify if Place is being Successfully added using AddPlaceAPI
		Given Add Place Payload with "<name>" "<language>" "<address>"
		When user calls "addPlaceApi" with "POST" http request
		Then the API call got success with status coce 200
		And "status" in response body is "OK"
		And "scope" in response body is "APP" 
		And  verify place_Id created maps to "<name>" using "getPlaceApi"
		
Examples: 
				|name    |language   | address         |
				|Ravi    |English    | woodland Heights|
		#		|sonu    |English    | woodland Lieghts|



@deleteplace @regression @smoke
Scenario: Verify if Delete place functionality is working
		Given Delete Place payload
		When user calls "deletePlaceApi" with "POST" http request
		Then the API call got success with status coce 200
		And "status" in response body is "OK"