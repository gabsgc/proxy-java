import java.util.List;

public interface IPaciente {
    List<String> obterHistoricoConsultas();
    List<String> obterDiagnosticoMedico(Funcionario funcionario);
}
