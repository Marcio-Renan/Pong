package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class racket {
	private int x, y;
	
	public racket(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getRacketY() {
		return this.y;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.x, this.y, 20, 100);
	}
	
	public void move(ArrayList<Integer> input, int inputA, int inputB) {
		for (Integer i : input) {
			if(i == inputA && this.y > 30) {
				this.y -= 5;
			}
			if(i == inputB && this.y < 470) {
				this.y += 5;
			}
		}
	}
	
}
