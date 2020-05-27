package Lab2;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Lab2.Beans.SpringConfig;

// Интерфейс командной строки, взаимодействует с пользователем
public class CLI {
	private int N, M, x, y;
	private Scanner in;
	private AnnotationConfigApplicationContext ctx;
	private ControlPanel panel;
	private Thread tr;
	protected String info = "Команды: -1 - выход, -2 - переключить режим моргания панели\nНажмите кнопку:";
    private boolean AutoButtonsPress = false;
    private int Timeout = 2000;
	
    // Конструктор по умолчанию
    public CLI() {}
    
    // Конструктор с параметрами
	public CLI (boolean AutoPress, int tout) {
		 AutoButtonsPress = AutoPress;
		 Timeout = tout;
	}
	
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
		panel = new ControlPanel(M, N, ctx, Timeout);
        System.out.println("Сгенерирована панель управления.");
        panel.print();
        
        // Создаем новый поток и запускаем его, если включено автопереключение
        if (AutoButtonsPress) {
        	tr = new Thread(panel);
        	tr.start();
        }
        
        // Запрос данных у пользователя
        while(true) {
        	 System.out.println(info);
        	 x = in.nextInt();
             if (x == -1) break;
             else if (x == -2) { // Переключение мигания панели
            	 this.SwitchAutoPress();
            	 continue;
             }
             y = in.nextInt();
             if (y == -1) break;
             else if (y == -2) {
            	 this.SwitchAutoPress();
            	 continue; 	 
             }
             if (x < 0 || x >= N || y < 0 || y >= M) {
                 System.out.println("Вы ввели неправильные координаты! Введите ещё раз.");
                 continue;
             }
             
             panel.PressButton( M-1-y, x);
             panel.print(); 
        }
	}
	
	// Метод переключения автонажатия
	void SwitchAutoPress() {
		 if (AutoButtonsPress) // прерываем поток, если он был активен
			 tr.interrupt();
		 else { // или создаём новый и запускаем
			 tr = new Thread(panel);
			 tr.start();
		 }
		 AutoButtonsPress = !AutoButtonsPress;
		 System.out.println("Режим автопереключения " + (AutoButtonsPress ? "включен" : "выключен") + ". Ура!");
	}
	
	// Завершаем работу
	public void finish() {
        if (AutoButtonsPress)
			tr.interrupt(); // завершаем поток по окончании выполнения программы
		ctx.close();
		System.out.println("Завершение работы программы...");
	}
}
