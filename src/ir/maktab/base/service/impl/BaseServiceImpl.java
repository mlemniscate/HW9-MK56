package ir.maktab.base.service.impl;

import ir.maktab.base.domain.BaseEntity;
import ir.maktab.base.repository.BaseRepository;
import ir.maktab.base.service.BaseService;

import java.util.Collection;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    private final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAllByIds(Collection<ID> ids) {
        return repository.findAllByIds(ids);
    }

    @Override
    public E findByID(ID id) {
        return repository.findByID(id);
    }

    @Override
    public Boolean deleteById(ID id) {
        return repository.deleteById(id);
    }
}
