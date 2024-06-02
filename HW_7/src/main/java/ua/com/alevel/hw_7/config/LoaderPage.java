package ua.com.alevel.hw_7.config;

public enum LoaderPage {

    LAYOUT("layout", "root-layout.fxml"),
    ACCOUNTS("students", "accounts-view.fxml"),
    GROUPS("groups", "groups-view.fxml");

    private final String view;
    private final String page;

    LoaderPage(String view, String page) {
        this.view = view;
        this.page = page;
    }

    public String getView() {
        return view;
    }

    public String getPage() {
        return page;
    }
}
