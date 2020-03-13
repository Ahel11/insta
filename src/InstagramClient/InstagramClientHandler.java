package InstagramClient;

import database.DatabaseHandler;
import model.InstagramUserRecord;
import model.MailAccount;

import java.util.ArrayList;
import java.util.List;

public class InstagramClientHandler {

    public static List<String> logList = new ArrayList<>();
    public static ArrayList<InstagramUserRecord> allRecords = new ArrayList<>();
    public static ArrayList<String> allUsernames = new ArrayList<>();

    public static synchronized void addEventLog(String logEvent) {
        logList.add(logEvent);
    }

    public InstagramClientHandler() {
        DatabaseHandler handler = new DatabaseHandler();
        allRecords = handler.getAllRecords();
        allUsernames = handler.getAllUserNames();
    }

    public void startPromotingMessages() {
        ArrayList<InstagramClient> allClients = (ArrayList) getInstagramClients();
        for(InstagramClient currClient: allClients) {
            currClient.start();
        }

        printLogs();
    }


    private void printLogs() {
        while(true) {
            for (int i = 0; i < 20; i++) {
                System.out.println("\n");
            }
            for(String currLog: logList) {
                System.out.println(currLog + "\n");
            }
            sleepT(20000);
        }
    }

    private void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

    private List<InstagramClient> getInstagramClients() {
        List<InstagramClient> allClients = new ArrayList<InstagramClient>();

        InstagramClient currClient = new InstagramClient("mindpieytings", "gorben19348U");
        allClients.add(currClient);

        currClient = new InstagramClient("Lajpalm26", "yWairstacy");
        allClients.add(currClient);

        currClient = new InstagramClient("Girayser39", "WIggGT7eGKEF");
        allClients.add(currClient);

        currClient = new InstagramClient("Manandeep24", "yoe3ocathy");
        allClients.add(currClient);

        currClient = new InstagramClient("Navtejbh9", "aBaeqbarba");
        allClients.add(currClient);

        currClient = new InstagramClient("Lakbirmki7", "saiNejames");
        allClients.add(currClient);

        return allClients;
    }

}

























