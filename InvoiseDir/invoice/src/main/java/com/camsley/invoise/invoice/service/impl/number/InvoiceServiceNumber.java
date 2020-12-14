package com.camsley.invoise.invoice.service.impl.number;

import com.camsley.invoise.core.entities.invoice.Invoice;
import com.camsley.invoise.invoice.repository.InvoiceRepositoryInterface;
import com.camsley.invoise.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InvoiceServiceNumber implements IInvoiceService {

    @Autowired
    private  InvoiceRepositoryInterface invoiceRepository;

//    @Autowired
//    private CustomerRepositoryInterface customerRepositoryInterface;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        invoiceRepository = invoiceRepository;
    }

    @Override
    public Iterable<Invoice> getInvoicelist() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow(NullPointerException::new);
    }

    @Override
    @Transactional
    public Invoice createInvoice(Invoice invoice) {
//        customerRepositoryInterface.save(invoice.getCustomer());
        return invoiceRepository.save(invoice);
    }
}
