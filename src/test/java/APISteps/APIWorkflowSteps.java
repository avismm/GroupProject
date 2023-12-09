package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utils.APIConstants;
import utils.APIPayloads;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIWorkflowSteps {
    public static String token;
    public static String employee_id;
    RequestSpecification request;
    Response response;

    @Given("a JWT is generated")
    public void a_jwt_is_generated() {
        /*RequestSpecification request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                body("{\n" +
                        "  \"email\": \"tests@batch17.com\",\n" +
                        "  \"password\": \"Tests@123\"\n" +
                        "}");*/

        RequestSpecification request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                body(APIPayloads.generateTokenPayload());

        Response response = request.when().post(APIConstants.GENERATE_TOKEN_URI);
        //storing the token after generating it
        token = "Bearer "+ response.jsonPath().getString("token");
        System.out.println(token);
    }

    @Given("a request is prepared to create an employee")
    public void a_request_is_prepared_to_create_an_employee() {
        /*request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token)
                .body("{\n" +
                        "  \"emp_firstname\": \"hind\",\n" +
                        "  \"emp_lastname\": \"pak\",\n" +
                        "  \"emp_middle_name\": \"ms\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2002-11-25\",\n" +
                        "  \"emp_status\": \"confirmed\",\n" +
                        "  \"emp_job_title\": \"qa\"\n" +
                        "}");*/

        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token)
                .body(APIPayloads.createEmployeePayload());
    }

    @When("a POST call is made to create an employee")
    public void a_post_call_is_made_to_create_an_employee() {
        response =  request.when().post(APIConstants.CREATE_EMPLOYEE_URI);
        //to print the response in console
        response.prettyPrint();
    }

    @Then("the status code for this request is {int}")
    public void the_status_code_for_this_request_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
        //validate the body
        response.then().assertThat().
                body("Message", equalTo("Employee Created"));
        response.then().assertThat().
                body("Employee.emp_firstname",equalTo("hind"));
        response.then().assertThat().
                header("Connection",equalTo("Keep-Alive"));
    }

    @Then("the employee id {string} is stored as global variable for other request")
    public void the_employee_id_is_stored_as_global_variable_for_other_request(String empID) {
        employee_id=response.jsonPath().getString(empID);
        System.out.println(employee_id);
    }

//------------------------------------------------------------------------------

    @Given("a request is prepared to get the created employee")
    public void a_request_is_prepared_to_get_the_created_employee() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token).
                queryParam("employee_id", employee_id);
    }

    @When("a GET call is made to get the employee")
    public void a_get_call_is_made_to_get_the_employee() {
        response = request.when().get(APIConstants.GET_ONE_EMPLOYEE_URI);
        response.prettyPrint();
    }

    @Then("the status code for this employee is {int}")
    public void the_status_code_for_this_employee_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Then("the global employee id must match with {string} key")
    public void the_global_employee_id_must_match_with_key(String empId) {
        String tempEmpId = response.jsonPath().
                getString(empId);
        Assert.assertEquals(tempEmpId, employee_id);
    }

    @Then("the retrieved data at {string} object matches the data used to create employee")
    public void the_retrieved_data_at_object_matches_the_data_used_to_create_employee
            (String employeeObject, io.cucumber.datatable.DataTable dataTable) {
        //one map comes from data table
        List<Map<String, String>> expectedData = dataTable.asMaps();
        //another map comes from employee object response
        //get is going to return the whole map, getString returns just one value
        Map<String, String> actualData =
                response.body().jsonPath().get(employeeObject);

        for (Map<String, String> map : expectedData){
            //storing all the keys under set
            Set<String> keys = map.keySet();
            //from set of keys to one key at one time
            for (String key:keys){
                //this will return the value against the keys of datatable
                String expectedValue = map.get(key);
                //this will return the value against the employee object
                String actualValue = actualData.get(key);
                Assert.assertEquals(actualValue, expectedValue);
            }
        }

    }
    @Given("a request is prepared for creating an employee via json payload")
    public void a_request_is_prepared_for_creating_an_employee_via_json_payload() {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token)
                .body(APIPayloads.createEmployeeJsonPayload());
    }
    @Then("the response body contains {string} key and value {string}")
    public void the_response_body_contains_key_and_value(String key, String value) {
        response.then().assertThat().body(key,equalTo(value));
    }

    @Given("a request is prepared for creating an employee with dynamic data {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void a_request_is_prepared_for_creating_an_employee_with_dynamic_data(String firstName, String lastName,
                                                                                 String middleName, String gender,
                                                                                 String birthday, String status,
                                                                                 String jobTitle) {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token)
                .body(APIPayloads.payloadDynamic(firstName,lastName,middleName,gender,birthday,status,jobTitle));
    }

    @Given("a request is prepared to get all job titles")
    public void a_request_is_prepared_to_get_all_job_titles() {
        request = given().
                header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY, token);
    }

    @When("a GET call is made to get all job titles")
    public void a_get_call_is_made_to_get_all_job_titles() {
        response = request.when().get(APIConstants.GET_ALL_JOB_TITLES);
        response.prettyPrint();
    }

    @Given("a request is prepared to update the employee in the HRMS system")
    public void a_request_is_prepared_to_update_the_employee_in_the_hrms_system() {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,token).
                body(APIPayloads.updateEmployeePayload());
    }
    @When("a PUT call is made to update an employee")
    public void a_put_call_is_made_to_update_an_employee() {
        response = request.when().put(APIConstants.UPDATE_EMPLOYEE_URI);
        response.prettyPrint();
    }
    @Then("the status code for updating the employee is {int}")
    public void the_status_code_for_updating_the_employee_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

}
