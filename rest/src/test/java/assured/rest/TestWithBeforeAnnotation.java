package assured.rest;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import assured.rest.countries.BaseRestTest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.ResponseBuilder;
import com.jayway.restassured.response.Response;

public class TestWithBeforeAnnotation extends BaseRestTest {

	private static final String VALUE_NAME = "India";
	private static final String VALUE_ALPHA_CODE_2 = "IN";
	private static final String VALUE_ALPHA_CODE_3 = "IND";
	private static final String URI_INDIA = getBaseUri() + getResourceAlpha2Uri() + VALUE_ALPHA_CODE_2;
	
	
	@BeforeClass
	private void setUpUri(){
		RestAssured.baseURI = "http://services.groupkt.com/country";
	}
	
	@BeforeTest
	private void setUpResource(){
		RestAssured.basePath = "/get/iso2code/";
	}

	
	@Test
	public void shouldFindIndiaViaIso2Code(){
		get("IN").then()
		.assertThat().body(getResponseNameSingleResult(), equalTo(VALUE_NAME + "MAKE IT FAIL"))
		.and()
		.assertThat().body(getResponseAlpha2SingleResult(), equalTo(VALUE_ALPHA_CODE_2))
		.and()
		.assertThat().body(getResponseAlpha3SingleResult(), equalTo(VALUE_ALPHA_CODE_3));
	}
	
	


}
