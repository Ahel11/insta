package database;


import model.InstagramUserRecord;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/instagram";

    Connection conn = null;

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    private String paran = "'";

    public DatabaseHandler() {
        init();
    }

    private void init() {
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addListOfNames(ArrayList<String> names) {
        try {
            Statement stmt = conn.createStatement();
            PreparedStatement preparedStmt = conn.prepareStatement("INSERT INTO instagramusername VALUES(0, UserName) VALUES ( ?, ?)");
            for(String s: names) {
                preparedStmt.setString (1, "0");
                preparedStmt.setString (2, s);

                preparedStmt.addBatch();
            }
            preparedStmt.executeBatch();


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUserName(String name) {
        try {
            Statement stmt = conn.createStatement();
            String sqlInsertion = "INSERT INTO instagramusername VALUES(0," + paran + name + paran + ")";
            stmt.executeUpdate(sqlInsertion);
        }catch (Exception e) {
        }
    }

    public ArrayList<String> getAllUserNames() {
        ArrayList<String> listToReturn = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sqlInsertion = "SELECT * FROM instagramusername";
            ResultSet srs = stmt.executeQuery(sqlInsertion);

            while (srs.next()) {
                listToReturn.add(srs.getString("userName"));
            }
            return listToReturn;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<InstagramUserRecord> getAllRecords() {
        ArrayList<InstagramUserRecord> allRecords = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sqlInsertion = "SELECT * FROM instagramuser";
            ResultSet srs = stmt.executeQuery(sqlInsertion);

            while (srs.next()) {
                InstagramUserRecord currRecord = new InstagramUserRecord();
                String name = srs.getString("userName");
                String bio = srs.getString("BioAndDesc");
                long followingCount = srs.getLong("FollowingCount");
                long followersCount = srs.getLong("FollowerCount");
                long mediaCount = srs.getLong("MediaCount");
                String phoneNr = srs.getString("PhoneNumber");
                String mail = srs.getString("Mail");
                Boolean isVerified = srs.getBoolean("IsVerified");
                String externalUrl = srs.getString("ExternalUrl");
                Long nrOfHighlights = srs.getLong("NrOfHighlights");
                Boolean isBusinessAcc = srs.getBoolean("IsBusinessAccount");
                Boolean IsRecentlyJoined = srs.getBoolean("IsRecentlyJoined");
                String businessCategoryName = srs.getString("businessCategoryName");

                currRecord.setName(name);
                currRecord.setBio(bio);
                currRecord.setFollowingCount(followingCount);
                currRecord.setFollowersCount(followersCount);
                currRecord.setMediaCount(mediaCount);
                currRecord.setPhoneNumber(phoneNr);
                currRecord.setMail(mail);
                currRecord.setVerfied(isVerified);
                currRecord.setExternalUrl(externalUrl);
                currRecord.setNrOfHighlights(nrOfHighlights);
                currRecord.setBusinessAccount(isBusinessAcc);
                currRecord.setRecentlyJoined(IsRecentlyJoined);
                currRecord.setBusinessCategoryName(businessCategoryName);

                allRecords.add(currRecord);

            }
            return allRecords;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addRecord(InstagramUserRecord record) {
        try {
            Statement stmt = conn.createStatement();
            String sqlInsertion = "INSERT INTO instagramuser VALUES(0," + record.getPk() + "," + paran + record.getName() + paran + "," +
                    paran + record.getBio() + paran + "," + record.getFollowingCount() + "," + record.getFollowersCount() + "," + record.getMediaCount() + ","
                    + paran + record.getPhoneNumber() + paran + "," + paran + record.getMail() + paran + "," + record.getVerfied() + "," + paran +  record.getExternalUrl() + paran + "," +
                    record.getNrOfHighlights() + "," + record.getBusinessAccount() + "," + record.getRecentlyJoined() + "," + paran + record.getBusinessCategoryName() + paran
                    + ")";
            stmt.executeUpdate(sqlInsertion);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }



}

























