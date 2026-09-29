public class CalendarioMundial {

    public static void main(String[] args) {

        // 1. ARREGLO DE GRUPOS (12 grupos: A-L)
        String[] grupos = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};

        // 2. MATRIZ DE EQUIPOS POR GRUPO [12 grupos][4 equipos] (de Info.xlsx)
        String[][] equiposPorGrupo = {
            {"Mexico", "Marruecos", "Noruega", "Austria"},              // Grupo A
            {"Bosnia y Herzegovina", "Tunez", "Inglaterra", "España"}, // Grupo B
            {"Francia", "Cabo Verde", "Corea del Sur", "Congo RD"},    // Grupo C
            {"Ecuador", "Alemania", "Belgica", "Chequia"},             // Grupo D
            {"Japon", "Sudafrica", "Turquia", "Colombia"},             // Grupo E
            {"Escocia", "Paraguay", "Suiza", "Egipto"},                // Grupo F
            {"Portugal", "Haiti", "Argelia", "Arabia Saudi"},          // Grupo G
            {"Croacia", "Argentina", "Costa de Marfil", "Paises Bajos"},// Grupo H
            {"Brasil", "Qatar", "Estados Unidos", "Uruguay"},          // Grupo I
            {"Senegal", "Jordania", "Canada", "Australia"},            // Grupo J
            {"Nueva Zelanda", "Panama", "Curazao", "Suecia"},          // Grupo K
            {"Iran", "Uzbekistan", "Irak", "Ghana"}                    // Grupo L
        };

        // 3. MATRIZ DE CALENDARIO Y PARTIDOS
        // [72 partidos][6 columnas]: ID, Grupo, Local, Visitante, Fecha, Hora
        String[][] partidos = new String[72][6];

        String[] fechas = {"11 de Junio", "12 de Junio", "13 de Junio", "14 de Junio", "15 de Junio", "16 de Junio"};
        String[] horas  = {"13:00", "16:00", "19:00", "21:00"};

        // Generar los 6 partidos por grupo
        int contadorPartido = 0;
        for (int g = 0; g < 12; g++) {
            String[] eq = equiposPorGrupo[g];
            int[][] cruces = {{0, 1}, {2, 3}, {0, 2}, {1, 3}, {3, 0}, {1, 2}};

            for (int p = 0; p < 6; p++) {
                partidos[contadorPartido][0] = String.valueOf(contadorPartido + 1); // ID
                partidos[contadorPartido][1] = grupos[g];                          // Grupo
                partidos[contadorPartido][2] = eq[cruces[p][0]];                   // Local
                partidos[contadorPartido][3] = eq[cruces[p][1]];                   // Visitante
                partidos[contadorPartido][4] = fechas[p % fechas.length];          // Fecha
                partidos[contadorPartido][5] = horas[(p + g) % horas.length];      // Hora

                contadorPartido++;
            }
        }

        // 4. MENÚ INTERACTIVO USANDO ConsoleInput
        int opcion = 0;

        do {
            System.out.println("\n=== CALENDARIO DEL MUNDIAL ===");
            System.out.println("1. Ver todos los partidos por grupo");
            System.out.println("2. Ver hora e integrantes de un partido especifico");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            
            // Uso de ConsoleInput para enteros
            opcion = ConsoleInput.getInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la letra del Grupo (A - L): ");
                    // Uso de ConsoleInput para cadenas
                    String grupoBuscado = ConsoleInput.getString().toUpperCase();
                    
                    System.out.println("\n--- PARTIDOS DEL GRUPO " + grupoBuscado + " ---");
                    boolean encontrado = false;
                    for (int i = 0; i < 72; i++) {
                        if (partidos[i][1].equalsIgnoreCase(grupoBuscado)) {
                            System.out.printf("Partido #%2s | %-20s vs %-20s | Fecha: %-12s | Hora: %s\n",
                                partidos[i][0], partidos[i][2], partidos[i][3], partidos[i][4], partidos[i][5]);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Grupo no valido.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el numero de partido (1 - 72): ");
                    // Uso de ConsoleInput para enteros
                    int idPartido = ConsoleInput.getInt();

                    if (idPartido >= 1 && idPartido <= 72) {
                        int index = idPartido - 1;
                        System.out.println("\n--- DETALLES DEL PARTIDO #" + idPartido + " ---");
                        System.out.println("Grupo      : " + partidos[index][1]);
                        System.out.println("Enfrentados: " + partidos[index][2] + " vs " + partidos[index][3]);
                        System.out.println("Fecha      : " + partidos[index][4]);
                        System.out.println("Hora       : " + partidos[index][5]);
                    } else {
                        System.out.println("Numero de partido fuera de rango.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 3);
    }
}