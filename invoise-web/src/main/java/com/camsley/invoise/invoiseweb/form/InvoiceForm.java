package com.camsley.invoise.invoiseweb.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InvoiceForm {

    private String number;
    @NotBlank(message = "Le nom est obligatoire")
    private String customerName;
    @Size(min=10,max=13)
    private String orderNumber;


    public InvoiceForm() {
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
