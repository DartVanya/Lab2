package Lab2.Beans;

import java.util.Random;

//Реализация состояния item для лампы
public class Lamp implements item {

	private String color;
	private String lamp;
	private boolean turned;
	
	// Инициализация
	public Lamp() {
		String colors[] = {"к", "с", "з", "г", "ф", "о", "ж"};
		Random rand = new Random();
		color = colors[rand.nextInt(colors.length)];
		lamp = "Л";
		turned = false;
	}
	
	public void print() {
		if(turned)
			System.out.print(lamp + '_' + color);
		else
			System.out.print(lamp);
	}
	
	public boolean get_type() {
		return false;
	}
	
	public void swith() {
		turned = !turned;
	}

}