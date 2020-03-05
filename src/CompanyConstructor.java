public class CompanyConstructor {
    String name;
    String value;
    public CompanyConstructor (String name, String value){
        this.name = name;
        this.value = value;

    }
    public void setName(CompanyConstructor e){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setValue(CompanyConstructor e){
        this.value = value;
    }
    public Double getValue(){
        double valueFinal = Double.parseDouble(value.replaceAll(",", "."));
        return valueFinal;
    }
}