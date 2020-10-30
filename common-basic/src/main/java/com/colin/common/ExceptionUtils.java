package com.colin.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class ExceptionUtils {

    public static final Logger LOG = LoggerFactory.getLogger(ExceptionUtils.class);

    public static <T extends Throwable> void throwThrowable(Class<T> clazz, Throwable cause, String msgTmpl, Object... args) throws Throwable {
        String message = String.format(msgTmpl, args);
        Throwable tRet = null;
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor(String.class, Throwable.class);
            tRet = constructor.newInstance(message, cause);
        } catch (Exception e) {
            LOG.error("Failed to generate {}, message: {}, throws as RuntimeException.", clazz.getSimpleName(), message);
            throw new RuntimeException(message, cause);
        }

        throw tRet;
    }

    public static <T extends RuntimeException> void throwRuntimeException(Class<T> clazz, Throwable cause, String msgTmpl, Object... args) {
        try {
            throwThrowable(clazz, cause, msgTmpl, args);
        } catch (Throwable throwable) {
            throw clazz.cast(throwable);
        }
    }
}
