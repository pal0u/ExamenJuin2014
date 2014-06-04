package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.Transaction;

import test.HibernateUtil;
import pojo.Joueurs;

public class FenetreAjouter extends JFrame {
	private JFrame fenetre = null;
	private JPanel top = new JPanel();
	private JPanel container = new JPanel();
	private JTextField txt = new JTextField();
	private JTextField txt1 = new JTextField();
	private JTextField txt2 = new JTextField();
	private JTextField txt3 = new JTextField();
	private JLabel label = new JLabel("Numéro d'affiliation  :  ");
	private JLabel label1 = new JLabel("Nom  : ");
	private JLabel label2 = new JLabel("Prenom  :  ");
	private JLabel label3 = new JLabel("Date De Naissance  :  ");
	
	public FenetreAjouter() {
		super();
		build();
		
	}

	private void build() {
		// TODO Auto-generated method stub
		this.setTitle("Ajouter un joueur");
		this.setSize(500,200);//taille
		this.setResizable(false);//ne pas agrandir
		this.setLocationRelativeTo(null);//centrer
		container.setLayout(new BorderLayout());
		Font police = new Font("Colibri",Font.BOLD,14);
		txt.setFont(police);
		txt.setPreferredSize(new Dimension(150,30));
		
		//Placement des boutons 
		this.getContentPane().setLayout(null);
		label.setBounds(20, 0, 150, 70);
		txt.setBounds(180, 19, 110, 30);
		label1.setBounds(20, 36, 150, 70);
		txt1.setBounds(180, 55, 110, 30);
		label2.setBounds(20, 70, 150, 70);
		txt2.setBounds(180, 91, 110, 30);
		label3.setBounds(20, 106, 150, 70);
		txt3.setBounds(180, 129, 110, 30);
		
		
		//Icone
		ImageIcon img = new ImageIcon(FenetreAjouter.class.getResource("joueur.jpg"));
		this.setIconImage(img.getImage());
		
		//Creation bouton OK
		JButton boutonOK = new JButton("Enregistrer");
		boutonOK.setBackground(Color.BLACK);
		boutonOK.setForeground(Color.GREEN);
		boutonOK.setBounds(350, 65, 100, 30);
		
		
		//Action bouton
		boutonOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Conversion en java.util.Date
				java.util.Date date = null;
				SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yy");
				//conversion en int
				int i = 0;
				Session session = null;
				session = HibernateUtil.instance().openSession();
				
				Transaction tx = null;
				tx = session.beginTransaction();
				Joueurs jou = null;
				try {
					jou = new Joueurs(i = Integer.parseInt(txt.getText()),txt1.getText(),txt2.getText(),date = sdf.parse(txt3.getText()));
					session.persist(jou);
					JOptionPane.showMessageDialog(null, "Joueur enregistré","Nouveau joueur",JOptionPane.INFORMATION_MESSAGE);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Attention joueur non enregistré","ERREUR",JOptionPane.INFORMATION_MESSAGE);
				}finally{
					if(jou == null){
						jou = new Joueurs();
					}
				}
				txt.setText("");
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				tx.commit();
				
			}
		});
		
		//ajouts et positionnement
		this.add(label);
		this.add(txt);
		this.add(label1);
		this.add(txt1);
		this.add(label2);
		this.add(txt2);
		this.add(label3);
		this.add(txt3);
		this.add(boutonOK,BorderLayout.CENTER);
	}
}
