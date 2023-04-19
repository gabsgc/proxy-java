import java.util.List;

public class Paciente implements IPaciente {
    private Integer cpf;
    private String nome;
    private String telefone;
    private String plano;
    private List<String> consultas;
    private List<String> diagnosticos;

    public Paciente(Integer cpf) {
        this.cpf = cpf;
        Paciente objeto = DataBase.getPaciente(cpf);
        this.nome = objeto.nome;
        this.telefone = objeto.telefone;
        this.plano = objeto.plano;
        this.consultas = objeto.consultas;
        this.diagnosticos = objeto.diagnosticos;
    }

    public Paciente(Integer cpf, String nome, String telefone, String plano, List<String> consultas,
                    List<String> diagnosticos) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.plano = plano;
        this.consultas = consultas;
        this.diagnosticos = diagnosticos;
    }

    public Integer getCpf() {
        return cpf;
    }

    @Override
    public List<String> obterHistoricoConsultas() {
        return consultas;
    }

    @Override
    public List<String> obterDiagnosticoMedico(Funcionario funcionario) {
        return diagnosticos;
    }
}
