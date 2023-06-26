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

    public Pedido findPedidoByCliente(String nombre){
        String jpql = "SELECT P FROM Pedido AS P WHERE P.cliente.nombre=:nombre";
        return entityManager.createQuery(jpql, Pedido.class).setParameter("nombre", nombre).getSingleResult();
//        return entityManager.find(Pedido.class, id);
    }


}
