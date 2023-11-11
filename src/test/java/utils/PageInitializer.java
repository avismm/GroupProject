package utils;

import pages.*;

public class PageInitializer {
    //created the obj
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static AdminPage adminPage;
    public static LanguagePage languagePage;

    public static void initializePageObjects(){
        //calling the obj
        loginPage= new LoginPage();
        dashboardPage= new DashboardPage();
        employeeSearchPage= new EmployeeSearchPage();
        addEmployeePage= new AddEmployeePage();
        adminPage= new AdminPage();
        languagePage= new LanguagePage();
    }
}
