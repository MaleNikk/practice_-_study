package com.example.mapping;

import com.example.model.AppEntity;
import com.example.model.AppModel;

public interface ImplAppMakerMapping {

    AppEntity from(AppModel model);

    AppModel from(AppEntity entity);
}
