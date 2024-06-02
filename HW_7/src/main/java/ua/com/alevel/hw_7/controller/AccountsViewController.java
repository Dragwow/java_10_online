package ua.com.alevel.hw_7.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ua.com.alevel.hw_7.entity.Account;
import ua.com.alevel.hw_7.reactiv.NativePubSub;
import ua.com.alevel.hw_7.service.AccountService;
import ua.com.alevel.hw_7.service.impl.AccountServiceImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountsViewController implements Initializable {

    private final AccountService accountService = new AccountServiceImpl();
    private ObservableList<Account> accounts = FXCollections.observableArrayList();

    @FXML
    private TextField accIdText;

    @FXML
    private TextField accNameText;

    @FXML
    private TextField accLNameText;

    @FXML
    private TextField accSNameText;

    @FXML
    private Button createAcc;

    @FXML
    private Button updateAcc;

    @FXML
    private Button deleteAcc;

    @FXML
    private TableView<Account> accTable;

    @FXML
    private TableColumn<Account, String> idColumn;

    @FXML
    private TableColumn<Account, String> nameColumn;

    @FXML
    private TableColumn<Account, String> lNameColumn;

    @FXML
    private TableColumn<Account, String> sNameColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accounts.addAll(accountService.findAll());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        sNameColumn.setCellValueFactory(new PropertyValueFactory<>("surName"));
        accTable.setItems(accounts);

        accTable.setRowFactory(tv -> {
            TableRow<Account> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Account rowData = row.getItem();
                    accIdText.setText(String.valueOf(rowData.getId()));
                    accNameText.setText(rowData.getFirstName());
                    accLNameText.setText(rowData.getLastName());
                    accSNameText.setText(rowData.getSurName());
                }
            });
            return row;
        });

        NativePubSub.getInstance().subscribeAcc(this::updateAccounts);
    }

    public void create() {
        Account account = new Account();
        account.setFirstName(accNameText.getText());
        account.setLastName(accLNameText.getText());
        account.setSurName(accSNameText.getText());

        accountService.create(account);
        NativePubSub.getInstance().publishAcc(true);
    }

    public void update() {
        Account account = new Account();
        account.setId(accIdText.getText());
        account.setFirstName(accNameText.getText());
        account.setLastName(accLNameText.getText());
        account.setSurName(accSNameText.getText());

        accountService.update(account);
        NativePubSub.getInstance().publishAcc(true);
    }

    public void delete() {
        accountService.delete(accIdText.getText());
        NativePubSub.getInstance().publishAcc(true);
    }

    private void updateAccounts(boolean b) {
        if (b) {
            accounts.setAll(accountService.findAll());
            accTable.refresh();
        }
    }
}