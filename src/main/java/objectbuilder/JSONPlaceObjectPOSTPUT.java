package objectbuilder;

import models.request.JsonPlaceModelRequestPUT;

public class JSONPlaceObjectPOSTPUT {
    public static JsonPlaceModelRequestPUT createBodyForJsonPlacePUT(){
        return JsonPlaceModelRequestPUT.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
}
