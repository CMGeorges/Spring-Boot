package com.camsley.invoise.invoice.service;

import com.camsley.invoise.core.entities.invoice.Invoice;
import com.camsley.invoise.invoice.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public interface IInvoiceService {

    Invoice createInvoice(Invoice invoice);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
    Iterable<Invoice> getInvoicelist();
    Invoice getInvoiceByNumber(String number);

}
