import org.kohsuke.github.GitHub;

public class Main {
    public static void main(String[] args) {
        Metodos metodos=new Metodos();
        metodos.Token("/home/dam1/cod/LibreriaAccesoGitHub/FicheroToken.properties");
        metodos.crearRepositorio();
    }
}
