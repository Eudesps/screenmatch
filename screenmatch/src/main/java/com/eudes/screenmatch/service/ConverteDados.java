package com.eudes.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();

    //como a classe é generica, é interessante na hora de chamar o método, passar também a classe que se deseja
    //converter no momento de sua utilização.
    @Override
    public <T> T converteDados(String json, Class<T> classe){
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
