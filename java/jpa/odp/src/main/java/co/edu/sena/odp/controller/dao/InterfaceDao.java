/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.odp.controller.dao;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Enrique
 */
public interface InterfaceDao<T> {
    public void insert(T entity);
    public void update(T entity);
    public void remove(T entity);
    public T find(Object id);
    public Collection<T> findAll();
    
}
