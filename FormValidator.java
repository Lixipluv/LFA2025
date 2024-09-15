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
        String nome1 = "Ada Lovelace";    // Válido
        String nome2 = "123";             // Inválido (números)
        String email = "divulga@ufpa.br"; // Válido
        String senha = "518R2r5e";        // Válido
        String cpf = "123.456.789-09";    // Válido
        String telefone = "(91) 99999-9999"; // Válido
        String dataHora = "31/08/2019 20:14:55"; // Válido
        String numeroReal = "-25.467";    // Válido

        System.out.println("Nome 'Ada Lovelace' válido: " + validar(regexNome, nome1));
        System.out.println("Nome '123' inválido: " + validar(regexNome, nome2));
        System.out.println("Email válido: " + validar(regexEmail, email));
        System.out.println("Senha válida: " + validar(regexSenha, senha));
        System.out.println("CPF válido: " + validar(regexCPF, cpf));
        System.out.println("Telefone válido: " + validar(regexTelefone, telefone));
        System.out.println("Data e Hora válida: " + validar(regexDataHora, dataHora));
        System.out.println("Número Real válido: " + validar(regexNumeroReal, numeroReal));
    }

    // Regex para validação de nome completo: permite o nome do meio opcional
    public static String regexNome = "^[A-Z][a-z]+( [A-Z][a-z]+)? [A-Z][a-z]+$";

    // Regex para validação de e-mail: permite letras minúsculas, números e aceita domínios com ".com.br" ou ".br"
    public static String regexEmail = "^[a-z0-9]+([._-]?[a-z0-9]+)*@[a-z0-9]+\\.(com\\.br|br)$";

    // Regex para validação de senha: exatamente 8 caracteres, pelo menos uma letra maiúscula e um número
    public static String regexSenha = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8}$";

    // Regex para validação de CPF: formato fixo xxx.xxx.xxx-xx com exatamente 11 dígitos
    public static String regexCPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

    // Regex para validação de telefone: cobre todos os formatos solicitados
    public static String regexTelefone = "^\\(\\d{2}\\) 9\\d{4}-\\d{4}$|^\\(\\d{2}\\) 9\\d{8}$|^\\d{2} 9\\d{8}$";

   // Verifica limites de dias (01-31), meses (01-12), horas (00-23), minutos e segundos (00-59)
    public static String regexDataHora = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4} (0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

    // Regex para validação de número real: números com até 7 dígitos na parte inteira e fracionária
    public static String regexNumeroReal = "^[+-]?\\d{1,7}(\\.\\d{1,7})?$";
}
