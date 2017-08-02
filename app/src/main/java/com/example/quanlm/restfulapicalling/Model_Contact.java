package com.example.quanlm.restfulapicalling;

/**
 * Created by QuanLM on 8/2/2017.
 */

class Model_Contact {
    String id;
    String contactName;
    String contactEmail;
    String contactAddress;

    public Model_Contact(String id, String contactName, String contactEmail, String contactAddress) {
        this.id = id;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactAddress = contactAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
}
