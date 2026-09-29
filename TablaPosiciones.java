import java.util.Scanner;

public class TablaPosiciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nombres de los 48 equipos
        String[] equipos = {
            "Mexico", "Marruecos", "Noruega", "Austria", "Bosnia y Herz.", "Tunez",
            "Inglaterra", "España", "Francia", "Cabo Verde", "Corea del Sur", "Congo RD",
            "Ecuador", "Alemania", "Belgica", "Chequia", "Japon", "Sudafrica",
            "Turquia", "Colombia", "Escocia", "Paraguay", "Suiza", "Egipto",
            "Portugal", "Haiti", "Argelia", "Arabia Saudi", "Croacia", "Argentina",
            "Costa de Marfil", "Paises Bajos", "Brasil", "Qatar", "Estados Unidos", "Uruguay",
            "Senegal", "Jordania", "Canada", "Australia", "Nueva Zelanda", "Panama",
            "Curazao", "Suecia", "Iran", "Uzbekistan", "Irak", "Ghana"
        };

        // 2. Matriz de 48 filas x 10 columnas
        // Columnas: 0:PJ, 1:PG, 2:PE, 3:PP, 4:GF, 5:GC, 6:DG, 7:TA, 8:TR, 9:Pts
        int[][] tabla = new int[48][10];

        int opcion = 0;

        do {
            System.out.println("\n=== TABLA DE POSICIONES MUNDIAL ===");
            System.out.println("1. Ver tabla (Paginada)");
            System.out.println("2. Modificar equipo");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                // OPCIÓN 1: MOSTRAR TABLA PAGINADA DE 10 EN 10
                int tamanoPagina = 10;
                int totalPaginas = 5; // 48 equipos caben en 5 páginas

                for (int pag = 0; pag < totalPaginas; pag++) {
                    System.out.println("\n-----------------------------------------------------------");
                    System.out.println("ID  | EQUIPO           | PJ | PG | PE | PP | GF | GC | DG | TA | TR | Pts");
                    System.out.println("-----------------------------------------------------------");

                    int inicio = pag * tamanoPagina;
                    int fin = Math.min(inicio + tamanoPagina, equipos.length);

                    for (int i = inicio; i < fin; i++) {
                        System.out.printf("%-3d | %-16s |", (i + 1), equipos[i]);
                        for (int j = 0; j < 10; j++) {
                            System.out.printf("%3d |", tabla[i][j]);
                        }
                        System.out.println();
                    }

                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Página " + (pag + 1) + " de " + totalPaginas);

                    if (pag < totalPaginas - 1) {
                        System.out.print("Presiona ENTER para ver la siguiente página...");
                        scanner.nextLine(); // Limpiar búfer
                        scanner.nextLine(); // Esperar Enter
                    }
                }

            } else if (opcion == 2) {
                // OPCIÓN 2: MODIFICAR / EDITAR
                System.out.print("\nIngrese el número (ID) del equipo (1-48): ");
                int id = scanner.nextInt() - 1;

                if (id >= 0 && id < 48) {
                    System.out.println("\nEditando a: " + equipos[id]);
                    System.out.print("Partidos Jugados (PJ): ");
                    tabla[id][0] = scanner.nextInt();
                    System.out.print("Partidos Ganados (PG): ");
                    tabla[id][1] = scanner.nextInt();
                    System.out.print("Partidos Empatados (PE): ");
                    tabla[id][2] = scanner.nextInt();
                    System.out.print("Partidos Perdidos (PP): ");
                    tabla[id][3] = scanner.nextInt();
                    System.out.print("Goles a Favor (GF): ");
                    tabla[id][4] = scanner.nextInt();
                    System.out.print("Goles en Contra (GC): ");
                    tabla[id][5] = scanner.nextInt();
                    System.out.print("Tarjetas Amarillas (TA): ");
                    tabla[id][7] = scanner.nextInt();
                    System.out.print("Tarjetas Rojas (TR): ");
                    tabla[id][8] = scanner.nextInt();

                    // Cálculos automáticos de las columnas que faltan
                    tabla[id][6] = tabla[id][4] - tabla[id][5];              // DG = GF - GC
                    tabla[id][9] = (tabla[id][1] * 3) + (tabla[id][2] * 1);   // Pts = PG*3 + PE*1

                    System.out.println("¡Datos actualizados correctamente!");
                } else {
                    System.out.println("ID no válido.");
                }
            }

        } while (opcion != 3);

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}