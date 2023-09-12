package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int x, y, speedx, speedy, raio, win;
	private char[] score = {'0', ':', '0'};
	
	public Ball(int x, int y, int raio) {
		this.x = x;
		this.y = y;
		this.raio = raio;
		this.speedx = 5;
		this.speedy = 5;
		this.win = 0;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(this.x, this.y, this.raio, this.raio);
	}
	
	public char[] getScore() {
		return score;
	}
	
	public int getWin() {
		return win;
	}
	
	public void move() {
		this.y += this.speedy;
		this.x += this.speedx;
	}
	
	public void collide(int width, int height, int racket1Y, int racket2Y) {
		if (this.x < 0 || this.x + this.raio > width) {
			speedx *= -1;
		}
		if (this.y < 0 || this.y + this.raio > height) {
			speedy *= -1;
		}
		
		//Checa colisão com a raquete da esquerda
		if (this.x <= 120 && this.x + raio >= 100 && this.y + raio > racket1Y + 10 && this.y < racket1Y + 90) {
			speedx = 5;
		}
		
		//Checa colisão com a raquete da direita
		if (this.x + raio >= 500 && this.x <= 520 && this.y + raio > racket2Y + 10 && this.y < racket2Y + 90) {
			speedx = -5;
		}
		
		//Checa colisão com a parte de cima da raquete da direita
		if (this.x <= 120 && this.x + raio >= 100 && (this.y + raio > racket1Y && this.y + raio <= racket1Y + 10 || this.y < racket1Y + 100 && this.y >= racket1Y + 90)) {
			speedy *= -1;
			if (this.y > racket1Y) {
				this.y = racket1Y + 100;
			} else {
				this.y = racket1Y - this.raio;
			}
		}
		//Checa colisão com a parte de cima da raquete da direita
		if (this.x + raio >= 500 && this.x <= 520 && (this.y + raio > racket2Y && this.y + raio <= racket2Y + 10 || this.y < racket2Y + 100 && this.y >= racket2Y + 90)) {
			speedy *= -1;
			if (this.y > racket2Y) {
				this.y = racket2Y + 100;
			} else {
				this.y = racket2Y - this.raio;
			}
		}
		
		if (this.x < 0) {
			this.x = 300;
			this.speedx = 2;
			this.y = 300;
			if (this.score[2] < 57) {
				this.score[2] += 1;
			} else {
				this.win = 2;
				this.score[2] = 48;
			}
		}
		
		if (this.x + raio > width) {
			this.x = 300;
			this.speedx = 2;
			this.y = 300;
			if (this.score[0] < 57) {
				this.score[0] += 1;
			} else {
				this.win = 1;
				this.score[0] = 48;
			}
		}
	}
	
}
