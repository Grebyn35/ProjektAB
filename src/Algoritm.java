import java.util.ArrayList;

public class Algoritm {
    private CompanyController cmpCont;
    private CompanyList compList;
    private CompanyConstructor compConst;
    static ArrayList<CompanyConstructor> companyList = new ArrayList<CompanyConstructor>();

    public void CompanyFetcher(){
        compList = new CompanyList();
        compList.getList();
        for (int i = 0; i < compList.cmpNameFinal.size(); i++) {
            CompanyConstructor company = new CompanyConstructor(compList.cmpNameFinal.get(i), compList.cmpLastPriceFinal.get(i));
            companyList.add(company);
            System.out.println(companyList.get(i).getValue() + " - " +companyList.get(i).getName());
        }
    }

}
