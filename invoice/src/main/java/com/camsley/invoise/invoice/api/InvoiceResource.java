package com.camsley.invoise.invoice.api;

import com.camsley.invoise.core.entities.customer.Address;
import com.camsley.invoise.core.entities.customer.Customer;
import com.camsley.invoise.core.entities.invoice.Invoice;
import com.camsley.invoise.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {

    @Autowired
    private IInvoiceService invoiceService;


    @Autowired
    private WebClient.Builder webClientBuilder;


/*
    @PostMapping
    public Invoice create(@RequestBody Invoice invoice){

       return invoiceService.createInvoice(invoice);

    }*/
    @GetMapping
    public ParallelFlux<Invoice> list(){
        System.out.println("La méthode display home is invoke");

        List<Mono<Invoice>> monoList = new ArrayList<>();

        final  WebClient webClient=webClientBuilder.baseUrl("http://customer-service").build();

     Iterable<Invoice> invoices=invoiceService.getInvoicelist();
     invoices.forEach(invoice ->
//         invoice.setCustomer(restTemplate.getForObject("/customer/"+invoice.getIdCustomer(), Customer.class));
         monoList.add(webClient.get().uri("/customer/"+invoice.getIdCustomer())
                 .retrieve()
                 .bodyToMono(Customer.class)
                 .map(customer -> {
                     invoice.setCustomer(customer);
                     return invoice;
                 }))
     );

        final Flux<Invoice>invoiceFlux=Flux.concat(monoList);
       return invoiceFlux.parallel().runOn(Schedulers.elastic());

//         return invoices;
    }


    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id") String number){
        System.out.println("La méthode displayInvoice is invoke");

        Invoice invoice= invoiceService.getInvoiceByNumber(number);

        final  WebClient webClient=webClientBuilder.baseUrl("http://customer-service").build();

        final Customer customer=webClient.get().uri("http://customer-service/customer/"+invoice.getIdCustomer())
                .retrieve()
                .bodyToMono(Customer.class).block();
        final Address address= webClient.get().uri("http://customer-service/address/"+customer.getAddress().getId())
                .retrieve()
                .bodyToMono(Address.class).block();
        customer.setAddress(address);
        invoice.setCustomer(customer);

        return invoice;
    }


//
//    @GetMapping("/create-form")
//    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoiceForm){
//
//        return "invoice-create-form";
//    }
public IInvoiceService getInvoiceService() {
    return invoiceService;
}

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;

    }


    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
