import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is an helper class that is used to perform different operations using a
 * list of points.
 * 
 * @author Rachel Curci Date: 9.5.23
 * 
 *
 */

public class PointProcessor {

    public static ArrayList<Point> readPointsFromFile(final String fileName)
            throws FileNotFoundException {
        // read data from file
        Scanner pointData = new Scanner(new File(fileName));

        // Creating an ArrayList to input integers from into
        ArrayList<Point> ptList = new ArrayList<>();

        // While loop to get integers out of the file and read them as points
        // into ptList
        while (pointData.hasNextInt()) {
            ptList.add(new Point(pointData.nextInt(), pointData.nextInt()));
        }
        // close the data file
        pointData.close();
        return ptList;
    }

    public static int cabDistance(final Point pt) {
        // get x from point and convert to integer to be able to return an
        // integer
        int x = (int) pt.getX();

        // get y from point and convert to integer to be able to return an
        // integer
        int y = (int) pt.getY();

        // if statements to get absolute values of x and y without using
        // math.abs function
        if (x < 0) {
            x = x * -1;
        }

        if (y < 0) {
            y = y * -1;
        }

        // getting distance by adding x and y points
        int distance = y + x;

        return distance;

    }

    public static void showPoint(final Point pt) {
        // print statement to have proper formatting when printing out a point
        // and its distance from (0,0)
        System.out
                .println("(" + (int) pt.getX() + ", " + (int) pt.getY() + ")\t"
                        + cabDistance(pt));

    }

    public static void showAllPoints(final ArrayList<Point> ptList) {
        // creating point variable to hold the point with the corresponding
        // index and use with the showPoint method
        Point pt = new Point();
        // if statement to print empty list if the list is empty
        if (ptList.isEmpty()) {
            System.out.println("Empty list");
            // for loop to loop through ptList and print out the index and use
            // the
            // showPoint method to print the point
        } else {
            for (int i = 0; i < ptList.size(); i++) {
                pt = ptList.get(i);
                System.out.print("[" + i + "] ");
                showPoint(pt);
            }
        }

    }

    public static ArrayList<Point> findAll(final ArrayList<Point> ptList,
            int dist) {
        // creating point variable to hold the point with the corresponding
        // index and use with the cadDistance method
        Point pt = new Point();
        // creating new array list to hold the points that have the distance the
        // user is looking for
        ArrayList<Point> foundPtList = new ArrayList<>();
        // for loop to loop through ptList and find which points correspond with
        // the distance the user is looking for
        // adding the corresponding points to foundPtList
        for (int i = 0; i < ptList.size(); i++) {
            pt = ptList.get(i);
            if (dist == cabDistance(pt)) {
                foundPtList.add(pt);
            }

        }
        return foundPtList;
    }
         
}
