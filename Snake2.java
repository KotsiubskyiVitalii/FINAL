package KursovaGameobject;
import KursovaGame.SnakeEvolution;
public class Snake2 {
	SnakeEvolution main;
	public int d2 = 0; //напрям змійки
	public int dlina2 = 2; //довжина змійки
	@SuppressWarnings("static-access")
	public int snake2X[]=new int[main.SHIR*main.VIS]; //максимальна кількість елементів змійки по Х
	@SuppressWarnings("static-access")
	public int snake2Y[]=new int[main.SHIR*main.VIS];//максимальна кількість елементів змійки по У
	public Snake2(int x0, int y0, int x1, int y1) {//конструктор змійки
		snake2X[0] = x0;
		snake2Y[0] = y0;
		snake2X[1] = x1;
		snake2Y[1] = y1;
		
	}
	public void move() {
		for(int h = dlina2; h > 0; h--) {//h-елемент, цикл для переміщення
			snake2X[h]=snake2X[h-1];
			snake2Y[h]=snake2Y[h-1];
		}
		if(d2==0) snake2X[0]++;//здвиг вправо
		if(d2==1) snake2Y[0]++;//здвиг вниз
		if(d2==2) snake2X[0]--;//здвиг вліво
		if(d2==3) snake2Y[0]--;//здвиг вверх
	
	for(int k=dlina2-1; k>0; k--) {
		if(snake2X[0]==snake2X[k] & snake2Y[0]==snake2Y[k] )
			dlina2=k;
	}
	
	if(snake2X[0] > main.SHIR) snake2X[0]= 0;//умови перетину рамки гри
	if(snake2X[0] < 0) snake2X[0] = main.SHIR-1;
	if(snake2Y[0] > main.VIS-1) snake2Y[0] = 0;
	if(snake2Y[0] < 0) snake2Y[0] = main.VIS-1;
	
	if(dlina2<2)
		dlina2=2;
	
	
	}

}