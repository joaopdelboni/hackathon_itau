package br.com.itau.datagenerator.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseModel<TId> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private TId id;

    public TId getId() {
        return id;
    }

    public void setId(TId id) {
        this.id = id;
    }
}
