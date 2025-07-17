package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(" programa del arbol con  24 nodos");

        // Crear el arbol
        Arbol arbol = new Arbol();

        // Crear el wrapper de operaciones - ESTA CLASE ES UTILIZADA COMPLETAMENTE
        OpracionesArbol operaciones = new OpracionesArbol(arbol);

        // Inicializar el árbol usando OpracionesArbol
        operaciones.ANULA(); // Usar el metodo ANULA para limpiar

        // Crear los nodos hoja (sin hijos) usando OpracionesArbol
        int nodoA = operaciones.CREA0("A");
        int nodoB = operaciones.CREA0("B");
        int nodoC = operaciones.CREA0("C");
        int nodoD = operaciones.CREA0("D");
        int nodoE = operaciones.CREA0("E");
        int nodoF = operaciones.CREA0("F");
        int nodoG = operaciones.CREA0("G");
        int nodoH = operaciones.CREA0("H");
        int nodoI = operaciones.CREA0("I");
        int nodoJ = operaciones.CREA0("J");
        int nodoK = operaciones.CREA0("K");
        int nodoL = operaciones.CREA0("L");
        int nodoM = operaciones.CREA0("M");
        int nodoN = operaciones.CREA0("N");
        int nodoO = operaciones.CREA0("O");
        int nodoP = operaciones.CREA0("P");
        int nodoQ = operaciones.CREA0("Q");
        int nodoR = operaciones.CREA0("R");
        int nodoS = operaciones.CREA0("S");

        // Crear nodos internos con hijos usando OpracionesArbol
        int nodoT = operaciones.CREA3("T", nodoA, nodoB, nodoC);
        int nodoU = operaciones.CREA2("U", nodoD, nodoE);
        int nodoV = operaciones.CREA2("V", nodoF, nodoG);
        int nodoW = operaciones.CREA4("W", nodoH, nodoI, nodoJ, nodoK);
        int nodoX = operaciones.CREA3("X", nodoL, nodoM, nodoN);

        // Crear la raíz final del arbol con todos los subárboles
        int raiz = operaciones.CREA("RAIZ", nodoT, nodoU, nodoV, nodoW, nodoX);

        System.out.println("arbol creado exitosamente con 24 nodos");
        System.out.println("numero total de nodos: " + operaciones.contarNodos());

        // Usar el nuevo metodo mostrarEstadoCompleto para demostrar uso completo
        operaciones.mostrarEstadoCompleto();






    }
}
