package utils;

import pages.*;

public class PageInitializer {

    public static LoginPage loginPage;
public static EmployeeDetailsPage employeeDetailsPage;
public static EmployeeJobPage employeeJobPage;
public static DashboardPage dashboardPage;
public static EmployeeSearchPage employeeSearchPage;
public static TerminateEmployee terminateEmployee;

      public static void initializePageObjects(){
        loginPage = new LoginPage();
        employeeDetailsPage=new EmployeeDetailsPage();
        employeeJobPage=new EmployeeJobPage();
       dashboardPage = new DashboardPage();
        employeeSearchPage = new EmployeeSearchPage();
       terminateEmployee = new TerminateEmployee();
        //addEmployeePage = new AddEmployeePage();
    }


}