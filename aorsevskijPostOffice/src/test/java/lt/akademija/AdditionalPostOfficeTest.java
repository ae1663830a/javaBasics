package lt.akademija;

import lt.vtvpmc.java.postoffice.Package;
import lt.vtvpmc.java.postoffice.PostOffice;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Additional tests for PostOfficeImpl
 *
 * @author Andrej Orsevskij
 * @version 2.0
 */
public class AdditionalPostOfficeTest {
    private PostOffice postOffice;

    @Before
    public void setUp() {
        postOffice = new PostOfficeImpl();
    }

    /**
     * Checks if correctly counts number packages by owner
     *
     * @throws Exception Throws IllegalPackageException
     */
    @Test
    public void shouldReturnCorrectNumberOfPackagesByOwner() throws Exception {
        Package andrewPackage1 = new Package("POP1", "Andrew");
        Package andrewPackage2 = new Package("POP2", "Andrew");
        postOffice.postPackage(andrewPackage1);
        postOffice.postPackage(andrewPackage2);
        assertEquals(2, postOffice.numberOfPackagesForOwner("Andrew"));
    }

    /**
     * Checks if correctly retrieves packages by package code
     *
     * @throws Exception Throws IllegalPackageException
     */
    @Test
    public void shouldRetrievePackageByPackageCode() throws Exception {
        Package package1 = new Package("POP1", "Andrew");
        Package package2 = new Package("POP2", "Andrew");
        postOffice.postPackage(package1);
        postOffice.postPackage(package2);
        assertEquals(package1, postOffice.retrievePackage("POP1"));
    }

    /**
     * Checks if return null when package does not exist
     *
     * @throws Exception Throws IllegalPackageException
     */
    @Test
    public void shouldReturnNullIfPackageDoesNotExist() throws Exception {
        Package package1 = new Package("POP1", "Andrew");
        Package package2 = new Package("POP2", "Andrew");
        postOffice.postPackage(package1);
        postOffice.postPackage(package2);
        assertEquals(null, postOffice.retrievePackage("POP12"));
    }

    /**
     * Checks if PostOffice removes package after it has been retrieved
     *
     * @throws Exception Throws IllegalPackageException
     */
    @Test
    public void shouldRemovePackageIfPackageHasBeenRetrieved() throws Exception {
        Package andrewPackage = new Package("POP1", "Andrew");
        postOffice.postPackage(andrewPackage);
        postOffice.retrievePackage("POP1");
        assertEquals(0, postOffice.numberOfPackagesForOwner("Andrew"));
    }
}
