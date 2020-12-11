package com.camsley.invoise.core.service;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.IInvoiceRepository;

import java.util.List;

public interface IInvoiceService {

    Invoice createInvoice(Invoice invoice);
    void setInvoiceRepository(IInvoiceRepository invoiceRepository);
    List<Invoice> getInvoicelist();
    Invoice getInvoiceByNumber(String number);

}
