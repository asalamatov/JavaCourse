package org.aztech.peopledb.repository;

import org.aztech.peopledb.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleRepositoryTests {

    private Connection connection;
    private PeopleRepository repo;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:/home/azamat/Desktop/DBeaverSQL/peopletest".replace("~", System.getProperty("user.home")));
        connection.setAutoCommit(true);
        repo = new PeopleRepository(connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }

    @Test
    public void canSaveOnePerson() throws SQLException {
        Person john = new Person("John", "Smith", ZonedDateTime.of(1880, 11, 15, 15, 15, 0, 0, ZoneId.of("-6")));
        Person savedPerson = repo.save(john);
        assertThat(savedPerson.getId()).isGreaterThan(0);
    }

    @Test
    public void canSaveTwoPeople() {
        Person john = new Person("John", "Smith", ZonedDateTime.of(1880, 11, 15, 15, 15, 0, 0, ZoneId.of("-6")));
        Person bobby = new Person("Bobby", "Smith", ZonedDateTime.of(1880, 11, 15, 15, 15, 0, 0, ZoneId.of("-6")));
        Person savedPerson1 = repo.save(john);
        Person savedPerson2 = repo.save(bobby);
        assertThat(savedPerson1.getId()).isNotEqualTo(savedPerson2.getId());
    }

    @Test
    public void canFindPersonByID() {
        Person savedPerson = repo.save(new Person("test", "jackson", ZonedDateTime.of(1880, 11, 15, 15, 15, 0, 0, ZoneId.of("-6"))));
        Person foundPerson = repo.findByID(savedPerson.getId()).get();
        assertThat(foundPerson).isEqualTo(savedPerson);
    }

    @Test
    public void testPersonIdNotFound() {
        Optional<Person> foundPerson = repo.findByID(-1L);
        assertThat(foundPerson).isEmpty();
    }

}
