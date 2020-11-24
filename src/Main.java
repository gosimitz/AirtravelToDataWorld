import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties properties = getProperties("src/config.properties");
        String filepath = properties.getProperty("filepath");
        BTSDownload.downloadFile(filepath, 2020, 2);
        //unzip
        //create data.world project
        //upload files from unzip
        //delete files from unzip
        //move on.
    }

    /**
     * A method to read in a properties file.
     * Adapted from: https://www.codejava.net/coding/reading-and-writing-configuration-for-java-application-using-properties-class
     * @param propFileName - filepath of properties file.
     * @return the Properties object made from the properties file.
     * or a new Properties object if there is an error in accessing properties
     */
    private static Properties getProperties(String propFileName) {
        File configFile = new File(propFileName);

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);
            return props;

        } catch (Exception ex) {
            // file does not exist
        }
        return new Properties();
    }
}
