/*package ir.maktab.store.front.menu;

import ir.maktab.store.domain.Cart;
import ir.maktab.store.domain.Product;
import ir.maktab.store.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductMenu extends Menu implements RunnableMenu{
    private Cart cart;
    private List<Product> products;

    public ProductMenu(Cart cart, List<Product> products) {
        super(new String[]{"Add Product", "Show Cart", "Back"});
        this.cart = cart;
        this.products = products;
    }

    @Override
    public Object runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                        ProductService.chooseProduct(products, cart);
                        ProductService.showProducts(products);
                    break;
                case 2:
                    TakenProductService.showTakenProducts(cart);
                    break;
                case 3:
                    return null;
            }
        }
    }
}*/
