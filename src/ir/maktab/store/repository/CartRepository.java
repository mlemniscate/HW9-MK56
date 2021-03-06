package ir.maktab.store.repository;

import ir.maktab.store.base.repository.BaseRepository;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.service.dto.CartProductChangeDTO;

public interface CartRepository extends BaseRepository<Cart, Long> {

    Cart findByCustomerId(Long customerId);

    boolean saveProduct(CartProductChangeDTO cartProductChangeDTO);

    boolean updateProduct(CartProductChangeDTO cartProductChangeDTO);

    boolean deleteProduct(CartProductChangeDTO cartProductChangeDTO);
}
