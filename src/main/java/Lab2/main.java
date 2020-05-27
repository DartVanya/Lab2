package Lab2;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main (String[] args) {
    	// Создаём интерфейс: параметр1 - активация автопереключения,
    	// 					  параметр2 - время автопереключения в мсек
		CLI prog = new CLI(false, 2000);
		
		// Выход в случае некорректного ввода размера панели
		if (!prog.getInfo())
		 	System.exit(-1);
		
		prog.start();
		
		prog.finish();
		
		System.exit(0);
    }
}
