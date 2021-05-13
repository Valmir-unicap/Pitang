package pitang.pkg01;
import java.util.Scanner;
/*
 * @author valmir
 */
public class PitangControle {
    private int contador;
    private Pitang03[]armazenar;//armazenar usuários
    
    public PitangControle(int tamanho){
        this.armazenar= new Pitang03[tamanho];//feito para armazenar, quantos usuários você quiser.
    }
    
   public int buscaSimples(Pitang03 P){//busca para verificar se possui algum cadastro repetido
       int i;
       if(this.contador==0){
           return -2;//vetor vázio!
       }else{
           for(i=0;i<this.contador;i=i+1){
               if(this.armazenar[i].compareTo(P)==0){
                   return i;
               }
           }
           return -1;//não achou
       }
   }
   public void Cadastrar(Pitang03 P){//cadastrar novo usuário
       if(this.contador<this.armazenar.length){
           int pos;
           pos=buscaSimples(P);
           if(pos==-1 || pos==-2){
               this.armazenar[this.contador]=P;
               this.contador++;
               System.out.println("Login criado! Inserção efetuada!");
           }else{
               System.out.println("Login repetido! Inserção não foi efetuada!");
            }
        }else{
           System.out.println("Cadastro cheio! Inserção não foi efetuada!");
        }
    }
   public void exibir(){//exibir todos os usuários cadastrados!
       int i;
       if(this.contador==0){
           System.out.println("Cadastro vázio!");
       }else{
       for(i=0;i<this.armazenar.length;i=i+1){
           if(this.armazenar[i]==null){
               return;//interromper a busca.
           }else{
                System.out.println("Usuários cadastardos");
                System.out.println(this.armazenar[i].toString());
                }
            }
        }
    }
   private int buscaBinaria(String email){//procurar um login, dentro do vetor
       int inicio=0, fim=this.contador-1, meio;
       if(this.contador==0){
           return -1;//vázio!
        }else{
           Pitang03 P= new Pitang03("",email,"","");
            do{
               meio= (inicio+fim)/2;
               if(P.compareTo(this.armazenar[meio])==0){
                   return meio;
               }else if(P.compareTo(this.armazenar[meio])<0){
                   fim=fim-1;
               }else{
                   inicio= meio+1;
               }
           }while(inicio<=fim);
           return -1;
       }
   }
   public void remover(String email){//remover um usuário cadastrado
       int pos, i;
       pos= this.buscaBinaria(email);
       if(pos==-1){
           System.out.println("Usuário não encontrado!");
       }else{
           for(i=pos;i<this.contador-1;i=i+1){
               this.armazenar[i]=this.armazenar[i+1];
           }
           this.armazenar[i]=null;
           this.contador--;
           System.out.println("Usuário removido!");
       }
   }
   public void consultar(String email){
       int pos, i;
       if(this.contador!=0){
          pos= this.buscaBinaria(email);
          if(pos==-1){
              System.out.println("Usuário não encontrado!");
          }else{
              System.out.println("Exibir usuário!");
              System.out.println(this.armazenar[pos].toString03());
          }
       }else{
           System.out.println("Cadastro vázio!");
       }
   }
    public void alterar(String login){
        Scanner in= new Scanner(System.in);
        PitangRun P= new PitangRun();
        int escolha, pos;
        do{
            P.MenuAlterar();
            escolha= in.nextInt();
            pos= buscaBinaria(login);
            if(pos==-1){
                System.out.println("Nao foi encontrado");
            }else{
                switch(escolha){
                    case 1://alterar nome
                        in.nextLine();//limpeza de buffer
                        String novoNome;
                        System.out.print("Informe o novo nome: ");
                        novoNome= in.nextLine();
                        this.armazenar[pos].setNome(novoNome);
                        System.out.println("Alteração efetuada, novo nome: "+this.armazenar[pos].getNome());
                        System.out.println("Exibir: "+this.armazenar[pos].toString02());
                        
                        break;

                    case 2://alterar senha
                        in.nextLine();//limpeza de buffer
                        String novaSenha;
                        System.out.print("Informe a nova senha: ");
                        novaSenha= in.nextLine();
                        this.armazenar[pos].setSenha(novaSenha);
                        System.out.println("Alteração efetuada, nova senha: "+this.armazenar[pos].getSenha());
                        System.out.println("Exibir: "+this.armazenar[pos].toString02());
                        break;

                    case 3://alterar número
                        in.nextLine();//limpeza de buffer
                        String novoNumero;
                        System.out.print("Informe o novo número de telefone: ");
                        novoNumero= in.nextLine();
                        this.armazenar[pos].setNumero(novoNumero);
                        System.out.println("Alteração efetuada, novo número de telefone: "+this.armazenar[pos].getNumero());
                        System.out.println("Exibir: "+this.armazenar[pos].toString02());
                        break;

                    case 4:
                        P.Menu();
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                    }
                }
            }while(escolha!=4);
        }
    public void incluir(String login){
        int pos;
        pos= buscaBinaria(login);
        if(pos==-1){
            System.out.println("Não foi encontrado!");
        }else{
            //continuar...
            System.out.println("Não deu tempo, pois estou em semana de avaliações");
        }
    }
}
