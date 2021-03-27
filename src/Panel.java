import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel{
	Game game;
	Timer tm;
	Font font;
	Panel(){
		setLayout(null);
		game = new Game();
		repaint();
		 font  = new Font("sans-serif",2,40);
		JButton nGameBtn = new JButton("Новая игра");
		nGameBtn.setBounds(500, 700, 200, 50);
		add(nGameBtn);
		nGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				game = new Game();
				repaint();
			}
		});
		JButton exitBtn = new JButton("Выход");
		exitBtn.setBounds(1250, 700, 200, 50);
		add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		game.computerField.paintField(g);
		game.playerField.paintField(g);
		if(game.computerWin()) {
			int x = game.computerLeftIndent - game.centerIndent + 15;
			int y =game.topIndent + game.fieldSize * game.cellSize + 50;
			g.drawString("YOU DEAD", x ,y);
		}else if (game.playerWin()) {
			int x = game.computerLeftIndent - game.centerIndent / 2 - 50;
			int y =game.topIndent + game.fieldSize * game.cellSize + 50;
			g.drawString("паздравляем ,вы сын маминой подруги ", x ,y);
		}
	}
}
