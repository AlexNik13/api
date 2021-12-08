package com.example.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestApiResponse {

    private int status;
    private String massage;
    private Object data;

    public RestApiResponse(int status, String massage) {
        this.status = status;
        this.massage = massage;
    }
}
