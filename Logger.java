/**
 * Logger
 * Author: Trevor Davies (ltd9938@rit.edu)
 * Maintainer: Trevor Davies
 * Date: 05/24/2018
 */

import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Logger
{
    // Class constants

    // Class variables
    private File file;


    /**
     * Constructor - Just sets the class file variable
     * @param file
     */
    public Logger(File file)
    {
        // Local constants

        // Local variables

        /****** start Logger() ******/

        this.file = file;

    }

    /**
     * The public method that gets called in MainActivity. Generates the current date/time
     * and concatenates it to the data. Also turns the string into a string array. Then calls the
     * private save method with txt as it's parameter
     * @param data - What command was sent to the controller
     */
    public void write(String data)
    {
        // Local constants

        // Local variables
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String time = "[" + formatter.format(date) + "]";
        String txt[];

        /****** start write() ******/

        data = time + " - " + data;
        txt = String.valueOf(data).split(System.getProperty("line.separator"));
        save(txt);
    }

    /**
     * Saves the string array to the log.txt file.
     * @param data
     */
    private void save(String[] data)
    {
        // Local constants

        // Local variables
        FileOutputStream fos = null;

        /****** start save() ******/

        try {
            fos = new FileOutputStream(file, true);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            for(int i = 0; i < data.length; i++)
                fos.write((data[i] + "\n").getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                fos.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
