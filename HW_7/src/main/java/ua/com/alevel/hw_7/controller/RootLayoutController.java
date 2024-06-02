package ua.com.alevel.hw_7.controller;

import ua.com.alevel.hw_7.config.LoaderPage;
import ua.com.alevel.hw_7.reactiv.NativePubSub;

public class RootLayoutController {

    public void showAccounts() {
        System.out.println("RootLayoutController.showAccounts");
        NativePubSub.getInstance().publish(LoaderPage.ACCOUNTS);
    }

    public void showGroups() {
        System.out.println("RootLayoutController.showGroups");
        NativePubSub.getInstance().publish(LoaderPage.GROUPS);
    }

}