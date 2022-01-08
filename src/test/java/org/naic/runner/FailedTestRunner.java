package org.naic.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "org/naic/step_definitions",
        features = "@target/rerun.txt"
        //   , tags = "@ui"
)
public class FailedTestRunner {

}
