public class Funcionario {
    private String nome;
    private Boolean medico;

    public Funcionario(String nome, Boolean medico) {
        this.nome = nome;
        this.medico = medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean isMedico() {
        return medico;
    }

    public void setMedico(Boolean medico) {
        this.medico = medico;
    }
}
