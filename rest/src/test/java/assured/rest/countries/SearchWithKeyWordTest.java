package assured.rest.countries;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class SearchWithKeyWordTest {
	
	private static final String URI = "http://services.groupkt.com/country/search?text=";
	private static final String KEY_PREFIX = "RestResponse.result.";
	private static final String KEY_NAME = "name";
	private static final String KEY_ALPHA_CODE_2 = "alpha2_code";
	private static final String KEY_ALPHA_CODE_3 = "alpha3_code";
	private static final String OBJECT_NUMBER = "[0]";
		
	@Test (dataProvider = "Countries")
	public void search_for_countries_with_keyword_happy(String keyword, String name, String aplha2, String alpha3) {
		final Response RESPONSE = get(URI + keyword);
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_NAME + OBJECT_NUMBER, equalTo(name));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_2 + OBJECT_NUMBER, equalTo(aplha2));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_3 + OBJECT_NUMBER, equalTo(alpha3));
	}
	
	
	@DataProvider(name = "Countries")
	 
	  public static Object[][] countries() {
	 
	        return new Object[][] { 
	        		{ "great", "United Kingdom of Great Britain and Northern Ireland" , "GB" , "GBR"},
	        		{ "nether", "Netherlands", "NL", "NLD"}
	        		};
	  }

}
