package assured.rest.countries;

import static org.hamcrest.Matchers.equalTo;

import java.util.logging.Logger;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class BaseRestTest {
	
	private static final String SEARCH_WITH_RESOURCE = "search?text=";
	private static final String RESPONSE_PREFIX = "RestResponse.result.";
	private static final String RESPONSE_MESSAGES = "RestResponse.messages";
	private static final String RESPONSE_NAME = "name";
	private static final String RESPONSE_ALPHA2 = "alpha2_code";
	private static final String RESPONSE_ALPHA3 = "alpha3_code";
	private static final String RESPONSE_NAME_1_RESULT = RESPONSE_PREFIX + RESPONSE_NAME;
	private static final String RESPONSE_ALPHA2_1_RESULT = RESPONSE_PREFIX + RESPONSE_ALPHA2;
	private static final String RESPONSE_ALPHA3_1_RESULT = RESPONSE_PREFIX + RESPONSE_ALPHA3;

	private static final Logger LOGGER = Logger
			.getLogger(BaseRestTest.class.getName());
	
	@BeforeClass
	public void setUpBaseUri(){
		RestAssured.baseURI = "http://services.groupkt.com/country/";
	}
	
	public void setResourcePathIso2Code(){
		RestAssured.basePath = "get/iso2code/";
	}
	
	public void setResourcePathIso3Code(){
		RestAssured.basePath = "get/iso3code/";
	}
	
	public void setResourcePathGetAll(){
		RestAssured.basePath = "get/all";
	}
	
	public String getSearchWith(String keyword){
		return SEARCH_WITH_RESOURCE + keyword;
	}
	
	public void show_output_service_from_uri(Response RESPONSE) {
		LOGGER.info("Response is	: \n" + RESPONSE.asString());
		LOGGER.info("Headers are	: \n" + RESPONSE.getHeaders());
		LOGGER.info("StatusCode is 	: \n" + RESPONSE.getStatusCode());
	}
	
	public static String getResponseNameSingleResult() {
		return RESPONSE_NAME_1_RESULT;
	}

	public static String getResponseAlpha2SingleResult() {
		return RESPONSE_ALPHA2_1_RESULT;
	}

	public static String getResponseAlpha3SingleResult() {
		return RESPONSE_ALPHA3_1_RESULT;
	}
	
	public static String getResourceSearchWith(String text){
		return "http://services.groupkt.com/country/search?text=" + text;
	}
	
	public static String getNameFromPosition(int position){
		return String.format(RESPONSE_PREFIX + RESPONSE_NAME + "[%1$s]", position);
	}
	
	public static String getAlpha2FromPosition(int position){
		return String.format(RESPONSE_PREFIX + RESPONSE_ALPHA2 + "[%1$s]", position);
	}

	
	public static String getAlpha3FromPosition(int position){
		return String.format(RESPONSE_PREFIX + RESPONSE_ALPHA3 + "[%1$s]", position);
	}
	
	public static String getMessageFromPosition(int position) {
		return String.format(RESPONSE_MESSAGES + "[%1$s]", position);		
	}
	
	public void assertResponse(Response response, String actual , String expected){ 
		response.then().assertThat().body(actual, equalTo(expected));
	}
	
	public void assertResponseStatusCode(Response response, int expected){ 
		response.then().assertThat().statusCode(equalTo(expected));
	}
	
	public void assertContentType(Response response, String contentType){
		Assert.assertEquals(response.getContentType(), contentType);
	}
	
	public void assertHeader(Response response, String headerType, String actual){
		Assert.assertEquals(response.getHeader(headerType), actual);
	}

	
	public String getMessageMoreWebservicesAvailable() {
		return "More webservices are available at http://www.groupkt.com/post/f2129b88/services.htm";
	}
}
