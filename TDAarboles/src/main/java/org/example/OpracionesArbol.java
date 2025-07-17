package org.example;

/**
 * Clase que encapsula las operaciones del arbol
 */
public class OpracionesArbol {
    private Arbol arbol;

    /**
     * Constructor que inicializa las operaciones del arbol
     * @param arbol El arbol sobre el cual se realizarán las operaciones
     */
    public OpracionesArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    /**
     * Obtiene la etiqueta de un nodo especifico
     * @param n indice del nodo
     * @return la etiqueta del nodo
     */
    public Object ETIQUETA(int n) {
        if (n != -1) {
            return arbol.cursor.getArreglo_arbol_dato(n);
        }
        return null;
    }

    /**
     * Obtiene la raiz del arbol
     * @return indice de la raiz
     */
    public int RAIZ() {
        return arbol.RAIZ();
    }

    /**
     * Anula el arbol
     */
    public void ANULA() {
        arbol.ANULA();
    }

    public int CREA0(Object v) {
        return arbol.CREA0(v);
    }

    public int CREA1(Object v, int A1) {
        return arbol.CREA1(v, A1);
    }

    public int CREA2(Object v, int A1, int A2) {
        return arbol.CREA2(v, A1, A2);
    }

    public int CREA3(Object v, int A1, int A2, int A3) {
        return arbol.CREA3(v, A1, A2, A3);
    }

    public int CREA4(Object v, int A1, int A2, int A3, int A4) {
        return arbol.CREA4(v, A1, A2, A3, A4);
    }

    public int CREA(Object v, int... hijos) {
        return arbol.CREA(v, hijos);
    }


    public void mostrarArbol() {
        arbol.visualizar();
    }

    public void mostrarRecorridos() {
        arbol.mostrarRecorridos();
    }

    public void mostrarInfoRaiz() {
        arbol.mostrarInfoRaiz();
    }

    /**
     * Cuenta el número total de nodos en el árbol
     * @return número de nodos
     */
    public int contarNodos() {
        return arbol.contarNodos();
    }

    /**
     * Metodo adicional para demostrar uso completo
     */

    public void mostrarEstadoCompleto() {
        System.out.println(" estado completo del arbol ");
        mostrarInfoRaiz();
        mostrarArbol();
        mostrarRecorridos();
        System.out.println("Total de nodos: " + contarNodos());
    }

    /**
     * Metodo para liberar memoria de un nodo específico
     * Utiliza el metodo libera_memoria mejorado del cursor
     */
    public void liberarNodo(int posicion) {
        System.out.println("Liberando nodo en posición: " + posicion);
        arbol.cursor.libera_memoria(posicion);
    }

    /**
     * Metodo para mostrar el estado de la memoria
     */
    public void mostrarEstadoMemoria() {
        System.out.println(" ESTADO DE LA MEMORIA ");
        arbol.cursor.mostrarArbol();
        arbol.cursor.mostrarNiveles();
    }

    /**
     * Metodo para demostrar el uso completo de liberación de memoria
     */
    public void demostrarLiberacionMemoria() {
        System.out.println("\nDEMOSTRACION DE LIBERACION DE MEMORIA ");

        // Crear un nodo temporal para demostrar
        int nodoTemporal = CREA0("TEMP");
        System.out.println("Nodo temporal creado en posición: " + nodoTemporal);

        // Mostrar estado antes de liberar
        System.out.println("Estado antes de liberar:");
        mostrarEstadoMemoria();

        // Liberar el nodo temporal
        liberarNodo(nodoTemporal);

        // Mostrar estado después de liberar
        System.out.println("Estado después de liberar:");
        mostrarEstadoMemoria();
    }
}
