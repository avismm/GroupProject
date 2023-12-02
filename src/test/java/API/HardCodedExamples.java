package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

//to run the methods in a particular order, you can fix the method order using the FixMethod interface from GUnit
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    //in rest assured uri = base url
    String baseURI= RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MDE1MzIwNTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTcwMTU3NTI1NiwidXNlcklkIjoiNjA4NCJ9.IUeIxR-DotQ8aKfv5fUlKbGHF_XyE6iLpEJPJN2kcZs";
    static String employee_id;

    //testNG is an extension of JUnit and NUnit
    @Test
    public void acreateEmployee(){

        //prepare the request using the BDD approach.
        //requestSpecification specification allows us to prepare the request and gives it in a variable "request"
       RequestSpecification request= given().header("Content-Type","application/json").header("Authorization",token)
                .body("{\n" +
                        "  \"emp_firstname\": \"Kinan\",\n" +
                        "  \"emp_lastname\": \"Jovan\",\n" +
                        "  \"emp_middle_name\": \"MPA\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2023-11-26\",\n" +
                        "  \"emp_status\": \"Confirmed\",\n" +
                        "  \"emp_job_title\": \"SBA\"\n" +
                        "}");

        // send the request for creating the employee/ hit the endpoint.
        //response of the class which calls the complete response body and the info (e.g., response time, etc)
        Response response=request.when().post("/createEmployee.php");

        // print the response in the console
        response.prettyPrint();

        //validate the response
        response.then().assertThat().statusCode(201);

        //verifying the data from the response body
        //we use hamcrest matchers class to verify and validate data from the body. The class contains some methods to perform assertions
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Kinan"));
        response.then().assertThat().header("Connection", equalTo("Keep-Alive"));
        //to store the employee id after generating the employee
        employee_id=response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);
    }

    @Test
    public void bgetCreatedEmployee(){
        //prepare the request
        RequestSpecification request = given().header
                ("Content-Type","application/json").
                header("Authorization",token).queryParam("employee_id",employee_id);
        Response response =request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //validate the employee id's one from post call another from get call
        String tempEmpId=response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId,employee_id);

    }
    @Test
    public void cUpdateEmployee(){
        RequestSpecification request = given().header
                        ("Content-Type","application/json").
                header("Authorization",token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"Anthem11\",\n" +
                        "  \"emp_lastname\": \"Muhwerane\",\n" +
                        "  \"emp_middle_name\": \"Mpairwe\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2023-11-29\",\n" +
                        "  \"emp_status\": \"suspended\",\n" +
                        "  \"emp_job_title\": \"SBA\"\n" +
                        "}");
        Response response=request.when().put("updateEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void dgetUpdatedEmployee(){
        //prepare the request
        RequestSpecification request = given().header
                        ("Content-Type","application/json").
                header("Authorization",token).queryParam("employee_id",employee_id);
        Response response =request.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        String tempEmpId=response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId,employee_id);

    }

}
