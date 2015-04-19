package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import assured.rest.BaseRest;

import com.jayway.restassured.response.Response;

public class GetAllCountries extends BaseRest{
	
	private static final String URI = getBaseUri() + getAllResource();
		
	@Test (dataProvider = "Countries")
	public void search_for_all_countries(int objectNumber, String name, String aplha2, String alpha3) {
		final Response RESPONSE = get(URI);
		RESPONSE.then().assertThat().body(getNameFromPosition(objectNumber), equalTo(name));
		RESPONSE.then().assertThat().body(getAlpha2FromPosition(objectNumber), equalTo(aplha2));
		RESPONSE.then().assertThat().body(getAlpha3FromPosition(objectNumber), equalTo(alpha3));
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
	
	
