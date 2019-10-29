package Graphic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame {
	
	public static void main(String[] args) {
		
		Game g = new Game();
		g.setVisible(true);	
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Dimension d=tk.getScreenSize();
	private JButton occidentalButton;
	private JButton orientalButton;
	private JPanel cards = new JPanel(new CardLayout());
	private JPanel panel;
	private GamePanel gp;
	
	public Game()
	{
		super();
		
		initGUI();
		initEH();
	}
	
	private void initGUI()
	{
		this.setSize(d.width, d.height);
		this.setTitle("MyCity");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);		
		createOccidentalButton();
		createOrientalButton();
		
		cards.add(panel);
		this.add(cards);
		
		
		
	}
	
	private void initEH()
	{
		occidentalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				occidentalVersion();	
			}
		});
		
		orientalButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				orientalVersion();
			}
		});
	}
	
	private void occidentalVersion()
	{
		orientalButton.setEnabled(false);
		gp = new GamePanel("occidental", d);
		
		cards.add(gp);
		
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.next(cards);
	}
	
	private void orientalVersion()
	{
		occidentalButton.setEnabled(false);
		gp = new GamePanel("oriental", d);
		
		cards.add(gp);
		
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.next(cards);
	}
	
	private void createOccidentalButton()
	{
		occidentalButton = new JButton("Occidental Style");
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 200;
		c.ipady = 20;
		
		panel.add(occidentalButton, c);
	}
	
	private void createOrientalButton()
	{
		orientalButton = new JButton("Oriental Style");
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 200;
		c.ipady = 20;
		c.insets = new Insets(20, 0, 0, 0);
		
		panel.add(orientalButton, c);
	}

}
