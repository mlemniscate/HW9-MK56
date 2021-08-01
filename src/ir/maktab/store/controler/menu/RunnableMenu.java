package ir.maktab.store.controler.menu;

import java.sql.SQLException;

public interface RunnableMenu<T> {
    T runMenu() throws SQLException;
}
