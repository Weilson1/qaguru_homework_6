package guru.qa;

import org.junit.jupiter.api.Test;

public class TestWithStepAnnotation {
    private static final String REPOSITORY = "eroshenoam/allure-example";
    WebSteps steps = new WebSteps();

    @Test
    public void annotatedStepsTest() {

        steps
                .openMainPage()
                .searchForRepository(REPOSITORY)
                .openRepositoryPage(REPOSITORY)
                .shouldSeeIssue();

    }
}

