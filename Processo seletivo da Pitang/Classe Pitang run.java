package pitang.pkg01;
import java.util.Scanner;
/*
 * @author valmir
 */
public class PitangRun {
   
    public void Run(){
        Scanner in= new Scanner(System.in);
        Pitang03 P3;
        int tamanho;
        System.out.println("Bem-Vindo!");
        System.out.println("");
        System.out.print("Digite a quantidade de usuários, para armazenar neste programa: ");
        tamanho= in.nextInt();
        while(tamanho<0){
            System.out.print("Inválido, digite novamente: ");
            tamanho= in.nextInt();
        }
        PitangControle P2= new PitangControle(tamanho);
        int escolha;
        String nome, email, senha,numero;
        do{
            Menu();
            escolha= in.nextInt();
            switch (escolha){
                case 1://fazer login
                    in.nextLine();
                    System.out.println("");
                    System.out.println("Vamos criar seu login");
                    System.out.println("");
                    System.out.print("Digite o nome do usuário: ");
                    nome= in.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    email= in.nextLine();
                    System.out.print("Digite a senha: ");
                    senha= in.nextLine();
                    System.out.print("Digite o número de telefone: ");
                    numero= in.nextLine();
                    P3= new Pitang03 (nome,email,senha,numero);//criar objeto!
                    P2.Cadastrar(P3);
                    break;

                case 2://consultar usuário //peça o email e em seguida exiba somente número e nome dele
                    P2.exibir();//exibir todos os usuários cadastrados
                    in.nextLine();
                    String NovoEmail;
                    System.out.print("Informe o email para consultar: ");
                    NovoEmail= in.nextLine();
                    P2.consultar(NovoEmail);
                    break;

                case 3://incluir usuário // continuar...
                    in.nextLine();
                    String novoIncluir;
                    System.out.println("Informe o email para incluir: ");
                    novoIncluir= in.nextLine();
                    P2.incluir(novoIncluir);                   
                    break;

                case 4://alterar usuário
                    in.nextLine();//limpeza de buffer
                    String informe;
                    System.out.print("Informe o login do usuário: ");
                    informe= in.nextLine();
                    P2.alterar(informe);
                    break;

                case 5://remover usuário
                    in.nextLine();//limpeza de buffer
                    String login;
                    System.out.print("Digite o login, para remover: ");
                    login= in.nextLine();
                    P2.remover(login);
                    break;
                case 0:
                    System.out.println("Goodbye user! @Developer Valmir Júnior");
                    break;

                default:
                    System.out.println("Opção inválida!");              
                    break;
                }
        }while(escolha!=0);
    }      
    public void Menu(){
        System.out.println("");
        System.out.println("Menu inicial");
        System.out.println("");
        System.out.println("1- Fazer login");
        System.out.println("2- Consultar usuários");
        System.out.println("3- Incluir usuário");
        System.out.println("4- Alterar usuário");
        System.out.println("5- Remover usuário");
        System.out.println("0- Fim do programa");
        System.out.print("Escolha umas das opções acima: ");
        } 
    public void MenuAlterar(){
        System.out.println("");
        System.out.println("Menu de opções para alterar");
        System.out.println("");
        System.out.println("1- Alterar nome");
        System.out.println("2- Alterar senha");
        System.out.println("3- Alterar número de telefone");
        System.out.println("4- Voltar para o menu inicial");
        System.out.println("OBS: Seu login não pode ser alterado, pois ele é sua identificação. ");
        System.out.print("Escolha uma das opções acima: ");
    }
}
