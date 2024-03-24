package Builder_01;
public class Main {

    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder.withName("Deniz").build();
        System.out.println(person.getName());

        EmployeeBuilder employeeBuilder = new EmployeeBuilder();
        Person tester = employeeBuilder.worksAs("QA").build();
        System.out.println(tester.getWorksAs());

    }

}