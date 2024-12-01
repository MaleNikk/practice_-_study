package com.example.repository;

import com.example.model.AppEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRepository implements ImplAppRepository{

    @Autowired
    private ImplMongoRepository repository;

    @Override
    public List<AppEntity> findAll() { return repository.findAll();  }

    @Override
    public AppEntity showSubscribe(Long id) { return repository.findById(id).orElse(null);  }

    @Override
    public AppEntity save(AppEntity appEntity) {  return repository.save(appEntity);  }

    @Override
    public String deleteById(Long id) {
        repository.deleteById(id);
        return showSubscribe(id) == null ? "Регистрация отменена!" : "Что-то пошло не так, попробуйте позже!" ;
    }
}
