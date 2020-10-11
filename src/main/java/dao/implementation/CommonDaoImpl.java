package dao.implementation;

import dao.interfaces.CommonDAO;
import model.CommonModel;
import model.Identified;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class CommonDaoImpl<T extends Identified<PK>, PK extends Serializable> implements CommonDAO<T, PK> {
    private Class<T> clazz;

    protected Map<PK, T> elements;

    public CommonDaoImpl(Class<T> elementClass, Map<PK, T> map) {
        this.clazz = elementClass;
        this.elements = map;
    }

    @Override
    public T getByPK(PK key) {
        T ob = elements.get(key);
        return ob;
    }

    @Override
    public Map<PK,T> getAll() {
        return elements;
    }

    @Override
    public T save(T ob) {
        elements.put(ob.getId(), ob);
        return ob;
    }

    @Override
    public T update(T ob) {
        elements.put(ob.getId(), ob);
        return ob;
    }

    @Override
    public T delete(T ob) {
        elements.remove(ob);
        return ob;
    }

    @Override
    public T deleteByPK(PK key) {
        return elements.remove(key);
    }

    @Override
    public void addAll(Map<PK,T> all) {

        this.elements.putAll(all);
    }

}
