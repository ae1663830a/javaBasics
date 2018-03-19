package lt.akademija;

import lt.vtvpmc.java.imperial.AbstractCubeTest;
import lt.vtvpmc.java.imperial.ImperialCube;
import lt.vtvpmc.java.imperial.MetricCube;

/**
 * class BaseTestImpl - tests MetricCubeImpl methods.
 *
 * @author Andrej Orševskij
 * @version 2.0
 */
public class BaseTestImpl extends AbstractCubeTest {
    /**
     * Creates new MetricCube
     *
     * @param imperialCube Receives cube in imperial values as a parameter
     * @return Returns cube in metric values
     */
    @Override
    protected MetricCube adapt(ImperialCube imperialCube) {
        return new MetricCubeImpl(imperialCube);
    }
}
