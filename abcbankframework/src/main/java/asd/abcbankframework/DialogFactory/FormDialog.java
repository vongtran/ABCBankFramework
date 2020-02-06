package asd.abcbankframework.DialogFactory;

import asd.abcbankframework.DialogFactory.Body.ActionBody;
import asd.abcbankframework.DialogFactory.Body.CompanyForm;
import asd.abcbankframework.DialogFactory.Body.FormBody;
import asd.abcbankframework.DialogFactory.Header.ActionHeader;
import asd.abcbankframework.DialogFactory.Header.FormHeader;
import asd.abcbankframework.View.MainView;
import asd.abcbankframework.model.account.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormDialog extends DialogFactory {
    String number, clientName,street,city,zip,state,accountType,clientType,amountDeposit,other,email;
    MainView mainView;
    FormHeader header ;
    public FormBody body ;
    SimpleFactory simpleFactory;
    public FormDialog(MainView mainView,String clientType) {
        super(mainView);
        this.clientType = clientType;
        this.mainView = mainView;
        this.simpleFactory = simpleFactory;
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
        return SimpleFactory.createDialog(this,this.clientType);
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getNumber() {
        return number;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setOKAction(ActionListener action){
        body.setJButton_OKAction(action);
    }

    public void setCancelAction(ActionListener action){
        body.setJButton_Cancel(action);
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getEmail() {
    	return this.email;
    }


}
