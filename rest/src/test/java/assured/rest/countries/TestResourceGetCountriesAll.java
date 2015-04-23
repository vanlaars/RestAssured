package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TestResourceGetCountriesAll extends BaseRestTest{
	
	private static final String URI = getBaseUri() + getResourceAll();
		
	@Test (dataProvider = "Countries")
	public void search_for_all_countries(int objectNumber, String name, String alpha2, String alpha3) {
		final Response response = get(URI);
		assertResponse(response, getNameFromPosition(objectNumber), name);
		assertResponse(response, getAlpha2FromPosition(objectNumber), alpha2);
		assertResponse(response, getAlpha3FromPosition(objectNumber), alpha3);
	}
	
	
	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 // First 5 of get all countries resource
	        return new Object[][] { 
	        		{ 0 , "Afghanistan" , "AF" , "AFG"},
	        		{ 1 , "Åland Islands" , "AX" , "ALA"},
	        		{ 2 , "Albania" , "AL" , "ALB"},
	        		{ 3 , "Algeria" , "DZ" , "DZA"},
	        		{ 4 , "American Samoa" , "AS" , "ASM"},
	        		};
	}
	
}
	
	
