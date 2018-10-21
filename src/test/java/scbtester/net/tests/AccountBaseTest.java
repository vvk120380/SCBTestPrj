package scbtester.net.tests;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import scbtester.net.models.AccountBaseResponse.AccountBaseResponseModel;
import scbtester.net.steps.api.account.AccountSteps;

public class AccountBaseTest extends BaseTest{

    protected AccountSteps accountSteps;

    @Test
    public void getAccessBaseWithCorrectData(){
        AccountBaseResponseModel accountBaseResponseModel = accountSteps.accountBase(user_name, client_id);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(accountBaseResponseModel.isSuccess()).as("").isTrue();
        softly.assertThat(accountBaseResponseModel.getStatus()).as("").isEqualTo(200);
        softly.assertThat(accountBaseResponseModel.getData().getUrl()).as("").isEqualTo(user_name);
        softly.assertAll();
    }

    @Test
    public void getAccessBaseWithWrongClientId(){
        AccountBaseResponseModel accountBaseResponseModel = accountSteps.accountBase(user_name, "wrong_data");
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(accountBaseResponseModel.isSuccess()).as("").isFalse();
        softly.assertThat(accountBaseResponseModel.getStatus()).as("").isEqualTo(400);
        softly.assertAll();
    }

    @Test
    public void getAccessBaseWithWrongUserName(){
        AccountBaseResponseModel accountBaseResponseModel = accountSteps.accountBase("wrong_data", client_id);
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(accountBaseResponseModel.isSuccess()).as("").isFalse();
        softly.assertThat(accountBaseResponseModel.getStatus()).as("").isEqualTo(404);
        softly.assertThat(accountBaseResponseModel.getData().getError()).as("").isEqualTo("Unable to find account username, wrong_data");
        softly.assertThat(accountBaseResponseModel.getData().getRequest()).as("").isEqualTo("/3/account/wrong_data");
        softly.assertThat(accountBaseResponseModel.getData().getMethod()).as("").isEqualTo("GET");
        softly.assertAll();
    }


}
