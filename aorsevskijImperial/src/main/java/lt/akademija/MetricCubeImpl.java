package lt.akademija;

import lt.vtvpmc.java.imperial.ImperialCube;
import lt.vtvpmc.java.imperial.MetricCube;

/**
 * Metric cube stories cube properties in Metric units.
 *
 * @author Andrej Orsevskij
 * @version 2.0
 */
public class MetricCubeImpl implements MetricCube {

    /**
     * A Logger is used to log messages
     */
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MetricCubeImpl.class);

    /**
     * Cube in imperial units
     */
    private ImperialCube imperialCube;
    /**
     * constant value of inch to centimeter conversion
     */
    private final double INCHES_TO_CENTIMETERS = 2.54;

    /**
     * Constructor of MetricCubeImpl
     *
     * @param imperialCube imperialCube
     */
    MetricCubeImpl(ImperialCube imperialCube) {
        this.imperialCube = imperialCube;
    }

    /**
     * Converts inches to centimeters of side values of cube
     *
     * @return Return cube's side values in centimeters
     */
    @Override
    public double getSideInCentimeters() {
        logger.info("Return side value in centimeters");
        return this.imperialCube.getSideInInches() * INCHES_TO_CENTIMETERS;
    }

    /**
     * Converts inches to centimeters of cube's volume
     *
     * @return Return cube's volume in centimeters
     */
    @Override
    public double getVolumeInCentimeters() {
        logger.info("Return volume in centimeters");
        double getVolumeInCm = INCHES_TO_CENTIMETERS * INCHES_TO_CENTIMETERS * INCHES_TO_CENTIMETERS;
        return this.imperialCube.getVolumeInInches() * getVolumeInCm;
    }

    /**
     * Retrieves cube's color. If cube's color is 'gray' replaces with 'grey'
     *
     * @return Return cubes color
     */
    @Override
    public String getColor() {
        String replaced = this.imperialCube.getColor().replace("gray", "grey");
        if (this.imperialCube.getColor().equals("gray")) {
            logger.info("Replaced cubes color from " + this.imperialCube.getColor() + " to grey and return it.");
            return replaced;
        }
        logger.info("Returns original cube's color");
        return this.imperialCube.getColor();
    }
}
