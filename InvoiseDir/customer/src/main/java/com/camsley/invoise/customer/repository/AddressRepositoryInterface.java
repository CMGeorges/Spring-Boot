package com.camsley.invoise.customer.repository;

import com.camsley.invoise.core.entities.customer.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepositoryInterface extends CrudRepository<Address,Long> {


}
