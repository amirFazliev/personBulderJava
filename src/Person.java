import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;

    private OptionalInt optionalInt;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return getAge().getAsInt() != 0;
    }

    public boolean hasAddress() {
        return city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        this.optionalInt = OptionalInt.of(age);
        return optionalInt;
    }

    public String getAddress() { return city; }

    public void setAddress(String address) {
        this.city = address;
    }

    public void happyBirthday() {
        this.age= age+1;
    }

    @Override
    public String toString() {
        return name + " " + surname + " возрастом " + age + " лет";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode();
    }

    public PersonBuilder newChildBuilder(){
        PersonBuilder child = new PersonBuilder();
        child.setSurname(surname);
        child.setAddress(city);
        return child;
    }
}
