/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import model.Impressora;
import model.Manutencao;


/**
 *
 * @author renahn.sebem
 */
public class ManutencaoDAO  extends PersistenciaJPA{
    public List<Manutencao> listaManutencao() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Manutencao> query
                    = em.createQuery("SELECT v FROM Manutencao v", Manutencao.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void finalizarManutencao(Impressora impressora) {
    try {
        // Busca a manutenção ABERTA (dataRetorno is null) para esta impressora
        String hql = "FROM Manutencao m WHERE m.impressora.id = :idImp AND m.dataRetorno IS NULL";
        
        Manutencao manu = (Manutencao) getEntityManager()
                .createQuery(hql)
                .setParameter("idImp", impressora.getId())
                .getSingleResult();

        if (manu != null) {
            manu.setDataRetorno(java.time.LocalDate.now());
            merge(manu); 
        }
    } catch (Exception e) {
        System.out.println("Nenhuma manutenção pendente encontrada ou erro: " + e.getMessage());
    }
}
    public void merge(Object objeto) {
    EntityManager em = getEntityManager();
    try {
        em.getTransaction().begin();
       
        em.merge(objeto); 
        
        em.getTransaction().commit();
    } catch (Exception e) {
        em.getTransaction().rollback();
        throw e; // Repassa o erro pra tela tratar
    } finally {
        if (em.isOpen()) {
            em.close();
        }
    }
}
    
}