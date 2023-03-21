package com.photoshoot.demo.data;

import com.photoshoot.demo.model.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhotoRepository extends CrudRepository<Photo, Long> {
    List<Photo> findByPhotoName(String photoName);
    Photo findById(long Id);
}
