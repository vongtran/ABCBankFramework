package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.DialogFactory.Body.ActionBody;
import asd.abcbankframework.DialogFactory.Body.FormBody;
import asd.abcbankframework.DialogFactory.Header.ActionHeader;
import asd.abcbankframework.DialogFactory.Header.FormHeader;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.model.account.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormDialog extends DialogFactory {
    String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
    MainView mainView;
    FormHeader header ;
    FormBody body ;
    public FormDialog(MainView mainView) {
        super(mainView);
        this.mainView = mainView;
        setTitle("Add compamy account");
        setSize(298,339);
        setVisible(true);
        header = createHeader();
        body = createBody();
        getContentPane().add(header);
        header.setBounds(0,10,298,30);
        getContentPane().add(body);
    }

    @Override
    public FormHeader createHeader() {
        return new FormHeader(this);
    }

    @Override
    public FormBody createBody() {
        return new FormBody(this);
    }

    public void setAccountnr(String accountnr) {
        this.accountnr = accountnr;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAccountnr() {
        return accountnr;
    }

    public String getClientName() {
        return clientName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getClientType() {
        return clientType;
    }

    public String getAmountDeposit() {
        return amountDeposit;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public void setAmountDeposit(String amountDeposit) {
        this.amountDeposit = amountDeposit;
    }

    public void actionOk(){
        header.setAccountType();
        body.setText();
    }

    public void setOKAction(ActionListener action){
        body.setJButton_OKAction(action);
    }

    public void setCancelAction(ActionListener action){
        body.setJButton_Cancel(action);
    }
}
