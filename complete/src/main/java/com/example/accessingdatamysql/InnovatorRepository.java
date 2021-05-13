package com.example.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;
import com.example.accessingdatamysql.Innovator;

public interface InnovatorRepository extends CrudRepository<Innovator, Integer> {
}
