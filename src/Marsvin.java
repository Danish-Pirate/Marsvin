import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Marsvin implements Comparable<Marsvin> {
    private String name;
    private String race;
    private int amountOfFoodInGrams;

    public static void main(String[] args) {
        List<Marsvin> listOfMarsvin = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("marsvin.txt"));
            while (scanner.hasNextLine()) {
                Marsvin marsvin = new Marsvin();
                marsvin.name = scanner.next();
                marsvin.race = scanner.next();
                marsvin.amountOfFoodInGrams = scanner.nextInt();

                listOfMarsvin.add(marsvin);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(0);
        }
        int amountOfFoodSum = 0;
        for (Marsvin marsvin : listOfMarsvin) {
            amountOfFoodSum += marsvin.amountOfFoodInGrams;
        }
        System.out.println("The Guinea pigs consume a total of " + amountOfFoodSum + " grams of food.");
        Collections.sort(listOfMarsvin);
        System.out.println(listOfMarsvin);
    }

    @Override
    public int compareTo(Marsvin o) {
        if (this.amountOfFoodInGrams > o.amountOfFoodInGrams) {
            return 1;
        }
        else if (this.amountOfFoodInGrams < o.amountOfFoodInGrams) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString () {
        return name + " " + amountOfFoodInGrams;
    }
}
