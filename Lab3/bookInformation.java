import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
class Address {
    private String country;
    private String city;
    private Integer index;
    private String street;
    private Integer house;
    private String flat;

    public Address(){
        // with no parameters constructor
    }

    public Address(String country, String city, Integer index, String street, Integer house, String flat){
        this.country = country;
        this.city = city;
        this.index = index;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getIndex(){
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse(){
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public String getFlat(){
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}

class Person{
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Address address;

    public Person() {
        // with no parameters
    }

    public Person(String name, String surname, Date dateOfBirth, Address address){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

public class bookInformation {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Jack", "Bulta", new Date(2002, 10, 2), new Address("UK", "London", 55211, "Baker St", 43, "Flat 7")),
                new Person("John", "Cream", new Date(1978,  3, 5), new Address("Ukraine", "Kyiv", 11200, "Slova St", 3, "Flat 32")),
                new Person("Max", "Max", new Date(1992, 5, 2), new Address("Germany", "Munich", 99122, "Kasin St", 423, "Flat 7")),
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("people_data.txt"))) {
            for (Person person : people) {
                writer.write("Name: " + person.getName() + "\n");
                writer.write("Surname: " + person.getSurname() + "\n");
                writer.write("Date of Birth: " + person.getDateOfBirth() + "\n");
                Address address = person.getAddress();
                writer.write("Address: " + address.getFlat() + ", " + address.getHouse() + ", " +
                        address.getStreet() + ", " + address.getCity() + ", " +
                        address.getCountry() + ", " + address.getIndex() + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}