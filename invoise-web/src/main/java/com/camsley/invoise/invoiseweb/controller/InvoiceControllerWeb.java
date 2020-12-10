package com.camsley.invoise.invoiseweb.controller;

import com.camsley.invoise.core.controller.IInvoiceController;
import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/invoice")
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

    @RequestMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthode display home is invoke");

        model.addAttribute("invoices",invoiceService.getInvoicelist());

        return "invoice-home";
    }

    @RequestMapping("/{id}")
    public String displayInvoice(@PathVariable("id") String number, Model model){
        System.out.println("La méthode displayInvoice is invoke");
//        List<Invoice>  invoices= invoiceService.getInvoicelist();

        model.addAttribute("invoice",invoiceService.getInvoiceByNumber(number));

        return "invoice-details";
    }
}
