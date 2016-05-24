package feature;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import com.google.common.primitives.Ints;

import collection.DuplicatesManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RemoveDuplicatesSteps {
	
	int result[];
 
	@When("^I use set to remove duplicates from array: (.*)")
	public void removeDuplicatesUsingSet(final List<Integer> input) {
		result = DuplicatesManager.removeDuplicatesUsingSet(input); 
	}
	
	@When("^I use iteration to remove duplicates from array: (.*)")
	public void removeDuplicatesUsingIteration(final List<Integer> input) {
		result = DuplicatesManager.removeDuplicatesUsingIterations(input); 
	}
	
	@When("^I use removeDuplicates method to remove duplicates from array: (.*)")
	public void removeDuplicatesWithoutCollection(final List<Integer> input) {
		result = DuplicatesManager.removeDuplicatesWithoutCollection(Ints.toArray(input)); 
	}
 
	@Then("I should get: (.*)")
	public void verifyResult(final List<Integer> expectedResult) {
		assertThat(result.length, equalTo(expectedResult.size()));
		for(int i = 0; i < result.length; i++) {
			assertThat(result[i], equalTo(expectedResult.get(i)));
		}
	}
}
