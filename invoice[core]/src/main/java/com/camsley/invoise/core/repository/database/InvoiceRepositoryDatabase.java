package com.camsley.invoise.core.repository.database;

import com.camsley.invoise.core.entities.Invoice;
import com.camsley.invoise.core.repository.IInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryDatabase implements IInvoiceRepository {

    private List<Invoice> invoices = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Invoice create(Invoice invoice){
        KeyHolder kh= new GeneratedKeyHolder();

       jdbcTemplate.update(connection-> {
           PreparedStatement statement= connection.prepareStatement("INSERT INTO INVOICE(CUSTOMER_NAME,ORDER_NUMBER) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, invoice.getCustomerName());
           statement.setString(2, invoice.getNumber());
           return statement;
       },kh);

       invoice.setNumber(kh.getKey().toString());
        invoices.add(invoice);
        System.out.println("Database Invoice added number : "+ invoice.getNumber()+" for "+invoice.getCustomerName() );

        return invoice;
    }

    @Override
    public List<Invoice> list() {

        return jdbcTemplate.query(" SELECT INVOICE_NUMBER, CUSTOMER_NAME FROM INVOICE ",
                (rs,rowNum) -> new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")),
                        rs.getString("CUSTOMER_NAME")));
    }

    @Override
    public Invoice getById(String number) {

        return jdbcTemplate.queryForObject(" SELECT INVOICE_NUMBER, CUSTOMER_NAME,ORDER_NUMBER FROM INVOICE WHERE INVOICE_NUMBER=? ",
                new Object[]{number},
                (rs,rowNum)->new Invoice(String.valueOf(rs.getLong("INVOICE_NUMBER")),rs.getString("CUSTOMER_NAME"),rs.getString("ORDER_NUMBER")));
    }

}
