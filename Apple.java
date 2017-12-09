package KursovaGameobject;

import KursovaGame.SnakeEvolution;

public class Apple {

	SnakeEvolution main; //виклик головного класу
	
	public int posX; //позиція Х
	public int posY;//позиція Y
	
	public Apple(int startX, int startY) {
		posX = startX;//позиція яблука Х
		posY = startY;//позиція яблука Y
	}
	
	@SuppressWarnings("static-access")//знаходиться в методі
	public void setRandomPosition() {
		posX = (int) (Math.random()*main.SHIR);//(int) заокруглення до цілого числа з рандому
		posY = (int) (Math.random()*main.VIS);
	}
}
