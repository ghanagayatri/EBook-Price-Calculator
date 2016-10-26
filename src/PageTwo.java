import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;


public class PageTwo extends JFrame implements ActionListener{

	JPanel contentPane = new JPanel();
	JScrollBar scrollPane = new JScrollBar();
	private JTable table;
	DefaultTableModel model;
	boolean pagetwocloseflag=false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PageTwo() {
		setMinimumSize(new Dimension(800, 555));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBounds(300, 200, 801, 650);
		scrollPane.setBounds(300,200,801,650);
		scrollPane.setOpaque(true);
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourBookshelf = new JLabel("Your Bookshelf");
		lblYourBookshelf.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		lblYourBookshelf.setBounds(304, 31, 145, 40);
		contentPane.add(lblYourBookshelf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setForeground(new Color(255, 222, 173));
		scrollPane_1.setBackground(new Color(255, 222, 173));
		scrollPane_1.setBounds(46, 101, 626, 228);
		contentPane.add(scrollPane_1);
		
		String data[][] = {{"",""}};
	    String col[] = {"Books","Prices ($)"};
		model = new DefaultTableModel(data,col);
		table = new JTable(model);
		table.setShowGrid(false);
		table.setRowHeight(24);
		table.setBackground(new Color(255, 222, 173));
		table.getTableHeader().setBackground(new Color(255, 222, 173));
		table.getTableHeader().setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		table.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		scrollPane_1.getViewport().setBackground(new Color(255, 222, 173));
		scrollPane_1.setViewportView(table);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnLogOut.setBounds(558, 409, 89, 23);
		contentPane.add(btnLogOut);
		btnLogOut.addActionListener(this);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(767, 83, 17, 518);
		scrollPane.add(scrollBar);
		
		
		
	}

	public void addRowTable(String bookTitle, String Price,int count)
	{
		model.insertRow(count+1,new Object[]{bookTitle,Price});
	}
		
	public void addTime(double time){
		JLabel lblTime = new JLabel("Time: "+ Double.toString(time)+" secs");
		lblTime.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
		lblTime.setBounds(41, 11, 145, 14);
		contentPane.add(lblTime);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		pagetwocloseflag = true;
	}
}
