package scbtester.net.models.AccessTokenResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GenerateAccessTokenFaildDataResponseModel {

    @JsonProperty("error")
    private String error;

    @JsonProperty("request")
    private String request;

    @JsonProperty("method")
    private String method;

    public GenerateAccessTokenFaildDataResponseModel(){}

    public GenerateAccessTokenFaildDataResponseModel(String error, String request, String method){
        setError(error);
        setRequest(request);
        setMethod(method);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
