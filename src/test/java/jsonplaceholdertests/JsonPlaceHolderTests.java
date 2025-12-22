package jsonplaceholdertests;

import client.JsonPlaceClient;
import datafactory.JSONPlaceDataFactoryPUT;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPUT;
import models.response.JsonPlaceModelResponseGET;
import models.response.JsonPlaceModelResponsePUT;
import objectbuilder.JSONPlaceObjectPOSTPUT;
import org.junit.Test;

import java.util.List;

import static objectbuilder.JSONPlaceObjectPOSTPUT.createBodyForJsonPlacePUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceHolderTests {

    @Test
    public void updatePostDefaultValuesHealthCheck(){
        JsonPlaceModelRequestPUT requestPUT = new JSONPlaceDataFactoryPUT(createBodyForJsonPlacePUT())
                .createRequest();

        Response putResponse = new JsonPlaceClient()
                .updatePost(requestPUT, "1");

        assertEquals(200, putResponse.statusCode());
    }

    @Test
    public void getAllPostsTest(){
        Response getResponse = new JsonPlaceClient()
                .getAllPosts();

        List<JsonPlaceModelResponseGET> getResponseList = getResponse
                .body()
                .jsonPath()
                .getList("", JsonPlaceModelResponseGET.class);

        assertEquals(200, getResponse.statusCode());
        assertFalse(getResponseList.isEmpty());

    }

    @Test
    public void postPostDefaultValuesHealthCheckTest(){
        JSONPlaceObjectPOSTPUT requestPOSTPUT;
    }

    @Test
    public void updatePostCustomValues(){
        JsonPlaceModelRequestPUT requestPUT = new JSONPlaceDataFactoryPUT(createBodyForJsonPlacePUT())
                .setTitle("custom value for title")
                .setBody("custom value for body")
                .createRequest();

        Response putResponse = new JsonPlaceClient()
                .updatePost(requestPUT, "1");

        JsonPlaceModelResponsePUT response = putResponse.body().as(JsonPlaceModelResponsePUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("custom value for title", response.getTitle());
        assertEquals("custom value for body", response.getBody());
    }

    @Test
    public void deletePostCustomValues(){
        JsonPlaceModelRequestPUT requestPUT = new JSONPlaceDataFactoryPUT(createBodyForJsonPlacePUT())
                .setTitle("custom value for title")
                .setBody("custom value for body")
                .createRequest();

        Response putResponse = new JsonPlaceClient()
                .updatePost(requestPUT, "1");

        JsonPlaceModelResponsePUT response = putResponse.body().as(JsonPlaceModelResponsePUT.class);

        assertEquals(200, putResponse.statusCode());
        assertEquals("custom value for title", response.getTitle());
        assertEquals("custom value for body", response.getBody());
    }
}
