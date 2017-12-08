package KursovaGameobject;

public class Snake {
	public int d = 0; //напрям змійки
	public int dlina = 10; //довжина змійки
	public int snakeX[]=new int[100]; //максимальна кількість елементів змійки по Х
	public int snakeY[]=new int[100];//максимальна кількість елементів змійки по У
	public Snake(int x0, int y0, int x1, int y1) {//конструктор змійки
		snakeX[0] = x0;
		snakeY[0] = y0;
		snakeX[1] = x1;
		snakeY[1] = y1;
	}
	public void move() {
		for(int h = dlina; h > 0; h--) {//h-елемент, цикл для переміщення
			snakeX[h]=snakeX[h-1];
			snakeY[h]=snakeY[h-1];
			
		}
		if(d==0) snakeX[0]++;//здвиг вправо
		if(d==1) snakeY[0]++;//здвиг вниз
		if(d==2) snakeX[0]--;//здвиг вліво
		if(d==3) snakeY[0]--;//здвиг вверх
	
	for(int k=dlina-1; k>0; k--) {
		if(snakeX[0]==snakeX[k] & snakeY[0]==snakeY[k] )
			dlina=k-2;
	}
	if(dlina<2)
		dlina=2;}
}
