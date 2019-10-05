package com.rosu;

import com.rosu.constants.Constants;
import com.rosu.db.DatabaseWrapper;
import com.rosu.model.Actor;
import com.rosu.model.Movie;
import com.rosu.repository.ActorRepository;
import com.rosu.repository.CrudRepository;
import com.rosu.repository.MovieRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Movies");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CrudRepository<Actor, Integer> actorRepository = new ActorRepository(entityManager);
        CrudRepository<Movie, Integer> movieRepository = new MovieRepository(entityManager);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String menu =
                "1. Gibberish \n" +
                        "2. delete by actor name \n" +
                        "3. insert actor\n" +
                        "4. delete movie\n" +
                        "5. show all\n" +
                        "6. drop table\n" +
                        "exit \n";

        System.out.println(menu);


        DatabaseWrapper databaseWrapper = new DatabaseWrapper();

        try {
            String option = reader.readLine();

            while (!option.equals("exit")) {

                try {
                    String tableName = "";
                    switch (option) {
                        case "1":
                            System.out.println("Actor id");
                            int id = Integer.parseInt(reader.readLine());
                            System.out.println(
                                    actorRepository.findById(id).isPresent() ?
                                            actorRepository.findById(id).get() :
                                            "not found");

                            System.out.println("Actor name");
                            String name = reader.readLine();
                            for (Actor actor : ((ActorRepository) actorRepository).findByName(name)) {
                                System.out.println(actor);
                                for (Movie movie : actor.getMovies()) {
                                    System.out.println(movie.getName());
                                }
                            }

                            break;
                        case "2":
                            System.out.print("actor last name:");
                            String lastNameToDelete = reader.readLine();
                            int some_id = Integer.parseInt(reader.readLine());
                            ((ActorRepository) actorRepository).deleteById(some_id);
                            break;
                        case "3": {
                            System.out.print("actor first name:");
                            String actorFirstName = reader.readLine();

                            System.out.print("actor last name:");
                            String actorLastName = reader.readLine();

                            Actor actor = new Actor();
                            actor.setFirst_name(actorFirstName);
                            actor.setLast_name(actorLastName);


                            System.out.print("MOVIE name:");
                            String movie_name = reader.readLine();

                            Movie movie = new Movie();
                            movie.setName(movie_name);

                            actor.getMovies().add(movie);

                            actorRepository.save(actor);
                            movieRepository.save(movie);

                            break;
                        }

                        case "4": {
                            System.out.print("movie name:");
                            String movieName = reader.readLine();
                            databaseWrapper.deleteRecord(movieName);

                            break;
                        }

                        case "5": {

                            for (Actor actor : actorRepository.findAll()) {
                                System.out.println(actor.getFirst_name() + " " + actor.getLast_name());
                            }

                            break;
                        }
                        case "6": {
                            System.out.print("Table name:");
                            tableName = reader.readLine();

                            databaseWrapper.dropTable(Class.forName("com.rosu.model." + tableName));

                            break;
                        }
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println();
                System.out.println(menu);
                option = reader.readLine();
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
