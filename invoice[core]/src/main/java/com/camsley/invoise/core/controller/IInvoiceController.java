package com.camsley.invoise.core.controller;

import com.camsley.invoise.core.service.IInvoiceService;

public interface IInvoiceController {

    void createInvoice();
    void setInvoiceService(IInvoiceService invoiceService);
}
