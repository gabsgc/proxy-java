import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<Integer, Paciente> pacientes = new HashMap<>();

    public static Paciente getPaciente(Integer cpf) {
        return pacientes.get(cpf);
    }

    public static void addPaciente(Paciente paciente) {
        pacientes.put(paciente.getCpf(), paciente);
    }
}
