package Builder_02;
public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .name("Ayşe")
                .lastName("Can")
                .worksAs("QA")
                .build();

        System.out.println(person.getName());
        System.out.println(person.getLastName());
        System.out.println(person.getWorksAs());
    }
}
