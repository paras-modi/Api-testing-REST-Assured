import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;




public class Get {
	

	@Test
	void test_01() {
	baseURI = "https://reqres.in/api/users";
	given().
          param("page","2").	
	get().then().body("data.id[0]", equalTo(7));	
	}
	
	@Test
	void test_02() {
	baseURI = "https://reqres.in/api/users"; 
	
	given().
		
		header("","").
	when().
		get("").
	then().
		statusCode(200).
	    body("data.id[0]", equalTo(1));	
	
	
	}
	
	@Test
	void test_03()
	{
		baseURI = "https://reqres.in/api/users/2"; 
		
		given().
			
			header("","").
		when().
			get("").
		then().
			statusCode(200).
		    body("data.id", equalTo(2)).
		    log().all();
	}
}