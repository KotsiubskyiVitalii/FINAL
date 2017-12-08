package KursovaGame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel; //імпортуємо всі бібліотеки які необхідні
import javax.swing.Timer;

import KursovaGameobject.Snake;//імпортуємо нашу змійку з класу snake

public class SnakeEvolution extends JPanel implements ActionListener {//використовуємо слухача подій

	public static final int PIX = 40; //кількість пікселів 1 умовна клітинка
	public static final int SHIR = 20; //ширина
	public static final int VIS = 15; //ВИСОТА
	public static final int SPEED =5; // обнова буде 10 разів за секунду

	Snake s = new Snake(1,1,0,1);//kоординати змійки
	Timer t = new Timer(1000/SPEED, this);
	public SnakeEvolution() {//створюємо конструктор ДЛЯ ПЕРЕМІЩЕННЯ
	t.start();
	addKeyListener(new Key());
	setFocusable(true);
	}
	public void paint(Graphics q) {
		q.setColor(color(5, 200, 0));//колір фона
		q.fillRect(0, 0, SHIR*PIX, VIS*PIX);//замальовуємо фон
		//q.setColor (color(250,0,0));//колір ліній
		//малюємо лінії
		
	for(int xx= 0; xx<=SHIR*PIX; xx+=PIX) {//малюємо вертикальні лінії
			q.drawLine(xx, 0, xx, VIS*PIX);			
		}
for(int yy= 0; yy<=VIS*PIX; yy+=PIX) {
			q.drawLine(0, yy, SHIR*PIX, yy);			
		}
		for(int h=0;h<s.dlina;h++) {
			q.setColor(color(250, 216,0));//колір змійки
			q.fillRect(s.snakeX[h]*PIX+1, s.snakeY[h]*PIX+1, PIX-1, PIX-1);//адресуємо змійку малюємо квадрат
			}
	}
	public Color color(int RED, int GREEN, int BLUE){//для кольорів
		return new Color(RED, GREEN, BLUE);
	}
	public static void main(String[] args) {//головна функція
		JFrame f = new JFrame();//робимо віконце 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //для закривання операції
		f.setResizable(false);
		f.setSize(SHIR*PIX+7, VIS*PIX+29);//задаємо розміри екрану
		f.add(new SnakeEvolution());
		f.setLocationRelativeTo(null);//вікно по центру
		f.setVisible(true);
	}
	private class Key extends KeyAdapter{//клас для клавіш
public void keyPressed(KeyEvent kE) {//клавіша нажата
int key = kE.getKeyCode();
if ((key==KeyEvent.VK_RIGHT)& s.d !=2)s.d =0;//напрямки руху змійки
if ((key==KeyEvent.VK_DOWN)& s.d !=3)s.d =1;
if ((key==KeyEvent.VK_LEFT)& s.d !=0)s.d =2;
if ((key==KeyEvent.VK_UP)& s.d !=1)s.d =3;}}

	public void actionPerformed(ActionEvent e ) {//тут буде переміщення нашої змійки
		s.move();
		repaint();
		
	}}
