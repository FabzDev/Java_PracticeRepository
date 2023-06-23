package DAO;

import modelo.Pedido;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDAO {
    EntityManager entityManager;

    public PedidoDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void guardar(Pedido pedido){

        entityManager.persist(pedido);
    }

    public Pedido findPedidoById(Long id){
        return entityManager.find(Pedido.class, id);
    }

    public List<Pedido> findAll(){
        String jpql = "SELECT P FROM Pedido AS P";
        return entityManager.createQuery(jpql, Pedido.class).getResultList();
    }

}
