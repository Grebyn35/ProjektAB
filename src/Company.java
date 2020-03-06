import java.util.ArrayList;
import java.util.List;

public class Company {
    String name;
    double averageValue = 0;
    double maxValue = 0;
    double minValue = 5000;
    double inconsistencyValue = 0;
    double inconScore = 0;
    ArrayList<Double> valueList = new ArrayList<Double>();
    public static List<Company> companyList = new ArrayList<Company>();

    @Override
    public String toString() {
        return name+"\n\t-max: " + maxValue + "\n\t-min: " + minValue + "\n\t-average: " + averageValue + "\n\t-inconsistency Score: " + inconScore + "\n\t-inconsistency value: " + inconsistencyValue+"\n";
    }

    public Company(String name){
        this.name = name;
        companyList.add(this);
    }
    public String getName(){
        return name;
    }
    public void addValue(String value){
        double valueDouble = Double.parseDouble(value.replaceAll(",", "."));
        valueList.add(valueDouble);
        updateValues();
        calculateInconsistencyValue(valueDouble);
        calculateInconScore();

    }
    public List<Double> getValue(){
        return valueList;
    }
    public void updateValues(){
        double tempAverageValue = 0;
        for(int i = 0; i<valueList.size(); i++){
            if(valueList.get(i)>maxValue){
                maxValue = valueList.get(i);
            }
        }
        for(int i = 0; i<valueList.size(); i++){
            if(valueList.get(i)<minValue){
                minValue = valueList.get(i);
            }
        }
        for(int i = 0; i<valueList.size(); i++){
            tempAverageValue += valueList.get(i);
        }
        averageValue = tempAverageValue / valueList.size();

    }
    double tempNumber = 0;
    public void calculateInconsistencyValue(Double value){
        if(tempNumber==0){
        tempNumber = value;
        }
            if (value > tempNumber) {
                inconsistencyValue += value - tempNumber;

            }
            if (tempNumber >value) {
                inconsistencyValue += tempNumber % value;

            }
            tempNumber = value;
    }
    public void calculateInconScore(){
        inconScore = (averageValue / (averageValue - inconsistencyValue));
    }

}