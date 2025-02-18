
import com.mycompany.projetolpooe1_paulalondero.dao.PersistenciaJPA;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import javax.persistence.EntityManager;
import modelo.Departamento;
import modelo.Ferias;
import modelo.Funcionario;
import modelo.HorarioTrabalho;
import static modelo.HorarioTrabalho_.funcionario;
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
         
        
        Funcionario f = new Funcionario();
        f.setMatricula("1234567");
        f.setNome("Paula Londero");
        f.setCpf("123.456.789-00");
        f.setTipo(TipoFuncionario.DOCENTE);
        f.setDepartamento(Departamento.DOCENCIA);
        
        HorarioTrabalho h = new HorarioTrabalho();
        //h.setFuncionario(funcionario);  // Certifique-se de que o funcionário não é null
        h.setHoraInicio(LocalTime.of(8, 0));
        h.setHoraFim(LocalTime.of(17, 0));
        h.setDiasSemana(Arrays.asList("Segunda-feira", "Terça-feira"));

        Ferias a = new Ferias();
        a.setInicio(new Date());
        a.setFim(new Date());

      
        RegistroPonto r = new RegistroPonto();

        // Definir a data e hora com LocalDateTime
        Date dataHora = new Date(); // Pega a data e hora atual
        
        // Caso queira definir uma hora específica como "08:30", use um formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horaString = "08:30";
        /*LocalDateTime dataHoraComHoraEspecifica = dataHora.withHour(Integer.parseInt(horaString.substring(0, 2)))
                                                         .withMinute(Integer.parseInt(horaString.substring(3, 5)));

        // Atribuindo a data e hora ao objeto
        r.setDataHora(dataHoraComHoraEspecifica);*/
        

        try{
            jpa.persist(a);
            jpa.persist(h);
            jpa.persist(r); 
            jpa.persist(f); 
            
            jpa.remover(f);
            
        } catch(Exception e){
            System.err.println("Erro ao persistir funcionário: "+h);
        }
    }
    
}