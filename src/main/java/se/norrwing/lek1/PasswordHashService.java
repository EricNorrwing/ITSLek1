package se.norrwing.lek1;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashService {

    public String hashPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
