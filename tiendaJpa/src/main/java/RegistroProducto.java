import DAO.CategoriaDAO;
import DAO.ProductoDAO;
import modelo.Categoria;
import modelo.Producto;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class RegistroProducto {
    public static void main(String[] args) {
        registrarProductoBase();
        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        Producto productoFound = productoDAO.findProductById(1L);
        System.out.println(productoFound.getNombre());

        List<Producto> productos = productoDAO.findAll();
        productos.forEach(prod -> System.out.println(prod.getNombre()));

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
