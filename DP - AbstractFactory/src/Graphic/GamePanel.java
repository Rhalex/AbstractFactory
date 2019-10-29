package Graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.Item;
import Logic.ItemsFactory;
import Logic.OccidentalFactory;
import Logic.OrientalFactory;

public class GamePanel extends JPanel implements MouseListener{
	
	private static int dimensionMatrix = 8;
	private int budget = 2000;
	
	private int graphicMultiplicator = 130;
	private ItemsFactory factory;
	private Item[][] matrix = new Item[dimensionMatrix][dimensionMatrix];
	public Item item = null;
	
	private Dimension dimensionFrame;
	private JPanel createPanel;
	private JButton addHouse;
	private JButton addTree;
	private JButton addLamp;
	private JLabel counterBudget;
	
	public GamePanel(String typeFactory, Dimension d)
	{	
		addMouseListener(this);
		
		dimensionFrame = d;
		
		switch(typeFactory)
		{
			case "occidental":
				this.setBackground(Color.LIGHT_GRAY);
				factory = new OccidentalFactory();
				break;
			
			case "oriental":
				this.setBackground(Color.PINK);
				factory = new OrientalFactory();
				break;
		}
			
		initGUI();
		createCity();
	}
	
	private void initGUI()
	{
		this.setLayout(new BorderLayout());
		
		createPanel = new JPanel();
		createPanel.setLayout( new BoxLayout(createPanel, BoxLayout.PAGE_AXIS));
		createPanel.setBackground(Color.DARK_GRAY);
		
		addHouse = new JButton("100", createIcon(factory.MakeHouse().getImg().getDescription(), 64));
		addHouse.setAlignmentX(CENTER_ALIGNMENT);
		
		addTree = new JButton("50", createIcon(factory.MakeTree().getImg().getDescription(), 64));
		addTree.setAlignmentX(CENTER_ALIGNMENT);
		
		addLamp = new JButton("25", createIcon(factory.MakeLamp().getImg().getDescription(), 64));
		addLamp.setAlignmentX(CENTER_ALIGNMENT);
		
		counterBudget = new JLabel(createIcon("imgs/budget.png", 40));
		
		Font newFont = new Font(counterBudget.getFont().getName(), Font.BOLD, 32);
		counterBudget.setFont(newFont);
		counterBudget.setForeground(Color.YELLOW);
		counterBudget.setText(String.valueOf(budget));
		counterBudget.setAlignmentX(CENTER_ALIGNMENT);
		
		createPanel.add(counterBudget);
		createPanel.add(Box.createVerticalGlue());
		createPanel.add(addHouse);
		createPanel.add(Box.createVerticalGlue());
		createPanel.add(addTree);
		createPanel.add(Box.createVerticalGlue());
		createPanel.add(addLamp);
		createPanel.add(Box.createVerticalGlue());

		createPanel.setPreferredSize(new Dimension((dimensionMatrix-1)*(graphicMultiplicator - 4), dimensionFrame.width));
		
		this.add(createPanel, BorderLayout.LINE_END);
	}
	
	private void createCity()
	{
		addHouse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				item = factory.MakeHouse();
				
			}
		});
		
		addTree.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				item = factory.MakeTree();
				
			}
		});
		
		addLamp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				item = factory.MakeLamp();
				
			}
		});
	}
	
	public void paintComponent(Graphics g)
	{
		g.setColor(this.getBackground());
		g.fillRect(0, 0, dimensionFrame.width, dimensionFrame.height);
		for(int i = 0; i<= dimensionMatrix; i++)
		{
			g.setColor(Color.BLACK);
			g.fillRect(i*graphicMultiplicator, 0, 1, dimensionFrame.width);
			g.fillRect(0, i*graphicMultiplicator, dimensionFrame.width, 1);
		}
		
		for(int i=0; i< dimensionMatrix; i++)
			for(int j=0; j< dimensionMatrix; j++)
				if(matrix[i][j] != null)
					g.drawImage(matrix[i][j].getImg().getImage(), j*graphicMultiplicator, i*graphicMultiplicator, graphicMultiplicator, graphicMultiplicator, null);	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int mouseX = e.getX();
		int mouseY = e.getY();
		
		int column = mouseX/graphicMultiplicator;
		int row = mouseY/graphicMultiplicator;
		
		if(item != null && e.getButton() == e.BUTTON1)
		{
			if(row < dimensionMatrix && column < dimensionMatrix && matrix[row][column] == null )
			{
				if(budget >= item.getPrice())
				{
					matrix[row][column] = item;
					budget -= item.getPrice();
					counterBudget.setText(String.valueOf(budget));
				}
				
				item = null;
			}
		}
		else if(e.getButton() == e.BUTTON3)
			if(row < dimensionMatrix && column < dimensionMatrix && matrix[row][column] != null )
				matrix[row][column] = null;
			
		
		if(budget == 0)
		{
			addHouse.setEnabled(false);
			addTree.setEnabled(false);
			addLamp.setEnabled(false);
		}
		
		repaint();
	}
	
	private ImageIcon createIcon(String path, int value)
	{
		ImageIcon iconNotScaled = new ImageIcon(path);
		Image scaledIcon = iconNotScaled.getImage().getScaledInstance(value, value, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledIcon);
		
		return icon;	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
