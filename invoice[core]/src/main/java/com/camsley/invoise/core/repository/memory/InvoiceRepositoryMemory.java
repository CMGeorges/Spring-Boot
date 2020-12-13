package com.camsley.invoise.core.repository.memory;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.InvoiceRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Repository
public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {

    private List<Invoice> invoices = new ArrayList<>();


    @Override
    public Invoice save(Invoice invoice){
        invoices.add(invoice);
        System.out.println("Invoice added number : "+ invoice.getNumber()+" for "+invoice.getCustomer().getName() );
        return invoice;
    }

    @Override
    public List<Invoice> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Invoice> findAllById(Iterable<String> iterable) {
        throw new UnsupportedOperationException();    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Invoice invoice) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Invoice> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Invoice> List<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Invoice> findById(String number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(String s) {
        throw new UnsupportedOperationException();
    }

}
