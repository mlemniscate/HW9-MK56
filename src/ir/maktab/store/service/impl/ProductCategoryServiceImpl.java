package ir.maktab.store.service.impl;

import ir.maktab.store.base.service.impl.BaseServiceImpl;
import ir.maktab.store.front.menu.Menu;
import ir.maktab.store.domain.ProductCategory;
import ir.maktab.store.repository.ProductCategoryRepository;
import ir.maktab.store.service.ProductCategoryService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory, Integer, ProductCategoryRepository> implements ProductCategoryService {

    public ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        super(repository);
    }


    @Override
    public ProductCategory getCategory() throws SQLException {
        List<ProductCategory> categories = findAll();
        ProductCategory main = chooseCategory(categories, 0);
        ProductCategory category = chooseCategory(categories, main.getId());
        return category;
    }

    private ProductCategory chooseCategory(List<ProductCategory> categories, int parentId) {
        ArrayList<String> mainsNames = new ArrayList<>();
        ArrayList<ProductCategory> mainCategories = new ArrayList<>();
        for (ProductCategory category : categories) {
            if (category.getParentId() == parentId) {
                mainsNames.add(category.getCategoryName());
                mainCategories.add(category);
            }
        }
        Menu menu = new Menu(mainsNames.toArray(new String[0]));
        menu.showMenu();
        int chosenItem = menu.getChosenItem() - 1;
        return mainCategories.get(chosenItem);
    }


}
