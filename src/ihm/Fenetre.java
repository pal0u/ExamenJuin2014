package ihm;
import java.awt.BorderLayout;

import ihm.FenetreConsulter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Fenetre extends JFrame {
	JLabel label = new JLabel("Argentinos La Louvière : Bienvenue");
	JPanel container = new JPanel();
	JTextField txt = new JTextField();
	FenetreConsulter feneC = new FenetreConsulter();
	FenetreAjouter feneA = new FenetreAjouter();
	FenetreModifier feneM = new FenetreModifier();
	FenetreSupprimer feneS = new FenetreSupprimer();
	JOptionPane option = new JOptionPane();
	
	// Un booleen pour savoir si la fenetre est ouverte
		private boolean flag = false;
	
	public Fenetre() {
		//Caractéristiques fenetre
		this.setTitle("Argentinos La Louvière");
		this.setSize(600,300);//taille
		this.setResizable(false);//Ne pas agrandir
		this.setLocationRelativeTo(null);//Centrer
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		container.setBackground(Color.BLUE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int v = JOptionPane.showConfirmDialog(null,"Voulez-vous quiiter l'application?", "Confirmez", JOptionPane.YES_NO_OPTION);
				//System.ou.println(v);
				//0 pour oui et 1 pour non
				if(v == 0){
					System.exit(0);
				}
			}
		});
		
		//BorderLayOut nord
		//Definition d'une police d'écriture
		Font police = new Font("Tahoma",Font.BOLD,16);
		//Application au JLabel
		label.setFont(police);
		//Couleur de texte
		label.setForeground(Color.WHITE);
		//Allignement du texte
		label.setHorizontalAlignment(JLabel.CENTER);
		
		//BorderLayout centre
		//Image
		JLabel image = new JLabel( new ImageIcon( Fenetre.class.getResource("ALL1.jpg")));
		ImageIcon img = new ImageIcon(Fenetre.class.getResource("ballon.jpg"));
		this.setIconImage(img.getImage());
		//BorderLayout sud
		//Creation des boutons
		final JButton boutonC = new JButton("Consulter");
		boutonC.setBackground(Color.BLUE);
		boutonC.setForeground(Color.YELLOW);
		final JButton boutonA = new JButton("Ajouter");
		boutonA.setBackground(Color.BLUE);
		boutonA.setForeground(Color.GREEN);
		final JButton boutonM = new JButton("Modifier");
		boutonM.setBackground(Color.BLUE);
		boutonM.setForeground(Color.DARK_GRAY);
		final JButton boutonS = new JButton("Supprimer");
		boutonS.setBackground(Color.BLUE);
		boutonS.setForeground(Color.RED);
		//Creation panel Bouton
		JPanel boutonPane = new JPanel();
		boutonPane.add(boutonC);
		boutonPane.add(boutonA);
		boutonPane.add(boutonM);
		boutonPane.add(boutonS);
		
		//Actions des boutons
		boutonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JButton)e.getSource()==boutonC)
				{
				new FenetreConsulter().setVisible(true);
				}
			}
		});
		boutonA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JButton)e.getSource()==boutonA)
				{
				new FenetreAjouter().setVisible(true);
				}
			}
			});
		boutonM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JButton)e.getSource()==boutonM)
				{
				new FenetreModifier().setVisible(true);
				}
			}
			});
		boutonS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if((JButton)e.getSource()==boutonS)
				{
				new FenetreSupprimer().setVisible(true);
				}
			}
			});
		
		//Ajouts et positionnement
		container.add(label);
		this.getContentPane().add(image,BorderLayout.CENTER);
		this.getContentPane().add(container,BorderLayout.NORTH);
		this.getContentPane().add(boutonPane,BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		
	}

}
