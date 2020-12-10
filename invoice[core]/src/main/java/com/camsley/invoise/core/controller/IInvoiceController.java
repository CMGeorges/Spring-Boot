package com.camsley.invoise.core.controller;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.service.IInvoiceService;

public interface IInvoiceController {

    String createInvoice(Invoice invoice);
    void setInvoiceService(IInvoiceService invoiceService);
}
