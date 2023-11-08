package utils;

import pages.LoginPage;
import pages.MyInfoPage;

public class PageInitializer {

    public static LoginPage loginPage;
    public static MyInfoPage myInfoPage;
//public static DashboardPage dashboardPage;
  //  public static EmployeeSearchPage employeeSearchPage;
   // public static AddEmployeePage addEmployeePage;


    public static void initializePageObjects(){
        loginPage = new LoginPage();
        myInfoPage=new MyInfoPage();

       // dashboardPage = new DashboardPage();
        //employeeSearchPage = new EmployeeSearchPage();
        //addEmployeePage = new AddEmployeePage();
    }


}