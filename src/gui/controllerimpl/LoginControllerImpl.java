package gui.controllerimpl;

import database.DatabaseHandler;
import model.CometonAccount;

public class LoginControllerImpl {


    public boolean authenticate(String username, String password) {
        DatabaseHandler handler = new DatabaseHandler();
        CometonAccount account = handler.getCometonAccount(username, password);
        if(account != null) {
            return true;
        } else {
            return false;
        }
    }

}
