package lt.akademija;

import lt.vtvpmc.java.postoffice.IllegalPackageException;
import lt.vtvpmc.java.postoffice.Package;
import lt.vtvpmc.java.postoffice.PostOffice;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * PostOffice distributes packages
 *
 * @author Andrej Orsevskij
 * @version 2.0
 */
public class PostOfficeImpl implements PostOffice {

    /**
     * A Logger is used to log messages
     */
    private static final Logger logger = Logger.getLogger(PostOfficeImpl.class);
    /**
     * Holds packages list
     */
    private ArrayList<Package> packages;

    /**
     * Constructor of PostOfficeImpl, has no parameters
     */
    PostOfficeImpl() {
        this.packages = new ArrayList<>();
    }

    /**
     * Posting the package adds it to PostOffice inventory
     *
     * @param packageToPost Package to post
     * @throws IllegalPackageException Throws exception if package without a package code or owner
     */
    @Override
    public void postPackage(Package packageToPost) throws IllegalPackageException {
        if (packageToPost != null) {
            if (packageToPost.getPackageCode() != null && !packageToPost.getPackageCode().equals("") && packageToPost.getOwner() != null && !packageToPost.getOwner().equals("")) {
                logger.info("Package of " + packageToPost.getOwner() + " with code " + packageToPost.getPackageCode() + " has been posted");
                packages.add(packageToPost);
            } else {
                throw new IllegalPackageException();
            }
        }
    }

    /**
     * Counts the number of packages by the owner currently in the PostOffice
     *
     * @param owner Owner as a parameter
     * @return Return number of packages of given owner
     */
    @Override
    public long numberOfPackagesForOwner(String owner) {
        long count = packages.stream().filter(pack -> pack.getOwner().equals(owner)).count();
        logger.info(owner + " has " + count + " packages");
        return count;
    }

    /**
     * Retrieves a package from PostOffice by package code. PostOffice removes the package from its inventory before returning it
     *
     * @param packageCode Package code as a parameter
     * @return Returns retrieved package or null if package is not found
     */
    @Override
    public Package retrievePackage(String packageCode) {
        Package retrieved = packages.stream().filter(pack -> pack.getPackageCode().equals(packageCode)).findAny().orElse(null);
        if (retrieved == null) {
            logger.info("Package with package code " + packageCode + " does not exist");
            return null;
        } else {
            packages.remove(retrieved);
            logger.info("Package with package code " + packageCode + " has been removed from PostOffice inventory");
            return retrieved;
        }
    }
}
