package com.camsley.invoise.core.repository.database;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.IInvoiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements IInvoiceRepository {

    private List<Invoice> invoices = new ArrayList<>();

    @Override
    public void create(Invoice invoice){
        /*
        (...)
        PreparedStatement statement= connexion.prepareStatement("INSERT INTO FACTURE(NUMBER,CUSTOMERNAME) " +
                "VALUES (?,?)");
        (...)
        statement.executeUpdate();*/
        invoices.add(invoice);
        System.out.println("Database Invoice added number : "+ invoice.getNumber()+" for "+invoice.getCustomerName() );

    }

    @Override
    public List<Invoice> list() {
        Invoice invoice1 = new Invoice();
        invoice1.setNumber("NUM_1");
        invoice1.setCustomerName("EDF");
        Invoice invoice2 = new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("La poste");
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(invoice1);
        invoices.add(invoice2);

        return invoices;
    }

}
