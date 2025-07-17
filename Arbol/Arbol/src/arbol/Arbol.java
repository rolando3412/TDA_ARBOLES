package arbol;

public class Arbol implements OperacionesDeArbol {
 //imlementacion de cursor " manejadores de memoria"
    Cursor Arbol = new Cursor();
// Implementación de la interfaz OperacionesDeArbol
    @Override
    public int PADRE(int i) {
        return Arbol.getPadre(i);
    }

    @Override
    public int HIJO_MAS_IZQ(int i) {
        return Arbol.getHijoMasIzquierdo(i);
    }

    @Override
    public int HERMANO_DER(int i) {
        return Arbol.getHermanoDerecho(i);
    }

    @Override
    public Object ETIQUETA(int i) {
        return Arbol.getDato(i);
    }

    @Override
    public int RAIZ() {
        return Arbol.getRaiz();
    }

    @Override
    public void ANULA() {
        Arbol.LimpiarMemoria();
    }

    @Override
    public int CREA0(Object D) {
        int espacio = Arbol.asigna_memoria();
        Arbol.setDato(D, espacio);
        Arbol.setRaiz(espacio);
        return espacio;
    }

    @Override
    public int CREA1(Object D, int A1) {
        int espacio = Arbol.asigna_memoria();
        Arbol.setDato(D, espacio);
        Arbol.setHijo_Mas_Izq(espacio, A1);
        Arbol.setRaiz(espacio);
        return espacio;
    }

    @Override
    public int CREA2(Object D, int A1, int A2) {
        int espacio = Arbol.asigna_memoria();
        Arbol.setDato(D, espacio);
        Arbol.setHijo_Mas_Izq(espacio, A1);
        Arbol.setHermano_Der(A1, A2);
        Arbol.setRaiz(espacio);
        return espacio;
    }

    @Override
    public int CREA3(Object D, int A1, int A2, int A3) {
        int espacio = Arbol.asigna_memoria();
        Arbol.setDato(D, espacio);
        Arbol.setHijo_Mas_Izq(espacio, A1);
        Arbol.setHermano_Der(A1, A2);
        Arbol.setHermano_Der(A2, A3);
        Arbol.setRaiz(espacio);
        return espacio;
    }

    @Override
    public int CREA4(Object D, int A1, int A2, int A3, int A4) {
        int espacio = Arbol.asigna_memoria();
        Arbol.setDato(D, espacio);
        Arbol.setHijo_Mas_Izq(espacio, A1);
        Arbol.setHermano_Der(A1, A2);
        Arbol.setHermano_Der(A2, A3);
        Arbol.setHermano_Der(A3, A4);
        Arbol.setRaiz(espacio);
        return espacio;
    }

    @Override
    public int CREA5(Object D, int A1, int A2, int A3, int A4, int A5) {
        int espacio = Arbol.asigna_memoria();
        Arbol.setDato(D, espacio);
        Arbol.setHijo_Mas_Izq(espacio, A1);
        Arbol.setHermano_Der(A1, A2);
        Arbol.setHermano_Der(A2, A3);
        Arbol.setHermano_Der(A3, A4);
        Arbol.setHermano_Der(A4, A5);
        Arbol.setRaiz(espacio);
        return espacio;
    }

    @Override
    public void ORD_POS(int n) {
        int c;
        c = Arbol.getHijoMasIzquierdo(n);
        while (c != -1) {
            ORD_POS(c);
            c = Arbol.getHermanoDerecho(c);
        }
        System.out.print(Arbol.getDato(n) + ",");
    }

    @Override
    public void ORD_PRE(int n) {
        int c;
        System.out.print(Arbol.getDato(n) + ",");
        c = Arbol.getHijoMasIzquierdo(n);
        while (c != -1) {
            ORD_PRE(c);
            c = Arbol.getHermanoDerecho(c);
        }
    }

    @Override
    public void ORD_SIM(int n) {
        int c, t;
        t = n;
        c = Arbol.getHijoMasIzquierdo(t);
        if (c == -1) {
            System.out.print(Arbol.getDato(t) + ",");
        } else {
            ORD_SIM(c);
            System.out.print(Arbol.getDato(t) + ",");
            c = Arbol.getHermanoDerecho(Arbol.getHijoMasIzquierdo(t));
            while (c != -1) {
                ORD_SIM(c);
                c = Arbol.getHermanoDerecho(c);
            }
        }
    }

    public void Listar() {
        Arbol.Listar();
    }

    public int Nivel_De_Nodo(int i) {
        int act, con;
        act = i;
        con = 0;
        while (Arbol.getPadre(act) != -1) {
            con++;
            act = Arbol.getPadre(i);
        }
        return con;
    }

    public int Altura(int n) {
        int max_altura;
        int comp;
        if (Arbol.getHijoMasIzquierdo(n) == -1) {
            return 0;
        }
        max_altura = Altura(Arbol.getHijoMasIzquierdo(n));
        int herder = Arbol.getHermanoDerecho(Arbol.getHijoMasIzquierdo(n));
        while (herder != -1) {
            comp = Altura(herder);
            if (comp > max_altura) {
                max_altura = comp;
            }
            herder = Arbol.getHermanoDerecho(herder);
        }

        return 1 + max_altura;
    }

}
