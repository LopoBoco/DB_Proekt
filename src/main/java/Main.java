import controllers.MainController;
import models.Contact;
import models.User;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        var controller = new MainController();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Petya");

        Contact cont = new Contact();
        cont.setPhone("+7565444464");
        cont.setContactName("Eric cont name");
        cont.setEmail("5555@ya.ru");

        var meta = new HashMap<String, Object>();
        meta.put("traceId", "8g28r7g989dh93dh29h8hd");
        meta.put("userId", 1);
        meta.put("time", new Date().getTime());


        controller.addContact(user1, cont, meta);
        controller.close();
    }
}
