package com.camsley.invoise.invoice.controller.scan;

import com.camsley.invoise.core.entities.customer.Customer;
import com.camsley.invoise.core.entities.invoice.Invoice;
import com.camsley.invoise.invoice.controller.IInvoiceController;
import com.camsley.invoise.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;


//@Controller
public class InvoiceControllerDouchette implements IInvoiceController {

    @Autowired
private IInvoiceService invoiceService;


    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public String  createInvoice(Invoice invoice) {
        System.out.println("USage of scanner");
         invoice = new Invoice();
        Customer customer = new Customer("Virging Galactic");
        invoice.setCustomer(customer);
        invoiceService.createInvoice(invoice);
    return null;
    }
}
