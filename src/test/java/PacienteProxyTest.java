import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteProxyTest {

    @BeforeEach
    void setUp() {
        DataBase.addPaciente(
                new Paciente(212922111,
                        "Mary",
                        "24992323212",
                        "Premium",
                        List.of("Consulta Nutricionista - 24/03/2023", "Consulta Psicologo - 12/03/2023"),
                        List.of("Dieta para melhorar a alimentação...", "Realizar teste para verificar...")));
    }

    @Test
    void deveRetornarHistoricoDeConsultasDoPaciente() {
        PacienteProxy paciente = new PacienteProxy(212922111);
        paciente.obterHistoricoConsultas();

        assertEquals(List.of("Consulta Nutricionista - 24/03/2023", "Consulta Psicologo - 12/03/2023"),
                paciente.obterHistoricoConsultas());
    }

    @Test
    void deveRetornarDiagnosticoMedicoDoPaciente() {
        Funcionario funcionario = new Funcionario("Peter", true);
        PacienteProxy paciente = new PacienteProxy(212922111);
        paciente.obterDiagnosticoMedico(funcionario);

        assertEquals(List.of("Dieta para melhorar a alimentação...", "Realizar teste para verificar..."),
                paciente.obterDiagnosticoMedico(funcionario));
    }

    @Test
    void deveLancarExcecaoQuandoFuncionarioNaoAutorizadoConsultarDiagnosticoMedico() {
        try {
            Funcionario funcionario = new Funcionario("Marcia", false);
            PacienteProxy paciente = new PacienteProxy(212922111);
            paciente.obterDiagnosticoMedico(funcionario);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Acesso negado.", e.getMessage());
        }
    }
}