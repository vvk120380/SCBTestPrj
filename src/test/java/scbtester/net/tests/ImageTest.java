package scbtester.net.tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.Ignore;
import org.junit.Test;
import scbtester.net.models.AccessTokenResponse.GenerateAccessTokenResponseModel;
import scbtester.net.models.ImageDeleteResponse.ImageDeleteResponseModel;
import scbtester.net.models.ImageListResponse.ImageListResponseModel;
import scbtester.net.models.ImageUploadResponse.ImageUploadResponseModel;
import scbtester.net.steps.api.account.AccountSteps;
import scbtester.net.steps.api.image.ImageSteps;
import static org.assertj.core.api.Assertions.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class ImageTest extends BaseTest{

    protected AccountSteps accountSteps;
    protected ImageSteps imageSteps;

    @Test
    public void uploadImageWithCorrectDataTest() {
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken(refresh_token, client_id, client_secret);
        assertThat(genAccessTokenRequest.getRequestModelSuccess()).as("Не удалось получить access_token").isNotNull();

        String accessToken = genAccessTokenRequest.getRequestModelSuccess().getAccess_token();
        ImageUploadResponseModel imageUploadRequest = imageSteps.upload(accessToken, imgBase64);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(imageUploadRequest.isSuccess()).isTrue();
        softly.assertThat(imageUploadRequest.getStatus()).isEqualTo(200);
        softly.assertThat(imageUploadRequest.getData().getId()).isNotNull();
        softly.assertThat(imageUploadRequest.getData().getDeletehash()).isNotNull();
        softly.assertAll();
    }

    @Test
    public void uploadImageWithWrongAccessTokenTest() {
        String accessToken = "wrong_data";
        ImageUploadResponseModel imageUploadRequest = imageSteps.upload(accessToken, imgBase64);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(imageUploadRequest.isSuccess()).isFalse();
        softly.assertThat(imageUploadRequest.getStatus()).isEqualTo(403);
        softly.assertThat(imageUploadRequest.getData().getError()).isEqualTo("The access token provided is invalid.");
        softly.assertThat(imageUploadRequest.getData().getRequest()).isEqualTo("/3/image");
        softly.assertThat(imageUploadRequest.getData().getMethod()).isEqualTo("POST");
        softly.assertAll();
    }

    @Test
    public void uploadImageWithWrongImageTest() {
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken(refresh_token, client_id, client_secret);
        assertThat(genAccessTokenRequest.getRequestModelSuccess()).as("Не удалось получить access_token").isNotNull();

        String accessToken = genAccessTokenRequest.getRequestModelSuccess().getAccess_token();
        ImageUploadResponseModel imageUploadRequest = imageSteps.upload(accessToken, "");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(imageUploadRequest.isSuccess()).isFalse();
        softly.assertThat(imageUploadRequest.getStatus()).isEqualTo(400);
        softly.assertThat(imageUploadRequest.getData().getError()).isEqualTo("Invalid URL ()");
        softly.assertThat(imageUploadRequest.getData().getRequest()).isEqualTo("/3/image");
        softly.assertThat(imageUploadRequest.getData().getMethod()).isEqualTo("POST");
        softly.assertAll();
    }

    @Test
    public void getImageListWithCorrectDataTest() {
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken(refresh_token, client_id, client_secret);
        assertThat(genAccessTokenRequest.getRequestModelSuccess()).as("Не удалось получить access_token").isNotNull();

        String accessToken = genAccessTokenRequest.getRequestModelSuccess().getAccess_token();
        String userName = genAccessTokenRequest.getRequestModelSuccess().getAccount_username();
        ImageListResponseModel imageListResponse = imageSteps.list(accessToken, userName);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(imageListResponse.isSuccess()).isTrue();
        softly.assertThat(imageListResponse.getStatus()).isEqualTo(200);
        softly.assertAll();
    }

    @Ignore("Надо реалировать проверку, что при передаче неверного access_token  метод отрабатывает корректно")
    @Test
    public void getImageListWithWrongAccessTokenTest() {
    }

    @Ignore ("Надо реалировать проверку, что при передаче неверного user_name метод отрабатывает корректно")
    @Test
    public void getImageListWithWrongUserNameTest() {
    }

    @Test
    public void deleteImageWithCorrectDataTest() {
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken(refresh_token, client_id, client_secret);
        assertThat(genAccessTokenRequest.getRequestModelSuccess()).as("Не удалось получить access_token").isNotNull();

        String accessToken = genAccessTokenRequest.getRequestModelSuccess().getAccess_token();
        String userName = genAccessTokenRequest.getRequestModelSuccess().getAccount_username();
        ImageUploadResponseModel imageUploadRequest = imageSteps.upload(accessToken, imgBase64);
        assertThat(imageUploadRequest.isSuccess()).as("Не удалось загрузить изображение access_token").isTrue();

        String uploadImageId = imageUploadRequest.getData().getId();
        ImageListResponseModel imageListResponse = imageSteps.list(accessToken, userName);
        assertThat(imageUploadRequest.isSuccess()).as("Не удалось список изображений").isTrue();
        assertThat(imageListResponse.getData().stream().filter(s -> s.getId().contains(uploadImageId)).findFirst().isPresent())
                .as("Список изображений не содержит вновь загруженной картинки")
                .isTrue();


        ImageDeleteResponseModel deleteResponse = imageSteps.delete(accessToken, uploadImageId);
        assertReflectionEquals( "Не верный формат ответа",correctImageDeleteData,deleteResponse);

        imageListResponse = imageSteps.list(accessToken, userName);
        assertThat(imageUploadRequest.isSuccess()).as("Не удалось список изображений").isTrue();
        assertThat(imageListResponse.getData().stream().filter(s -> s.getId().contains(uploadImageId)).findFirst().isPresent())
                .as("Изображение не удалилось (список изображений все ее содержит)")
                .isFalse();
    }

    private static final ImageDeleteResponseModel correctImageDeleteData = new ImageDeleteResponseModel(true, true, 200);
}