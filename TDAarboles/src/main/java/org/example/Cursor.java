package org.example;


public class Cursor {
    private int raiz;
    private boolean[] memoria = new boolean[25];
    private Nodo[] arreglo_arbol_dato = new Nodo[25];

    public Cursor() {
        for (int i = 0; i < memoria.length; i++) {
            memoria[i] = true; // Inicializa toda la memoria como libre
        }
        for (int i = 0; i < arreglo_arbol_dato.length; i++) {
            arreglo_arbol_dato[i] = new Nodo();
            arreglo_arbol_dato[i].setHijo_mas_izq(-1);
            arreglo_arbol_dato[i].setHermano_mas_der(-1);
        }
        raiz = -1; // Inicializa la raíz como -1 (sin nodo)
    }

    public int asigna_memoria() {
        for (int i = 0; i < memoria.length; i++) {
            if (memoria[i]) {
                memoria[i] = false; // Marca la posición como ocupada
                return i; // Retorna el índice de memoria asignado
            }
        }
        return -1; // Retorna -1 si no hay memoria disponible
    }
//!ojito aca
    public void libera_memoria(int pos) {
        if (pos >= 0 && pos < memoria.length) {
            // Verificar que la posición esté ocupada antes de liberarla
            if (!memoria[pos]) {
                // Limpiar los datos del nodo antes de liberar la memoria
                arreglo_arbol_dato[pos].setDato(null);
                arreglo_arbol_dato[pos].setHijo_mas_izq(-1);
                arreglo_arbol_dato[pos].setHermano_mas_der(-1);

                // Marcar la posición como libre
                memoria[pos] = true;

                // Mensaje de confirmación verificar o debuguear
                System.out.println("Memoria liberada en posición: " + pos);
            } else {
                System.out.println("Advertencia: La posición " + pos + " ya estaba libre");
            }
        } else {
            System.out.println("Error: Posición " + pos + " fuera de rango");
        }
    }


    // Getters y Setters corregidos
    public int getRaiz() {
        return raiz;
    }

    public void setRaiz(int raiz) {
        this.raiz = raiz;
    }

    public int getArreglo_arbol_der(int i) {
        return arreglo_arbol_dato[i].getHermano_mas_der();
    }

    public Object getArreglo_arbol_dato(int i) {
        return arreglo_arbol_dato[i].getDato();
    }

    public int getArreglo_arbol_izq(int i) {
        return arreglo_arbol_dato[i].getHijo_mas_izq();
    }

    public void setArreglo_arbol_izq(int izq, int i) {
        this.arreglo_arbol_dato[i].setHijo_mas_izq(izq);
    }

    public void setArreglo_arbol_der(int der, int i) {
        this.arreglo_arbol_dato[i].setHermano_mas_der(der);
    }

    public void setArreglo_arbol_dato(Object o, int i) {
        this.arreglo_arbol_dato[i].setDato(o);
    }


    public void limpiaMemoria() {
        for (int i = 0; i < memoria.length; i++) {
            memoria[i] = true; // Marca toda la memoria como libre
        }
    }


    public int get_papa(int n) {
        // Recorre todos los nodos en memoria para encontrar padres
        for (int p = 0; p < arreglo_arbol_dato.length; p++) {
            if (!memoria[p] && arreglo_arbol_dato[p].getHijo_mas_izq() != -1) {
                // p es un padre potencial, recorre sus hijos
                int sigue = arreglo_arbol_dato[p].getHijo_mas_izq();
                while (sigue != -1) {
                    if (sigue == n) {
                        return p; // Retorna el padre del nodo n
                    }
                    sigue = arreglo_arbol_dato[sigue].getHermano_mas_der();
                }
            }
        }
        return -1; // Retorna -1 si no se encuentra el padre
    }


    public void mostrarArbol() {
        System.out.println(" estado del arbol ");
        System.out.println("Raiz del arbol esta en la cubeta: " + raiz);
        if (raiz != -1) {
            System.out.println("Valor de la raiz: " + getArreglo_arbol_dato(raiz));
        }

        System.out.println("\n memoria del arbol:");
        for (int i = 0; i < arreglo_arbol_dato.length; i++) {
            if (!memoria[i]) { // Si está ocupada
                System.out.println("Cubeta " + i + ": " +
                        "Dato=" + getArreglo_arbol_dato(i) +
                        ", Hijo_izq=" + getArreglo_arbol_izq(i) +
                        ", Hermano_der=" + getArreglo_arbol_der(i));
            }
        }
    }

    public int contarNodos() {
        int contador = 0;
        for (int i = 0; i < memoria.length; i++) {
            if (!memoria[i]) { // Si está ocupada
                contador++;
            }
        }
        return contador;
    }

    public int calcularNivel(int nodo) {
        if (nodo == -1 || nodo == raiz) {
            return 0;
        }

        int padre = get_papa(nodo);
        if (padre == -1) {
            return -1; // No se encontro el padre
        }

        return 1 + calcularNivel(padre);
    }

    public void mostrarNiveles() {
        System.out.println("\n niveles del arbol de nodos:");
        for (int i = 0; i < arreglo_arbol_dato.length; i++) {
            if (!memoria[i]) { // Si está ocupada
                int nivel = calcularNivel(i);
                System.out.println("Nodo " + getArreglo_arbol_dato(i) +
                        " (cubeta " + i + ") - Nivel: " + nivel);
            }
        }
    }
}
