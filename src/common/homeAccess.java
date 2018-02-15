package common;

/**
 * Created by FINETEKLABS on 11/16/2017.
 */

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * Created by FINETECHLABS on 02/06/2016.
 */
public class homeAccess {

    private static TitledPane company;
    private static Hyperlink companyInfo;
    private static Hyperlink close;
    private static Hyperlink backup;
    private static Hyperlink restore;
    private static Hyperlink create;
    private static Hyperlink open;
    private static Hyperlink utilites;
    private static Hyperlink licencing;
    private static Hyperlink addMembers;
    private static Hyperlink editMembers;
    // private static Hyperlink deposits;
    //private static Hyperlink withdrawals;
    // private static Hyperlink reports;
    private static Hyperlink depositsHistory;
    private static Hyperlink newDeposit;
    private static Hyperlink depositSettings;

    private static Hyperlink withdrawalsHistory;
    private static Hyperlink newWithdrawals;
    private static Hyperlink withdrawalsSettings;

    private static Hyperlink exportMembers;
    private static Hyperlink deactivateMember;
    private static Hyperlink individualStatement;
    private static Hyperlink groupStatement;
    private static Hyperlink memorisedStatement;
    private static Hyperlink activityReport;
    private static Hyperlink fixedDepositReports;
    private static Hyperlink savingsReports;
    private static Hyperlink individualLoans;

    private static VBox companyHolder;
    private static VBox statementsHolder;
    private static VBox reportsHolder;
    private static VBox depositsHolder;
    private static VBox membersHolder;
    private static VBox withdrawalsHolder;
    private static VBox dashboard;
    private static VBox dashboard1;
    private static Accordion acc;
    private static TitledPane members;
    private static TitledPane deposits;
    private static TitledPane statements;
    private static TitledPane reports;
    private static TitledPane withdrawals;

