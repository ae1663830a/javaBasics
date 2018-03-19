package lt.akademija;

import lt.vtvpmc.java.imperial.ImperialCube;
import lt.vtvpmc.java.imperial.MetricCube;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Additional tests for MetricCubeImpl
 *
 * @author Andrej Orsevskij
 * @version 2.0
 */
public class AdditionalCubeTest {
    private MetricCube metricCube;
    private ImperialCube imperialCube;

    @Before
    public void setUp() {
        metricCube = new MetricCubeImpl(imperialCube);
    }

    /**
     * Checks if correctly changes color name of cube
     */
    @Test
    public void shouldConvertColor() {
        ImperialCube imperialCube = new ImperialCube(5.3, "gray");
        MetricCube metricCube = new MetricCubeImpl(imperialCube);
        assertEquals("grey", metricCube.getColor());
    }

    /**
     * Checks if correctly converts side value of cube
     */
    @Test
    public void shouldCorrectlyConvertCubeSideValues() {
        ImperialCube imperialCube = new ImperialCube(1, "gray");
        MetricCube metricCube = new MetricCubeImpl(imperialCube);
        assertEquals(2.54, metricCube.getSideInCentimeters(), 0.0001);
    }

    /**
     * Checks if correctly converts volume of cube
     */
    @Test
    public void shouldCorrectlyConvertCubeVolume() {
        ImperialCube imperialCube = new ImperialCube(1, "gray");
        MetricCube metricCube = new MetricCubeImpl(imperialCube);
        assertEquals(16.387, metricCube.getVolumeInCentimeters(), 0.01);
    }
}
