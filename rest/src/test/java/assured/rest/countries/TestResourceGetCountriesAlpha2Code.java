package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TestResourceGetCountriesAlpha2Code extends BaseRestTest{
	
	private static final String URI_PREFIX = getBaseUri() + getResourceAlpha2();	
	
	@Test (dataProvider = "Countries")
	public void search_for_countries_alpha2code(String country, String name, String alpha2, String alpha3) {
		final String URI = URI_PREFIX + country;
		final Response response = get(URI);
		final String messagePrefix = "Country found matching code ["; 
		final String messagePostFix = "].";
		final String contentType = "application/json;charset=UTF-8";
		//
		assertResponseStatusCode(response, 200);
		assertContentType(response, contentType);
		assertResponse(response, getMessageFromPosition(0), getMessageMoreWebservicesAvailable());
		assertResponse(response, getMessageFromPosition(1), messagePrefix + country + messagePostFix);
		assertResponse(response, getResponseNameSingleResult(), name);
		assertResponse(response, getResponseAlpha2SingleResult(), alpha2);
		assertResponse(response, getResponseAlpha3SingleResult(), alpha3);
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
