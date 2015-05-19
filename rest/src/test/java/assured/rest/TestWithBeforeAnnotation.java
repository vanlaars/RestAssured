package assured.rest;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import assured.rest.countries.BaseRestTest;

import com.jayway.restassured.RestAssured;

public class TestWithBeforeAnnotation extends BaseRestTest {

	private static final String VALUE_NAME = "India";
	private static final String VALUE_ALPHA_CODE_2 = "IN";
	private static final String VALUE_ALPHA_CODE_3 = "IND";
	
	private static final String RESPONSE_PREFIX = "RestResponse.result.";
	private static final String RESPONSE_NAME = "name";
	private static final String RESPONSE_ALPHA2 = "alpha2_code";
	private static final String RESPONSE_ALPHA3 = "alpha3_code";
	private static final String RESPONSE_NAME_1_RESULT = RESPONSE_PREFIX + RESPONSE_NAME;
	private static final String RESPONSE_ALPHA2_1_RESULT = RESPONSE_PREFIX + RESPONSE_ALPHA2;
	private static final String RESPONSE_ALPHA3_1_RESULT = RESPONSE_PREFIX + RESPONSE_ALPHA3;
	
	
	@BeforeTest
	private void setUpResource(){
		RestAssured.basePath = getResourceAlpha2Uri();
	}

	
	@Test
	public void shouldFindIndiaViaIso2Code(){
		get("IN").then()
		.assertThat().body(RESPONSE_NAME_1_RESULT, equalTo(VALUE_NAME + 1))
		.and()
		.assertThat().body(RESPONSE_ALPHA2_1_RESULT, equalTo(VALUE_ALPHA_CODE_2))
		.and()
		.assertThat().body(RESPONSE_ALPHA3_1_RESULT, equalTo(VALUE_ALPHA_CODE_3));
	}
	
}
