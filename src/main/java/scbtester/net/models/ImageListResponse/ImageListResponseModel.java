package scbtester.net.models.ImageListResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import scbtester.net.models.DefaultResponseModel;
import scbtester.net.models.ImageUploadResponse.ImageUploadDataResponseModel;

import java.util.List;

public class ImageListResponseModel  extends DefaultResponseModel {

    @JsonProperty("data")
    private List<ImageUploadDataResponseModel> data;

    public ImageListResponseModel(){}

    public List<ImageUploadDataResponseModel> getData() {
        return data;
    }

    public void setData(List<ImageUploadDataResponseModel> data) {
        this.data = data;
    }
}
