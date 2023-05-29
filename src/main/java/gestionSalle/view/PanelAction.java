package gestionSalle.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;

public class PanelAction extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelAction() {
		initComponents();

	}
	  private void initComponents() {
		  setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		  modifbtn = new ActionButton();
		  modifbtn.setIcon(new ImageIcon(PanelAction.class.getResource("/gestionSalle/view/editer.png")));
		  add(modifbtn);
			
		  
		  deletebtn = new ActionButton();
		  deletebtn.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  	}
		  });
		  deletebtn.setIcon(new ImageIcon(PanelAction.class.getResource("/gestionSalle/view/supprimer (2).png")));
		  add(deletebtn);
		  
	  }

	    public void initEvent(TableActionEvent event, int row) {
	    	modifbtn.addActionListener(new ActionListener() {
	    		 @Override
	             public void actionPerformed(ActionEvent ae) {
	                 event.onEdit(row);
	             }
			});
	    	
			deletebtn.addActionListener(new ActionListener() {
				 @Override
		            public void actionPerformed(ActionEvent ae) {
		                event.onDelete(row);
		            }
			});
	    	
	    	
	    }
	    private ActionButton modifbtn;
	    private ActionButton deletebtn;
}
