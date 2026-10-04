import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MegaMundial {

    // Nombres estandarizados de los 48 países del mundial
    private static final String[] PAISES = {
        "Inglaterra", "España", "Francia", "Cabo Verde", "Arabia Saudita",
        "Corea del Sur", "Congo RD", "Ecuador", "Estados Unidos", "Argentina",
        "Brasil", "Canadá", "Costa de Marfil", "Jordania", "Alemania",
        "Japón", "Colombia", "Bélgica", "Turquía", "Sudáfrica",
        "Chequia", "Suiza", "Portugal", "Egipto", "Paraguay",
        "Escocia", "Haití", "Argelia", "México", "Marruecos",
        "Austria", "Noruega", "Bosnia y Herzegovina", "Túnez", "Croacia",
        "Países Bajos", "Uruguay", "Qatar", "Australia", "Nueva Zelanda",
        "Senegal", "Ghana", "Panamá", "Irak", "Suecia",
        "Curazao", "Irán", "Uzbekistán"
    };

    // Estructura de la Tabla de Posiciones para los 48 países
    // Índices: [0] PJ, [1] PG, [2] PE, [3] PP, [4] GF, [5] GC, [6] DG, [7] Pts
    private static int[][] tablaStats = new int[48][8];

    // Matriz global para la carga de banderas
    private static char[][] matriz = new char[480][15];

	public static final String YELLOW_BACKGROUND = "\u001B[43m";
    	public static final String ORANGE_BACKGROUND = "\u001B[48;5;208m";
    	public static final String RED_BACKGROUND = "\u001B[41m";
    	public static final String PURPLE_BACKGROUND = "\u001B[45m";
   	 public static final String BLUE_BACKGROUND = "\u001B[44m";
   	 public static final String GREEN_BACKGROUND = "\u001B[42m";
   	 public static final String WHITE_BACKGROUND = "\u001B[47m";
   	 public static final String BLACK_BACKGROUND = "\u001B[40m";
   	 public static final String BROWN_BACKGROUND = "\u001B[48;5;94m";
   	 public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cargarMatrizCSV();

        int opcion = 0;
        do {
            mostrarAsciiArt(); // <-- Agrégalo aquí para que se dibuje al iniciar el menú
      
            System.out.println("\n==================================================");
            System.out.println("   MEGA SISTEMA MUNDIAL 2026 - CONSOLE EDITION   ");
            System.out.println("==================================================");
            System.out.println("1. Consultar Selección (Bandera e Información Completa)");
            System.out.println("2. Tabla de Posiciones (Ver y Modificar)");
            System.out.println("3. Calendario de Partidos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        menuBanderaEInformacion(sc);
                        break;
                    case 2:
                        menuTablaPosiciones(sc);
                        break;
                    case 3:
                        menuCalendario(sc);
                        break;
                    case 4:
                        System.out.println("\n¡Gracias por usar el Mega Sistema Mundial!");
                        break;
                    default:
                        System.out.println("Opción inválida. Ingrese un número entre 1 y 4.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Intente de nuevo.");
                sc.nextLine(); // Limpiar buffer
                opcion = 0;
            }
        } while (opcion != 4);

        sc.close();
    }

    // =========================================================================
    // 1. CARGA DE ARCHIVO CSV PARA BANDERAS
    // =========================================================================
    private static void cargarMatrizCSV() {
        try {
            BufferedReader archivo = new BufferedReader(new FileReader("recursos/Flags.csv"));
            String linea;
            int fila = 0;

            while ((linea = archivo.readLine()) != null && fila < matriz.length) {
                String[] columnas = linea.split(";");
                for (int columna = 0; columna < columnas.length && columna < matriz[fila].length; columna++) {
                    if (columnas[columna].length() > 0) {
                        matriz[fila][columna] = columnas[columna].charAt(0);
                    }
                }
                fila++;
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Aviso: No se pudo cargar 'recursos/Flags.csv'. Asegúrese de que existe la carpeta y el archivo.");
        }
    }

    // =========================================================================
    // 2. MÓDULO UNIFICADO: BANDERAS + FICHA TÉCNICA
    // =========================================================================
    private static void menuBanderaEInformacion(Scanner sc) {
        System.out.println("\n+------+---------------------------+");
        System.out.println("| Case | País                      |");
        System.out.println("+------+---------------------------+");
        for (int i = 0; i < PAISES.length; i++) {
            System.out.println("| " + (i + 1) + "\t| " + PAISES[i]);
        }
        System.out.println("+------+---------------------------+");
        System.out.print("Ingresa el número de bandera (1-48): ");
        int flag = sc.nextInt();

        if (flag < 1 || flag > 48) {
            System.out.println("Número fuera de rango.");
            return;
        }

        dibujarBandera(flag);
        mostrarInformacionPais(flag);
    }

    private static void dibujarBandera(int flag) {
        System.out.println("\n--------------------------------");
        System.out.println("BANDERA: " + PAISES[flag - 1].toUpperCase());
        System.out.println("--------------------------------");

        int filaInicio = 0;
        int filaFin = 0;

        switch (flag) {
            case 1:  filaInicio = 61;  filaFin = 70;  break;
            case 2:  filaInicio = 71;  filaFin = 80;  break;
            case 3:  filaInicio = 81;  filaFin = 90;  break;
            case 4:  filaInicio = 91;  filaFin = 100; break;
            case 5:  filaInicio = 271; filaFin = 280; break;
            case 6:  filaInicio = 101; filaFin = 110; break;
            case 7:  filaInicio = 111; filaFin = 120; break;
            case 8:  filaInicio = 121; filaFin = 130; break;
            case 9:  filaInicio = 341; filaFin = 350; break;
            case 10: filaInicio = 291; filaFin = 300; break;
            case 11: filaInicio = 321; filaFin = 330; break;
            case 12: filaInicio = 381; filaFin = 390; break;
            case 13: filaInicio = 301; filaFin = 310; break;
            case 14: filaInicio = 371; filaFin = 380; break;
            case 15: filaInicio = 131; filaFin = 140; break;
            case 16: filaInicio = 161; filaFin = 170; break;
            case 17: filaInicio = 191; filaFin = 200; break;
            case 18: filaInicio = 141; filaFin = 150; break;
            case 19: filaInicio = 181; filaFin = 190; break;
            case 20: filaInicio = 171; filaFin = 180; break;
            case 21: filaInicio = 151; filaFin = 160; break;
            case 22: filaInicio = 221; filaFin = 230; break;
            case 23: filaInicio = 241; filaFin = 250; break;
            case 24: filaInicio = 231; filaFin = 240; break;
            case 25: filaInicio = 211; filaFin = 220; break;
            case 26: filaInicio = 201; filaFin = 210; break;
            case 27: filaInicio = 251; filaFin = 260; break;
            case 28: filaInicio = 261; filaFin = 270; break;
            case 29: filaInicio = 11;  filaFin = 20;  break;
            case 30: filaInicio = 21;  filaFin = 30;  break;
            case 31: filaInicio = 1;   filaFin = 10;  break;
            case 32: filaInicio = 31;  filaFin = 40;  break;
            case 33: filaInicio = 41;  filaFin = 50;  break;
            case 34: filaInicio = 51;  filaFin = 60;  break;
            case 35: filaInicio = 281; filaFin = 290; break;
            case 36: filaInicio = 311; filaFin = 320; break;
            case 37: filaInicio = 351; filaFin = 360; break;
            case 38: filaInicio = 331; filaFin = 340; break;
            case 39: filaInicio = 391; filaFin = 400; break;
            case 40: filaInicio = 401; filaFin = 410; break;
            case 41: filaInicio = 361; filaFin = 370; break;
            case 42: filaInicio = 471; filaFin = 480; break;
            case 43: filaInicio = 411; filaFin = 420; break;
            case 44: filaInicio = 461; filaFin = 470; break;
            case 45: filaInicio = 431; filaFin = 440; break;
            case 46: filaInicio = 421; filaFin = 430; break;
            case 47: filaInicio = 441; filaFin = 450; break;
            case 48: filaInicio = 451; filaFin = 460; break;
        }

        for (int fila = filaInicio - 1; fila < filaFin; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                imprimirColor(matriz[fila][columna]);
            }
            System.out.println();
	}
  } 
        
    
	private static void imprimirColor(char c) {
        	if (c == '1') System.out.print(YELLOW_BACKGROUND + "   ");
        	if (c == '2') System.out.print(ORANGE_BACKGROUND + "   ");
        	if (c == '3') System.out.print(RED_BACKGROUND + "   ");
        	if (c == '4') System.out.print(PURPLE_BACKGROUND + "   ");
        	if (c == '5') System.out.print(BLUE_BACKGROUND + "   ");
        	if (c == '6') System.out.print(GREEN_BACKGROUND + "   ");
        	if (c == '7') System.out.print(WHITE_BACKGROUND + "   ");
        	if (c == '8') System.out.print(BLACK_BACKGROUND + "   ");
        	if (c == '9') System.out.print(BROWN_BACKGROUND + "   ");
        	System.out.print(RESET);
    }


       

    private static void mostrarInformacionPais(int num) {
        String pais = PAISES[num - 1];
        String capital = getCapital(num);
        int participaciones = getParticipacionesMundiales(num);
        String[] alineacion = getAlineacionTitular(num);

        System.out.println("\n==================================================");
        System.out.println("       FICHA TÉCNICA Y NÓMINA: " + pais.toUpperCase());
        System.out.println("==================================================");
        System.out.println("Capital                     : " + capital);
        System.out.println("Participaciones en Mundiales: " + participaciones + " ediciones");
        System.out.println("--------------------------------------------------");
        System.out.println("ALINEACIÓN TITULAR (11 JUGADORES ACTUALES):");
        for (int i = 0; i < alineacion.length; i++) {
            System.out.println("  " + (i + 1) + ". " + alineacion[i]);
        }
        System.out.println("==================================================");
    }

    private static String getCapital(int num) {
        String[] capitales = {
            "Londres", "Madrid", "París", "Praia", "Riad", "Seúl", "Kinhasa", "Quito", "Washington D.C.", "Buenos Aires", "Brasilia", "Ottawa", "Yamusukro", "Amán", "Berlín", "Tokio", "Bogotá", "Bruselas", "Ankara", "Pretoria", "Praga", "Berna", "Lisboa", "El Cairo", "Asunción", "Edimburgo", "Puerto Príncipe", "Argel", "Ciudad de Mexico", "Rabat", "Viena", "Oslo", "Sarajevo", "Tunez", "Zagreb", "Ámsterdam", "Montevideo", "Doha", "Canberra", "Wellington", "Dakar", "Acra", "Ciudad de Panamá", "Bagdad", "Estocolmo", "Willemstad", "Teherán", "Tashkent"
        };
        return capitales[num - 1];
    }

    private static int getParticipacionesMundiales(int num) {
        int[] participaciones = {
            17, 17, 17, 1, 7, 12, 2, 5, 12, 19, 23, 3, 11, 1, 21, 8, 7, 14, 3, 4, 10, 7, 7, 2, 5, 2, 1, 3, 18, 7, 8, 4, 2, 7, 7, 12, 15, 2, 7, 3, 4, 5, 2, 2, 13, 1, 7, 1
        };
        return participaciones[num - 1];
    }

    private static String[] getAlineacionTitular(int num) {
        switch (num) {
            case 1: // Inglaterra
                return new String[]{"Jordan Pickford", "Djed Spence", "Ezri Konsa", "Marc Guéhi", "Nico O'Riley", "Declan Rice", "Elliot Anderson", "Buyako Saka", "Jude Bellingham", "Anthony Gordon", "Harry Kane"};
            case 2: // España
                return new String[]{"Unai Simon", "Pedro Porro", "Pau Cubarsi", "Aymeric Laporte", "Marc Cucurella", "Rodri Hernandez", "Dani Olmo", "Fabián Ruiz", "Lamine Yamal", "Mikel Oyarzabal", "Álex Baena"};
            case 3: // Francia
                return new String[]{"Mike Maignan", "Jules Koundé", "Ibrahima Konaté", "Dayot Upamecano", "Theo Hernández", "Aurélien Tchuamení", "Adrien Rabiot", "Ousmane Dembélé", "Michael Olise", "Désiré Doué", "Kylian Mbappé"};
            case 4: // Cabo Verde
                return new String[]{"Vozinha", "Steven Moeira", "Roberto Lopes", "Diney", "Sidny Lopes Cabral", "Kevin Pina", "Laros Duarte", "Ryan Mendes", "Jamiro Monteiro", "Jovane Cabral", "Davilon Livramento"};
            case 5: // Arabia Saudita
                return new String[]{"Mohammed Al-Owais", "Abdulelah Alamri", "Saud Abdulhamid", "Moteb Al Harbi", "Hassan Altambakti", "Mohammed Abu Al Shamat", "Mohammed Kanno", "Abdullah Alkhaibari", "Salem Al Dawsari", "Firas Al Breikan", "Musab Al Juwayr"};
            case 6: // Corea del Sur
                return new String[]{"Kim Seung-gyu", "Seol Young-woo", "Kim Min-jae", "Cho Yu-min", "Lee Myung-jae", "Hwang In-beom", "Paik Seung-ho", "Lee Kang-in", "Lee Jae-sung", "Hwang Hee-chan", "Son Heung-min"};
            case 7: // Congo RD
                return new String[]{"Lionel Mpasi", "Aaron Wan-Bissaka", "Chancel Mbemba", "Axel Tuanzebe", "Joris Kayembe", "Samuel Moutoussamy", "Charles Pickel", "Edo Kayembe", "Yoane Wissa", "Cédric Bakambu", "Meschack Elia"};
            case 8: // Ecuador
                return new String[]{"Hernán Galíndez", "Ángelo Preciado", "Joel Ordóñez", "Willian Pacho", "Piero Hincapié", "Moisés Caicedo", "Pedro Vite", "John Yeboah", "Nilson Angulo", "Gonzalo Plata", "Enner Valencia"};
            case 9: // Estados Unidos
                return new String[]{"Matt Turner", "Joe Scally", "Chris Richards", "Tim Ream", "Antonee Robinson", "Weston McKennie", "Tyler Adams", "Yunus Musah", "Timothy Weah", "Folarin Balogun", "Christian Pulisic"};
            case 10: // Argentina
                return new String[]{"Emiliano Martinez", "Nahuel Molina", "Cristian  Romero", "Nicolás Otamendi", "Nicolás Tagliafico", "Rodrigo De Paul", "Enzo Fernández", "Alexis Mac Allister", "Lionel Messi", "Lautaro Martínez", "Julián Álvarez"};
            case 11: // Brasil
                return new String[]{"Alisson", "Danilo", "Marquinhos", "Gabriel Magalhães", "Guilherme Arana", "Bruno Guimarães", "Lucas Paquetá", "Rodrygo", "Raphinha", "Endrick", "Vinícius Jr."};
            case 12: // Canadá
                return new String[]{"Maxime Crépeau", "Alistair Johnston", "Moïse Bombito", "Derek Cornelius", "Alphonso Davies", "Jonathan Osorio", "Stephen Eustáquio", "Ismaël Koné", "Tajon Buchanan", "Jonathan David", "Cyle Larin"};
            case 13: // Costa de Marfil
                return new String[]{"Yahia Fofana", "Wilfried Singo", "Odilon Kossounou", "Evan Ndicka", "Ghislain Konan", "Franck Kessié", "Jean Michaël Seri", "Seko Fofana", "Simon Adingra", "Sébastien Haller", "Nicolas Pépé"};
            case 14: // Jordania
                return new String[]{"Yazan Al-Naimat", "Abdallah Nasib", "Yazan Al-Arab", "Salem Al-Ajalin", "Ehsan Haddad", "Nizar Al-Rashdan", "Noor Al-Rawabdeh", "Mahmoud Al-Mardi", "Mousa Al-Tamari", "Yazan Al-Naimat", "Ali Olwan"};
            case 15: // Alemania
                return new String[]{"Manuel Neuer", "Joshua Kimmich", "Jonathan Tah", "Antonio Rüdiger", "David Raum", "Felix Nmecha", "Aleksandar Pavlović", "Leroy Sané", "Jamal Musiala", "Florian Wirtz", "Kai Havertz"};
            case 16: // Japón
                return new String[]{"Zion Suzuki", "Hiroki Itō", "Kō Itakura", "Takehiro Tomiyasu", "Ritsu Dōan", "Daichi Kamada", "Kaishu Sano", "Keito Nakamura", "Takefusa Kubo", "Junya Itō", "Ayase Ueda"};
            case 17: // Colombia
                return new String[]{"Camilo Vargas", "Daniel Muñoz", "Dávinson Sánchez", "Jhon Lucumí", "Johan Mojica", "Jefferson Lerma", "Richard Ríos", "Jhon Arias", "James Rodríguez", "Luis Díaz", "Jhon Córdoba"};
            case 18: // Bélgica
                return new String[]{"Thibaut Courtois", "Timothy Castagne", "Brandon Mechele", "Arthur Theate", "Maxim De Cuyper", "Youri Tielemans", "Hans Vanaken", "Jérémy Doku", "Kevin De Bruyne", "Leandro Trossard", "Charles De Ketelaere"};
            case 19: // Turquía
                return new String[]{"Uğurcan Çakır", "Zeki Çelik", "Merih Demiral", "Abdülkerim Bardakcı", "Ferdi Kadıoğlu", "İsmail Yüksek", "Hakan Çalhanoğlu", "Orkun Kökçü", "Arda Güler", "Barış Alper Yılmaz", "Kenan Yıldız"};
            case 20: // Sudáfrica
                return new String[]{"Ronwen Williams", "Khuliso Mudau", "Thabiso Sesane", "Nkosinathi Mbokazi", "Aubrey Modiba", "Teboho Mokoena", "Sphephelo Sithole", "Thalente Mbatha", "Oswin Appollis", "Tshepang Moremi", "Lyle Foster"};
            case 21: // Chequia
                return new String[]{"Matěj Kovář", "Vladimír Coufal", "Štěpán Chaloupek", "Robin Hranáč", "Ladislav Krejčí", "Jaroslav Zelený", "Tomáš Souček", "Lukáš Provod", "Alexandr Sojka", "Pavel Šulc", "Patrik Schick"};
            case 22: // Suiza
                return new String[]{"Yann Sommer", "Silvan Widmer", "Manuel Akanji", "Fabian Schär", "Ricardo Rodríguez", "Granit Xhaka", "Remo Freuler", "Michel Aebischer", "Dan Ndoye", "Breel Embolo", "Ruben Vargas"};
            case 23: // Portugal
                return new String[]{"Diogo Costa", "Diogo Dalot", "Rúben Dias", "Pepe", "Nuno Mendes", "João Palhinha", "Vitinha", "Bruno Fernandes", "Bernardo Silva", "Cristiano Ronaldo", "Rafael Leão"};
            case 24: // Egipto
                return new String[]{"Mohamed El Shenawy", "Mohamed Hany", "Rami Rabia", "Mohamed Abdelmonem", "Mohamed Hamdy", "Marwan Attia", "Hamdy Fathi", "Zizo", "Mohamed Salah", "Mostafa Mohamed", "Trezeguet"};
            case 25: // Paraguay
                return new String[]{"Carlos Coronel", "Iván Ramírez", "Gustavo Gómez", "Omar Alderete", "Matías Espinoza", "Andrés Cubas", "Mathías Villasanti", "Damián Bobadilla", "Miguel Almirón", "Julio Enciso", "Alex Arce"};
            case 26: // Escocia
                return new String[]{"Angus Gunn", "Ralston Anthony", "Ryan Porteous", "Grant Hanley", "Kieran Tierney", "Andrew Robertson", "Billy Gilmour", "Callum McGregor", "Scott McTominay", "John McGinn", "Che Adams"};
            case 27: // Haití
                return new String[]{"Johny Placide", "Carlens Arcus", "Ricardo Adé", "Jean-Kévin Duverne", "Alex Christian", "Leverton Pierre", "Danley Jean Jacques", "Bryan Alceus", "Duckens Nazon", "Frantzdy Pierrot", "Louicius Don Deedson"};
            case 28: // Argelia
                return new String[]{"Amine Gouiri", "Anthony Mandrea", "Yousef Atal", "Aïssa Mandi", "Ramy Bensebaini", "Rayan Aït-Nouri", "Nabil Bentaleb", "Ismaël Bennacer", "Houssem Aouar", "Riyad Mahrez", "Baghdad Bounedjah"};
            case 29: // México
                return new String[]{"Luis Malagón", "Jorge Sánchez", "César Montes", "Johan Vásquez", "Jesús Gallardo", "Edson Álvarez", "Luis Chávez", "Erick Sánchez", "Hirving Lozano", "Julián Quiñones", "Santiago Giménez"};
            case 30: // Marruecos
                return new String[]{"Yassine Bounou", "Achraf Hakimi", "Nayef Aguerd", "Romain Saïss", "Noussair Mazraoui", "Sofyan Amrabat", "Azzedine Ounahi", "Brahim Díaz", "Hakim Ziyech", "Youssef En-Nesyri", "Sofiane Boufal"};
            case 31: // Austria
                return new String[]{"Alexander Schlager", "Stefan Posch", "Kevin Danso", "David Alaba", "Maximilian Wöber", "Nicolas Seiwald", "Xaver Schlager", "Marcel Sabitzer", "Christoph Baumgartner", "Michael Gregoritsch", "Marko Arnautović"};
            case 32: // Noruega
                return new String[]{"Ørjan Nyland", "Julian Ryerson", "Kristoffer Ajer", "Torbjørn Heggem", "David Møller Wolfe", "Sander Berge", "Patrick Berg", "Martin Ødegaard", "Alexander Sørloth", "Antonio Nusa", "Erling Haaland"};
            case 33: // Bosnia y Herzegovina
                return new String[]{"Nikola Vasilj", "Amar Dedić", "Dennis Hadžikadunić", "Tarik Muharemović", "Sead Kolašinac", "Benjamin Tahirović", "Armin Gigović", "Ivan Bašić", "Esmir Bajraktarević", "Ermedin Demirović", "Edin Džeko"};
            case 34: // Túnez
                return new String[]{"Aymen Dahmen", "Yan Valery", "Montassar Talbi", "Omar Rekik", "Ali Abdi", "Ellyes Skhiri", "Rani Khedira", "Hannibal Mejbri", "Elias Achouri", "Ismaël Gharbi", "Hazem Mastouri"};
            case 35: // Croacia
                return new String[]{"Dominik Livaković", "Josip Stanišić", "Josip Šutalo", "Joško Gvardiol", "Borna Sosa", "Luka Modrić", "Mateo Kovačić", "Petar Sučić", "Andrej Kramarić", "Ante Budimi", "Ivan Perišić"};
            case 36: // Países Bajos
                return new String[]{"Bart Verbruggen", "Denzel Dumfries", "Stefan de Vrij", "Virgil van Dijk", "Nathan Aké", "Jerdy Schouten", "Tijjani Reijnders", "Xavi Simons", "Jeremie Frimpong", "Memphis Depay", "Cody Gakpo"};
            case 37: // Uruguay
                return new String[]{"Sergio Rochet", "Nahitan Nández", "Ronald Araújo", "José María Giménez", "Mathías Olivera", "Manuel Ugarte", "Federico Valverde", "Rodrigo Bentancur", "Facundo Pellistri", "Darwin Núñez", "Maximiliano Araújo"};
            case 38: // Qatar
                return new String[]{"Meshaal Barsham", "Pedro Miguel", "Lucas Mendes", "Boualem Khoukh", "Tarek Salman", "Fatai Mohed", "Ahmed Fathy", "Jassem Gaber", "Hassan Al-Haydos", "Almoez Ali", "Akram Afif"};
            case 39: // Australia
                return new String[]{"Mathew Ryan", "Lewis Miller", "Harry Souttar", "Kye Rowles", "Aziz Behich", "Connor Metcalfe", "Jackson Irvine", "Aiden O'Neill", "Martin Boyle", "Kusini Yengi", "Craig Goodwin"};
            case 40: // Nueva Zelanda
                return new String[]{"Max Crocombe", "Tim Payne", "Tyler Bindon", "Nando Pijnaker", "Liberato Cacace", "Joe Bell", "Marko Stamenic", "Matthew Garbett", "Elijah Just", "Chris Wood", "Ben Old"};
            case 41: // Senegal
                return new String[]{"Édouard Mendy", "Formose Mendy", "Kalidou Koulibaly", "Moussa Niakhaté", "Ismail Jakobs", "Pape Matar Sarr", "Idrissa Gueye", "Lamine Camara", "Ismaïla Sarr", "Nicolas Jackson", "Sadio Mané"};
            case 42: // Ghana
                return new String[]{"Lawrence Ati-Zigi", "Alidu Seidu", "Alexander Djiku", "Mohammed Salisu", "Gideon Mensah", "Thomas Partey", "Salis Abdul Samed", "Mohammed Kudus", "Ernest Nuamah", "Iñaki Williams", "Jordan Ayew"};
            case 43: // Panamá
                return new String[]{"Orlando Mosquera", "Michael Amir Murillo", "Edgardo Fariña", "José Córdoba", "Roderick Miller", "Eric Davis", "Adalberto Carrasquilla", "Cristian Martínez", "Yoel Bárcenas", "José Fajardo", "José Luis Rodríguez"};
            case 44: // Irak
                return new String[]{"Jalal Hassan", "Hussein Ali", "Saad Natiq", "Rebin Sulaka", "Merchas Doski", "Amir Al-Ammari", "Osama Rashid", "Zidane Iqbal", "Ibrahim Bayesh", "Aymen Hussein", "Ali Jasim"};
            case 45: // Suecia
                return new String[]{"Viktor Johansson", "Emil Krafth", "Isak Hien", "Victor Lindelöf", "Ludwig Augustinsson", "Jens Cajuste", "Anton Salétros", "Dejan Kulusevski", "Alexander Isak", "Anthony Elanga", "Viktor Gyökeres"};
            case 46: // Curazao
                return new String[]{"Eloy Room", "Nathangelo Markelo", "Sherel Floranus", "Cuco Martina", "Jurien Gaari", "Vurnon Anita", "Juninho Bacuna", "Leandro Bacuna", "Brandley Kuwas", "Rangelo Janga", "Kenji Gorré"};
            case 47: // Irán
                return new String[]{"Alireza Beiranvand", "Ramin Rezaeian", "Hossein Kanaanizadegan", "Shojae Khalilzadeh", "Milad Mohammadi", "Saeid Ezatolahi", "Saman Ghoddos", "Ahmad Nourollahi", "Alireza Jahanbakhsh", "Mehdi Taremi", "Sardar Azmoun"};
            case 48: // Uzbekistán
                return new String[]{"Utkir Yusupov", "Husniddin Alikulov", "Abdukodir Khusanov", "Umar Eshmurodov", "Sherzod Nasrullaev", "Otabek Shukurov", "Odiljon Hamrobekov", "Azizbek Turgunboev,", "Jaloliddin Masharipov", "Abbasbek Fayzullaev", "Eldor Shomurodov"};
            default: 
                return new String[]{};
        }
    }

    // =========================================================================
    // 3. TABLA DE POSICIONES CON CONTROL LÓGICO ESTRICTO
    // =========================================================================
    private static void menuTablaPosiciones(Scanner sc) {
        int subOpc = 0;
        do {
            System.out.println("\n--- TABLA DE POSICIONES INTERACTIVA ---");
            System.out.println("1. Ver Tabla Completa");
            System.out.println("2. Registrar/Modificar Estadísticas de un País");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Opción: ");
            subOpc = sc.nextInt();

            if (subOpc == 1) {
                mostrarTabla();
            } else if (subOpc == 2) {
                modificarEstadisticas(sc);
            }
        } while (subOpc != 3);
    }

    private static void mostrarTabla() {
        System.out.println("\n+----+-------------------+----+----+----+----+----+----+----+-----+");
        System.out.println("| ID | País              | PJ | PG | PE | PP | GF | GC | DG | PTS |");
        System.out.println("+----+-------------------+----+----+----+----+----+----+----+-----+");
        for (int i = 0; i < 48; i++) {
            System.out.printf("| %2d | %-17s | %2d | %2d | %2d | %2d | %2d | %2d | %2d | %3d |\n",
                (i + 1), PAISES[i],
                tablaStats[i][0], tablaStats[i][1], tablaStats[i][2], tablaStats[i][3],
                tablaStats[i][4], tablaStats[i][5], tablaStats[i][6], tablaStats[i][7]);
        }
        System.out.println("+----+-------------------+----+----+----+----+----+----+----+-----+");
    }

    private static void modificarEstadisticas(Scanner sc) {
        System.out.print("Seleccione el ID del País a modificar (1-48): ");
        int id = sc.nextInt();
        if (id < 1 || id > 48) {
            System.out.println("ID fuera de rango.");
            return;
        }

        int index = id - 1;
        System.out.println("\nModificando datos para: " + PAISES[index]);
        System.out.print("Partidos Ganados (PG): ");
        int pg = sc.nextInt();
        System.out.print("Partidos Empatados (PE): ");
        int pe = sc.nextInt();
        System.out.print("Partidos Perdidos (PP): ");
        int pp = sc.nextInt();
        System.out.print("Goles a Favor (GF): ");
        int gf = sc.nextInt();
        System.out.print("Goles en Contra (GC): ");
        int gc = sc.nextInt();

        // VALIDACIONES LÓGICAS DE CONTROL DE ERRORES DEPORTIVOS
        if (pg < 0 || pe < 0 || pp < 0 || gf < 0 || gc < 0) {
            System.out.println("\n[ERROR LÓGICO] Ninguna estadística puede ser negativa.");
            return;
        }

        int pjCalculado = pg + pe + pp;
        if (pjCalculado > 3) {
            System.out.println("\n[ERROR LÓGICO] La suma de PG + PE + PP (" + pjCalculado + ") supera el límite de la fase de grupos (máximo 3 partidos).");
            return;
        }

        int dg = gf - gc;
        int pts = (pg * 3) + (pe * 1);

        tablaStats[index][0] = pjCalculado;
        tablaStats[index][1] = pg;
        tablaStats[index][2] = pe;
        tablaStats[index][3] = pp;
        tablaStats[index][4] = gf;
        tablaStats[index][5] = gc;
        tablaStats[index][6] = dg;
        tablaStats[index][7] = pts;

        System.out.println("\n¡Estadísticas actualizadas con éxito!");
    }

    // =========================================================================
    // 4. CALENDARIO DE PARTIDOS
    // =========================================================================
   
 private static void menuCalendario(Scanner sc) {
        System.out.println("\n=== CALENDARIO DE PARTIDOS DESTACADOS ===");
        System.out.println("1. Ver Calendario Completo por Fechas");
        System.out.println("2. Buscar Partidos por País");
        System.out.print("Opción: ");
        int opc = sc.nextInt();

        if (opc == 1) {
            System.out.println("\n--- FASE DE GRUPOS ---");
            System.out.println("[Fecha 1] 11 de Junio: México vs. Sudáfrica (Grupo A)");
            System.out.println("[Fecha 1] 12 de Junio: Estados Unidos vs. Paraguay (Grupo B)");
            System.out.println("[Fecha 1] 13 de Junio: España vs. Colombia (Grupo C)");
            System.out.println("[Fecha 1] 14 de Junio: Argentina vs. Arabia Saudita (Grupo D)");
            System.out.println("\n--- FASE ELIMINATORIA ---");
            System.out.println("[Dieciseisavos de Final] 28 de Junio al 3 de Julio");
            System.out.println("[Octavos de Final]       4 de Julio al 7 de Julio");
            System.out.println("[Cuartos de Final]      9 de Julio al 11 de Julio");
            System.out.println("[Semifinales]           14 y 15 de Julio");
            System.out.println("[GRAN FINAL]            19 de Julio");
        } else if (opc == 2) {
            System.out.print("Ingrese el número del país (1-48): ");
            int p = sc.nextInt();
            if (p >= 1 && p <= 48) {
                System.out.println("\nPróximo partido programado para " + PAISES[p - 1] + ":");
                System.out.println("-> " + PAISES[p - 1] + " vs. " + PAISES[(p % 48)] + " - Estadio Principal");
            } else {
                System.out.println("País inválido.");
            }
        }
}

    private static void mostrarAsciiArt() {
        System.out.println("  __  __ _____ ____    __  __ _    _ _   _ _____ ___  _      ");
        System.out.println(" |  \\/  | ____/ ___|  |  \\/  | |  | | \\ | | ____/ _ \\| |     ");
        System.out.println(" | |\\/| |  _| \\___ \\  | |\\/| | |  | |  \\| |  _| | | | | |     ");
        System.out.println(" | |  | | |___ ___) | | |  | | |__| | |\\  | |___| |_| | |___  ");
        System.out.println(" |_|  |_|_____|____/  |_|  |_|\\____/|_| \\_|_____|\\___/|_____| ");
        System.out.println("===============================================================");
    }
}
