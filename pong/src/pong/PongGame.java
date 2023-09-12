package pong;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PongGame extends JPanel{
	private int width, heigth;
	private Ball b;
	private racket r1;
	private racket r2;
	
	public PongGame(int width, int height) {
		this.width = width;
		this.heigth = height;
		this.b = new Ball(300, 300, 25);
		this.r1 = new racket(100, 250);
		this.r2 = new racket(500, 250);
	}
	
	public void paint(Graphics g) {
		g.fillRect(0, 0, width, heigth);
		b.paint(g);
		r1.paint(g);
		r2.paint(g);
		g.setFont(new Font("Arial", Font.PLAIN, 60));
		g.drawChars(b.getScore(), 0, 3, 250, 100);
		if (b.getWin() == 1) {
			char win[] = {'W', 'I', 'N'};
			g.drawChars(win, 0, 3, 60, 100);
		} else if (b.getWin() == 2) {
			char win[] = {'W', 'I', 'N'};
			g.drawChars(win, 0, 3, 420, 100);
		}
	}
	
	public void gamelogic(ArrayList<Integer> input) {
		if (b.getWin() == 0) {
			b.move();
			r1.move(input, 87, 83);
			r2.move(input, 38, 40);
			b.collide(600, 600, r1.getRacketY(), r2.getRacketY());
		}
	}
	
}
