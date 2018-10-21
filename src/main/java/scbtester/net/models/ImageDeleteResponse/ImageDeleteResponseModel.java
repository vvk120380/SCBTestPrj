package scbtester.net.models.ImageDeleteResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDeleteResponseModel {

    @JsonProperty("data")
    private boolean data;

    @JsonProperty("success")
    private boolean success;

    @JsonProperty("status")
    private int status;

    public ImageDeleteResponseModel(){}

    public ImageDeleteResponseModel(boolean data, boolean success, int status){
        setData(data);
        setSuccess(success);
        setStatus(status);
    }


    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

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
