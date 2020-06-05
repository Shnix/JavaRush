package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable factory(Enum en){
        if (en == null)
            return new IllegalArgumentException();
        String message = en.name().charAt(0) + en.name().substring(1).toLowerCase().replace("_", " ");
            if(en.getClass().equals(DatabaseExceptionMessage.class))
                return new RuntimeException(message);
            if(en.getClass().equals(ApplicationExceptionMessage.class))
                return new Exception(message);
            if(en.getClass().equals(UserExceptionMessage.class))
                return new Error(message);
            return new IllegalArgumentException();
    }
}
