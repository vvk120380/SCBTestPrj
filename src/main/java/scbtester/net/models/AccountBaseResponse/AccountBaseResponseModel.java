package scbtester.net.models.AccountBaseResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import scbtester.net.models.DefaultResponseModel;

public class AccountBaseResponseModel extends DefaultResponseModel {

    @JsonProperty("data")
    private AccountBaseDataResponseModel data;

    public AccountBaseResponseModel(){}

    public AccountBaseDataResponseModel getData() {
        return data;
    }

    public void setData(AccountBaseDataResponseModel data) {
        this.data = data;
    }
}
