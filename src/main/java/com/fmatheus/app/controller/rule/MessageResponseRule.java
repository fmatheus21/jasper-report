package com.fmatheus.app.controller.rule;

import com.fmatheus.app.controller.enumerable.MessagesEnum;
import com.fmatheus.app.controller.exception.*;
import com.fmatheus.app.controller.exception.handler.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


@Component
public class MessageResponseRule {

    @Autowired
    private MessageSource messageSource;

    private MessageResponse messageResponse(MessagesEnum messagesEnum) {
        String message = messageSource.getMessage(messagesEnum.getMessage(), null, LocaleContextHolder.getLocale());
        return new MessageResponse(messagesEnum, messagesEnum.getHttpSttus().getReasonPhrase(), message);
    }

    public MessageResponse messageSuccessUpdate() {
        return messageResponse(MessagesEnum.SUCCESS_UPDATE);
    }

    public MessageResponse messageSuccessCreate() {
        return messageResponse(MessagesEnum.SUCCESS_CREATE);
    }

    public MessageResponse messageSuccessDelete() {
        return messageResponse(MessagesEnum.SUCCESS_DELETE);
    }

    public BadRequestException errorBadRequest(MessagesEnum messagesEnum) {
        return new BadRequestException(messagesEnum);
    }

    public BadRequestException errorRecordExist() {
        return new BadRequestException(MessagesEnum.ERROR_RECORD_EXIST);
    }

    public BadRequestException errorNotFound() {
        return new BadRequestException(MessagesEnum.ERROR_NOT_FOUND);
    }

    public InternalError internalError() {
        return new InternalError(MessagesEnum.ERROR_INTERNAL.getMessage());
    }


}
