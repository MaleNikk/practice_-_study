package com.example.repository;

import com.example.model.AppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository
public interface ImplMongoRepository extends MongoRepository<AppEntity, Long> {
}
