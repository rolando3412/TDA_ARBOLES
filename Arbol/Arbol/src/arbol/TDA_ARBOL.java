package arbol;

public class TDA_ARBOL {

    // CLASE PRINCIPAL.
    public static void main(String[] args) {
        // creamos instancia de la clase Arbol que implementa la interfaz
        // OperacionesDeArbol
        Arbol arbol = new Arbol();
        ///// CONSTRUPCION DEL ARBOL COMLEJO  10 ala 19 creacion del arbol 
        // !AQUI PODRIAMOS MENTER EL CAMBIO DE MANANA
        // TODO aqui metemos el nuevo arbol, que el lic nos va dar. aqui abajo.
        //!ROOT ES LA RAIZ DEL ARBOL NUEVO IMPLMENTADO 
        arbol.CREA4("ROOT",
                arbol.CREA2("A", arbol.CREA0("A1"), arbol.CREA0("A2")),
                arbol.CREA1("B", arbol.CREA0("B1")),
                arbol.CREA0("C"),
                arbol.CREA3("D", arbol.CREA0("D1"), arbol.CREA0("D2"), arbol.CREA0("D3")));

        // todo en la parte de arriba.
        /*
         * arbol.CREA4("A", arbol.CREA2("B", arbol.CREA3("F", arbol.CREA0("G"),
         * arbol.CREA0("H"), arbol.CREA0("I")),
         * arbol.CREA0("J")), arbol.CREA1("C", arbol.CREA2("K", arbol.CREA0("L"),
         * arbol.CREA0("M"))),
         * arbol.CREA1("D", arbol.CREA1("N", arbol.CREA0("O"))), arbol.CREA2("E",
         * arbol.CREA1("P",
         * arbol.CREA2("Q", arbol.CREA0("R"), arbol.CREA0("S"))), arbol.CREA0("T")));
         */
        // !Listamos el arbol para ver su estructura su visualizacion 
        arbol.Listar();
        System.out.println("La raiz del arbol esta en la cubeta " + arbol.RAIZ() + " Del arreglo");
        // mostramos los recorridos del arbol
        System.out.println("\n\n=====Recorrido en Orden Simetrico=====");
        arbol.ORD_SIM(arbol.RAIZ());
        System.out.println("\n\n=====Recorrido en Orden Posterio=====");
        arbol.ORD_POS(arbol.RAIZ());
        System.out.println("\n\n=====Recorrido en Orden Previo=====");
        arbol.ORD_PRE(arbol.RAIZ());

        // los demas componentes del arbol
        System.out.println("\n\nNiveles de Arbol -----> " + arbol.Altura(arbol.RAIZ()));
        System.out.println("\nEtiqueta Raiz del arbol -----> " + arbol.ETIQUETA(arbol.RAIZ()));
        System.out.println("\nEtiqueta Hijo_Mas_Izq(RAIZ) ------> " + arbol.ETIQUETA(arbol.HIJO_MAS_IZQ(arbol.RAIZ())));
        System.out.println("\nEtiqueta Hermano_Der(Hijo_mas_izq(RAiZ)) -------> "
                + arbol.ETIQUETA(arbol.HERMANO_DER(arbol.HIJO_MAS_IZQ(arbol.RAIZ()))));

        System.out.println("======Finalizacion de las Pruebas======");
        arbol.ANULA();
        arbol.Listar();
    }

}
