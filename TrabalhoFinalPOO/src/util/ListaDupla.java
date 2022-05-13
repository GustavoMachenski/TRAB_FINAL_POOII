package util;

import java.util.List;


public class ListaDupla<T> {
    private List<T> listA;
    private List<T> listB;
    
    public ListaDupla(List<T> listaA, List<T> listaB) {
        this.listA = listaA;
        this.listB = listaB;
    }
    
    public void transferirObject(T t){
        
        if (this.getListA().contains(t)){ //AtoB
            this.getListB().add(t);
            this.getListA().remove(t);
        }else if (this.getListB().contains(t)){ //BtoA
            this.getListA().add(t);
            this.getListB().remove(t);
        }else{
            //do nothing
        }
    }

    public List<T> getListA() {
        return listA;
    }

    public List<T> getListB() {
        return listB;
    }
    
    
    
    
}
