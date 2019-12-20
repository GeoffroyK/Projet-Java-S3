package project;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GUI extends JFrame {
	private JLabel valueLabel = new JLabel("Veuillez entrer un lien dans la console et appuyer sur l'un des boutons pour effectuer l'action associée.");
	private JTextField linkField = new JTextField(30);
	private JButton arboParcours = new JButton("Parcours d'arborescence");
	private JButton scan = new JButton("Scanner");
	private JButton save = new JButton("Sauvegarder");
	private JButton aide = new JButton("Aide");
	private JButton browse = new JButton("Browse");
	private JButton quitButton = new JButton("Quitter");
	private JPanel rightPanel = new JPanel();
	
	/**
	 * This is the model in MVC (model-view-controller).
	 */

	public GUI(String title) {
		super(title);

		init();

		arboParcours.addActionListener(new ArboParcoursAction());
		scan.addActionListener(new ScanAction());
		save.addActionListener(new SaveAction());
		aide.addActionListener(new AideAction());
		browse.addActionListener(new BrowseAction());
		quitButton.addActionListener(new QuitAction(this)); 
		
	}

	private void init() {
		BorderLayout border = new BorderLayout();
		Container contentPane = getContentPane();
		contentPane.setLayout(border);
		
		rightPanel.setLayout(new GridLayout(3, 2));
		rightPanel.add(arboParcours);
		rightPanel.add(scan);
		rightPanel.add(save);
		rightPanel.add(aide);
		rightPanel.add(browse);
		contentPane.add(BorderLayout.EAST, rightPanel);
		
		contentPane.add(BorderLayout.NORTH, valueLabel);
		contentPane.add(BorderLayout.CENTER, linkField);
		contentPane.add(BorderLayout.SOUTH, quitButton);
		
		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private class ArboParcoursAction implements ActionListener {

		String lien = null;
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
		System.out.println("Saississez le lien");
		lien = linkField.getText();
		FilesWalk f = new FilesWalk(lien);
		try {
			f.start();
			f.getAllFiles();
		} catch (IOException e1) {
			System.err.println(e1);
		}
		
		}
	}

	 private class ScanAction implements ActionListener {
		String tmp = null;
		String lien = null;
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saississez le lien");
 			lien = linkField.getText();
 			Informations i = new Informations(lien);
 			tmp += i.toString();
				try {
				Database d = new Database(i.getFileExt());
				Compare c = new Compare(i.getMimeType(),d.researchMime(),i.getSign(),d.researchSign());
				tmp += c.toString();
				linkField.setText(tmp);
				} catch (IOException e1) {
				System.err.println(e1.getMessage());
			}
		}

	}

	private class SaveAction implements ActionListener {

		String lien = null;
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Saississez le lien");
 			lien = linkField.getText();;
 			Informations i = new Informations(lien);
 			System.out.println(i);
				try {
				Database d = new Database(i.getFileExt());
				Compare c = new Compare(i.getMimeType(),d.researchMime(),i.getSign(),d.researchSign());
				System.out.println(c);
				Saving s = new Saving(i, c);
				Serialization ser = new Serialization(s,"nouveau");
				ser.serializationSave();
				System.out.println("Sauvegarde effectuée");
				} catch (IOException e1) {
				System.err.println(e1.getMessage());
			}
		}

	}
	
	private class AideAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane help = new JOptionPane();
			help.showMessageDialog(null, "Là tu écris ce que tu veux mettre dans l'aide", "Aide", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	private class BrowseAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
	        int returnVal = chooser.showOpenDialog(getParent());
	        if(returnVal == JFileChooser.APPROVE_OPTION) {
	            linkField.setText(chooser.getSelectedFile().getPath());
	        }
		}
	}
	
	private class QuitAction implements ActionListener {
		private JFrame window;

		public QuitAction(JFrame window) {
			this.window = window;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			window.dispose();
		}

	}  	
}