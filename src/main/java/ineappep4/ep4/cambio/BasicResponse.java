package ineappep4.ep4.cambio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicResponse {

    private int code;
    private String message;


    public static BasicResponse whenSuccess(){
        return BasicResponse.builder()
                .code(200)
                .message("Success")
                .build();
    }

    public static BasicResponse whenError(String message){
        return BasicResponse.builder()
                .code(500)
                .message("Error")
                .build();
    }


}
