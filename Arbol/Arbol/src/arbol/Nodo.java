package arbol;

public class Nodo {
 // almacenamiento del dato del nodo
    private Object Dato;
//indice del hermano derecho
    private int Hermano_Derecho;
//indice del hijo mas izquierdo
    private int Hijo_Mas_Izquierdo;
//indice del padre
    // este es el padre del nodo, que es el padre del hijo mas izquierdo
    private int indice_padre;

    // Constructor por defecto 
    public Nodo() {
        //todo -1 valor nulo  para indices 
        this.Dato = -1;
        this.Hermano_Derecho = -1;
        this.Hijo_Mas_Izquierdo = -1;
        this.indice_padre = -1;
    }
    // nodo con valores espesificos, 
    //! aqui debe ser de tipo Object, pero por simplicidad se usa int 
          //todo verificar manana si podemos cambiarlo a Object
    public Nodo(int Dato, int Hermano_Derecho, int Hijo_Mas_Izquierdo, int indice_padre) {
        this.Dato = Dato;
        this.Hermano_Derecho = Hermano_Derecho;
        this.Hijo_Mas_Izquierdo = Hijo_Mas_Izquierdo;
        this.indice_padre = indice_padre;
    }
    // metodos de acceso y modificacion 
// set 
    public void setDato(Object Dato) {
        this.Dato = Dato;
    }

    public void setHermano_Derecho(int Hermano_Derecho) {
        this.Hermano_Derecho = Hermano_Derecho;
    }

    public void setHijo_Mas_Izquierdo(int Hijo_Mas_Izquierdo) {
        this.Hijo_Mas_Izquierdo = Hijo_Mas_Izquierdo;
    }

    public void setIndice_padre(int indice_padre) {
        this.indice_padre = indice_padre;
    }
//metodo getter 
    public Object getDato() {
        return Dato;
    }

    public int getHermano_Derecho() {
        return Hermano_Derecho;
    }

    public int getHijo_Mas_Izquierdo() {
        return Hijo_Mas_Izquierdo;
    }

    public int getIndice_padre() {
        return indice_padre;
    }

}
