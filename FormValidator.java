import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FormValidator {

    // Função de validação genérica
    public static boolean validar(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Exemplo de como usar para validar diferentes campos (os regex estão definidos abaixo)
        String nome = "Ada Lovelace";
        String email = "divulga@ufpa.br";
        String senha = "518R2r5e";
        String cpf = "123.456.789-09";
        String telefone = "(91) 99999-9999";
        String dataHora = "31/08/2019 20:14:55";
        String numeroReal = "-25.467";

        System.out.println("Nome válido: " + validar(regexNome, nome));
        System.out.println("Email válido: " + validar(regexEmail, email));
        System.out.println("Senha válida: " + validar(regexSenha, senha));
        System.out.println("CPF válido: " + validar(regexCPF, cpf));
        System.out.println("Telefone válido: " + validar(regexTelefone, telefone));
        System.out.println("Data e Hora válida: " + validar(regexDataHora, dataHora));
        System.out.println("Número Real válido: " + validar(regexNumeroReal, numeroReal));
    }

    // Aqui estão os regex que serão explicados abaixo
    public static String regexNome = "^[A-Z][a-z]+( [A-Z][a-z]+)*( [A-Z][a-z]+)?$";
    public static String regexEmail = "^[a-z]+@[a-z]+\\.(com\\.br|br)$";
    public static String regexSenha = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8}$";
    public static String regexCPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
    public static String regexTelefone = "^\\(\\d{2}\\) 9\\d{4}-\\d{4}|\\(\\d{2}\\) 9\\d{8}|\\d{2} 9\\d{8}$";
    public static String regexDataHora = "^\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}:\\d{2}$";
    public static String regexNumeroReal = "^[+-]?\\d+(\\.\\d+)?$";
}
