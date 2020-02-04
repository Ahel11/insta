package instagramimpl;

import model.InstagramUserRecord;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        //InstagramHandler handler = new InstagramHandler("midoo56", "Ahmad7!" + '"');
        testGetPictureIds();


    }

    public static void testGetPictureIds() {
        InstagramScraperHandler handler = new InstagramScraperHandler();
        ArrayList<String> allPictureIds = handler.getAllPictureIdsFromUser("thejasmarie");

        String randPictureId = allPictureIds.get(2);
        handler.getUsersFromPictureId(randPictureId);

    }

}




























