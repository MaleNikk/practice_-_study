package com.example.repository;

import com.example.model.AppEntity;

import java.util.List;

public interface ImplAppRepository {

    AppEntity showSubscribe(Long id);

    AppEntity save(AppEntity appEntity);

    String deleteById(Long id);

    List<AppEntity> findAll();
}
