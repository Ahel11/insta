package gui.helper;

import model.InstagramUserRecord;

import java.awt.*;
import java.io.*;
import java.util.List;

public class FileHandler {


    private static long msStat = System.currentTimeMillis();

    public static void saveResultsToFile(List<InstagramUserRecord> allRecs) {
        try {
            String userDir = System.getProperty("user.dir");
            File directory = new File(userDir + "//results");
            if (! directory.exists()){
                directory.mkdir();
                // If you require it to make the entire directory path including parents,
                // use directory.mkdirs(); here instead.
            }

            createResultsFileDetailed(allRecs, directory);
            createResultsFileCsv(allRecs, directory);
            Desktop.getDesktop().open(directory);



        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createResultsFileCsv(List<InstagramUserRecord> allRecs, File directory) throws Exception{
        long ms = System.currentTimeMillis();
        String fileName = msStat + "_results";
        File resultsFile = new File(directory,fileName+".csv");

        if(!resultsFile.exists()){
            resultsFile.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFile, true));
        for(InstagramUserRecord rec: allRecs) {
            String recStr = rec.toString();
            writer.newLine();
            writer.append(recStr);
        }
        writer.close();
    }

    private static void createResultsFileDetailed(List<InstagramUserRecord> allRecs, File directory) throws Exception {
        long ms = System.currentTimeMillis();
        String fileName = msStat + "_results";
        File resultsFile = new File(directory,fileName+"_detailed.csv");

        if(!resultsFile.exists()){
            resultsFile.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(resultsFile, true));

        writer.write("NAME,ID,BIO,FOLLOWING,FOLLOWERS,MEDIACOUNT,PHONE,MAIL,ISVERIFIED,EXTERNALURL,NROFHIGHLIGHTS,ISBUSINESSACCOUNT,ISRECENTLYJOINED,BUSINESSCATEGORY\n");
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



































