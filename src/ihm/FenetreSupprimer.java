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
import javax.swing.JTextField;

import com.mysql.jdbc.ResultSetMetaData;

public class FenetreSupprimer extends JFrame {
	private GridBagConstraints gbc = null;
	private JPanel container = new JPanel();
	private JTextField txtnom = new JTextField();
	private JTextField txtprenom = new JTextField();
	private JLabel labelnom = new JLabel("Nom");
	private JLabel labelprenom = new JLabel("Prenom");
	private JButton bouton2 = new JButton("Supprimer"); 
	private JComboBox<String> combo = new JComboBox<String>();
	public FenetreSupprimer(){
		super();
		build();
	}

	private void build() {
		// TODO Auto-generated method stub
		this.setTitle("Supprimer des données");
		this.setSize(400,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.GRAY);
		//On definit le layout du JPanel
		container.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		// On définit un espace entre les composants avec insets
		gbc.insets = new Insets(10, 45, 15, 15);
		// On ajoute le composant au JPanel
		// ***** ATTENTION ***** Ne pas oublier d'indiquer le gbc *****
		gbc.gridx = 0;
		gbc.gridy = 0;
		labelnom.setPreferredSize(new Dimension(60,30));
		container.add(labelnom,gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		txtnom.setPreferredSize(new Dimension(100,30));
		container.add(txtnom,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		labelprenom.setPreferredSize(new Dimension(60,30));
		container.add(labelprenom,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		txtprenom.setPreferredSize(new Dimension(100,30));
		container.add(txtprenom,gbc);
		
		
		
		//Creation Combobox et ajouts
		combo.setPreferredSize(new Dimension(100,20));
		combo.setBackground(Color.BLACK);
		combo.setForeground(Color.RED);
		combo.addItem("Correspondantqualifie");
		combo.addItem("President");
		combo.addItem("Delegue");
		combo.addItem("Joueurs");
		combo.addItem("Coachs");
		
		//Icone
		ImageIcon img = new ImageIcon(FenetreSupprimer.class.getResource("supprimer.png"));
		this.setIconImage(img.getImage());
		
		//Bouton
		bouton2.setBackground(Color.BLACK);
		bouton2.setForeground(Color.RED);
		
		bouton2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String url = "jdbc:mysql://localhost/argentinos-ll";
				String user = "root";
				String password = "";
				int v = JOptionPane.showConfirmDialog(null, "Voulez-vous réellement supprimer cette personne?","DELETE",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(v == 0){
				try {
					Connection conn = DriverManager.getConnection(url, user, password);
					Statement state =  (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
					 
					state.executeUpdate("DELETE FROM "+combo.getSelectedItem()+" WHERE nom ='"+txtnom.getText()+"' AND prenom ='"+txtprenom.getText()+"';");
					 state.close();
					JOptionPane.showMessageDialog(null, "Personne supprimée","INFO",JOptionPane.INFORMATION_MESSAGE);
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Attention non supprimé","ERREUR",JOptionPane.INFORMATION_MESSAGE);
				}finally{
					txtnom.setText("");
					txtprenom.setText("");
				}

			}
			}	});
				
		//Ajouts et positionnements
		
		this.add(combo,BorderLayout.NORTH);
		this.add(container,BorderLayout.CENTER);
		this.add(bouton2,BorderLayout.SOUTH);
		this.pack();
		
	}

}
