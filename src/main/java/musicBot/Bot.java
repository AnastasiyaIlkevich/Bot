package musicBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "first_music_sirin_bot";
    }

    @Override
    public String getBotToken() {
        return null;
    }

    private final static String FIRST_SOUND = null;
    private final static String SECOND_SOUND = null;

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());

//        KeyboardRow keyboardRow1 = new KeyboardRow();
//        keyboardRow1.add(new KeyboardButton("Приветствие"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("First sound"));
        keyboardRow2.add(new KeyboardButton("Second sound"));

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
//        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch (update.getMessage().getText()) {
            case "First sound":
                inputFile.setMedia(FIRST_SOUND);
                break;
            case "Second sound":
                inputFile.setMedia(SECOND_SOUND);
                break;
        }
        sendAudio.setAudio(inputFile);

        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


/*        // для запуска песни
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        sendAudio.setAudio(new InputFile("CQACAgIAAxkBAAMgYv4PXqgzpxmpkQABvhEzT1ELkvJCAAJEGwACvxTxS-QzchdMs1cFKQQ"));
        sendAudio.setCaption("Zero");
        for (int i = 0; i < 3; i++) {
            try {
                execute(sendAudio);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }*/

/*        // Метод ля загрузки фото
        SendMessage sendMessage =  new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        List<PhotoSize> photos = update.getMessage().getPhoto();

        String f_id = photos.stream()
                .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
                .findFirst()
                .orElse(null).getFileId();
        sendMessage.setText(f_id);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/

/*        // метод для закачки в телегу аудио
        SendMessage sendMessage =  new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        String id = String.valueOf(update.getMessage().getAudio().getFileId());
        sendMessage.setText(id);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/

/*       // для приветствия
 String name = update.getMessage().getText();

        SendMessage sendMessage =  new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        if (name.equals("/start")){
            sendMessage.setText("Enter your name ");
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }else {
            sendMessage.setText("Hi " + name);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }*/
    }
/*    private void greetings(Update update) {
        String name = update.getMessage().getText();// получаем строку от пользователя

        SendMessage sendMessage = new SendMessage();// предназначет чтобы отсылать сообщения пользователю
        sendMessage.setChatId(update.getMessage().getChatId().toString());//сетаем чат в готором будет работать сообщение
        if (name.equals("/start")) {
            sendMessage.setText("Enter your name ");//шлём текст на любую реакцию пользователя
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else {
            sendMessage.setText("Hi " + name);//шлём текст на любую реакцию пользователя
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }*/


}
