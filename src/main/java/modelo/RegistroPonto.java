/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "tb_registroponto")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RegistroPonto implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;
    
     private Date dataHora;
    
        
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;
    
    public RegistroPonto() {
    this.funcionario = null;
    this.dataHora = new Date();
}

public RegistroPonto(Funcionario funcionario, Date dataHora) {
    this.funcionario = funcionario;
    this.dataHora = dataHora;
}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }


    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    @Override
    public String toString() {
    // Definindo o formato para data e hora
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    // Formatando a dataHora e retornando a string com o nome do funcionário
    return funcionario.getNome() + " - " + sdf.format(dataHora);
    }
    
}
