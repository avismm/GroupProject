package utils;

import pages.LoginPage;
import pages.MyInfoPage;

import pages.*;

public class PageInitializer {

    public static LoginPage loginPage;

    public static MyInfoPage myInfoPage;
//public static DashboardPage dashboardPage;
  //  public static EmployeeSearchPage employeeSearchPage;
   // public static AddEmployeePage addEmployeePage;

public static EmployeeDetailsPage employeeDetailsPage;
public static EmployeeJobPage employeeJobPage;
public static DashboardPage dashboardPage;
public static EmployeeSearchPage employeeSearchPage;
public static TerminateEmployee terminateEmployee;


      public static void initializePageObjects(){
        loginPage = new LoginPage();

        myInfoPage=new MyInfoPage();

       // dashboardPage = new DashboardPage();
        //employeeSearchPage = new EmployeeSearchPage();

        employeeDetailsPage=new EmployeeDetailsPage();
        employeeJobPage=new EmployeeJobPage();
       dashboardPage = new DashboardPage();
        employeeSearchPage = new EmployeeSearchPage();
       terminateEmployee = new TerminateEmployee();

        //addEmployeePage = new AddEmployeePage();
    }


}