package com.camsley.invoise.invoiseweb.controller;

import com.camsley.invoise.core.controller.IInvoiceController;
import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class InvoiceControllerWeb implements IInvoiceController {

    @Autowired
    private IInvoiceService invoiceService;

    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    @Override
    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public void createInvoice(){

        String customerName = "Tesla";
        Invoice invoice= new Invoice();
        invoice.setCustomerName(customerName);
        this.invoiceService.createInvoice(invoice);
    }

    @RequestMapping("/invoice-home")
    public @ModelAttribute("invoices") List<Invoice> displayHome(){
        System.out.println("La méthode display home is invoke");
        List<Invoice>  invoices= invoiceService.getInvoicelist();

        return invoices;
    }
}
