import java.util.List;

public class PacienteProxy implements IPaciente {
    private Paciente paciente;
    private int cpf;

    public PacienteProxy(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public List<String> obterHistoricoConsultas() {
        if (this.paciente == null) {
            this.paciente = new Paciente(this.cpf);
        }
        return this.paciente.obterHistoricoConsultas();
    }

    @Override
    public List<String> obterDiagnosticoMedico(Funcionario funcionario) {
        if (!funcionario.isMedico()) {
            throw new IllegalArgumentException("Acesso negado.");
        }
        if (this.paciente == null) {
            this.paciente = new Paciente(this.cpf);
        }
        return this.paciente.obterDiagnosticoMedico(funcionario);
    }
}
