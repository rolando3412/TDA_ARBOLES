package org.example;

public class Arbol {
    protected Cursor cursor; // Cambio de private a protected para acceso desde otras clases

    public Arbol() {
        this.cursor = new Cursor();
    }

    public int RAIZ() {
        return cursor.getRaiz();
    }

    public void ANULA() {
        cursor.setRaiz(-1);
        cursor.limpiaMemoria();
    }

    public int CREA0(Object v) {
        int disp = cursor.asigna_memoria();
        if (disp != -1) {
            cursor.setArreglo_arbol_dato(v, disp);
            cursor.setArreglo_arbol_izq(-1, disp);
            cursor.setArreglo_arbol_der(-1, disp);
            cursor.setRaiz(disp);
        }
        return disp;
    }

    public int CREA1(Object v, int A1) {
        int disp = cursor.asigna_memoria();
        if (disp != -1) {
            cursor.setArreglo_arbol_dato(v, disp);
            cursor.setArreglo_arbol_izq(A1, disp);
            cursor.setArreglo_arbol_der(-1, disp);
            cursor.setRaiz(disp);
        }
        return disp;
    }

    public int CREA2(Object v, int A1, int A2) {
        int disp = cursor.asigna_memoria();
        if (disp != -1) {
            cursor.setArreglo_arbol_dato(v, disp);
            cursor.setArreglo_arbol_izq(A1, disp);
            cursor.setArreglo_arbol_der(A2, A1);
            cursor.setRaiz(disp);
        }
        return disp;
    }

    public int CREA3(Object v, int A1, int A2, int A3) {
        int disp = cursor.asigna_memoria();
        if (disp != -1) {
            cursor.setArreglo_arbol_dato(v, disp);
            cursor.setArreglo_arbol_izq(A1, disp);
            cursor.setArreglo_arbol_der(A2, A1);
            cursor.setArreglo_arbol_der(A3, A2);
            cursor.setRaiz(disp);
        }
        return disp;
    }

    public int CREA4(Object v, int A1, int A2, int A3, int A4) {
        int disp = cursor.asigna_memoria();
        if (disp != -1) {
            cursor.setArreglo_arbol_dato(v, disp);
            cursor.setArreglo_arbol_izq(A1, disp);
            cursor.setArreglo_arbol_der(A2, A1);
            cursor.setArreglo_arbol_der(A3, A2);
            cursor.setArreglo_arbol_der(A4, A3);
            cursor.setRaiz(disp);
        }
        return disp;
    }

    // Metodo para crear árbol con múltiples hijos
    public int CREA(Object v, int... hijos) {
        int disp = cursor.asigna_memoria();
        if (disp != -1) {
            cursor.setArreglo_arbol_dato(v, disp);
            if (hijos.length > 0) {
                cursor.setArreglo_arbol_izq(hijos[0], disp);
                // Enlazar hermanos
                for (int i = 0; i < hijos.length - 1; i++) {
                    cursor.setArreglo_arbol_der(hijos[i + 1], hijos[i]);
                }
            }
            cursor.setRaiz(disp);
        }
        return disp;
    }

    public void visualizar() {
        cursor.mostrarArbol();
        cursor.mostrarNiveles();
    }

    public void ORD_PRE(int n) {
        if (n != -1) {
            System.out.print(cursor.getArreglo_arbol_dato(n) + " ");
            int c = cursor.getArreglo_arbol_izq(n);
            while (c != -1) {
                ORD_PRE(c);
                c = cursor.getArreglo_arbol_der(c);
            }
        }
    }




    public void ORD_IN(int n) {
        if (n != -1) {
            int c = cursor.getArreglo_arbol_izq(n);
            if (c != -1) {
                ORD_IN(c); // Procesar primer hijo (subárbol izquierdo)
                System.out.print(cursor.getArreglo_arbol_dato(n) + " "); // Procesar nodo actual
                c = cursor.getArreglo_arbol_der(c); // Continuar con hermanos
                while (c != -1) {
                    ORD_IN(c);
                    c = cursor.getArreglo_arbol_der(c);
                }
            } else {
                // Si no tiene hijos, procesar solo el nodo actual
                System.out.print(cursor.getArreglo_arbol_dato(n) + " ");
            }
        }
    }

    public void ORD_POST(int n) {
        if (n != -1) {
            int c = cursor.getArreglo_arbol_izq(n);
            while (c != -1) {
                ORD_POST(c);
                c = cursor.getArreglo_arbol_der(c);
            }
            System.out.print(cursor.getArreglo_arbol_dato(n) + " ");
        }
    }

    public void mostrarRecorridos() {
        System.out.println("\n=== RECORRIDOS DEL ARBOL ===");

        System.out.print("Recorrido PREORDEN: ");
        ORD_PRE(RAIZ());
        System.out.println();

        System.out.print("Recorrido INORDEN (Simétrico): ");
        ORD_IN(RAIZ());
        System.out.println();

        System.out.print("Recorrido POSTORDEN (Posterior): ");
        ORD_POST(RAIZ());
        System.out.println();
    }

    public void mostrarInfoRaiz() {
        System.out.println("\n=== INFORMACIÓN DE LA RAIZ ===");
        int raiz = RAIZ();
        if (raiz != -1) {
            System.out.println("Raiz esta en cubeta: " + raiz);
            System.out.println("Valor de la raiz: " + cursor.getArreglo_arbol_dato(raiz));
            int hijoIzq = cursor.getArreglo_arbol_izq(raiz);
            System.out.println("Hijo mas izquierdo de la raíz: " +
                (hijoIzq != -1 ? cursor.getArreglo_arbol_dato(hijoIzq) + " (cubeta " + hijoIzq + ")" : "No tiene"));
            if (hijoIzq != -1) {
                int hermano = cursor.getArreglo_arbol_der(hijoIzq);
                System.out.println("Hermano derecho del hijo más izquierdo: " +
                    (hermano != -1 ? cursor.getArreglo_arbol_dato(hermano) + " (cubeta " + hermano + ")" : "No tiene"));
            }
        } else {
            System.out.println("El arbol está vacío");
        }
    }

    public int contarNodos() {
        return cursor.contarNodos();
    }
}
