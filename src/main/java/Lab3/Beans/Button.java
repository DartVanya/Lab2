package Lab3.Beans;


// Реализация методов item для кнопки
public class Button implements item {

	private volatile String button;
	private volatile boolean turned;
	
	// Инициализация
	public Button() {
		button = "О";
		turned = false;
	}
	
	public void print() {
		System.out.print(button);
	}
	public boolean get_type() {
		return true;
	}
	public void swith() {
		turned = !turned;
		if(button == "О")
			button = "о";
		else
			button = "О";
	}
 
}
