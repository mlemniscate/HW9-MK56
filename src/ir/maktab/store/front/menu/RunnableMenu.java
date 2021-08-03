package ir.maktab.store.front.menu;

import java.sql.SQLException;

public interface RunnableMenu<T> {
    T runMenu() throws SQLException;
}
