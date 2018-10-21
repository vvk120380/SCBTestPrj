package scbtester.net.models.ImageUploadResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import scbtester.net.models.DefaultResponseModel;

public class ImageUploadResponseModel extends DefaultResponseModel {

    @JsonProperty("data")
    private ImageUploadDataResponseModel data;

    public ImageUploadResponseModel(){}

    public ImageUploadDataResponseModel getData() {
        return data;
    }

    public void setData(ImageUploadDataResponseModel data) {
        this.data = data;
    }
}
