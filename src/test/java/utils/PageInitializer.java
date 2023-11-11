package utils;


import pages.*;

public class PageInitializer {
    //created the obj
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeDetailsPage employeeDetailsPage;
    public static EmployeeJobPage employeeJobPage;
    public static AdminPage adminPage;
    public static LanguagePage languagePage;
    public static membershipSectionPage membershipSectionPage;
    public static EditEmployeeInfoPage editEmployeeInfoPage;
    public static MyInfoPage myInfoPage;
    public static TerminateEmployeePage terminateEmployeePage;
    public static void initializePageObjects(){
        //calling the obj
        loginPage= new LoginPage();
        dashboardPage= new DashboardPage();
        employeeSearchPage= new EmployeeSearchPage();
        addEmployeePage= new AddEmployeePage();
        employeeDetailsPage = new EmployeeDetailsPage();
        adminPage= new AdminPage();
        languagePage= new LanguagePage();
        membershipSectionPage=new membershipSectionPage();
        editEmployeeInfoPage=new EditEmployeeInfoPage();
        myInfoPage=new MyInfoPage();
        employeeJobPage=new EmployeeJobPage();
        terminateEmployeePage=new TerminateEmployeePage();
    }
}