package com.camsley.invoise.invoiseweb.controller;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.service.IInvoiceService;
import com.camsley.invoise.invoiseweb.form.InvoiceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb  {

    @Autowired
    private IInvoiceService invoiceService;

    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


    @PostMapping("/create")
    public String createInvoice(@Valid @ModelAttribute InvoiceForm invoiceForm, BindingResult result){


        if (result.hasErrors()) {
            return "invoice-create-form";
        }
        Invoice invoice= new Invoice();
        invoice.setCustomerName(invoiceForm.getCustomerName());
        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }

    @GetMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthode display home is invoke");

        model.addAttribute("invoices",invoiceService.getInvoicelist());

        return "invoice-home";
    }

//    @GetMapping("/{id}")
//    public String displayInvoice(@PathVariable("id") String number, Model model){
//        System.out.println("La méthode displayInvoice is invoke");
////        List<Invoice>  invoices= invoiceService.getInvoicelist();
//
//        model.addAttribute("invoice",invoiceService.getInvoiceByNumber(number));
//
//        return "invoice-details";
//    }



    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoiceForm){

        return "invoice-create-form";
    }
}
