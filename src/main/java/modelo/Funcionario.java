/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author paula
 */
@Entity
@Table(name = "tb_funcionario")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Funcionario implements Serializable{
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int id;
    
    @Column(length = 7, nullable = false)
    private String matricula;
    
    @Column(length = 50, nullable = false)
    private String nome;
    
    @Column(length = 20)
    private String cpf;
    
    @Column(length = 20)
    private String senha;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private TipoFuncionario tipo;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private Departamento departamento;
    
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Ferias> listaFerias;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<HorarioTrabalho> listaHorarios;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<RegistroPonto> listaPonto;
    
    
    // Construtor, getters, setters
    public Funcionario(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    
    
    
    
    public Funcionario() {
        listaFerias = new ArrayList<>();
        listaHorarios = new ArrayList<>();
        listaPonto = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
    this.matricula = matricula;
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
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    
    public void addFerias(Ferias ferias){
        listaFerias.add(ferias);
    }

    public List<Ferias> getListaFerias() {
        return listaFerias;
    }
    
    public void addHorarios(HorarioTrabalho horarios){
        listaHorarios.add(horarios);
    }

    public List<HorarioTrabalho> getHorarios() {
        return listaHorarios;
    }
    
    public void addPonto(RegistroPonto ponto){
        listaPonto.add(ponto);
    }

    public List<RegistroPonto> getPonto() {
        return listaPonto;
    }
    
    @Override
    public String toString() {
        return nome+" ("+departamento+")";
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.nome, other.nome);
    }

    
}
