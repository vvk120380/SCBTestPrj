package scbtester.net.models.AccessTokenResponse;

import scbtester.net.models.DefaultResponseModel;

public class GenerateAccessTokenResponseModel extends DefaultResponseModel {

    private GenerateAccessTokenSuccessResponseModel requestModelSuccess;
    private GenerateAccessTokenFaildResponseModel requestModelFaild;

    public GenerateAccessTokenResponseModel(){}

    public GenerateAccessTokenResponseModel(GenerateAccessTokenSuccessResponseModel requestModelSuccess,
                                            GenerateAccessTokenFaildResponseModel requestModelFaild){
        setRequestModelSuccess(requestModelSuccess);
        setRequestModelFaild(requestModelFaild);
    }

    public GenerateAccessTokenSuccessResponseModel getRequestModelSuccess() {
        return requestModelSuccess;
    }

    public void setRequestModelSuccess(GenerateAccessTokenSuccessResponseModel requestModelSuccess) {
        this.requestModelSuccess = requestModelSuccess;
    }

    public GenerateAccessTokenFaildResponseModel getRequestModelFaild() {
        return requestModelFaild;
    }

    public void setRequestModelFaild(GenerateAccessTokenFaildResponseModel requestModelFaild) {
        this.requestModelFaild = requestModelFaild;
    }
}
