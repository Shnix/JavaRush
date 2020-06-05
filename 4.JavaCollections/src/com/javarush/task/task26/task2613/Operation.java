package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException{
        if(i==0)
            throw new IllegalArgumentException();
        if(i==1)
            return Operation.INFO;
        if(i==2)
            return Operation.DEPOSIT;
        if(i==3)
            return Operation.WITHDRAW;
        if(i==4)
            return Operation.EXIT;
        else
            throw  new IllegalArgumentException();
    }
}
