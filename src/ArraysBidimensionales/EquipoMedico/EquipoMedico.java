package ArraysBidimensionales.EquipoMedico;

public class EquipoMedico {
    private final static String[] EMPLEADOS = {
            "vsd,Manuel,García,55,Fisioterapeuta,si",
            "wlp,Luis,Suárez,29,Nutricionista,B",
            "pnd,María,López,35,Médico,6",
            "plr,Alberto,López,47,Fisioterapeuta,no",
            "rmz,Andrea,Rodríguez,26,Nutricionista,A",
            "htq,Arturo,Velázquez,32,Fisioterapeuta,no"
    };
    public static Empleado[] empleados;
    public static int pos;

    public EquipoMedico() {
        empleados = new Empleado[EMPLEADOS.length];
        pos = 0;

        for (String empleado : EMPLEADOS) {
            String[] datos = empleado.split(",");
            String codigo = datos[0];
            String nombre = datos[1];
            String apellido = datos[2];
            int edad = Integer.parseInt(datos[3]);
            String rol = datos[4];

            switch (rol) {
                case "Nutricionista" -> {
                    char categoria = datos[5].charAt(0);
                    empleados[pos] = new Nutricionista(codigo, nombre, apellido, edad, rol, categoria);
                    pos++;
                }
                case "Fisioterapeuta" -> {
                    boolean internacional = Boolean.parseBoolean(datos[5]);
                    empleados[pos] = new Fisioterapeuta(codigo, nombre, apellido, edad, rol, internacional);
                    pos++;
                }
                case "Médico" -> {
                    int aniosExperiencia = Integer.parseInt(datos[5]);
                    empleados[pos] = new Medico(codigo, nombre, apellido, edad, rol, aniosExperiencia);
                    pos++;
                }
                default -> System.out.println("Rol de empleado no identificado " + rol);
            }
        }
    }

    public String[][] horarioSemanal() {
        DiasSemana[] diasSemana = DiasSemana.values();
        Turnos[] turnos = Turnos.values();
        String[][] horario = new String[turnos.length][diasSemana.length];

        for (Empleado empleado : empleados) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 7; j++) {
                    if (empleado.getHorarioLaboral()[i][j].equals("x")) {
                        horario[i][j] = "x";
                    }
                }
            }
        }
        return horario;
    }

    public boolean trabajar(String codigo, DiasSemana dia, Turnos turno) {
        for (int i = 0; i < pos; i++) {
            if (empleados[i].getCodigo().equals(codigo)) {
                empleados[i].trabajar(dia, turno);
                return true;
            }
        }
        return false;
    }

    public int horasSemana(String codigo) {
        for (Empleado empleado : empleados) {
            if (empleado.getCodigo().equals(codigo)) {
                return empleado.horasSemana();
            }
        }
        return -1;
    }

    public static void imprimirMatriz(String codigo) {
        char[] dias = new char[]{'L', 'M', 'X', 'J', 'V', 'S', 'D'};
        char[] turno = new char[]{'m', 't', 'n'};
        for (int i = 0; i < dias.length; i++) {
            System.out.print("\t" + dias[i]);
        }
        System.out.println();

        for (int i = 0; i < turno.length; i++) {
            System.out.println(turno[i] + "\t");
        }
        for (int i = 0; i < pos; i++) {
            if (codigo.equals(empleados[i].getCodigo())) {
                for (int f = 0; f < empleados[i].getHorarioLaboral().length; f++) {
                    for (int columna = 0; columna < empleados[i].getHorarioLaboral()[f].length; columna++) {

                        System.out.print(empleados[i].getHorarioLaboral()[f][columna] = "x");
                    }
                    System.out.println();
                }
            }
        }


    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("-------------- Equipo Médico----------------------\n");
        for (int i = 0; i < empleados.length; i++) {
            sb.append("EMPLEADO NÚMERO ").append(i + 1).append(empleados[i]).append("\n").append("\n");

        }
        sb.append("---------------------------------------------------");
        return sb.toString();
    }
}
