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
        registrarProductoBase();

        EntityManager em = JPAUtils.getEntityManager();

        ProductoDAO productoDAO = new ProductoDAO(em);
//        CategoriaDAO categoriaDAO = new CategoriaDAO(em);
        PedidoDAO pedidoDAO = new PedidoDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();

        Producto producto = productoDAO.findProductById(Long.valueOf(1));
        Cliente cliente = new Cliente("Fabio Escobar", "1140829342");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarItems(new ItemsPedido(5, producto, pedido));
        pedido.agregarItems(new ItemsPedido(8, producto, pedido));

        pedidoDAO.guardar(pedido);
        clienteDAO.guardar(cliente);
        System.out.println(pedidoDAO.findPedidoByCliente("Fabio Escobar").getCliente().getNombre());

        em.getTransaction().commit();
        em.close();

    }

    private static void registrarProductoBase() {
        Categoria categoria1 = new Categoria("CELULARES");
        Producto producto1 = new Producto("Xiaomi Redmi", "Bandas abiertas", new BigDecimal(800), categoria1);

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
