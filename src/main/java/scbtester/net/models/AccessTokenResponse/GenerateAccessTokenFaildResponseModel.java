package scbtester.net.models.AccessTokenResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import scbtester.net.models.DefaultResponseModel;

public class GenerateAccessTokenFaildResponseModel extends DefaultResponseModel {

    @JsonProperty("data")
    private GenerateAccessTokenFaildDataResponseModel data;

    public GenerateAccessTokenFaildResponseModel(){}

    public GenerateAccessTokenFaildResponseModel(boolean success, int status, GenerateAccessTokenFaildDataResponseModel data)
    {
        setSuccess(success);
        setStatus(status);
        setData(data);
    }

    public GenerateAccessTokenFaildDataResponseModel getData() {
        return data;
    }

    public void setData(GenerateAccessTokenFaildDataResponseModel data) {
        this.data = data;
    }
}
