/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author paula
 */
@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;
    
    @Column(length = 50, nullable = false)
    private String nome;
    
    @Column(length = 20)
    private String cpf;
    
    @Enumerated(EnumType.STRING)
    private TipoFuncionario tipo;
    
    @Enumerated(EnumType.STRING)
    private Departamento departamento;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Ferias> ferias = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<HorarioTrabalho> horariosTrabalho = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<RegistroPonto> registrosPonto = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TipoFuncionario tipo) {
        this.tipo = tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Ferias> getFerias() {
        return ferias;
    }

    public List<HorarioTrabalho> getHorariosTrabalho() {
        return horariosTrabalho;
    }


    public List<RegistroPonto> getRegistrosPonto() {
        return registrosPonto;
    }
}
