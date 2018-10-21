package scbtester.net.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultResponseModel {

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public DefaultResponseModel(){}

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
