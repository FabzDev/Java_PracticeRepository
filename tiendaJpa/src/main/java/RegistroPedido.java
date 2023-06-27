import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProductoDAO;
import modelo.*;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroPedido {
    public static void main(String[] args) {
        registrarProductoBase("Xiaomi Redmi", "Bandas abiertas", 800);
        registrarProductoBase("Iphone 13", "Reacondicionado", 1500);
        registrarProductoBase("Samsung S23", "Original de fábrica", 1400);

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(em);
//        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();

        Producto producto1 = productoDAO.findProductById(Long.valueOf(1));
        Producto producto2 = productoDAO.findProductById(Long.valueOf(2));
        Producto producto3 = productoDAO.findProductById(Long.valueOf(3));
        Cliente cliente = new Cliente("Fabio Escobar", "1140829342");
        Pedido pedido = new Pedido(cliente);
        Pedido pedido2 = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5, producto1, pedido));
        pedido.agregarItems(new ItemsPedido(8, producto2, pedido));
        pedido2.agregarItems(new ItemsPedido(4, producto3, pedido2));

        pedidoDAO.guardar(pedido);
        pedidoDAO.guardar(pedido2);
        clienteDAO.guardar(cliente);
        System.out.println(pedidoDAO.findPedidoExpensive() + "------------------------------------------");

        em.getTransaction().commit();
        em.close();

    }

    private static void registrarProductoBase(String prod, String desc, int price) {
        Categoria categoria1 = new Categoria("CELULARES");
        Producto producto1 = new Producto(prod, desc, new BigDecimal(price), categoria1);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDAO.guardar(categoria1);
        productoDAO.guardar(producto1);
        em.getTransaction().commit();
        em.close();
    }
}
