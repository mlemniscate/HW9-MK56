package ir.maktab.base.service;

import ir.maktab.base.domain.BaseEntity;

import java.util.Collection;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>, ID>{

    E save(E e);

    E update(E e);

    List<E> findAll();

    List<E> findAllByIds(Collection<ID> ids);

    E findByID(ID id);

    Boolean deleteById(ID id);

    Boolean isExist(ID id);

}
