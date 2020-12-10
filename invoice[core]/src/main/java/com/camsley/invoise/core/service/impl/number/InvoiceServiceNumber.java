package com.camsley.invoise.core.service.impl.number;

import com.camsley.invoise.core.service.IInvoiceService;
import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.IInvoiceRepository;

import java.util.List;


//@Service
public class InvoiceServiceNumber implements IInvoiceService {

private static long lastNumber =0L;
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
    public void createInvoice(Invoice invoice) {
            invoice.setNumber(String.valueOf(++lastNumber));
            this.invoiceRepository.create(invoice);
    }
}
