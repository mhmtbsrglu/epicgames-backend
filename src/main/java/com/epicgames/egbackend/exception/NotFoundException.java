package com.epicgames.egbackend.exception;


import com.epicgames.egbackend.constant.ExceptionConstant;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {

    private final String methodName;

    private final String exceptionDetail;

    @Override
    public String getMessage() {
        return String.format(ExceptionConstant.SIMPLE_EXCEPTION_FORMAT, methodName, exceptionDetail);
    }
}
