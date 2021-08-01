package ir.maktab.store.controler.menu;

public class CheckMenu extends Menu implements RunnableMenu<Boolean>{
    private final String message;
    private boolean isAccepted;

    public CheckMenu(String message) {
        super(new String[]{"Yes", "No"});
        this.message = message;

    }

    @Override
    public Boolean runMenu() {
        System.out.println("\n" + message);
        while(true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
        }
    }
}
