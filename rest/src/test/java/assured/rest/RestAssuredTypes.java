package assured.rest;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import assured.rest.countries.BaseRestTest;

import com.jayway.restassured.response.Response;

public class RestAssuredTypes extends BaseRestTest {

	private static final String VALUE_NAME = "India";
	private static final String VALUE_ALPHA_CODE_2 = "IN";
	private static final String VALUE_ALPHA_CODE_3 = "IND";
	private static final String URI_INDIA = getBaseUri() + getResourceAlpha2() + VALUE_ALPHA_CODE_2;

	

	@Test
	public void search_for_india_with_response() {
		final Response response = get(URI_INDIA);
		response.then().assertThat().body(getResponseNameSingleResult(), equalTo(VALUE_NAME));
		response.then().assertThat().body(getResponseAlpha2SingleResult(), equalTo(VALUE_ALPHA_CODE_2));
		response.then().assertThat().body(getResponseAlpha3SingleResult(), equalTo(VALUE_ALPHA_CODE_3));
	}

	@Test
	public void search_for_india_with_expect() {
		expect()
			.body(getResponseNameSingleResult(), equalTo(VALUE_NAME))
			.body(getResponseAlpha2SingleResult(), equalTo(VALUE_ALPHA_CODE_2))
			.body(getResponseAlpha3SingleResult(), equalTo(VALUE_ALPHA_CODE_3)).
		when().
			get(URI_INDIA);
	}
	
	@Test
	public void search_for_india_assert_that(){
		get(URI_INDIA).then()
				.assertThat().body(getResponseNameSingleResult(), equalTo(VALUE_NAME))
				.and()
				.assertThat().body(getResponseAlpha2SingleResult(), equalTo(VALUE_ALPHA_CODE_2))
				.and()
				.assertThat().body(getResponseAlpha3SingleResult(), equalTo(VALUE_ALPHA_CODE_3));
	}
	
	


}
