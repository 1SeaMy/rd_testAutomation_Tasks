package Builder_01;
public class PersonBuilder {

    protected Person person = new Person();

    public PersonBuilder withName(String name) {
        person.setName(name);
        return this;
    }

    public Person build() {
        return person;
    }

}