package ir.maktab.store.base.service;

import ir.maktab.store.base.domain.BaseProduct;

public interface BaseProductService<E extends BaseProduct<E>> extends BaseService<E, Long> {
}
