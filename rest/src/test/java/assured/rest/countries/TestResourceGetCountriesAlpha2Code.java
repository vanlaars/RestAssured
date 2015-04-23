package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TestResourceGetCountriesAlpha2Code extends BaseRestTest{
	
	private static final String URI_PREFIX = getBaseUri() + getResourceAlpha2Uri();	
	
	@Test (dataProvider = "Countries")
	public void search_for_countries_alpha2code(String country, String name, String alpha2, String alpha3) {
		final String URI = URI_PREFIX + country;
		final Response response = get(URI);
		final String messageFound = "Country found matching code [" + country + "].";
		final String contentType = "application/json;charset=UTF-8";
		//
		assertResponseStatusCode(response, 200);
		assertHeaders(response);
		assertContentType(response, contentType);
		assertResponse(response, messageFound, name, alpha2, alpha3);
	}
	
	private void assertHeaders(Response response){
		assertHeader(response, "Server", "Apache-Coyote/1.1");
		assertHeader(response, "Vary", "Accept-Encoding");
		assertHeader(response, "Transfer-Encoding", "chunked");
		assertHeader(response, "Content-Encoding", "gzip");
		assertHeader(response, "Connection", "Keep-Alive");
		assertHeader(response, "Age", "0");
	}
	
	private void assertResponse(Response response, String messageFound, String name, String alpha2, String alpha3){
		assertResponse(response, getMessageFromPosition(0), getMessageMoreWebservicesAvailable());
		assertResponse(response, getMessageFromPosition(1), messageFound);
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
