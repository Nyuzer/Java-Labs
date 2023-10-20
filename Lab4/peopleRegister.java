import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
class Residence {
    private String country;
    private String city;
    private Integer index;
    private String street;
    private Integer house;
    private String flat;

    public Residence(){
        // with no parameters constructor
    }

    public Residence(String country, String city, Integer index, String street, Integer house, String flat){
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

class Individual{
    private String name;
    private String surname;
    private Date dateOfBirth;
    private Residence residence;

    public Individual() {
        // with no parameters
    }

    public Individual(String name, String surname, Date dateOfBirth, Residence residence){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.residence = residence;
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

    public Residence getResidence(){
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }
}

public class peopleRegister {
    public static void main(String[] args) {
        Individual[] people = {
                new Individual("Jack", "Bulta", new Date(2002, 10, 2), new Residence("UK", "London", 55211, "Baker St", 43, "Flat 7")),
                new Individual("John", "Cream", new Date(1978,  3, 5), new Residence("Ukraine", "Kyiv", 11200, "Slova St", 3, "Flat 32")),
                new Individual("Max", "Max", new Date(1992, 5, 2), new Residence("Germany", "Munich", 99122, "Kasin St", 423, "Flat 7")),
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("people_data.txt"))) {
            for (Individual person : people) {
                writer.write("Name: " + person.getName() + "\n");
                writer.write("Surname: " + person.getSurname() + "\n");
                writer.write("Date of Birth: " + person.getDateOfBirth() + "\n");
                Residence residence = person.getResidence();
                writer.write("Address: " + residence.getFlat() + ", " + residence.getHouse() + ", " +
                        residence.getStreet() + ", " + residence.getCity() + ", " +
                        residence.getCountry() + ", " + residence.getIndex() + "\n");
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}