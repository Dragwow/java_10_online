package ua.com.alevel.console;


import ua.com.alevel.Work.WorkAccount;

import java.io.BufferedReader;
import java.io.IOException;

public class LogIn {


    public void start(BufferedReader reader) throws IOException{
        WorkAccount.logInStart(reader);
    }

    public void adminStart(BufferedReader reader) throws IOException{
        WorkAccount.logInAdmin(reader);
    }

    public void cardStart(BufferedReader reader) throws IOException{
        WorkAccount.logInCard(reader);
    }
}
