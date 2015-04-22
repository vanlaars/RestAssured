package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class SearchWithKeyWordTest extends BaseRestTest{
	
		
	@Test (dataProvider = "Countries")
	public void search_for_countries_with_keyword_happy(String keyword, String name, String alpha2, String alpha3) {
		final String uri = getBaseUri() + getResourceSearchWith(keyword);
		final Response RESPONSE = get(uri);
		final String message_records_found = "Total [1] records found.";
		show_output_service_from_uri(uri);
		//		
		assertResponse(RESPONSE, getNameFromPosition(0), name);
		assertResponse(RESPONSE, getAlpha2FromPosition(0), alpha2);
		assertResponse(RESPONSE, getAlpha3FromPosition(0), alpha3);
		assertResponse(RESPONSE, getMessageFromPosition(1), message_records_found);
	}
		
	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 
	        return new Object[][] { 
	        		{ "great", "United Kingdom of Great Britain and Northern Ireland" , "GB" , "GBR"},
	        		{ "nether", "Netherlands", "NL", "NLD"}
	        		};
	  }

}
