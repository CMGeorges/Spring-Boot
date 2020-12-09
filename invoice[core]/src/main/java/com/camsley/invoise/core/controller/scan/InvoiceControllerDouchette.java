package com.camsley.invoise.core.controller.scan;

import com.camsley.invoise.core.controller.IInvoiceController;
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
    public void createInvoice() {
        System.out.println("USage of scanner");
        Invoice invoice = new Invoice();
        invoice.setCustomerName("Virging Galactic");
        invoiceService.createInvoice(invoice);

    }
}
