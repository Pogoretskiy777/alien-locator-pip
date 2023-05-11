import java.util.HashMap;
import java.util.Map;

/**
 * This sensor class functions similar to the original Sensor, but also logs each area that is scanned along with the
 * information on whether the scan was successful or not.
 * 
 * @author Joseph Pogoretskiy
 * @version 04/29/2023
 */
public class LoggingSensor extends Sensor {
    private static final long serialVersionUID = 1L;
    private Map<Area, Boolean> scanLog;

    /**
     * Construct a new LoggingSensor same as the Sensor but declare the scanLog as well.
     * 
     * @param etName The name of the extra-terrestrial
     * @param scanTime The time the sensor took to scan
     */
    public LoggingSensor(String etName, int scanTime) {
        super(etName, scanTime);
        this.scanLog = new HashMap<>();
    }

    /**
     * Scan the area to be scanned with the given x and y-coordinates along with the width. Add the result of the scan
     * to the scanLog.
     * 
     * @param x The x-coordinate of the scan
     * @param y The y-coordinate of the scan
     * @param width The width of the area of the scan
     * @return Positive width if the scan was complete and vice versa
     */
    public int scan(int x, int y, int width) {
        Boolean result;
        int returned = super.scan(x, y, width);
        if (returned > 0) {
            result = true;
        } else {
            result = false;
        }
        Area area = new Area(x, y, width);
        this.scanLog.put(area, result);
        return returned;
    }

    /**
     * Get the scanLog.
     * 
     * @return Return the scanLog
     */
    public Map<Area, Boolean> getScanLog() {
        return this.scanLog;
    }

    /**
     * Return a formatted summary of all the scans in the scanLog that happened when the sensor was active in locating
     * the extra-terrestrial.
     * 
     * @return Return the formatted string
     */
    public String toString() {
        return scanLog.toString();
    }
}