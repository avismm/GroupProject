package utils;

import pages.*;

public class PageInitializer {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static EditEmployeeInfoPage editEmployeeInfoPage;
    public static void initializePageObjects(){
        loginPage= new LoginPage();
        dashboardPage= new DashboardPage();
        employeeSearchPage= new EmployeeSearchPage();
        addEmployeePage= new AddEmployeePage();
        editEmployeeInfoPage=new EditEmployeeInfoPage();
    }
}
