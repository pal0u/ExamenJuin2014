package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.ResultSetMetaData;

public class FenetreModifier extends JFrame{
	private GridBagConstraints gbc = null;
	private JPanel container = new JPanel();
	private JButton bouton = new JButton("Enregistrer"); 
	private JTextField txtnum = new JTextField();
	private JTextField txtscore = new JTextField();
	private JLabel lblnum = new JLabel("Numéro de match");
	private JLabel lblscore = new JLabel("Score");
	
	public FenetreModifier(){
		super();
		build();
	}

	private void build() {
		// TODO Auto-generated method stub
		this.setTitle("Entrer Score");
		this.setSize(300,300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.BLUE);
		container.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		// On définit un espace entre les composants avec insets
		gbc.insets = new Insets(10, 20, 10, 10);
		// On place les composants
		gbc.gridx = 0;
		gbc.gridy = 0;
		lblnum.setPreferredSize(new Dimension(120,30));
		container.add(lblnum,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		txtnum.setPreferredSize(new Dimension(100,30));
		container.add(txtnum,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lblscore.setPreferredSize(new Dimension(120,30));
		container.add(lblscore,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		txtscore.setPreferredSize(new Dimension(100,30));
		container.add(txtscore,gbc);
		
		
		//Icone
		ImageIcon img = new ImageIcon(FenetreModifier.class.getResource("maj.gif"));
		this.setIconImage(img.getImage());
		
		//Bouton
		bouton.setBackground(Color.BLACK);
		bouton.setForeground(Color.GREEN);
		
		bouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String url = "jdbc:mysql://localhost/argentinos-ll";
				String user = "root";
				String password = "";
				int i=0;
				try {
					
					Connection conn = DriverManager.getConnection(url, user, password);
					Statement state = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					state.executeUpdate("UPDATE matchs SET score ='"+txtscore.getText()+"' WHERE numerodematch ='"+(i = Integer.parseInt(txtnum.getText()))+"';");
					state.close();
					
					JOptionPane.showMessageDialog(null, "Score enregistré","INFO",JOptionPane.INFORMATION_MESSAGE);
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Attention,  non-effectué","ATTENTION!", JOptionPane.INFORMATION_MESSAGE);
					
				}finally{
					txtnum.setText(" ");
				    txtscore.setText(" ");
				}
				
				
			}
		});
		
		
		
		//Ajouts et positionnements
		
		this.getContentPane().add(container,BorderLayout.CENTER);
		this.getContentPane().add(bouton,BorderLayout.SOUTH);
		this.pack();
	}

}
