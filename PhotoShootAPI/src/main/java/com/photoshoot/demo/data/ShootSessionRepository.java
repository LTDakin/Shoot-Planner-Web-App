package com.photoshoot.demo.data;

import com.photoshoot.demo.model.ShootSession;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShootSessionRepository extends CrudRepository<ShootSession, Long> {
    ShootSession findById(long Id);

}
