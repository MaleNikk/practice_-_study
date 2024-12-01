package com.example.service;

import com.example.exception.AppBotException;
import com.example.mapping.ImplAppMakerMapping;
import com.example.model.AppModel;
import com.example.repository.ImplAppRepository;
import com.example.uploading.ImplUploadCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class AppService implements ImplAppService{

    @Autowired
    private ImplAppRepository repository;

    @Autowired
    private ImplUploadCurrency uploadCurrency;

    @Autowired
    private ImplAppMakerMapping makerMapping;


    @Override
    public Double getCurrency() {
        log.info("Init method getCurrency in class AppService.");
        try {
            return uploadCurrency.getBitcoinPrice();
        } catch (AppBotException | IOException e) {
            log.info("We caught exception, something work not wonderful!");
            throw new AppBotException(e.getMessage(), e);
        }
    }

    @Override
    public AppModel initSubscribe(AppModel model) {
        log.info("Now work method initSubscribe from class AppService!");
        return makerMapping.from(repository.save(makerMapping.from(model)));
    }

    @Override
    public AppModel showSubscribe(Long id) {
        log.info("Now work method showSubscribe from class AppService!");
        return makerMapping.from(repository.showSubscribe(id));
    }

    @Override
    public String initUnsubscribe(Long id) {
        log.info("Now work method initUnsubscribe from class AppService!");
        return repository.deleteById(id);
    }

    @Override
    public List<AppModel> showAll() {
        log.info("Now work method showAll from class AppService!");
        return repository.findAll().stream().map(makerMapping::from).toList();
    }
}
