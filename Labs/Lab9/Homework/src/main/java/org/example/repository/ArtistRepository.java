package org.example.repository;


import org.example.models.ArtistJPA;

import javax.persistence.EntityManagerFactory;

public class ArtistRepository extends AbstractRepository<ArtistJPA>{

    public ArtistRepository(EntityManagerFactory emf)
    {
        super(emf);
    }

}
