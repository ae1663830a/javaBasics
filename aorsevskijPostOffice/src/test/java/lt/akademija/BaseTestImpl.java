package lt.akademija;

import lt.vtvpmc.java.postoffice.AbstractPostOfficeTest;
import lt.vtvpmc.java.postoffice.PostOffice;

/**
 * class BaseTestImpl - tests PostOfficeImpl methods.
 *
 * @author Andrej Orsevskij
 * @version 2.0
 */
public class BaseTestImpl extends AbstractPostOfficeTest {
    /**
     * Creates new PostOffice
     * @return Returns PostOffice
     */
    @Override
    protected PostOffice getPostOffice() {
        return new PostOfficeImpl();
    }
}
