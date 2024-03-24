package Builder_01;
public class EmployeeBuilder extends  PersonBuilder{

    public EmployeeBuilder worksAs(String designation) {
        person.setWorksAs(designation);
        return this;
    }

}