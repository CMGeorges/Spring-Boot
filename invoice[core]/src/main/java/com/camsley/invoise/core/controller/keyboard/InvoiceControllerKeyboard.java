package com.camsley.invoise.core.controller.keyboard;

import com.camsley.invoise.core.controller.IInvoiceController;
import com.camsley.invoise.core.entities.Customer;
import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

//@Controller
public class InvoiceControllerKeyboard implements IInvoiceController {
    @Autowired
    private IInvoiceService invoiceService;

    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public String createInvoice(Invoice invoice){
        System.out.println("What is the customer name?");
        Scanner sc = new Scanner(System.in);
        String customerName = sc.nextLine();
         invoice= new Invoice();
        Customer customer = new Customer(customerName);
        invoice.setCustomer(customer);


        invoiceService.createInvoice(invoice);
        return null;

    }
}
