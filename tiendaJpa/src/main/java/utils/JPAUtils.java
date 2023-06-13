package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tiendajpa");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
