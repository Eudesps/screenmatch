package com.eudes.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConverteDados {
    <T> T converteDados(String json, Class<T> classe) throws JsonProcessingException;
}
