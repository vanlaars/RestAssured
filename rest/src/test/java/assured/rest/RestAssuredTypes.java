package assured.rest;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import java.util.logging.Logger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class RestAssuredTypes {
	
	private static final Logger LOGGER = Logger
			.getLogger(RestAssuredTypes.class.getName());

	private static final String URI_INDIA = "http://services.groupkt.com/country/get/iso2code/IN";
	private static final String KEY_PREFIX = "RestResponse.result.";
	private static final String KEY_NAME = "name";
	private static final String VALUE_NAME = "India";
	private static final String KEY_ALPHA_CODE_2 = "alpha2_code";
	private static final String VALUE_ALPHA_CODE_2 = "IN";
	private static final String KEY_ALPHA_CODE_3 = "alpha3_code";
	private static final String VALUE_ALPHA_CODE_3 = "IND";
	
	@Test
	private void show_output_service_from_uri() {
		String response = get(URI_INDIA).asString();
		LOGGER.info("We got response from " + URI_INDIA + " with  \n" + response);
	}


	@Test
	public void search_for_india_with_response() {
		final Response RESPONSE = get(URI_INDIA);
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_NAME, equalTo(VALUE_NAME));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_2, equalTo(VALUE_ALPHA_CODE_2));
		RESPONSE.then().assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_3, equalTo(VALUE_ALPHA_CODE_3));
	}

	@Test
	public void search_for_india_with_expect() {
		expect()
			.body(KEY_PREFIX + KEY_NAME, equalTo(VALUE_NAME))
			.body(KEY_PREFIX + KEY_ALPHA_CODE_2, equalTo(VALUE_ALPHA_CODE_2))
			.body(KEY_PREFIX + KEY_ALPHA_CODE_3, equalTo(VALUE_ALPHA_CODE_3)).
		when().
			get(URI_INDIA);
	}
	
	@Test
	public void search_for_india_assert_that(){
		get(URI_INDIA).then()
				.assertThat().body(KEY_PREFIX + KEY_NAME, equalTo(VALUE_NAME))
				.and()
				.assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_2, equalTo(VALUE_ALPHA_CODE_2))
				.and()
				.assertThat().body(KEY_PREFIX + KEY_ALPHA_CODE_3, equalTo(VALUE_ALPHA_CODE_3));
	}
	
	


}
