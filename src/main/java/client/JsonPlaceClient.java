package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPUT;

import static utils.Configuration.BASE_URL_JSONPLACE;

public class JsonPlaceClient {
    public Response updatePost(JsonPlaceModelRequestPUT requestBody, String id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .put(BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }

    public Response getAllPosts(){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL_JSONPLACE)
                .thenReturn();
    }

    public Response getSinglePost(String id){
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }

    public Response postPost(JsonPlaceModelRequestPUT requestBody){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(BASE_URL_JSONPLACE)
                .thenReturn();
    }

    public Response deletePost(String id){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .delete(BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }
}
