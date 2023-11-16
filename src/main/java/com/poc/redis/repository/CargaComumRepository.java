package com.poc.redis.repository;

import com.poc.redis.model.CargaComum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargaComumRepository extends CrudRepository<CargaComum, String> {
}