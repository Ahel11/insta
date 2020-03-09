package threads;

import database.DatabaseHandler;
import handlers.AccountConverterHandler;
import handlers.InstagramScraperHandler;
import model.InstagramUserRecord;

import java.util.ArrayList;

public class FetchUserFromNameThread extends Thread {

    private ArrayList<String> allNames;
    private InstagramScraperHandler instagramScraperHandler;
    private DatabaseHandler handler;

    public FetchUserFromNameThread(ArrayList<String> names) {
        allNames = names;
        handler = new DatabaseHandler();
        instagramScraperHandler = new InstagramScraperHandler();
    }

    public void run() {
        for(int i=0; i<allNames.size(); i++) {
            String currName = allNames.get(i);
            InstagramUserRecord record = getRecord(currName);
            if(record == null) {
                continue;
            }

            if(record.getFollowingCount() != -1) {
                handler.addRecord(record);
            }
            sleepT(5000);
        }
    }

    private InstagramUserRecord getRecord(String name) {
        String userNameHtml = instagramScraperHandler.getUserFromName(name);
        if(userNameHtml == null) {
            return null;
        }
        AccountConverterHandler converterHandler = new AccountConverterHandler();
        InstagramUserRecord rec = converterHandler.convertHtmlToInstagramUserRecord(userNameHtml);
        rec.setName(name);
        return rec;
    }

    public void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}







































