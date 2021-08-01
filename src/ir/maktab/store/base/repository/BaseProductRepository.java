package ir.maktab.store.base.repository;

import ir.maktab.store.base.domain.BaseProduct;

public interface BaseProductRepository<E extends BaseProduct<E>> extends BaseRepository<E, Long> {
}
