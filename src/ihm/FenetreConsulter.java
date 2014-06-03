package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.mysql.jdbc.ResultSetMetaData;


public class FenetreConsulter extends JFrame {
	    private JButton bouton = new JButton("Rechercher");
		private JPanel container = new JPanel();
		private JComboBox<String> combo = new JComboBox<String>();
		private JLabel label = new JLabel("Sélectionner");
		private JTextArea textarea  = new JTextArea();
		private JScrollPane scrollpane = new JScrollPane();
		
public FenetreConsulter() {
		// TODO Auto-generated constructor stub
		super();
		build();
	}

private void build() {
		// TODO Auto-generated method stub
		this.setTitle("Consulter des données");
		this.setSize(600,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.GRAY);
		container.setLayout(new BorderLayout());
		
		//Creation JScrollPane avec textearea
		textarea.setPreferredSize(new Dimension(1200,1000));
		textarea.setForeground(Color.BLACK);//couleur texte
		textarea.setBackground(Color.LIGHT_GRAY);//Couleur de fond
		scrollpane.setBounds(22, 50, 550, 450);
		scrollpane.setViewportView(textarea);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollpane);
		
		//Creation combobox
		combo.setPreferredSize(new Dimension(100,20));
		combo.setBackground(Color.BLACK);
		combo.addItem("Correspondantqualifie");
		combo.addItem("President");
		combo.addItem("Delegue");
		combo.addItem("Coach");
		combo.addItem("Joueurs");
		combo.addItem("Matchs");
		combo.addItem("Blessures");
		combo.addItem("Suspensions");
		combo.addItem("Lieux");
		
		//Icone
		ImageIcon img = new ImageIcon(FenetreConsulter.class.getResource("cons.png"));
		this.setIconImage(img.getImage());
		
		//Bouton
		bouton.setPreferredSize(new Dimension(10,30));
		bouton.setBackground(Color.BLACK);
		bouton.setForeground(Color.YELLOW);
		//Action bouton
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textarea.setText("");//Nettoyer textarea 
				String url = "jdbc:mysql://localhost/argentinos-ll";
				String user = "root";
				String password = "";
				Connection conn;
				try {
					
					ResultSet rs = null;
					conn = DriverManager.getConnection(url, user, password);
					Statement state = conn.createStatement();
					rs = state.executeQuery("SELECT * FROM "+ combo.getSelectedItem()+" ;");
					ResultSetMetaData resultmeta = (ResultSetMetaData) rs.getMetaData();
					for(int i = 1;i <= resultmeta.getColumnCount();i++){
						textarea.append(resultmeta.getColumnName(i).toUpperCase().trim()+"\t*| ");
					}
					textarea.append("\n");
					while(rs.next()){
						for(int i = 1;i <= resultmeta.getColumnCount();i++){
							textarea.append(rs.getObject(i).toString()+"\t*| "+" ");
						    
						}
						textarea.append("\n");
					}
					rs.close();
					state.close();
					conn.close();
					JOptionPane.showMessageDialog(null, "Recherche effectuée","INFO",JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Attention erreur de recherche !!","INFO",JOptionPane.INFORMATION_MESSAGE);
				}
			
				
			}});
			      
		//Ajouts et positionnement
		JPanel top = new JPanel();
		top.add(label);
		top.add(combo);
		container.add(top,BorderLayout.NORTH);
		this.add(bouton,BorderLayout.SOUTH);
		this.add(container);
	
		
}
}

