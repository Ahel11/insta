package gui.helper;

import com.sun.javafx.runtime.SystemProperties;
import model.InstagramUserRecord;

import java.awt.*;
import java.io.*;
import java.util.List;

public class FileHandler {

    public static void saveResultsToFile(List<InstagramUserRecord> allRecs) {
        try {
            String userDir = System.getProperty("user.dir");
            File directory = new File(userDir + "//results");
            if (! directory.exists()){
                directory.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }

            createResultsFile(allRecs, directory);
            Desktop.getDesktop().open(directory);



        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createResultsFile(List<InstagramUserRecord> allRecs, File directory) throws Exception{
        long ms = System.currentTimeMillis();
        String fileName = ms + "_results";
        File resultsFile = new File(directory,fileName+".csv");

        if(!resultsFile.exists()){
            resultsFile.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFile, true));
        int counter = 1;
        for(InstagramUserRecord rec: allRecs) {
            String recStr = rec.toString();
            writer.write("Result Number:\t" + counter);
            writer.newLine();
            writer.append(recStr);
            writer.newLine();
            counter++;
        }
        writer.close();

    }

}



































