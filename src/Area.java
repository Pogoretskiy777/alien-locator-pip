/**
 * This class represents the area that is scanned with the sensor.
 * 
 * @author Joseph Pogoretskiy
 * @version 04/29/2023
 */
public class Area {
    private int x;
    private int y;
    private int width;

    /**
     * Construct an area with the inputed x and y coordinated and the width.
     * 
     * @param x The x-coordinate
     * @param y The y-coordinate
     * @param width The width of the square that was scanned.
     */
    public Area(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    /**
     * Get the x-coordinate of the area.
     * 
     * @return Return x-coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the y-coordinate of the area.
     * 
     * @return Return y-coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * Get the width of the area.
     * 
     * @return Return the width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Return a formatted summary representing the x and y-coordinates of the upper left corner of the square and the
     * bottom right corner of the square after the width is added to both coordinates.
     * 
     * @return Return the formatted string
     */
    public String toString() {
        int updatedX = this.x + this.width;
        int updatedY = this.y + this.width;
        String string = "\n+-------------------+\n|";
        String coords = String.format("(%3d, %3d) + %3d   |\n", this.x, this.y, this.width);
        String updatedCoords = String.format("|         (%3d, %3d)|\n", updatedX, updatedY);
        string += coords;
        string += updatedCoords;
        string += "+-------------------+";
        return string;
    }
}