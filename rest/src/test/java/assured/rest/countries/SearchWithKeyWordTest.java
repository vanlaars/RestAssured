package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import assured.rest.BaseRest;

import com.jayway.restassured.response.Response;

public class SearchWithKeyWordTest extends BaseRest{
	
	private static final String URI = getBaseUri() + "search?text=";
		
	@Test (dataProvider = "Countries")
	public void search_for_countries_with_keyword_happy(String keyword, String name, String aplha2, String alpha3) {
		final Response RESPONSE = get(URI + keyword);
		RESPONSE.then().assertThat().body(getNameFromPosition(0), equalTo(name));
		RESPONSE.then().assertThat().body(getAlpha2FromPosition(0), equalTo(aplha2));
		RESPONSE.then().assertThat().body(getAlpha3FromPosition(0), equalTo(alpha3));
	}
	
	
	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 
	        return new Object[][] { 
	        		{ "great", "United Kingdom of Great Britain and Northern Ireland" , "GB" , "GBR"},
	        		{ "nether", "Netherlands", "NL", "NLD"}
	        		};
	  }

}
