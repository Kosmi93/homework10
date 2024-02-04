import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            registration("0123456789012345678", "confPass1", "confPass");
        } catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("оно работает, но это не точно.");
        }
    }

    public static void registration(String login, String password, String confirmPassword) {
        Pattern loginAnpPassPattern = Pattern.compile("[0-9a-zA-Z_]{1,19}");
        Matcher loginAnpPassMather = loginAnpPassPattern.matcher(login);
        if (!loginAnpPassMather.matches())
            throw new WrongLoginException("Логин может принимать только" +
                    " латинские буквы, цифры и знак подчеркивания, длина логина должна быть менее 20 символов.\n");
        loginAnpPassMather = loginAnpPassPattern.matcher(password);
        if (!loginAnpPassMather.matches() || !password.equals(confirmPassword))
            throw new WrongPasswordException("Пароль может принимать только" +
                    " латинские буквы, цифры и знак подчеркивания, длина пароля должна быть менее 20 символов.\n" +
                    "Поля password и confirmPassword должны совпадать.\n");
    }

}