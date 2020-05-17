package Lab2;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Lab2.Beans.SpringConfig;

// Интерфейс командной строки, взаимодействует с пользователем
public class CLI {
	private int N, M, x, y;
	private Scanner in;
	private AnnotationConfigApplicationContext ctx;
	
	// Получаем информацию о размере панели
	public boolean getInfo() {
	    in = new Scanner(System.in);
	    System.out.println("Введите параметры панели: ");
	    N = in.nextInt();
	    M = in.nextInt();
	    if (N < 1 || M < 1) {
	       System.out.println("Вы ввели неправильный размер панели! Завершение работы программы...");
	       return false;
	    }
	    return true;
	}
	
	// Запускаем процесс взаимодействия с пользователем
	public void start() {
		ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		ControlPanel panel = new ControlPanel(M, N, ctx);
        System.out.println("Сгенерирована панель управления.");
        panel.print();
        while(true) {
        	 System.out.println("Нажмите кнопку: __ (-1 - выход)");
        	 x = in.nextInt();
             if (x == -1) break;
             y = in.nextInt();
             if (y == -1) break;
             if (x < 0 || x >= N || y < 0 || y >= M) {
                 System.out.println("Вы ввели неправильные координаты! Введите ещё раз.");
                 continue;
             }
             panel.PressButton( M-1-y, x);
             panel.print(); 
        }
	}
	
	// Завершаем работу
	public void finish() {
		System.out.println("Завершение работы программы...");
        ctx.close();
	}
}
