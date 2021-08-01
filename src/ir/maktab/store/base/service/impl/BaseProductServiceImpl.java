package ir.maktab.store.base.service.impl;

import ir.maktab.store.base.domain.BaseProduct;
import ir.maktab.store.base.repository.BaseProductRepository;
import ir.maktab.store.base.service.BaseProductService;

import java.util.Collection;
import java.util.List;

public class BaseProductServiceImpl<E extends BaseProduct<E>, R extends BaseProductRepository<E>>
        implements BaseProductService<E> {

    private final R repository;

    public BaseProductServiceImpl(R repository) {
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
    public List<E> findAllByIds(Collection<Long> ids) {
        return repository.findAllByIds(ids);
    }

    @Override
    public E findByID(Long id) {
        return repository.findByID(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Boolean isExist(Long id) {
        return repository.isExist(id);
    }
}
