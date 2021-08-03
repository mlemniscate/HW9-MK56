package ir.maktab.store.base.repository;

import ir.maktab.store.base.domain.BaseEntity;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID>{

    Boolean save(E e);

    Boolean update(E e);

    List<E> findAll() throws SQLException;

    List<E> findAllByIds(Collection<ID> ids);

    E findByID(ID id);

    Boolean deleteById(ID id);

    Boolean isExist(ID id);

}
