package com.company;

//Generic Class
public class genericClass<T>{
    private T t;

    public genericClass(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }
}