package com.example.service;

import com.example.model.AppModel;

import java.util.List;

public interface ImplAppService {

    Double getCurrency();

    AppModel initSubscribe(AppModel model);

    AppModel showSubscribe(Long id);

    String initUnsubscribe(Long id);

    List<AppModel> showAll();
}
