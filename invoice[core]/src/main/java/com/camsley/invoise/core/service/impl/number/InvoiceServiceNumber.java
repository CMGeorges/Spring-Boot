package com.camsley.invoise.core.service.impl.number;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.IInvoiceRepository;
import com.camsley.invoise.core.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvoiceServiceNumber implements IInvoiceService {

    @Autowired
private IInvoiceRepository invoiceRepository;


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

    @Override
    public Invoice createInvoice(Invoice invoice) {
           return invoiceRepository.create(invoice);
    }
}
