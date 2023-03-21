package com.photoshoot.demo.data;

import com.photoshoot.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByClientName(String clientName);
    Client findById(long Id);

}
