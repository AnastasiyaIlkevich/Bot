package sirinBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SirinBot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return NAME_BOT;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Who am I?"));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Collections.singletonList(keyboardRow));

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("loading....");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        SendPhoto sendPhoto = new SendPhoto();
        if (update.getMessage().getText().equals("Who am I?")) {

            List<String> idPhotos = new ArrayList<>();
            Random random = new Random();
            idPhotos.add("AgACAgIAAxkBAAMSYwTHqbimkr2iK5ljm8Jn4pdeuaMAAqa9MRsWQCFIG5VSnVKCRt0BAAMCAAN5AAMpBA");
            idPhotos.add("AgACAgIAAxkBAAMVYwTH_44f6EVHVnrqc-SDINzWTe8AAr69MRsWQCFIRXcFMjBWfnABAAMCAAN4AAMpBA");
            idPhotos.add("AgACAgIAAxkBAAMXYwTIJKrEK5rZj5QIdLJwZJgzt5cAAr-9MRsWQCFIjKVoCHFhZKsBAAMCAAN5AAMpBA");
            idPhotos.add("AgACAgIAAxkBAAMZYwTITRaYseorb_oWX4L8T7zVNU8AAsC9MRsWQCFIigGBOdc72XEBAAMCAAN5AAMpBA");
            String idPhoto = idPhotos.get(random.nextInt(idPhotos.size()));
            sendPhoto.setChatId(update.getMessage().getChatId().toString());
            sendPhoto.setPhoto(new InputFile(idPhoto));
            sendPhoto.setCaption("You->");
        }

        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
