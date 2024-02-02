package ru.synergy;

import ru.synergy.controllers.MainController;
import ru.synergy.models.Contact;
import ru.synergy.models.User;


import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();

        User user_1 = new User();
        user_1.setId(1);
        user_1.setName("Vladimir");

        Contact contact = new Contact("cont name", "111122322323", "email@lll.ru");

        var meta = new HashMap<String, Object>();
        meta.put("traceId", "dhjgfdghh");
        meta.put("userId", 1);
        meta.put("time", new Date().getTime());

        controller.addContact(user_1, contact, meta);  //добавляем контакт в БД Postgres, а метаданные(meta) в MongoDB
        controller.close();
    }

}