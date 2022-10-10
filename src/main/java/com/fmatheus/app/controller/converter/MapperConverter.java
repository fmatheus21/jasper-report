package com.fmatheus.app.controller.converter;

public interface MapperConverter<T, U> {

    U converterToResponse(T t);

}
