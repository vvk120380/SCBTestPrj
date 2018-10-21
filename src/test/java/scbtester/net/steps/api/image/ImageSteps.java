package scbtester.net.steps.api.image;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import scbtester.net.models.ImageDeleteResponse.ImageDeleteResponseModel;
import scbtester.net.models.ImageListResponse.ImageListResponseModel;
import scbtester.net.models.ImageUploadResponse.ImageUploadResponseModel;
import scbtester.net.steps.api.RestApiCommonSteps;

import static io.restassured.RestAssured.given;
import static io.restassured.config.MultiPartConfig.multiPartConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class ImageSteps extends RestApiCommonSteps {

    static public ImageUploadResponseModel upload(String accessToken, String base64ImageData){
        RequestSpecification request = given().header("Authorization", String.format("Bearer %s", accessToken))
                .spec(new RequestSpecBuilder().setContentType("multipart/form-data").build()).
                        config(config().multiPartConfig(multiPartConfig().defaultSubtype("mixed")))
                .multiPart("image", base64ImageData)
                .log().all();
        Response response = request.baseUri(BASE_URL).basePath(IMAGE_PATH_URL).when().post();
        return response.then().log().all().extract().as(ImageUploadResponseModel.class);
    }

    static public ImageListResponseModel list(String accessToken, String user_name){
        RequestSpecification request = given().header("Authorization", String.format("Bearer %s", accessToken)).log().all();
        Response response = request.baseUri(BASE_URL).basePath(ACCESS_PATH_URL).when().get("/{username}/images/0", user_name);
        return response.then().log().all().extract().as(ImageListResponseModel.class);
    }

    static public ImageDeleteResponseModel delete(String accessToken, String imageHash){
        RequestSpecification request = given().header("Authorization", String.format("Bearer %s", accessToken)).log().all();
        Response response = request.baseUri(BASE_URL).basePath(IMAGE_PATH_URL).when().delete("/{imageHash}/images/0", imageHash);
        return response.then().log().all().extract().as(ImageDeleteResponseModel.class);
    }

}
