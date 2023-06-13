package DAO;

import modelo.Producto;

import javax.persistence.EntityManager;

public class ProductoDAO {
    EntityManager entityManager;

    public ProductoDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void guardar(Producto producto){
        entityManager.persist(producto);
    }
}
