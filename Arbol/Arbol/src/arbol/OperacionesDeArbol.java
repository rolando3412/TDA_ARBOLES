package arbol;

// objet para almacenar cualquier tipo de dato
// y para realizar operaciones de arboles
public interface OperacionesDeArbol {
    // DEVUELVE EL PADRE DEL NODO
    public int PADRE(int i);

    // DEVUELVE EL HIJO MAS IZQUIERDO DEL NODO
    public int HIJO_MAS_IZQ(int i);

    // DEVUELVE EL HERMANO DERECHO DEL NODO
    public int HERMANO_DER(int i);

    // DEVUELVE LA ETIQUETA DEL NODO VALOR ALMACENADO
    public Object ETIQUETA(int i);

    // DEVUELVE LA RAIZ DEL ARBOL
    public int RAIZ();

    // vacia el arbol, eliminando todos sus nodos o lo anula
    public void ANULA();

    // NODO HOJA DEL DATO D
    public int CREA0(Object D);

    // NODO CON UN HIJO IZQUIERDO A1 DEL DATO D
    public int CREA1(Object D, int A1);

    // NODO CON DOS HIJOS IZQUIERDO A1 Y DERECHO A2 DEL DATO D
    public int CREA2(Object D, int A1, int A2);

    // NODO CON TRES HIJOS IZQUIERDO A1, DERECHO A2 Y HERMANO DERECHO A3 DEL DATO D
    public int CREA3(Object D, int A1, int A2, int A3);

    // NODO CON CUATRO HIJOS IZQUIERDO A1, DERECHO A2, HERMANO DERECHO A3 Y HERMANO
    // DERECHO A4 DEL DATO D
    public int CREA4(Object D, int A1, int A2, int A3, int A4);

    // NODO CON CINCO HIJOS IZQUIERDO A1, DERECHO A2, HERMANO DERECHO A3, HERMANO
    // DERECHO A4 Y HERMANO DERECHO A5 DEL DATO D
    public int CREA5(Object D, int A1, int A2, int A3, int A4, int A5);

    // RECORRIDO EN ORDEN SIMETRICO POST ORDEN
    public void ORD_POS(int n);

    // RECORRIDO EN ORDEN PREVIO PRE ORDEN
    public void ORD_PRE(int n);

    // RECORRIDO EN ORDEN SIMETRICO INT ORDEN
    public void ORD_SIM(int n);

}
