package com.camsley.invoise.core.repository;

import com.camsley.invoise.core.entities.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepositoryInterface extends CrudRepository<Invoice,String> {

  /* Invoice create(Invoice invoice);
   List<Invoice> list();
   Invoice getById(String number);*/

}
