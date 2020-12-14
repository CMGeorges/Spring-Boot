package com.camsley.invoise.invoice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/invoice")
public class InvoiceControllerWeb  {
/*
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
        Customer customer = new Customer(invoiceForm.getCustomerName());
        invoice.setCustomer(customer);
        Address address= new Address(invoiceForm.getStreetName(),invoiceForm.getStreetNumber(),invoiceForm.getCity(),invoiceForm.getZipcode(),invoiceForm.getCountry());
        customer.setAddress(address);
//        invoice.setOrderNumber(invoiceForm.getOrderNumber());
        invoiceService.createInvoice(invoice);
        return "invoice-created";
    }*/

    @GetMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthode display home is invoke");


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


/*
    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoiceForm){

        return "invoice-create-form";
    }*/
}
