package instagramimpl;

import handlers.InstagramScraperHandler;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        testCore();
    }

    public static void testCore() {
        Core core = new Core();
        core.getUsersOfUsers();
    }

    public static void testGetPictureIds() {
        InstagramScraperHandler handler = new InstagramScraperHandler();
        ArrayList<String> allPictureIds = handler.getAllPictureIdsFromUser("thejasmarie");

        String randPictureId = allPictureIds.get(2);
        handler.getUsersFromPictureId(randPictureId);

    }

    public static void testGetInstagramUserRecordFromName() {
        InstagramScraperHandler handler = new InstagramScraperHandler();
        handler.getInstagramUserRecordFromName("thejasmarie");
    }

}




























