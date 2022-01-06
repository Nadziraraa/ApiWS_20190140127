/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.jajan.c.ws.jajan.ass;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ws.jajan.c.ws.jajan.ass.exceptions.NonexistentEntityException;

/**
 *
 * @author asus
 */
public class BungaJpaController implements Serializable {

    public BungaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ws.jajan.c_ws.jajan.ass_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BungaJpaController() {
    }
    
    

    public void create(Bunga bunga) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bunga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bunga bunga) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bunga = em.merge(bunga);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bunga.getId();
                if (findBunga(id) == null) {
                    throw new NonexistentEntityException("The bunga with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bunga bunga;
            try {
                bunga = em.getReference(Bunga.class, id);
                bunga.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bunga with id " + id + " no longer exists.", enfe);
            }
            em.remove(bunga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bunga> findBungaEntities() {
        return findBungaEntities(true, -1, -1);
    }

    public List<Bunga> findBungaEntities(int maxResults, int firstResult) {
        return findBungaEntities(false, maxResults, firstResult);
    }

    private List<Bunga> findBungaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bunga.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Bunga findBunga(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bunga.class, id);
        } finally {
            em.close();
        }
    }

    public int getBungaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bunga> rt = cq.from(Bunga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
