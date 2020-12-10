package com.camsley.invoise.core.service.impl.prefix;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.IInvoiceRepository;
import com.camsley.invoise.core.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServicePrefix implements IInvoiceService {

    @Value("${invoice.lastNumber}")
    private long lastNumber;

    @Value("${invoice.prefix}")
    private String prefix;


    @Autowired
    private IInvoiceRepository invoiceRepository;

    public InvoiceServicePrefix() {
    }

    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }



    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getInvoicelist() {
        return invoiceRepository.list();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.getById(number);
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
    public void createInvoice(Invoice invoice) {
        invoice.setNumber(String.valueOf(prefix+(++lastNumber)));
        this.invoiceRepository.create(invoice);
    }

}
