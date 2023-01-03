package com.example.aroundhub.service;

import com.example.aroundhub.data.entity.ListenerEntity;

import java.net.http.WebSocket;

public interface ListenerService {

    ListenerEntity getEntity(Long id);

    void saveEntity(ListenerEntity listenerEntity);

    void updateEntity(ListenerEntity listenerEntity);

    void removeEntity(ListenerEntity listenerEntity);
}
