package com.example.management;

import com.example.exception.AppBotException;
import com.example.model.AppModel;
import com.example.service.ImplAppService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class AppBotManagement extends TelegramLongPollingBot {

    private final String botUsername;

    @Autowired
    @Getter
    private ImplAppService service;

    public AppBotManagement(
            @Value("${telegram.connection.token}")
            String botToken,
            @Value("${telegram.connection.username}")
            String botUsername) {
        super(botToken);
        this.botUsername = botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {

        String checkedCommand = update.getMessage().getText().strip();
        Long id = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(id);

        if (!checkedCommand.isEmpty()) {

            if (checkedCommand.contains("start"))
            {
                log.info("Init start at system time: {}", System.currentTimeMillis());
                sendMessage.setText(""" 
                        Привет!
                         Данный бот помогает отслеживать стоимость биткоина.
                          Поддерживаемые команды:
                           /start - запуск бота
                           /show_price - получить стоимость биткоина
                           /init_subscribe - регистрация авто обновления курса биткоина каждые 10 минут.
                           /show_subscribe - напомнить о регистрации.
                           /init_unsubscribe - отмена регистрации.
                        """);
                try{execute(sendMessage);} catch (TelegramApiException e){throw new AppBotException(e.getMessage(),e);}

            } else
                if (checkedCommand.contains("init_subscribe"))
                {
                log.info("Init subscribe at system time: {}", System.currentTimeMillis());
                sendMessage.setText("Вы зарегистрировали текущую стоимость:" +
                        getService().initSubscribe(new AppModel(id, getCurrency())).getCurrency());
                try{execute(sendMessage);} catch (TelegramApiException e){throw new AppBotException(e.getMessage(),e);}

            } else
                if (checkedCommand.contains("show_subscribe"))
                {
                log.info("Init show subscribe at system time: {}", System.currentTimeMillis());
                Double currencyFromDB = getService().showSubscribe(id).getCurrency();
                String receivedCurrency = (currencyFromDB == 0.0) ? "Регистрация отсутствует." :
                        "Регистрационная стоимость криптовалюты: " + currencyFromDB;
                sendMessage.setText(receivedCurrency);
                try{execute(sendMessage);} catch (TelegramApiException e){throw new AppBotException(e.getMessage(),e);}

            } else
                if (checkedCommand.contains("init_unsubscribe"))
                {
                log.info("Init unsubscribe at system time: {}", System.currentTimeMillis());
                sendMessage.setText(getService().initUnsubscribe(id));
                try{execute(sendMessage);} catch (TelegramApiException e){throw new AppBotException(e.getMessage(),e);}

            } else
                if (checkedCommand.contains("show_price"))
                {
                log.info("Init show price at system time: {}", System.currentTimeMillis());
                sendMessage.setText("Текущая стоимость криптовалюты:" + getCurrency());
                try{execute(sendMessage);} catch (TelegramApiException e){throw new AppBotException(e.getMessage(),e);}

            } else
            {
                log.info("Init default answer at system time: {}", System.currentTimeMillis());
                sendMessage.setText(""" 
                          Поддерживаемые команды:
                           /start - запуск бота
                           /show_price - получить стоимость биткоина
                           /init_subscribe - регистрация авто обновления курса биткоина каждые 10 минут.
                           /show_subscribe - напомнить о регистрации.
                           /init_unsubscribe - отмена регистрации.
                        """);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new AppBotException(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    private Double getCurrency() {
        return getService().getCurrency();
    }

    @Async
    @Scheduled(fixedRateString = "${time.upload.fixed}")
    private void updater() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        if (!getService().showAll().isEmpty()) {
            log.info("Sending message to telegram user at system time, sec.: {} ", (System.currentTimeMillis() / 1000));
            for (AppModel appModel : getService().showAll()) {
                sendMessage.setChatId(appModel.getId());
                sendMessage.setText("Относительная разница стоимости криптовалюты: " +
                        (appModel.getCurrency() - getService().getCurrency()));
                execute(sendMessage);
            }
        }
    }
}
