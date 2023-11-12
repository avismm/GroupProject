package utils;

import pages.*;

public class PageInitializer {
    public static LoginPage loginPage;
    public static InvalidLoginPage invalidLoginPage;
    public static DashboardPage dashboardPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static void initializePageObjects(){
        loginPage= new LoginPage();
        invalidLoginPage= new InvalidLoginPage();
        dashboardPage= new DashboardPage();
        employeeSearchPage= new EmployeeSearchPage();
        addEmployeePage= new AddEmployeePage();
    }
}
