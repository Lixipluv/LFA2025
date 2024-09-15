import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FamilyArrangements {

    // Função genérica para validar expressões regulares
    public static boolean validar(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Testes para arranjos familiares

        // Casais heterossexuais com pelo menos dois filhos (filhas ou filhos homens)
        String regexHeteroFilhos = "^MH((h|m){2,}|h*m+|h{2,}m)$";
        String[] heteroFilhosTestes = {"MHhmm", "MHhh", "MHmm", "MHhm", "MHh", "MH", "MHhhhm"};

        System.out.println("Testes para casais heterossexuais com filhos:");
        for (String teste : heteroFilhosTestes) {
            System.out.println("Teste " + teste + ": " + validar(regexHeteroFilhos, teste));
        }

        // Casais com número ímpar de filhas
        String regexFilhasImpares = "^MH(m)(m{2})*$";  // Número ímpar de filhas (mínimo uma filha)
        String[] filhasImparesTestes = {"MHm", "MHmmm", "MHmmmmm", "MHmm", "MHmmmmm"};

        System.out.println("\nTestes para casais com número ímpar de filhas:");
        for (String teste : filhasImparesTestes) {
            System.out.println("Teste " + teste + ": " + validar(regexFilhasImpares, teste));
        }

        // Casais com filha mais velha e filho mais novo
        String regexFilhaMaisVelhaFilhoMaisNovo = "^MHm(h|m)*h$";
        String[] filhaMaisVelhaTestes = {"MHmhh", "MHmh", "MHmmh", "MHmhmmh", "MHm"};

        System.out.println("\nTestes para casais com filha mais velha e filho mais novo:");
        for (String teste : filhaMaisVelhaTestes) {
            System.out.println("Teste " + teste + ": " + validar(regexFilhaMaisVelhaFilhoMaisNovo, teste));
        }

        // Casais homossexuais com filhos alternados
        String regexHomossexuaisFilhosAlternados = "^(HH|MM)(hm|mh)*(h|m)?$";
        String[] homossexuaisFilhosAlternadosTestes = {"HHhmhm", "MMhmmh", "MMhmh", "HHmh", "MMhmhmh"};

        System.out.println("\nTestes para casais homossexuais com filhos alternados:");
        for (String teste : homossexuaisFilhosAlternadosTestes) {
            System.out.println("Teste " + teste + ": " + validar(regexHomossexuaisFilhosAlternados, teste));
        }

        // Casais homossexuais sem dois filhos homens consecutivos
        String regexHomossexuaisSemFilhosHomensConsecutivos = "^(HH|MM)(h?m)*h?$";
        String[] semFilhosHomensConsecutivosTestes = {"HHhmhm", "HHhmmh", "HHhmm", "HHmh", "HHhmhh"};

        System.out.println("\nTestes para casais homossexuais sem dois filhos homens consecutivos:");
        for (String teste : semFilhosHomensConsecutivosTestes) {
            System.out.println("Teste " + teste + ": " + validar(regexHomossexuaisSemFilhosHomensConsecutivos, teste));
        }

        // Casais homossexuais com seis filhos, sendo que os dois primeiros e os dois últimos formam casais
        String regexHomossexuaisSeisFilhosCasais = "^(HH|MM)(hm|mh){2,}(hm|mh)$";
        String[] seisFilhosCasaisTestes = {"HHhmhmhmhm", "MMmhmmhmmhm", "HHhmhmhm", "MMhmhmhmhm"};

        System.out.println("\nTestes para casais homossexuais com seis filhos, sendo que os dois primeiros e os dois últimos formam casais:");
        for (String teste : seisFilhosCasaisTestes) {
            System.out.println("Teste " + teste + ": " + validar(regexHomossexuaisSeisFilhosCasais, teste));
        }
    }
}
