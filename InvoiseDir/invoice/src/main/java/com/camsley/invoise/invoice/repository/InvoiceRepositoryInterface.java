package com.camsley.invoise.invoice.repository;

import com.camsley.invoise.core.entities.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepositoryInterface extends CrudRepository<Invoice,String> {


}
