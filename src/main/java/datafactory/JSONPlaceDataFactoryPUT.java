package datafactory;

import models.request.JsonPlaceModelRequestPUT;

public class JSONPlaceDataFactoryPUT {
    private JsonPlaceModelRequestPUT request;

    public JSONPlaceDataFactoryPUT(JsonPlaceModelRequestPUT requestBody){
        request = requestBody;
    }

    public JSONPlaceDataFactoryPUT setTitle(String title){
        request.setTitle(title);
        return this;
    }

    public JSONPlaceDataFactoryPUT setBody(String body){
        request.setBody(body);
        return this;
    }

    public JsonPlaceModelRequestPUT createRequest(){
        return request;
    }
}
