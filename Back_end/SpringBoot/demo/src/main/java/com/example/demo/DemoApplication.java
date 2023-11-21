package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.config.Bean3;
import com.example.demo.config.BeanConfig;
import com.example.demo.config.Game;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
	

	
	// private static final Bean3 Bean3 = null;
	// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Bean3.class);
	// Bean3 b = (Bean3);
    // String s = (String) context.getBean("bean3");
	// 
	// 	ClassPathXmlApplicationContext context = 
    //     new ClassPathXmlApplicationContext(
    //         "classpath:application.xml");
    // int i = (int) context.getBean("bean2");
    // System.out.println(i);

		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		// String s = (String) context.getBean("bean1");
		// System.out.println(s);
		//SpringApplication.run(DemoApplication.class, args);

	// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
	// 	Game game = (Game) context.getBean("game");
	// 	game.play();
	// 	((AnnotationConfigApplicationContext) context).close();

	AnnotationConfigApplicationContext context =
      new AnnotationConfigApplicationContext(BeanConfig.class);
    Game game = (Game) context.getBean("game");
    game.play();
    Movie movie = (Movie) context.getBean("movie");
    movie.play();
	Music music = (Music) context.getBean("music");
    music.play();
    ((AnnotationConfigApplicationContext) context).close();

	}

}
