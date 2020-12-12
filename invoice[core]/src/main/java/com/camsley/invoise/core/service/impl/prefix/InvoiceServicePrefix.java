package com.camsley.invoise.core.service.impl.prefix;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.InvoiceRepositoryInterface;
import com.camsley.invoise.core.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.NoSuchElementException;

//@Service
public class InvoiceServicePrefix implements IInvoiceService {

    @Value("${invoice.lastNumber}")
    private long lastNumber;

    @Value("${invoice.prefix}")
    private String prefix;


    @Autowired
    private InvoiceRepositoryInterface invoiceRepository;

    public InvoiceServicePrefix() {
    }

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }



    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Iterable<Invoice> getInvoicelist() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow(NoSuchElementException::new);
    }

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
        invoice.setNumber(prefix+(++lastNumber));
        invoiceRepository.save(invoice);
        return invoice;
    }

}
