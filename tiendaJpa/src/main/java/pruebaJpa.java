import DAO.CategoriaDAO;
import DAO.ProductoDAO;
import modelo.Categoria;
import modelo.Producto;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class pruebaJpa {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Producto producto1 = new Producto("Samsung", "Celular de segunda", new BigDecimal(1000), celulares);

        EntityManager em = JPAUtils.getEntityManager();
        ProductoDAO productoDAO = new ProductoDAO(em);
        CategoriaDAO categoriaDAO = new CategoriaDAO(em);

        em.getTransaction().begin();

        categoriaDAO.guardar(celulares);
        productoDAO.guardar(producto1);

        em.getTransaction().commit();
        em.close();
    }
}
