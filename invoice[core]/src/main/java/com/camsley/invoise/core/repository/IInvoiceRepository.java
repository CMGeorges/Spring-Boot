package com.camsley.invoise.core.repository;

import com.camsley.invoise.core.entities.Invoice;

import java.util.List;

public interface IInvoiceRepository {

   void create(Invoice invoice);
   List<Invoice> list();
}
