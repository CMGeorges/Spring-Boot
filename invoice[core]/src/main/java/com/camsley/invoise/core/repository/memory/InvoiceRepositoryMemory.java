package com.camsley.invoise.core.repository.memory;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.IInvoiceRepository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class InvoiceRepositoryMemory implements IInvoiceRepository {

    private List<Invoice> invoices = new ArrayList<>();


    @Override
    public void create(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added number : "+ invoice.getNumber()+" for "+invoice.getCustomerName() );
    }

    @Override
    public List<Invoice> list() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Invoice getById(String number) {
        throw new UnsupportedOperationException();
    }

}
