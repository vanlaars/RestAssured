package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TestResourceSearchWith extends BaseRestTest{
	
	private static final String MESSAGE_RECORDS_FOUND = "Total [1] records found.";

	
		
	@Test (dataProvider = "Countries")
	public void search_for_countries_with_keyword_happy(String keyword, String name, String alpha2, String alpha3) {
		final Response response = get(getResourceSearchWith(keyword));
		response.prettyPrint();
		assertResponseStatusCode(response, 200);
		assertResponse(response, getMessageFromPosition(1), MESSAGE_RECORDS_FOUND);
		assertResponse(response, getMessageFromPosition(0), getMessageMoreWebservicesAvailable());
		assertResponse(response, getNameFromPosition(0), name);
		assertResponse(response, getAlpha2FromPosition(0), alpha2);
		assertResponse(response, getAlpha3FromPosition(0), alpha3);
	}

	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 
	        return new Object[][] { 
	        		{ "great", "United Kingdom of Great Britain and Northern Ireland" , "GB" , "GBR"},
	        		{ "nether", "Netherlands", "NL", "NLD"},
	        		{ "ital", "Italy", "IT", "ITA"},
	        		};
	  }

}
