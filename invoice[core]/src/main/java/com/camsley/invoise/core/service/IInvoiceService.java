package com.camsley.invoise.core.service;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.InvoiceRepositoryInterface;

public interface IInvoiceService {

    Invoice createInvoice(Invoice invoice);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
    Iterable<Invoice> getInvoicelist();
    Invoice getInvoiceByNumber(String number);

}
