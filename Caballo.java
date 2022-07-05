//b) Ahora desarrollaremos una aplicación para mover el caballo alrededor de un tablero de ajedrez. 
//   El tablero estará representado por un arreglo bidimensional de ocho por ocho, llamado tablero. 
//   Cada posición se inicializa con cero. Describiremos cada uno de los ocho posibles movimientos 
//   en términos de sus componentes horizontales y verticales. Por ejemplo, un movimiento de tipo 0, 
//   como se muestra en la figura 7.30, consiste en mover dos posiciones en forma horizontal a la derecha 
//   y una posición vertical hacia arriba. Un movimiento de tipo 2 consiste en mover una posición 
//   horizontalmente a la izquierda y dos posiciones verticales hacia arriba. Los movimientos horizontal 
//   a la izquierda y vertical hacia arriba se indican con números negativos. 

import java.util.Random;

public class Caballo
{
    Random numerosAlAzar = new Random();

    int tablero[][]; 
    int horizontal[] = {2, 1, -1, -2, -2, -1, 1, 2};
    int vertical[] = {-1, -2, -2, -1, 1, 2, 2, 1};

    public void paseo()
    {
        int filaActual; // la posición de la fila en el tablero
        int columnaActual; // la posición de la columna en el tablero
        int numeroMovimiento = 0; // el número de movimiento actual

        tablero = new int[8][8]; 

        int pFila; // posición de la fila del próximo movimiento 
        int pColumna; // posición de la columna del próximo movimiento 

        // aleatoriza la posición inicial del tablero
        filaActual = numerosAlAzar.nextInt(8);
        columnaActual = numerosAlAzar.nextInt(8);

        tablero[filaActual][columnaActual] = ++numeroMovimiento;
        boolean hecho = false;

        // continua hasta que el caballo ya no pueda moverse más
        while (!hecho)
        {
            boolean buenMovimiento = false;

            // comprueba todos los movimientos posibles hasta que encontremos uno que sea legal
            for (int tipoDeMovimiento = 0; tipoDeMovimiento < 8 && !buenMovimiento;
            tipoDeMovimiento++)
            {
                pFila = filaActual + vertical[tipoDeMovimiento];
                pColumna = columnaActual + horizontal[tipoDeMovimiento];
                buenMovimiento = movimientoValido(pFila, pColumna);

                // prueba si el nuevo movimiento es válido
                if (buenMovimiento)
                {
                    filaActual = pFila;
                    columnaActual = pColumna;
                    tablero[filaActual][columnaActual] = ++numeroMovimiento;
                } 
            } 

            // si ya no hay movimientos válidos, el caballo ya no puede moverse
            if (!buenMovimiento)
            hecho = true;
            // si se han realizado los 64 movimientos, se completa un paseo completo
            else if (numeroMovimiento == 64)
            hecho = true;
        } 

        System.out.println("\n------------------------------------------------------------------");
        System.out.println("La cantidad de movimientos realizados fue de: " + numeroMovimiento);
        System.out.println("------------------------------------------------------------------\n");

        imprimirPaseo();
    } 

    public boolean movimientoValido (int fila, int columna)
    {
        // Devuelve falso si el movimiento está fuera del tablero o si el caballo ya ha visitado esa posición
        // Esta intrucción se detiene tan pronto se vuelve falsa
        return (fila >= 0 && fila < 8 && columna >= 0 && columna < 8
        && tablero[fila][columna] == 0);
    } 

    // muestra la ruta de recorrido del caballo
    public void imprimirPaseo()
    {
        // muestra los números para la columna
        for (int c = 0; c < 8; c++)
        System.out.printf( "\t%d",c);
        System.out.print("\n\n");

        for (int fila = 0; fila < tablero.length; fila++)
        {
            System.out.print (fila);

            for (int columna = 0; columna < tablero[ fila ].length; columna++)
            System.out.printf("\t%d", tablero[ fila ][ columna ]);

            System.out.println();
        } 

    } 
} 

