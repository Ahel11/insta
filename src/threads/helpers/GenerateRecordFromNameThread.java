package threads.helpers;

import fetchers.AddDbRecordsFetcher;
import handlers.InstagramScraperHandler;
import model.InstagramUserRecord;

public class GenerateRecordFromNameThread extends Thread {

    private String username;
    InstagramScraperHandler scraperHandler;

    public GenerateRecordFromNameThread(String name) {
        scraperHandler = new InstagramScraperHandler();
        username = name;
    }

    public void run() {
        InstagramUserRecord currRecord = scraperHandler.getInstagramUserRecordFromName(this.username);
        AddDbRecordsFetcher.addAllRecords(currRecord);
    }

}


























