import java.util.ArrayList;

public class CompanyController {
    private CompanyList compList;
    private Algoritm alg;
    static ArrayList<CompanyConstructor> companyList = new ArrayList<CompanyConstructor>();

    public void companyFetcher(){
        compList = new CompanyList();
        compList.getList();
        for (int i = 0; i < compList.cmpNameFinal.size(); i++) {
            CompanyConstructor company = new CompanyConstructor(compList.cmpNameFinal.get(i), compList.cmpLastPriceFinal.get(i));
            companyList.add(company);
            System.out.println(companyList.get(i).getValue() + " - " + companyList.get(i).getName());
        }
    }

    public void dataBaseConnection(){

    }
    public void dataBaseUpload(){
        dataBaseConnection();
        companyFetcher();

    }

    public void run() {
        compList = new CompanyList();
        compList.logIn();
        //dataBaseUpload();
    }
}