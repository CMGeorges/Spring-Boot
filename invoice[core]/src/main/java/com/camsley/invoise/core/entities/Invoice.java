package com.camsley.invoise.core.entities;

public class Invoice {

    private String number;
    private String customerName;
    private String orderNumber;


    public Invoice() {
    }

    public Invoice(String invoice_number, String customer_name) {
        this.customerName=customer_name;
        this.number=invoice_number;
    }

    public Invoice(String number, String customerName, String orderNumber) {
        this.number = number;
        this.customerName = customerName;
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
