package br.com.itau.datagenerator.controllers;


import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseCrudController<TEntity, TKey> {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public TEntity create(@RequestBody TEntity entity) {
        this.getRepository().save(entity);
        return entity;
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public TEntity update(@RequestBody TEntity entity) {
        this.getRepository().save(entity);
        return entity;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public TEntity get(@PathVariable TKey id) {
        return this.getRepository().findById(id).orElse(null);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TEntity> list() {
        return new ArrayList<TEntity>((Collection<? extends TEntity>) this.getRepository().findAll());
    }

    protected abstract CrudRepository<TEntity, TKey> getRepository();
}
