import modelo.Producto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class pruebaJpa {
    public static void main(String[] args) {
        Producto producto1 = new Producto();
        producto1.setNombre("Samsung");
        producto1.setDescripcion("Celular de segunda");
        producto1.setPrecio(new BigDecimal(1000));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(producto1);
        em.getTransaction().commit();
        em.close();
    }
}
