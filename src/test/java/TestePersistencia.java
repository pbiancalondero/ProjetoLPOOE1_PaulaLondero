
import com.mycompany.projetolpooe1_paulalondero.dao.PersistenciaJPA;
import java.util.Date;
import modelo.Departamento;
import modelo.Ferias;
import modelo.Funcionario;
import modelo.HorarioTrabalho;
import modelo.RegistroPonto;
import modelo.TipoFuncionario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author paula
 */
public class TestePersistencia {
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestePersistencia() {
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    
    @Test
    public void testePersistencia() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Paula Londero");
        funcionario.setCpf("123.456.789-00");
        funcionario.setTipo(TipoFuncionario.DOCENTE);
        funcionario.setDepartamento(Departamento.DOCENCIA);

        Ferias ferias = new Ferias();
        ferias.setInicio(new Date());
        ferias.setFim(new Date());
        ferias.setFuncionario(funcionario);
        funcionario.getFerias().add(ferias);

        HorarioTrabalho horario = new HorarioTrabalho();
        horario.setDiasSemana("Segunda a Sexta");
        horario.setHoraInicio("08:00");
        horario.setHoraFim("17:00");
        horario.setFuncionario(funcionario);
        funcionario.getHorariosTrabalho().add(horario);

        RegistroPonto registro = new RegistroPonto();
        registro.setData(new Date());
        registro.setHora("08:30");
        registro.setFuncionario(funcionario);
        funcionario.getRegistrosPonto().add(registro);

        try {
            jpa.persist(funcionario);
        } catch (Exception e) {
            System.err.println("Erro ao persistir funcionário: " + e.getMessage());
        }
    }
}