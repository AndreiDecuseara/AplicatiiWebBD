package com.example.webapp;


import com.example.webapp.domain.Items;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import static junit.framework.TestCase.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("mysql")
@Rollback(false)
public class EntityManagerTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void findItem() {

        Items itemFound1 = entityManager.find(Items.class, 1L);
        Items itemFound2 = entityManager.find(Items.class, 2L);

        assertEquals(itemFound1.getCode(), "23423423");
        assertEquals(itemFound2.getCode(), "4525453");
    }

    @Test
    public void updateItem() {

        Items itemFound = entityManager.find(Items.class, 1L);
        itemFound.setName("Test item");

        assertEquals(itemFound.getName(), "Test item");
        entityManager.persist(itemFound);
        entityManager.flush();

    }




}

