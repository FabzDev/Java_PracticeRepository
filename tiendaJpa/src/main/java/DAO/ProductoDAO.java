package DAO;

import modelo.Producto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductoDAO {
    EntityManager entityManager;

    public ProductoDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void guardar(Producto producto){
        entityManager.persist(producto);
    }

    public Producto findProductById(Long id){
        return entityManager.find(Producto.class, id);
    }

    public List<Producto> findAll(){
        String jpql = "SELECT P FROM Producto AS P";
        return entityManager.createQuery(jpql, Producto.class).getResultList();
    }

    public List<Producto> findByName(String nombre){
        String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
        return entityManager.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Producto> findByCategoria(String categoriaNombre){
        String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.nombre=:categoriaNombre";
        return entityManager.createQuery(jpql, Producto.class).setParameter("categoriaNombre", categoriaNombre).getResultList();
    }

    public BigDecimal findPriceByProductName(String productName) {
//        String jpql = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:productName";
        return entityManager.createNamedQuery("findByPrice", BigDecimal.class).setParameter("productName", productName).getSingleResult();
    }
}
