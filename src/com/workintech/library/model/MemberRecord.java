package com.workintech.library.model;

import com.workintech.library.helper.Role;

public class MemberRecord extends Person {
    private int memberID;
    private String dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit;
    private String address;
    private String phoneNo;
    private double billAmount;

    public MemberRecord(int id, String name, Role role, int memberID, String dateOfMembership, int maxBookLimit, String address, String phoneNo, double billAmount) {
        super(id, name, role);
        this.memberID = memberID;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = 0;
        this.maxBookLimit = maxBookLimit;
        this.address = address;
        this.phoneNo = phoneNo;
        this.billAmount = billAmount;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void incBookIssued() {
        if (noBooksIssued < maxBookLimit) {
            noBooksIssued++;
        }
    }

    public void decBookIssued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        }
    }

    public void payBill(double amount) {
        if (amount >= billAmount) {
            billAmount = 0;
        } else {
            billAmount -= amount;
        }
    }

    @Override
    public Role whoYouAre() {
        return getRole();
    }
}
