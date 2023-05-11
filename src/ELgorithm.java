import java.awt.Point;

/**
 * This algorithm uses the Sensor class to methodically scan an area of a map to find the inputed extra-terrestrial.
 * 
 * Honor Code: All work is my own.
 * 
 * @author Joseph Pogoretskiy
 * @version 04/22/2023
 */
public class ELgorithm {
    private Sensor sensor;

    /**
     * Constructs a new ELgorithm with the inputed sensor.
     * 
     * @param sensor The extra-terrestrial sensor
     */
    public ELgorithm(Sensor sensor) {
        this.sensor = sensor;
    }

    /**
     * Search for the extra-terrestrial by splitting the map into four quadrants and scanning each quadrant. If none on
     * the quadrants have signals, there are no extra-terrestrials. Else, whatever quadrant the signal is located in,
     * split that quadrant into four and repeat the process until the width is less than two.
     * 
     * @param x The x-coordinate of the scan
     * @param y The y-coordinate of the scan
     * @param width The width and height of the square to scan with the x and y-coordinates being the top left corner.
     * @return The point where the extra-terrestrial is and null if the extra-terrestrial is not on campus
     */
    public Point search(int x, int y, int width) {
        if (width < 2) {
            return new Point(x, y);
        } else {
            int result = sensor.scan(x, y, width / 2);
            if (result > 0) {
                return search(x, y, width / 2);
            } else {
                int result2 = sensor.scan(x + width / 2, y, width / 2);
                if (result2 > 0) {
                    return search(x + width / 2, y, width / 2);
                } else {
                    int result3 = sensor.scan(x, y + width / 2, width / 2);
                    if (result3 > 0) {
                        return search(x, y + width / 2, width / 2);
                    } else {
                        int result4 = sensor.scan(x + width / 2, y + width / 2, width / 2);
                        if (result4 > 0) {
                            return search(x + width / 2, y + width / 2, width / 2);
                        } else {
                            return null;
                        }
                    }
                }
            }
        }
    }
}
