package StepDefinition;

import java.time.Duration;

import Utilities.testContainer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePgeValidation {
	
	public testContainer tc;
	public HomePgeValidation(testContainer tcnr) {
		this.tc = tcnr;
	}
	@Given("verify previous update is present as card titile.")
	public void verify_previous_update_is_present_as_card_titile() {
		System.out.println("one");
		this.tc.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    this.tc.pageObject.HomePage().getCardTitle();
	}

	@Then("verify last transcation detail along with transDETAIL is displayed")
	public void verify_last_transcation_detail_along_with_trans_detail_is_displayed() {
		this.tc.pageObject.HomePage().lastTransDetail();
	}

	@Then("verify checkbox along with content when it clicked.")
	public void verify_checkbox_along_with_content_when_it_clicked() {
		this.tc.pageObject.HomePage().checkBoxValidation();
	}
	
	@Given("verify the transcation popup is visible")
	public void verify_the_transcation_popup_is_visible() {
	    this.tc.pageObject.HomePage().transcationPopUpVisiblity();
	}

	@Then("check transcationType dropdown has options")
	public void check_transcation_type_dropdown_has_options(DataTable dataTable) {
		 this.tc.pageObject.HomePage().transcationTypeDropdown(dataTable);
	}

	@Then("check user able to add the transcation details {string} {string} {int}")
	public void check_user_able_to_add_the_transcation_details(String string, String string2, Integer int1) {
		this.tc.pageObject.HomePage().updateTranscationDetail(string, string2, int1);
	}

	@Then("verify the total accounts in accountDetail and add the transcation")
	public void verify_the_total_accounts_in_account_detail_and_add_the_transcation(DataTable dataTable) {
		this.tc.pageObject.HomePage().accountType();
	}

	@Then("check whether the transcation got added to the section")
	public void check_whether_the_transcation_got_added_to_the_section() {
	    
	}
}
