package scbtester.net.models.AccountBaseResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountBaseDataUserFollowResponseModel {
    @JsonProperty ("status")
    private boolean status;

    public AccountBaseDataUserFollowResponseModel(){}

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
