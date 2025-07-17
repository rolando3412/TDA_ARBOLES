package org.example;

public class Nodo {
    private Object dato;
    private int hijo_mas_izq;
    private int hermano_mas_der;

    public Nodo() {
        this.dato = null;
        this.hijo_mas_izq = -1;
        this.hermano_mas_der = -1;
    }

    public Nodo(Object dato) {
        this.dato = dato;
        this.hijo_mas_izq = -1;
        this.hermano_mas_der = -1;
    }

    // Getters y Setters
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public int getHijo_mas_izq() {
        return hijo_mas_izq;
    }

    public void setHijo_mas_izq(int hijo_mas_izq) {
        this.hijo_mas_izq = hijo_mas_izq;
    }

    public int getHermano_mas_der() {
        return hermano_mas_der;
    }

    public void setHermano_mas_der(int hermano_mas_der) {
        this.hermano_mas_der = hermano_mas_der;
    }
}
