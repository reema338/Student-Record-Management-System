

import app.student.StudentManager;
import app.menu.Menu;

public class main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Menu menu = new Menu(manager);
        menu.start();

    }
}