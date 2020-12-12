package com.camsley.invoise.core.entities;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVOICE_NUMBER")
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
