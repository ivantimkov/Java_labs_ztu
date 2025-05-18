package com.education.ztu;


import java.util.List;

public abstract class AbstractDAO<T> {
    public abstract void create(T obj);
    public abstract T read(int id);
    public abstract void update(T obj);
    public abstract void delete(int id);
    public abstract List<T> getAll();
}