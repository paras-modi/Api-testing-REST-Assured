import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Put {
	@Test
		public void test_1_put() {

			JsonObject request = new JsonObject();

			request.addProperty("name", "Raghav");
			request.addProperty("job", "Teacher");

			//System.out.println(request);
			//System.out.println(request.toString());

			given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toString()).
			when().
			put("https://reqres.in/api/users/2").
			then().
			statusCode(200).
			 body("name", equalTo("Raghav"));
			//log().all();

		}

}

