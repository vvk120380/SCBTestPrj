package scbtester.net.tests;

import org.junit.Test;
import scbtester.net.models.AccessTokenResponse.GenerateAccessTokenResponseModel;
import scbtester.net.models.AccessTokenResponse.GenerateAccessTokenFaildResponseModel;
import scbtester.net.models.AccessTokenResponse.GenerateAccessTokenFaildDataResponseModel;
import scbtester.net.steps.api.account.AccountSteps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

public class GenerateAccountTokenTest extends BaseTest{
    protected AccountSteps accountSteps;

    @Test
    public void getAccessTokenWithCorrectIdentityData(){
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken(refresh_token, client_id, client_secret);
        assertThat(genAccessTokenRequest.getRequestModelSuccess().getToken_type()).isEqualTo("bearer");
        assertThat(genAccessTokenRequest.getRequestModelSuccess().getAccount_username()).isEqualTo("SCBTester");
    }

    @Test
    public void getAccessTokenWithWrongRefreshToken(){
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken("wrong_data", client_id, client_secret);
        assertReflectionEquals( "Не верный формат ответа",
                                wrongRefreshTokenData,
                                genAccessTokenRequest.getRequestModelFaild());
    }

    @Test
    public void getAccessTokenWithWrongClientId(){
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken(refresh_token, "wrong_data", client_secret);
        assertReflectionEquals( "Не верный формат ответа",
                wrongWrongClientId,
                genAccessTokenRequest.getRequestModelFaild());
    }

    @Test
    public void getAccessTokenWithWrongClientSecret(){
        GenerateAccessTokenResponseModel genAccessTokenRequest = accountSteps.generateAccessToken(refresh_token, client_id, "wrong_data");
        assertReflectionEquals( "Не верный формат ответа",
                wrongWrongClientSecret,
                genAccessTokenRequest.getRequestModelFaild());
    }

    private static final GenerateAccessTokenFaildResponseModel wrongRefreshTokenData = new GenerateAccessTokenFaildResponseModel(false, 400,
            new GenerateAccessTokenFaildDataResponseModel("Invalid refresh token","/oauth2/token","POST")
    );

    private static final GenerateAccessTokenFaildResponseModel wrongWrongClientId = new GenerateAccessTokenFaildResponseModel(false, 400,
            new GenerateAccessTokenFaildDataResponseModel("The client credentials are invalid","/oauth2/token","POST")
    );

    private static final GenerateAccessTokenFaildResponseModel wrongWrongClientSecret = new GenerateAccessTokenFaildResponseModel(false, 400,
            new GenerateAccessTokenFaildDataResponseModel("The client credentials are invalid","/oauth2/token","POST")
    );
}
