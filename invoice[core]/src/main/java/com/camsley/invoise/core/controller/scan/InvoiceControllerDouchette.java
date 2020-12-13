package com.camsley.invoise.core.controller.scan;

import com.camsley.invoise.core.controller.IInvoiceController;
import com.camsley.invoise.core.entities.Customer;
import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.service.IInvoiceService;
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
