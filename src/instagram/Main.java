package instagram;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        testLikeComment();
    }

    public static void login() {
        String pass = "Polin137";
        try {
            InstagramUser user = new InstagramUser("raimen173",pass);
            user.login();
            user.commentMedia("B3K2v77gI7Z", "Tempus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testCommentLatestPostOnUser() {
        InstagramUser currUser = new InstagramUser("raimen173", "Polin137");
        currUser.login();

        InstagramUserHandler searchHandler = new InstagramUserHandler();
        ArrayList<String> allMediaIds = searchHandler.getAllPictureIdsFromUser("mageshpil");
        String latestPictureId = allMediaIds.get(0);
        String mediaId = searchHandler.getMediaIdFromPictureId(latestPictureId);

        System.out.print("\n\nCommenting:\tPictureId: " + latestPictureId + "\tMediaId: " + mediaId + "\n");
        currUser.commentMedia(mediaId, "Hello, nice post!");

        for(String currPictureId: allMediaIds) {
            System.out.print(currPictureId + "\n");
        }


    }

    public static void testLikeMedia() {
        String pass = "Polin137";
        try {
            InstagramUser user = new InstagramUser("raimen173",pass);
            user.login();

            InstagramUserHandler searchHandler = new InstagramUserHandler();
            ArrayList<String> allMediaIds = searchHandler.getAllPictureIdsFromUser("mageshpil");
            String latestPictureId = allMediaIds.get(1);
            String mediaId = searchHandler.getMediaIdFromPictureId(latestPictureId);

            user.likeMedia(mediaId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testLikeComment() {
        String commentId = "18073734712185142";
        String pass = "Polin137";

        try {
            InstagramUser user = new InstagramUser("raimen173",pass);
            user.login();

            user.likeComment(commentId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
