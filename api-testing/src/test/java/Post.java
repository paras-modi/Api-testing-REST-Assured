import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Post {
	@Test
		public void test_1() {

			JsonObject request = new JsonObject();

			request.addProperty("name", "Paras");
			request.addProperty("job", "Tester");

			//System.out.println(request);
			//System.out.println(request.toString());

			given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toString()).
			when().
			post("https://reqres.in/api/users/").
			then().
			statusCode(201).
			 body("name", equalTo("Paras")).
			 log().all();

		}

}
