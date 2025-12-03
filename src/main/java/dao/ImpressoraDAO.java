package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import model.Impressora; 

public class ImpressoraDAO extends PersistenciaJPA{
    public List<Impressora> listaImpressora() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Impressora> query
                    = em.createQuery("SELECT v FROM Impressora v", Impressora.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
        throw e; 
    } finally {
        if (em.isOpen()) {
            em.close();
        }
    }
}
}