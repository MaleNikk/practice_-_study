package com.example.mapping;

import com.example.model.AppEntity;
import com.example.model.AppModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppMakerMapping implements ImplAppMakerMapping {

    @Override
    public AppEntity from(AppModel model){
        log.info("We need change type from AppModel to AppEntity in class AppMakerMapping! ");
        return new AppEntity(model.getId(), model.getCurrency());
    }

    @Override
    public AppModel from(AppEntity entity){
        log.info("We need change type from AppEntity to AppModel in class AppMakerMapping! ");
        if (entity == null) {
            return new AppModel(0L, 0.00);
        }
        return new AppModel(entity.getId(), entity.getCurrency());
    }
}
