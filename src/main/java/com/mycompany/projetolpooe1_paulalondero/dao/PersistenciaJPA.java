/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetolpooe1_paulalondero.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.Departamento;
import modelo.Ferias;
import modelo.Funcionario;
import modelo.RegistroPonto;
import modelo.TipoFuncionario;
/**
 *
 * @author paula
 */
public class PersistenciaJPA implements InterfaceBD{
  EntityManager entity;
    EntityManagerFactory factory;
    
    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory
                = Persistence.createEntityManagerFactory("pu_ProjetoLPOOE1_PaulaLondero");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {

        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        entity.close();
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Anexa o objeto ao contexto de persistência, se necessário
            }
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao persistir a entidade: " + o.getClass().getSimpleName(), e);
            e.printStackTrace(); // Isso imprimirá o erro completo no console
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o); // Garantir que o objeto está no contexto de persistência
            }
            entity.remove(o); // Remover o objeto
            entity.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover entidade: " + o.getClass().getSimpleName());
            e.printStackTrace();
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    /*
    Todos os métodos agora chamam getEntityManager() 
    para garantir que o EntityManager esteja sempre aberto e 
    pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }
    
    public List<Funcionario> getFuncionarios() {
        entity = getEntityManager();

        try {
            TypedQuery<Funcionario> query
                    = entity.createQuery("Select f from Funcionario f", Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionários: " + e);
            return null;
        }

    }

    public List<Funcionario> getFuncionarios(Departamento departamentoSelecionado) {
        entity = getEntityManager();

        try {
            TypedQuery<Funcionario> query
                    = entity.createQuery("Select f from Funcionario f where f.departamento = '"
                            + departamentoSelecionado + "'",
                            Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionários: " + e);
            return null;
        }

    }

    public List<Funcionario> getFuncionarios(String nome) {
        entity = getEntityManager();

        try {
            TypedQuery<Funcionario> query
                    = entity.createQuery("Select f from Funcionario f where lower(f.nome) LIKE :n",
                            Funcionario.class);
            query.setParameter("n", "%" + nome.toLowerCase() + "%");
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionários: " + e);
            return null;
        }

    }
    
    public List<Funcionario> getFuncionarios(TipoFuncionario tipoSelecionado) {
        entity = getEntityManager();

        try {
            TypedQuery<Funcionario> query
                    = entity.createQuery("Select f from Funcionario f where f.tipo = '"
                            + tipoSelecionado + "'",
                            Funcionario.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionários: " + e);
            return null;
        }

    }
    
    //férias
    public List<Ferias> getFerias() {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<Ferias> query = em.createQuery("SELECT a FROM Ferias a ORDER BY a.inicio DESC", Ferias.class);
        return query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

   
    public Funcionario buscarFuncionarioPorMatriculaESenha(String matricula, String senha) {
    // Implementação da consulta ao banco de dados para buscar o funcionário
    // com base na matrícula e senha fornecidas
    try {
        // Usando o EntityManager de um método ou variável já existente
        String query = "SELECT f FROM Funcionario f WHERE f.matricula = :matricula AND f.senha = :senha";
        return getEntityManager().createQuery(query, Funcionario.class)
                .setParameter("matricula", matricula)
                .setParameter("senha", senha)
                .getSingleResult();
    } catch (Exception e) {
        return null; // Caso não encontre o funcionário ou ocorra algum erro
    }
}
    
    
    public void salvar(RegistroPonto ponto) {
        try {
            entity.getTransaction().begin(); // Inicia a transação
            entity.persist(ponto); // Salva o objeto ponto
            entity.getTransaction().commit(); // Confirma a transação
        } catch (Exception e) {
            entity.getTransaction().rollback(); // Se houver erro, faz o rollback
            e.printStackTrace();
        }
    }

    
    
    public List<RegistroPonto> buscarTodosPontos() {
    try {
        String query = "SELECT r FROM RegistroPonto r";
        return entity.createQuery(query, RegistroPonto.class).getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

public List<RegistroPonto> buscarPontosPorNome(String nome) {
    try {
        String query = "SELECT r FROM RegistroPonto r JOIN r.funcionario f WHERE f.nome LIKE :nome";
        return entity.createQuery(query, RegistroPonto.class)
                 .setParameter("nome", "%" + nome + "%")
                 .getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

public List<RegistroPonto> buscarPontosPorMatricula(String matricula) {
    try {
        String query = "SELECT r FROM RegistroPonto r JOIN r.funcionario f WHERE f.matricula LIKE :matricula";
        return entity.createQuery(query, RegistroPonto.class)
                 .setParameter("matricula", "%" + matricula + "%")
                 .getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

public void removerPonto(RegistroPonto ponto) {
    try {
        entity.getTransaction().begin();
        entity.remove(entity.contains(ponto) ? ponto : entity.merge(ponto));
        entity.getTransaction().commit();
    } catch (Exception e) {
        entity.getTransaction().rollback();
        e.printStackTrace();
    }
}

    public List<RegistroPonto> getPontos() {
    try {
        String query = "SELECT r FROM RegistroPonto r"; // Consulta para obter todos os pontos
        return entity.createQuery(query, RegistroPonto.class).getResultList(); // Executa a consulta e retorna a lista
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>(); // Retorna uma lista vazia em caso de erro
    }
}


   

}
