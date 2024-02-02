package ru.synergy.controllers;

import ru.synergy.models.Contact;
import ru.synergy.models.User;
import ru.synergy.services.EntityService;
import ru.synergy.services.LogService;

import java.io.Closeable;
import java.util.Map;

public class MainController implements Closeable {
    LogService log;
    EntityService entity;

    public MainController() {
        log = new LogService();
        entity = new EntityService();
    }

    @Override
    public void close() {
        log.close();
        entity.close();
    }

    public void addContact(User user, Contact contact, Map<String, Object> meta) {
        entity.add(user, contact);
        meta.put("action", "create contact");
        meta.put("newContactId", contact.getId());
        log.add(meta);
    }
}