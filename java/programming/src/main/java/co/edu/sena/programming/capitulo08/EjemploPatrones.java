package co.edu.sena.programming.capitulo08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EjemploPatrones {
    public static void main(String[] args) {
        String t = "hemoreno33@misena.edu.co";

        String patronEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String patronEmailMiSena = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "misena.edu.co";

        try {

            Pattern pattern = Pattern.compile(patronEmailMiSena);
            Matcher matcher = pattern.matcher(t);

            if (matcher.matches()) {
                System.out.println("el correo correcto");
            }else {
                System.out.println("el correo no es correcto ");

            }



        }catch (PatternSyntaxException e){
            System.out.println(e.getMessage());
        }
    }
}
