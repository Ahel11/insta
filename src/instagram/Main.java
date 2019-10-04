package instagram;

public class Main {

    public static void main(String args[]) {
        String pass = "Ahmad7!" + '"';
        try {
            InstagramUser user = new InstagramUser("thoughtss_expressed",pass);
            user.login();
            user.commentMedia("B3K2v77gI7Z", "Tempus");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
