import java.util.Random;
import java.util.Scanner;
class CMyArray {
    private int size = 100;
    private int collection[];

    // allocates and initializes the array
    public CMyArray(int size) {
        this.size = size;
        collection = new int[size];
    }
    // returns the size of the array
    public int getSize() {
        return size;
    }
    private int genRandom(int low, int high) {
        Random rand = new Random();

        return low + Math.abs(rand.nextInt()) % (high - low);
    }
    // assigns random int values in the array
    public void assignArray() {
        final int LOWER = 10, UPPER = 50;
        for (int index = 0; index < size; index++) {
            collection[index] = genRandom(LOWER, UPPER);
        }
    }
    // displays the array elements
    public void displayArray() {
        System.out.println();
        System.out.println("Array Elements Are: ");
        for (int index = 0; index < size; index++) {
            System.out.print(collection[index] + " ");
        }
        System.out.println();
    }
}

/**
 * Movie class
 *
 */
class Movie {
    private String name;
    private String director;
    private int year;

    Movie() {
        this.name = "";
        this.director = "";
        this.year = 1900;
    }
    Movie(String n, String d, int y) {
        this.name = n;
        this.director = d;
        this.year = y;
    }
    public void InputMovie() {
        Scanner cin = new Scanner(System.in);

        System.out.println("Enter name: ");
        this.name = cin.nextLine();

        System.out.println("Enter director: ");
        this.director = cin.nextLine();

        // preventive mechanism
        System.out.println("Enter year: ");
        if (cin.hasNextInt()) {
            this.year = cin.nextInt();
        }
        else {
            // invalid input
            this.year = 1900;
        }

        cin.close();
    }
    public void displayMovie() {
        System.out.println("Name: " + this.name);
        System.out.println("Director: " + this.director);
        System.out.println(("Year: " + this.year));
    }
}

/**
 *
 *
 */
public class Hello {
    public static void main(String[] args) {
        Movie mov = new Movie();
        mov.InputMovie();
        mov.displayMovie();
    }
}