package assured.rest;

import static com.jayway.restassured.RestAssured.get;

import java.util.logging.Logger;

import com.jayway.restassured.response.Response;

public class BaseRest {
	
	private static final String BASE_URI = "http://services.groupkt.com/country/";
	private static final String GET_ALPHA2_RESOURCE = "get/iso2code/";
	private static final String GET_ALL_RESOURCE = "get/all";

	private static final String RESPONSE_PREFIX = "RestResponse.result.";
	private static final String RESPONSE_NAME = "name";
	private static final String RESPONSE_ALPHA2 = "alpha2_code";
	private static final String RESPONSE_ALPHA3 = "alpha3_code";
	private static final String RESPONSE_NAME_1_RESULT = RESPONSE_PREFIX + RESPONSE_NAME;
	private static final String RESPONSE_ALPHA2_1_RESULT = RESPONSE_PREFIX + RESPONSE_ALPHA2;
	private static final String RESPONSE_ALPHA3_1_RESULT = RESPONSE_PREFIX + RESPONSE_ALPHA3;

	private static final Logger LOGGER = Logger
			.getLogger(RestAssuredTypes.class.getName());
	
	public void show_output_service_from_uri(String uri) {
		final Response RESPONSE = get(uri);
		LOGGER.info("We got response from " + uri + " with  \n" + RESPONSE.asString());
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
	
	public static String getBaseUri() {
		return BASE_URI;
	}
	
	public static String getAlpha2Resource() {
		return GET_ALPHA2_RESOURCE;
	}
	
	public static String getAllResource(){
		return GET_ALL_RESOURCE;
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

}
