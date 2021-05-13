package pitang.pkg01;
/*
 * @author valmir
 */
public class Pitang03 implements Comparable <Pitang03> {
    private String nome;
    private String email;
    private String senha;
    private String numero;//provavelmente, criar uma matriz seria uma boa opção.
    
    public Pitang03(String nome, String email, String senha, String numero){//Construtor
        this.nome=nome;
        this.email=email;
        this.senha=senha;
        this.numero=numero;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setSenha(String senha){
        this.senha=senha;
    }
    public String getSenha(){
        return this.senha=senha;
    }
    public void setNumero(String numero){
        this.numero=numero;
    }
    public String getNumero(){
        return this.numero=numero;
    }
    @Override
    public int compareTo(Pitang03 P) {
        return this.email.compareTo(P.email);//se dois email forem iguais, ele não deve armazenar
    }
    @Override
    public String toString(){        
        return " Email: "+this.email;//exbir só email para consultar
    }
    public String toString02(){
        return " O usuário do nome: "+this.nome+", do login: "+this.email+", da senha: "+this.senha+", do número de telefone: "+this.numero;//exibir para usuário logado
    }
    public String toString03(){
        return " O usuário do nome: "+this.nome+", do número de telefone: "+this.numero;//exibir para visitante
    }
}
