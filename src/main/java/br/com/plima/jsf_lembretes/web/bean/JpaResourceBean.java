package br.com.plima.jsf_lembretes.web.bean;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaResourceBean {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory(){
        //verificando se ele é nulo, se for a gente instancia
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("lembrete");
        }

        return entityManagerFactory;
    }
}
