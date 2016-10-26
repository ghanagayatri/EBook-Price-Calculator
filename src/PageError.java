import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.*;


 public class PageError extends JFrame implements ActionListener{

	JPanel contentPane;
	JButton btnTryAgain = new JButton("Try Again");
	
	/**
	 *
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PageError() {
		//System.out.println("it is in page error");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 187, 193);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblError = new JLabel("ERROR");
		lblError.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblError.setBounds(51, 0, 80, 50);
		contentPane.add(lblError);
		
		JLabel lblNewLabel = new JLabel("Invalid Username");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblNewLabel.setBounds(28, 61, 121, 25);
		contentPane.add(lblNewLabel);
		
		
		btnTryAgain.setBounds(42, 109, 89, 23);
		contentPane.add(btnTryAgain);
		btnTryAgain.addActionListener((ActionListener) this);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}

}