/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author paula
 */
@Entity
@Table(name = "tb_horariotrab")
public class HorarioTrabalho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
@CollectionTable(
    name = "horario_trabalho_dias", 
    joinColumns = @JoinColumn(name = "horariotrabalho_id")
)
@Column(name = "dia_semana")
private List<String> diasSemana;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fim", nullable = false)
    private LocalTime horaFim;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(List<String> diasSemana) {
        this.diasSemana = diasSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        if (this.funcionario != null) {
            return "Funcionário: " + this.funcionario.getNome()
                    + " | Dias: " + String.join(", ", this.diasSemana)
                    + " | Entrada: " + this.horaInicio
                    + " | Saída: " + this.horaFim;
        } else {
            return "Funcionário não disponível | Dias: " + String.join(", ", this.diasSemana)
                    + " | Entrada: " + this.horaInicio
                    + " | Saída: " + this.horaFim;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diasSemana, horaInicio, horaFim, funcionario);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final HorarioTrabalho other = (HorarioTrabalho) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.diasSemana, other.diasSemana)
                && Objects.equals(this.horaInicio, other.horaInicio)
                && Objects.equals(this.horaFim, other.horaFim)
                && Objects.equals(this.funcionario, other.funcionario);
    }

}