    public static VBox quickAccess() {
        dashboard1 = new VBox();
        dashboard = new VBox();
        acc = new Accordion();
        company = new TitledPane();


        company.setText("COMPANY");
        companyInfo = new Hyperlink("COMPANY DETAILS");
        create = new Hyperlink(" CREATE COMPANY ");
        create.setTooltip(new Tooltip("create a new company"));
        companyInfo.setTooltip(new Tooltip(" company details"));
        close = new Hyperlink("CLOSE/LOG OFF ");
        close.setTooltip(new Tooltip(" close"));
        //    sale.setOnAction(e->tile.setCenter(pointOfSale.flow()));
        backup = new Hyperlink("BACKUP DATA");
        backup.setTooltip(new Tooltip(" backup company file"));

        open = new Hyperlink("OPEN COMPANY ");
        open.setTooltip(new Tooltip(" open exisitng company"));
        restore = new Hyperlink("RESTORE COMPANY");
        restore.setTooltip(new Tooltip(" restore from backup"));
        utilites = new Hyperlink("UTILITIES");
        utilites.setTooltip(new Tooltip(" UTILITIES"));
        licencing = new Hyperlink("Licence");
        company.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        licencing.setFont(Font.font("sans sif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        backup.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        create.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));

        close.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        companyInfo.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        restore.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        open.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        utilites.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        companyHolder = new VBox();
        companyHolder.getChildren().addAll(create, companyInfo, open, restore, backup, close);
        company.setContent(companyHolder);


        // second pane

        members = new TitledPane();
        members.setText("MANAGE");
        addMembers = new Hyperlink("ADD MEMBERS");
        editMembers = new Hyperlink(" EDIT MEMBERS");
        editMembers = new Hyperlink(" EDIT MEMBERS");
        exportMembers = new Hyperlink(" EXPORT /IMPORT");
        addMembers.visitedProperty().addListener((obs, ov, nv) -> {
            //       tile.setCenter(null);

        });
        addMembers.setOnAction(e -> {
            addMembers.visitedProperty().addListener((obs, ov, nv) -> {


            });


        });


        //  deposits= new Hyperlink(" deposits");
        // deposits.setTooltip(new Tooltip("member deposits"));
        //  withdrawals= new Hyperlink("withdrawals");
        //  withdrawals.setTooltip( new Tooltip(" member withdrawals"));
        // reports=  new Hyperlink ("REPORTS");
        //reports.setTooltip(new Tooltip("reports for members"));


//
//        deposits.setOnAction(e -> {
//            // GroupedItems.grouped();
//
//        });


        //  deposits.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        // withdrawals.setFont(Font.font("sans sif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        //     reports.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR,15));
        addMembers.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        editMembers.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        exportMembers.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        members.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));

        membersHolder = new VBox();
        membersHolder.getChildren().addAll(addMembers, editMembers, exportMembers);
        members.setContent(membersHolder);


        //deposits.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR,15));
        //withdrawals.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR,15));
//        addMembers.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR,12));
//        editMembers.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR,12));
//        reports.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR,12));

        deposits = new TitledPane();
        deposits.setText("DEPOSITS");
        newDeposit = new Hyperlink("NEW DEPOSIT");
        //customers.setOnAction(e->tile.setCenter(Employees.view()));
        depositsHistory = new Hyperlink("DEPOSIT HISTORY");
        depositSettings = new Hyperlink("DEPOSIT SETTINGS");


        deposits.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        depositSettings.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 12));
        depositsHistory.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 12));
        newDeposit.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 12));


        depositsHolder = new VBox();
        depositsHolder.getChildren().addAll(newDeposit, depositsHistory, depositSettings);

        deposits.setContent(depositsHolder);
        deposits.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));


        withdrawals = new TitledPane();
        withdrawals.setText("WITHDRAWALS");

        withdrawalsHistory = new Hyperlink("WITHDRAWAL HISTORY");
        withdrawalsSettings = new Hyperlink(" WITHDRAWAL SETTINGS");
        newWithdrawals = new Hyperlink("NEW WITHDRAWAL");


        withdrawalsSettings.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        withdrawalsHistory.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        newWithdrawals.setFont(Font.font("sans serif", FontWeight.MEDIUM, FontPosture.REGULAR, 10));
        withdrawals.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        withdrawalsHolder = new VBox();
        withdrawalsHolder.getChildren().addAll(newWithdrawals, withdrawalsHistory, withdrawalsSettings);
        withdrawals.setContent(withdrawalsHolder);


        statements = new TitledPane();
        statements.setText("STATEMENTS ");
        individualStatement = new Hyperlink("INDIVIDUAL");
        individualLoans = new Hyperlink("LOANS STATEMENT");
        groupStatement = new Hyperlink("GROUP STATEMENT");
        memorisedStatement = new Hyperlink("MEMORISED STATEMENT");


        individualStatement.setFont(Font.font("sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        individualLoans.setFont(Font.font("sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        groupStatement.setFont(Font.font("sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        memorisedStatement.setFont(Font.font("sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        statements.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));

        statementsHolder = new VBox();
        statementsHolder.setStyle("-fx-border-radius: 20px; -fx-border-insets: 10px");
        statementsHolder.getChildren().addAll(individualStatement, individualLoans, groupStatement, memorisedStatement);
        statements.setContent(statementsHolder);
        statements.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));


        reports = new TitledPane();
        reports.setText("REPORTS");
        fixedDepositReports = new Hyperlink("FIXED DEPOSITS REPORT");
        activityReport = new Hyperlink("ACTIVITY REPORT");
        savingsReports = new Hyperlink("SAVINGS REPORT");
        Hyperlink inactivesuppliers = new Hyperlink("INACTIVE SUPPLIERS");
        Hyperlink supplierbalances = new Hyperlink("SUPPLIER BALANCES");


        reports.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        fixedDepositReports.setFont(Font.font("sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        activityReport.setFont(Font.font("sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        savingsReports.setFont(Font.font("sans serif", FontWeight.NORMAL, FontPosture.REGULAR, 10));
        reportsHolder = new VBox();
        reportsHolder.getChildren().addAll(fixedDepositReports, activityReport, savingsReports);
        reports.setContent(reportsHolder);


        TitledPane pane6 = new TitledPane();
        Hyperlink banks = new Hyperlink("BANKING CENTRE ");
        Hyperlink bankstatements = new Hyperlink("BANK STATEMENTS");
        Hyperlink reconciliation = new Hyperlink("RECONCILIATION");
        Hyperlink banksettings = new Hyperlink("BANK SETTINGS");

        pane6.setText("BANKING ");
        ;
        banks.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane6.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));

        TitledPane pane7 = new TitledPane();
        pane7.setText("USERS");
        Hyperlink users = new Hyperlink("Users");
        Button usersbutton = new Button();
        usersbutton.setGraphic(users);
        users.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane7.setContent(usersbutton);
        pane7.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));

        TitledPane pane8 = new TitledPane();
        pane8.setText("INVOICES");
        Hyperlink invoice = new Hyperlink("Invoices");
        Button invoicebutton = new Button();
        invoicebutton.setGraphic(invoice);
        invoice.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane8.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane8.setContent(invoicebutton);

        TitledPane pane9 = new TitledPane();
        pane9.setText("RECEIPTS");
        Hyperlink receipts = new Hyperlink("Receipts");
        Button receiptsbutton = new Button();
        receiptsbutton.setGraphic(receipts);
        receipts.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane9.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane9.setContent(receiptsbutton);

        TitledPane pane10 = new TitledPane();
        pane10.setText("RETURNS");
        Hyperlink returns = new Hyperlink("Returns");
        Button returnsbutton = new Button();
        returnsbutton.setGraphic(returns);
        returns.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane10.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane10.setContent(returnsbutton);

        TitledPane pane11 = new TitledPane();
        pane11.setText("TAX");
        Hyperlink tax = new Hyperlink("Tax");
        Button taxbutton = new Button();
        taxbutton.setGraphic(tax);
        tax.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane11.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane11.setContent(taxbutton);

        TitledPane pane12 = new TitledPane();
        Hyperlink liabilities = new Hyperlink("Liabilities");
        pane12.setText("LIABILITIES");
        Button liabilitiesbutton = new Button();
        liabilitiesbutton.setGraphic(liabilities);
        liabilities.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane12.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane12.setContent(liabilitiesbutton);

        TitledPane pane13 = new TitledPane();
        Hyperlink accounts = new Hyperlink("Accounts");
        pane13.setText("ACCOUNTS");
        Button accountsbutton = new Button();
        accountsbutton.setGraphic(accounts);
        accounts.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane13.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane13.setContent(accountsbutton);

        TitledPane pane14 = new TitledPane();
        Hyperlink branches = new Hyperlink("Branches");
        pane14.setText("BRANCHES");
        Button branchesbutton = new Button();
        branchesbutton.setGraphic(branches);
        branches.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane14.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane14.setContent(branchesbutton);

        TitledPane pane15 = new TitledPane();
        Hyperlink pobuttons = new Hyperlink("PURCHASE ORDER");
        pane15.setText("PURCHASE ORDERS");
        Button pobutton = new Button();
        pobutton.setGraphic(branches);
        pobuttons.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane15.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane15.setContent(pobuttons);


        TitledPane pane16 = new TitledPane();
        Hyperlink Delivery = new Hyperlink("Delivery");
        pane16.setText("DELIVERIES");
        Button deliveries = new Button();
        deliveries.setGraphic(Delivery);
        Delivery.setFont(Font.font("Monospaced", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane16.setFont(Font.font("sans serif", FontWeight.BOLD, FontPosture.REGULAR, 15));
        pane16.setContent(deliveries);

        acc.getPanes().addAll(company, members, deposits, withdrawals, statements, reports);
        acc.setExpandedPane(company);
        dashboard.getChildren().addAll(acc);
        // dashboard1.setContent(dashboard);
        //dashboard1.setHvalue(10);
        dashboard1.getChildren().addAll(dashboard);

        dashboard1.setPadding(new Insets(10, 10, 10, 10));
        dashboard1.setCursor(Cursor.HAND);
        return dashboard1;
    }

}
