package com.photoshoot.demo.data;

import com.photoshoot.demo.model.Photographer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotographerRepository extends CrudRepository<Photographer, Long> {
    List<Photographer> findByName(String name);
    Photographer findById(long Id);
}
