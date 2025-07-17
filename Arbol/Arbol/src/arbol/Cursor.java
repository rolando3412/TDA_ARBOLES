package arbol;

public class Cursor {

    private int raiz;
    private int tamaño = 25;
    private boolean[] Memoria_Disponible = new boolean[tamaño];
    private Nodo[] arreglo = new Nodo[tamaño];

    public Cursor() {
        for (int i = 0; i < Memoria_Disponible.length; i++) {
            Memoria_Disponible[i] = true;
        }
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = new Nodo();
            arreglo[i].setHijo_Mas_Izquierdo(-1);
            arreglo[i].setHermano_Derecho(-1);
            arreglo[i].setDato(null);
        }
        this.raiz = -1;
    }

    public int asigna_memoria() {
        for (int i = 0; i < Memoria_Disponible.length; i++) {
            if (Memoria_Disponible[i]) {
                Memoria_Disponible[i] = false;
                return i;
            }
        }
        return -1;
    }

    public void setRaiz(int i) {
        raiz = i;
    }

    public void setHijo_Mas_Izq(int padre, int i) {
        arreglo[padre].setHijo_Mas_Izquierdo(i);
        arreglo[i].setIndice_padre(padre);
    }

    public void setHermano_Der(int HER_IZQ, int i) {
        arreglo[HER_IZQ].setHermano_Derecho(i);
        arreglo[i].setIndice_padre(arreglo[HER_IZQ].getIndice_padre());

    }

    public void setDato(Object Dato, int i) {
        arreglo[i].setDato(Dato);
    }

    public void SetPadre(int i) {
        arreglo[i].setIndice_padre(i);
    }

    public void LimpiarMemoria() {
        for (int i = 0; i < Memoria_Disponible.length; i++) {
            Memoria_Disponible[i] = true;
            for (int j = 0; j < arreglo.length; j++) {
                arreglo[i].setDato(null);
                arreglo[i].setHermano_Derecho(-1);
                arreglo[i].setHijo_Mas_Izquierdo(-1);
                arreglo[i].setIndice_padre(-1);
            }
        }
    }

    public int BuscarRaiz(int i) {
        while (arreglo[i].getIndice_padre() != -1) {
            i = arreglo[i].getIndice_padre();
        }
        return i;
    }

    public int getHermanoDerecho(int i) {
        return arreglo[i].getHermano_Derecho();
    }

    public int getHijoMasIzquierdo(int i) {
        return arreglo[i].getHijo_Mas_Izquierdo();
    }

    public Object getDato(int i) {
        return arreglo[i].getDato();
    }

    public int getPadre(int i) {
        return arreglo[i].getIndice_padre();
    }

    public int getRaiz() {
        return raiz;
    }

    public void Listar() {
        System.out.println("Cubeta    hijo mas izquierdo    Etiqueta    Hermano Derecho");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(i + "          " + arreglo[i].getHijo_Mas_Izquierdo() + "                    "
                    + arreglo[i].getDato() + "                     " + arreglo[i].getHermano_Derecho());
        }
    }

}
