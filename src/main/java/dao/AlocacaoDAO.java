/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import model.Alocacao;

/**
 *
 * @author renahn.sebem
 */
public class AlocacaoDAO extends PersistenciaJPA{
    public List<Alocacao> listaAlocacao() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Alocacao> query
                    = em.createQuery("SELECT v FROM Alocacao v", Alocacao.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}