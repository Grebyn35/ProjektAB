import java.util.ArrayList;

public class CompanyController {
    private ScanCompany compList;
    private Algoritm alg;
    static ArrayList<Company> companyList = new ArrayList<Company>();



    public void dataBaseConnection(){

    }
    public void dataBaseUpload(){
        dataBaseConnection();

    }

    public void run() {
        compList = new ScanCompany();
        ;
        compList.getList();

    }

}