package com.camsley.invoise.core.service.impl.number;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.InvoiceRepositoryInterface;
import com.camsley.invoise.core.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServiceNumber implements IInvoiceService {

    @Qualifier("invoiceRepositoryInterface")
    @Autowired
    private  InvoiceRepositoryInterface invoiceRepository;



    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        invoiceRepository = invoiceRepository;
    }

    @Override
    public Iterable<Invoice> getInvoicelist() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow(NullPointerException::new);
    }

    @Override
    public Invoice createInvoice(Invoice invoice) {
           return invoiceRepository.save(invoice);
    }
}
