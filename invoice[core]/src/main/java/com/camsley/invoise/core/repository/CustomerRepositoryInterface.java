package com.camsley.invoise.core.repository;

import com.camsley.invoise.core.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoryInterface extends CrudRepository<Customer,Long> {




  /* Invoice create(Invoice invoice);
   List<Invoice> list();
   Invoice getById(String number);*/

}
