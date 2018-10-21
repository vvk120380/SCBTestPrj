package scbtester.net.steps.api.account;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import scbtester.net.models.AccessTokenResponse.GenerateAccessTokenResponseModel;
import scbtester.net.models.AccessTokenResponse.GenerateAccessTokenFaildResponseModel;
import scbtester.net.models.AccessTokenResponse.GenerateAccessTokenSuccessResponseModel;
import scbtester.net.models.AccountBaseResponse.AccountBaseResponseModel;
import scbtester.net.steps.api.RestApiCommonSteps;

import static io.restassured.RestAssured.given;
import static io.restassured.config.MultiPartConfig.multiPartConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class AccountSteps extends RestApiCommonSteps{

    static public GenerateAccessTokenResponseModel generateAccessToken(String refresh_token, String client_id, String client_secret){
        RequestSpecification request = given().spec(new RequestSpecBuilder().setContentType("multipart/form-data").build()).
                config(config().multiPartConfig(multiPartConfig().defaultSubtype("mixed")))
                .multiPart("refresh_token", refresh_token)
                .multiPart("client_id", client_id)
                .multiPart("client_secret", client_secret)
                .multiPart("grant_type","refresh_token")
                .log().all();
        Response response = request.baseUri(BASE_URL).basePath(GENERATE_ACCESS_TOKEN_URL).when().post();
        int statusCode = response.then().log().all().extract().response().getStatusCode();
        return statusCode == 200
                ?
                new GenerateAccessTokenResponseModel(response.then().log().all().extract().as(GenerateAccessTokenSuccessResponseModel.class), null)
                :
                new GenerateAccessTokenResponseModel(null, response.then().log().all().extract().as(GenerateAccessTokenFaildResponseModel.class));
    }

    static public AccountBaseResponseModel accountBase(String user_name, String client_id){
        RequestSpecification request = given().header("Authorization", String.format("Client-ID %s", client_id)).log().all();
        Response response = request.baseUri(BASE_URL).basePath(ACCESS_PATH_URL).when().get("/{username}", user_name);
        return response.then().log().all().extract().as(AccountBaseResponseModel.class);
    }
}
