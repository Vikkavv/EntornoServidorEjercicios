package Jugadores;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jugadores");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        //FIND
        Jugador torres = em.find(Jugador.class, 2);

        Jugador iker = em.find(Jugador.class, 1);
        Equipo equipo1 = em.find(Equipo.class, 1);
        tx.commit();

        iker.setNombre("Ikar");
        iker.setEstatura(1.20f);
        Jugador j = new Jugador("Pepito", 1.50f, 57.2f, equipo1);

        //tx.begin();
        //em.persist(j);
        //em.merge(iker);
        //tx.commit();

        tx.begin();
        //em.remove(em.find(Jugador.class, 5));
        TypedQuery<Jugador> q = em.createQuery("select e from Jugador e", Jugador.class);
        Query qu = em.createNativeQuery("SELECT * FROM jugador", Jugador.class);
        tx.commit();
        System.out.println(qu.getResultList());
        System.out.println(torres);
        System.out.println(q.getResultList());
    }
}
