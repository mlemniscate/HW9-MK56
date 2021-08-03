package ir.maktab.store.repository;

import ir.maktab.store.base.repository.BaseRepository;
import ir.maktab.store.domain.Cart;

public interface CartRepository extends BaseRepository<Cart, Long> {

    Cart findByCustomerId(Long customerId);

    boolean saveProduct(Long cartId, int quantity, Long productId);

    boolean updateProduct(Long cartId, Long productId, Integer quantity);
}
