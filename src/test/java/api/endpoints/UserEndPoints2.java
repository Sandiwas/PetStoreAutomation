package api.endpoints;


import static io.restassured.RestAssured.given;
import java.util.ResourceBundle;
import api.payload.User;
import io.restassured.response.Response;




//UserEndpoints.java 
//Created to perform Create, Read, Update, Delete requests to the User services 

public class UserEndPoints2 {

	//method create for getting Urls from properties file 
	
	static ResourceBundle getUrl(){
		ResourceBundle routes=ResourceBundle.getBundle("routes"); //load the properties file  routes.propertie file name 
	return routes;
	}
	
	
	
	public static Response cerateUser(User payload){
		
		String post_url=getUrl().getString("post_url");
		
	Response response=given()
			             .contentType("application/json")
			             .accept("application/json")
			             .body(payload)
	                  .when()
	                      .post(post_url);
		 return response;
	}
	
	public static Response readUser(String userName){
		
		String get_url=getUrl().getString("get_url");
	
		Response response=given()
			              .pathParam("username",userName)
	                   .when()
	                     .get(get_url);
		 return response;
	}
	
	public static Response updateUser(String userName,User payload){
		
		String update_url=getUrl().getString("update_url");
		
	Response response=given()
			             .contentType("application/json")
			             .accept("application/json")
			             .body(payload).pathParam("username",userName)
			          .when()
			             .put(update_url);
		 return response;
	}
	
	
	public static Response deleteUser(String userName){
		
		String delete_url=getUrl().getString("delete_url");
		
	Response response=given()
			            .pathParam("username",userName)
	                  .when()
	                    .delete(delete_url);
		 return response;
	}
	
}
