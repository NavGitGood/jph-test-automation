# JPH-Test-Automation #

## API Test Automation framework with following features ##
1. Use of Serenity BDD with Cucumber
2. Test Automation of [JPH API](https://jsonplaceholder.typicode.com/) using SerenityAssured (RestAssured)
3. Integration with CircleCI CI pipeline for test execution and report generation

## Pre-requisites to run and use locally ##
1. Make sure maven is installed (verified on maven 3.6.0 and java 8)

## How to run on powershell or terminal ##
1. Open `powershell / terminal` and navigate to root directory of the project
2. Update the tag (if required) in `TestRunner` file
3. Run `mvn clean verify`
4. Html report would be generated as `target/site/serenity/index.html`

## How to run and view the test report on CircleCI ##
1. Go to [CircleCI pipeline](https://app.circleci.com/pipelines/github/NavGitGood/jph-test-automation)
2. Select `main` branch
3. Click on `Run Pipeline` button and confirm on the popup
4. After execution is complete, click on `test` and then on `ARTIFACTS` button
5. Search for `index.html` and click on it to view the test report

