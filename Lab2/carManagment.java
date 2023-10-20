import java.io.FileWriter;
import java.util.*;
import java.io.*;
import java.time.Year;

class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private int registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, int registrationNumber){
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYearOfManufacture() {
        return yearOfManufacture;
    }

    public Double getPrice() {
        return price;
    }
}

public class carManagment {
    public static void main(String[] args){
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car(1, "Toyota", "Corola", 2002, "blue", 12500.0, 102);
        Car car2 = new Car(2, "BMW", "Prada", 2005, "blue", 12500.0, 102);
        Car car3 = new Car(3, "Toyota", "Corola", 2007, "blue", 12500.0, 102);
        Car car4 = new Car(4, "Toyota", "Prada", 2002, "blue", 12500.0, 102);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        saveCarsOfBrand(cars, "Toyota");
    }

    private static void saveCarsOfBrand(List<Car> cars, String brand) {
        List<Car> carsBrand = new ArrayList<>();
        for (Car car: cars) {
            if (car.getMake().equals(brand)) {
                carsBrand.add(car);
            }
        }
        saveCarsToFile(carsBrand, "cars_" + brand + "_brand.txt");
    }

    private static void saveCarsModelYear(List<Car> cars, String model, int years) {
        List<Car> carsModelYear = new ArrayList<>();
        int currentYear = Year.now().getValue();
        for (Car car: cars){
            if (car.getModel().equals(model) && currentYear - car.getYearOfManufacture() > years){
                carsModelYear.add(car);
            }
        }
        saveCarsToFile(carsModelYear, "cars_" + model + "_model_" + years +"_year.txt");
    }

    private static void saveCarsYearPrice(List<Car> cars, int year, double price) {
        List<Car> carsYearPrice = new ArrayList<>();
        for (Car car: cars){
            if (car.getYearOfManufacture() == year && car.getPrice() > price) {
                carsYearPrice.add(car);
            }
        }
        saveCarsToFile(carsYearPrice, "cars_" + year + "_year_" + price + "_price.txt");
    }

    private static void saveCarsToFile(List<Car> cars, String filename) {
        try {
            File file = new File("./" + filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Car car: cars){
                bw.write("Car - " + car.getPrice() + " price - " + car.getModel() + " model - " + car.getMake() + " make - " + car.getYearOfManufacture() + " year \n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
