package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class GetAllCountries {
	
	private static final String URI = "http://services.groupkt.com/country/get/all";
	private static final String KEY_PREFIX = "RestResponse.result.";
	private static final String KEY_NAME = "name";
	private static final String KEY_ALPHA_CODE_2 = "alpha2_code";
	private static final String KEY_ALPHA_CODE_3 = "alpha3_code";
		
	@Test (dataProvider = "Countries")
	public void search_for_all_countries(String objectNumber, String name, String aplha2, String alpha3) {
		final Response RESPONSE = get(URI);
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_NAME + objectNumber, equalTo(name));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_2 + objectNumber, equalTo(aplha2));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_3 + objectNumber, equalTo(alpha3));
	}
	
	
	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 // First 5 of get all countries resource
	        return new Object[][] { 
	        		{ "[0]" , "Afghanistan" , "AF" , "AFG"},
	        		{ "[1]" , "Åland Islands" , "AX" , "ALA"},
	        		{ "[2]" , "Albania" , "AL" , "ALB"},
	        		{ "[3]" , "Algeria" , "DZ" , "DZA"},
	        		{ "[4]" , "American Samoa" , "AS" , "ASM"},
	        		};
	}
	
}
	
	
