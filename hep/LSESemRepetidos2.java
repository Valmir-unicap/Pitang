package br.unicap.c3.ed1.listas;
/*
 * @author valmir
 */
public class LSESemRepetidosLista2< T extends Comparable<T>> {
    private LSENode<T> prim;
    private LSENode<T> ult;
    private int quantidade;
    
    public boolean buscar(T valor){//erro assite a outra aula e emplemta o novo busca
        LSENode<T> aux;
        LSENode<T> aux2=new LSENode(valor);
        //aux2= valor;
        if(this.quantidade==0){
            return false;
        }else{
            aux= this.prim;
            while(aux!=null){
                if(aux.getInfo().compareTo(aux2.getInfo())==0){
                    return true;
                }else{
                    aux= aux.getProx();  
                }
            }
            return false;
        }
    }
    public void insirirNoInicio(T valor){
        LSENode<T>novo= new LSENode(valor);
        boolean procurar;
        if(this.quantidade==0){//lista vázia!
            this.prim= novo;
            this.ult= novo;
            this.quantidade++;
            System.out.println("Inserção efetuada!");
        }else{
            procurar = this.buscar(valor);
            if(procurar==true){
                System.out.println("Valor repetido, inserção não efetuada. ");
            }else{
                novo.setProx(prim);
                this.prim= novo;
                this.quantidade++;
                System.out.println("Inserção efetuada!");
            }
        }
    }
    public void inserirNoFinal(T valor){
        LSENode<T>novo= new LSENode(valor);
        boolean percorreu;
        if(this.quantidade==0){//lista vázia!
            this.prim=novo;
            this.ult= novo;
            this.quantidade++;
            System.out.println("Inserção efetuada!.");
        }else{
            percorreu= this.buscar(valor);
            if(percorreu==true){
                System.out.println("Valor repetido, inserção não efeutada.");
            }else{
                this.ult.setProx(novo);
                this.ult= novo;
                this.quantidade++;
                System.out.println("Inserção efetuada!");
            }
        }
    }
    public void exibirLista(){
        LSENode<T> aux;
        if(this.quantidade==0){
            System.out.println("Lista vázia!");
        }else{
            aux= this.prim;
            while(aux!=null){
                System.out.println(aux.getInfo());
                aux=aux.getProx();
            }
        }
    }
    public void removerPrimeiroProduto(){
        if(this.quantidade==0){
            System.out.println("Lista vázia!");
        }else if(this.quantidade==1){
            this.prim=null;
            this.ult=null;
            this.quantidade=0;
            System.out.println("Remoção efetuada!");
        }else{
            this.prim= this.prim.getProx();//o primiero nó é removido
            this.quantidade--;
            System.out.println("Remoção efetuada!");
        }
    }
    public void removerUltimoProduto(){
        LSENode<T>aux;
        if(this.quantidade==0){
            System.out.println("Lista vázia!");
        }else if(this.quantidade==1){
            this.prim=null;
            this.ult=null;
            this.quantidade=0;
            System.out.println("Remoção efetuada!");
        }else{
            aux=this.prim;
            while(aux.getProx()!=null){//percorro até chegar no penultimo nó. 
                aux=aux.getProx();//armazeno o penultimo nó encontrado.
            }
            aux.setProx(null);//o penultimo nó passa ser o ultimo nó
            this.ult=aux;//o valor armazenado no penultimo nó passa a ser o ultimo valor no ultimo nó.
            this.quantidade--;//removo menos -1.
            System.out.println("Remoção efetuada!");
        }
    }
}
