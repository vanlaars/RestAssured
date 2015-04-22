package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class AlphaCode2Test extends BaseRestTest{
	
	private static final String URI_PREFIX = getBaseUri() + getResourceAlpha2();	
	
	@Test (dataProvider = "Countries")
	public void search_for_countries_alpha2code(String country, String name, String alpha2, String alpha3) {
		final String URI = URI_PREFIX + country;
		final Response RESPONSE = get(URI);
		final String messagePrefix = "Country found matching code ["; 
		final String messagePostFix = "].";
		//
		show_output_service_from_uri(URI);
		assertResponse(RESPONSE, getResponseNameSingleResult(), name);
		assertResponse(RESPONSE, getResponseAlpha2SingleResult(), alpha2);
		assertResponse(RESPONSE, getResponseAlpha3SingleResult(), alpha3);
		assertResponse(RESPONSE, getMessageFromPosition(1), messagePrefix + country + messagePostFix);
	}
	
	
	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 
	        return new Object[][] { 
	        		{ "IN", "India" , "IN" , "IND" }, 
	        		{ "GB", "United Kingdom of Great Britain and Northern Ireland" , "GB" , "GBR"},
	        		{ "NL", "Netherlands", "NL", "NLD"}
	        		};
	  }

}
