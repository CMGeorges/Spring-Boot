package com.camsley.invoise.invoice.controller;

import com.camsley.invoise.core.entities.invoice.Invoice;
import com.camsley.invoise.invoice.service.IInvoiceService;

public interface IInvoiceController {

    String createInvoice(Invoice invoice);
    void setInvoiceService(IInvoiceService invoiceService);
}
