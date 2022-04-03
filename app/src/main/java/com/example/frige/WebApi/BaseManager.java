package com.example.frige.WebApi;

public class BaseManager {
    protected RestApi getRestApi() {
        RestApiClient restApiClient = new RestApiClient(BaseUrl.model_Url);

        return restApiClient.getRestApi();
    }

}
