import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.EventQueue;
import java.lang.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dimension;


public class PageOne extends JFrame implements ActionListener{

	private JPanel contentPane;
	private final JLabel lblEnterUsername = new JLabel("Enter Username: ");
	JTextField textField;
	JButton btnOk = new JButton("OK");
	boolean pageOneFlag = false;
	//PageError frame_error = new PageError();
	

	
	/**
	 * Launch the application.
	 */

	 String nameget;
	/**
	 * Create the frame.
	 */
	 
	 public PageOne() {
		setMinimumSize(new Dimension(800, 555));
			setForeground(new Color(210, 105, 30));
			setLocation(0, 0);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(300, 200, 800, 555);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(255, 222, 173));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			lblEnterUsername.setBounds(220, 272, 131, 19);
			lblEnterUsername.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
			contentPane.add(lblEnterUsername);
			
			textField = new JTextField();
			textField.setBounds(424, 269, 136, 25);
			textField.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
			contentPane.add(textField);
			textField.setColumns(10);
			//System.out.println("constructor" +nameget);
			
			JLabel lblWhatsItCosting = DefaultComponentFactory.getInstance().createTitle("Whats it Costing?");
			lblWhatsItCosting.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
			lblWhatsItCosting.setBounds(300, 90, 172, 39);
			contentPane.add(lblWhatsItCosting);
			
			
			btnOk.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
			btnOk.setBounds(339, 324, 89, 23);
			btnOk.addActionListener((ActionListener) this);
			contentPane.add(btnOk);
			
			JLabel lblNewLabel = new JLabel("A unique calculator which gets you the budget of your next reading spree!\r\n");
			lblNewLabel.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
			lblNewLabel.setBounds(124, 158, 551, 25);
			contentPane.add(lblNewLabel);
			//return textField.getText();
			
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		nameget = textField.getText();
		pageOneFlag = true;
	}
}

	 
	


	/*
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk
			//if (nameget.equals("")){	
				System.out.println("else here");
				//frame.setVisible(false);
				//PageError frame_error = new PageError();
				//frame_error.contentPane.setVisible(true);
			}
			}
		//if(e.getSource()==frame_error.btnTryAgain){
		//	frame_error.contentPane.setVisible(false);
		}
	}
*/
	

