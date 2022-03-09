import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Metodos {
    FileWriter fich;
    PrintWriter esc;
    GitHub github = null;
    GHRepository repo=null;
    public GitHub Token(String pathalFich){
        File file=new File(pathalFich);
        if(file.exists()){
            try {
                github = new GitHubBuilder()
                        .fromPropertyFile(pathalFich)
                        .build();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else{
            try {
                fich=new FileWriter(file , true);
                esc=new PrintWriter(fich);
                String tok=JOptionPane.showInputDialog("Introduce tu token");
                esc.print("oauth="+tok);
                github=new GitHubBuilder()
                        .withOAuthToken(tok)
                        .build();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                esc.close();
            }
        }
        return github;
    }
    public void crearRepositorio(){
        try {
            repo = github
                    .createRepository(JOptionPane.showInputDialog("Introduce el nombre de tu repositorio"))
                    .create();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
