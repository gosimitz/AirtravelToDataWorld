import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * A simple class to download a Ontime Carrier performance file from the transtats.bts.gov website
 */
class BTSDownload {
    /**
     * Adapted from: https://stackabuse.com/how-to-download-a-file-from-a-url-in-java/
     * A method to download a file using the schema below.
     * https://transtats.bts.gov/PREZIP/On_Time_Reporting_Carrier_On_Time_Performance_1987_present_ + YEAR + _ + MONTH + .zip
     * @param filePathInSystem - /Users/User/Desktop/ - where you wish the file to be stored.
     * @param year - year of data desired (YYYY)
     * @param month - month of data requested (no leading zeros)
     * @return a relative file path to the file downloaded as a string.
     */
    static String downloadFile(String filePathInSystem, int year, int month) {
        try {
            ReadableByteChannel readChannel = Channels.newChannel(new URL("https://transtats.bts.gov/PREZIP/On_Time_" +
                    "Reporting_Carrier_On_Time_Performance_1987_present_" + year + "_" + month + ".zip").openStream());
            FileOutputStream fileOS = new FileOutputStream(filePathInSystem + month + "-" + year + ".zip");
            FileChannel writeChannel = fileOS.getChannel();
            writeChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);
        }
        catch(Exception e){
            return "-1";
        }

        return "";
    }

    /**
     * Delets filePath when called.
     * @param filePath - Filepath of the file to delete
     * @return True if successfully deleted, False if not found or error when delete attempted.
     */
    static boolean deleteFile(String filePath) {
        //#TODO Implement me!
        return false;
    }
}
