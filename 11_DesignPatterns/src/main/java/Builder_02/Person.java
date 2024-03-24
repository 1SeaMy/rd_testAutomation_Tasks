package Builder_02;

public class Person {
    private final String name;
    private final String lastName;
    private final String worksAs;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.worksAs = builder.worksAs;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {return lastName; }

    public String getWorksAs() {
        return worksAs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                "last name='" + lastName + '\'' +
                ", worksAs='" + worksAs + '\'' +
                '}';
    }

    public static class PersonBuilder {
        private String name;
        private String lastName;
        private String worksAs;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }
        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder worksAs(String worksAs) {
            this.worksAs = worksAs;
            return this;
        }

        public Person build() {
            Person person = new Person(this);
            return person;
        }
    }
}

