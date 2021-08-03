package ir.maktab.store.service.impl;

import ir.maktab.store.ApplicationContext;
import ir.maktab.store.base.service.impl.BaseProductServiceImpl;
import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.domain.ProductCategory;
import ir.maktab.store.front.input.InputInt;
import ir.maktab.store.repository.ProductRepository;
import ir.maktab.store.service.ProductService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl extends BaseProductServiceImpl<Product, ProductRepository> implements ProductService {

    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
        this.repository = repository;
    }

    private List<Product> getProducts(Integer categoryId) {
        return repository.findAllByCategoryId(categoryId);
    }

    private List<Product> showProducts(Integer categoryId) {
        List<Product> products = getProducts(categoryId);
        for (int i = 0; i < products.size(); i++) {
            System.out.println("#"+(i+1) + "\n" + products.get(i));
        }
        return products;
    }

    @Override
    public Product getProduct() throws SQLException {
        ProductCategory productCategory = ApplicationContext.productCategoryService.getCategory();
        List<Product> products = showProducts(productCategory.getId());
        return chooseProduct(products);
    }

    @Override
    public Product checkStocks(Cart cart) {
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = findByID(entry.getKey().getId());
            if(product.getStock() < entry.getValue()) return product;
        }
        return null;
    }

    private Product chooseProduct(List<Product> products) {
        int productIndex = new InputInt("Enter your product number: ", products.size(), 1, null)
                .getIntInput() - 1;
        return products.get(productIndex);
    }
}
