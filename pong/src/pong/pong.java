package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class pong {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Pong");
		janela.setSize(600, 600);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		PongGame game = new PongGame(600, 600);
		janela.add(game);
		
		ArrayList<Integer> input = new ArrayList();
		janela.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				int KeyCode = e.getKeyCode();
				if(input.contains(KeyCode) == false)
					input.add(KeyCode);
			}
			public void keyReleased(KeyEvent e) {
				int KeyCode = e.getKeyCode();
				input.remove(input.indexOf(KeyCode));
			}
		});
		
		Timer timer = new Timer(33, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				game.gamelogic(input);
				game.repaint();
			}
		});
		timer.start();
	}
}
