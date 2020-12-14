package com.camsley.invoise.invoiseweb.api;

import com.camsley.invoise.core.entities.invoice.Invoice;
import com.camsley.invoise.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private IInvoiceService invoiceService;

    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){

       return invoiceService.createInvoice(invoice);

    }

    @GetMapping
    public Iterable<Invoice> list(){
        System.out.println("La méthode display home is invoke");

        return invoiceService.getInvoicelist();
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number, Model model){
        System.out.println("La méthode displayInvoice is invoke");

        model.addAttribute("invoice",invoiceService.getInvoiceByNumber(number));

        return invoiceService.getInvoiceByNumber(number);
    }


//
//    @GetMapping("/create-form")
//    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoiceForm){
//
//        return "invoice-create-form";
//    }
}
