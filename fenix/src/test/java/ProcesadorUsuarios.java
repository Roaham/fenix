import java.util.List;

/**
 * Procesa y clasifica una lista de usuarios según sus roles.
 * Separa a los usuarios en categorías de Administradores e Invitados basándose en un formato de cadena de texto específico.
 * * @author Roaham
 * @version 1.0
 */

public class ProcesadorUsuarios {

/**
 * Procesa una lista de cadenas (listas, parecidas a las de python) con formato "nombre:rol" y devuelve un resumen.
 * <p>
 * Los roles permitidos son:
 * <ul>
 * <li>1: Administradores</li>
 * <li>2: Invitados</li>
 * </ul>
 *
 * @param usuarios Lista de strings donde cada elemento sigue el formato "nombre:ID_ROL".
 * @return Una cadena con los nombres de los administradores e invitados.
 */

    public String procesarLista(List<String> dataList) {
        String admins = "";
        String invitados = "";

        for (String u : dataList) {
            String[] parts = u.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String n = parts[0];
                int r = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (r == 1) {
                    admins = procesarAdmin(admins, n);
                }
                // Número Mágico: 2 es Invitado
                else if (r == 2) {
                    invitados = procesarInvitado(invitados, n);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

/**
 * Añade un nombre a la cadena acumulada de administradores.
 * @param nombre Nombre del administrador a añadir.
 */

    private String procesarAdmin(String admins, String n) {
        admins += n + ",";
        return admins;
    }

/**
 * Añade un nombre a la cadena acumulada de invitados.
 * @param nombre Nombre del invitado a añadir.
 */

    private String procesarInvitado(String invitados, String n) {
        invitados += n + ",";
        return invitados;
    }
}