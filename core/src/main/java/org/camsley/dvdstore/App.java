package org.camsley.dvdstore;

import org.camsley.dvdstore.controller.MovieController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Georges
 *
 */
@SpringBootApplication
public class App
{
    public static void main( String[] args )
    {
//        ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext context= new AnnotationConfigApplicationContext(App.class);
        ApplicationContext context= SpringApplication.run(App.class,args);
        MovieController movieController = context.getBean(MovieController.class);
        movieController.addUsingConsole();



    }
}
