package DAO;

import modelo.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {
    EntityManager entityManager;

    public ClienteDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void guardar(Cliente cliente){
        entityManager.persist(cliente);
    }

    public Cliente findProductById(Long id){
        return entityManager.find(Cliente.class, id);
    }

    public List<Cliente> findAll(){
        String jpql = "SELECT C FROM Cliente AS C";
        return entityManager.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> findByName(String nombre){
        String jpql = "SELECT C FROM Cliente AS C WHERE C.nombre=:nombre";
        return entityManager.createQuery(jpql, Cliente.class).setParameter("nombre", nombre).getResultList();
    }

    public Cliente findByDni(String dni) {
        String jpql = "SELECT C.dni FROM Cliente AS C WHERE C.dni=:dni";
        return entityManager.createQuery(jpql, Cliente.class).setParameter("dni", dni).getSingleResult();
    }
}
