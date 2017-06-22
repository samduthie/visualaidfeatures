/**
 *
 * Copyright (c) 2005 University of Kent
 * Computing Laboratory, Canterbury, Kent, CT2 7NP, U.K
 *
 * This software is the confidential and proprietary information of the
 * Computing Laboratory of the University of Kent ("Confidential Information").
 * You shall not disclose such confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with
 * the University.
 *
 * @author Dean Ashton
 *
 */

package view.windows;

import managers.ActionManager;
import managers.WindowManager;

import managers.SpeechManager;

import view.dialogs.FileDialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseListener;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


public class WizardWindow {
  private JPanel panelOptions;
  private JTextField jTextFieldInterpreterPath; 
 
  private JDialog dialog;
  
  private WindowManager wm = WindowManager.getInstance();
  
  /*Speech Manager*/
  private SpeechManager sm = new SpeechManager();

  public WizardWindow() {
    try {
      jbInit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
    // panel for interpreter options:
    JPanel panelInterpreter = new JPanel(new GridLayout(0,1));
    JButton browse = new JButton("Browse");
    browse.setToolTipText("Browse for file");
    browse.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          interpreterPath_actionPerformed();
        }
      });
    JPanel panelInterpreterPath = new JPanel();
    panelInterpreterPath.setPreferredSize(new Dimension(100,75));
    panelInterpreterPath.add(new JLabel("Full path of the Haskell interpreter ghci (not ghc or winghci!): "));
    panelInterpreterPath.add(browse);
    panelInterpreter.add(panelInterpreterPath);
    jTextFieldInterpreterPath = new JTextField();
    panelInterpreter.add(jTextFieldInterpreterPath);
    panelInterpreter.add(new JSeparator(SwingConstants.HORIZONTAL));
    
    panelInterpreterPath.addMouseListener(new MouseListener() {
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        	sm.speak("Full path of the Haskell interpreter ghci. not ghc or winghci!");
        }
        });
  
    // button for applying options and cancellation in normal mode.
    JPanel panelButtons = new JPanel(new GridLayout(4,1));
    JButton buttonApply = new JButton("Apply");
    buttonApply.setAction(ActionManager.getInstance().getSaveWizardAction());
    panelButtons.add(buttonApply);
    
    buttonApply.addMouseListener(new MouseListener() {
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        	sm.speak("Continue");
        }
        });
    
    // Buttons for applying with accessibility options
    JButton buttonApplyGUIAccessibility = new JButton("Continue with Enlarged Icons");
    buttonApplyGUIAccessibility.setAction(ActionManager.getInstance().getSaveWizardGUIAction());
    panelButtons.add(buttonApplyGUIAccessibility);
    
    buttonApplyGUIAccessibility.addMouseListener(new MouseListener() {
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        	sm.speak("Continue with Enlarged Icons");
        }
        });

    JButton buttonApplyTTSAccessibility = new JButton("Continue with Text to Speech enabled");
    buttonApplyTTSAccessibility.setAction(ActionManager.getInstance().getSaveWizardTTSAction());
    panelButtons.add(buttonApplyTTSAccessibility);
    
    buttonApplyTTSAccessibility.addMouseListener(new MouseListener() {
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        	sm.speak("Continue with Text to Speech enabled");
        }
        });

    JButton buttonApplyGUITTSAccessibility = new JButton("Continue with Enlarged Icons and Text to Speech enabled");
    buttonApplyGUITTSAccessibility.setAction(ActionManager.getInstance().getSaveWizardGUITTSAction());
    panelButtons.add(buttonApplyGUITTSAccessibility);
    
    buttonApplyGUITTSAccessibility.addMouseListener(new MouseListener() {
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {}
        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {}
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
        	sm.speak("Continue with Enlarged Icons and Text to Speech enabled");
        }
        });

    /*JButton buttonApplyHighCAccessibility = new JButton("Continue with High Contrast Mode");
    buttonApplyHighCAccessibility.setAction(ActionManager.getInstance().getSaveWizardHighCAction());
    panelButtons.add(buttonApplyHighCAccessibility);
*/
    // 
    JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));
    panelInfo.setPreferredSize(new Dimension(200,100));

    JLabel info = new JLabel("<html>"
    		+ "<p>Visual impairment features can be changed <br>from the accessiblity tab in the menu bar.<p>"
    		+ "</html>");
	
    info.setFont(new Font("Calibri", Font.PLAIN, 22));
    info.addMouseListener(new MouseListener() {
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {}
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    	sm.speak("Visual impairment features can be changed "
    			+ "from the accessiblity tab in the menu bar.");
    }
    });
    panelInfo.add(info);
    
    // put all together
    panelOptions = new JPanel(new BorderLayout());
    panelOptions.add(panelInterpreter,BorderLayout.NORTH);
    panelOptions.add(panelButtons,BorderLayout.CENTER);
    panelOptions.add(panelInfo,BorderLayout.SOUTH);
    
    
    Thread thread = new Thread(new Runnable() {
    	@Override
    	public void run() {
    		speakIntro();
    	}
    });
    thread.start();
  }

  
  public void speakIntro() {
	  
	  sm.speak("Welcome to HEAT.");
  }
  
  private void interpreterPath_actionPerformed() {
    File selectedFile = FileDialogs.getInstance().showDefaultFileChooser(
            new File(jTextFieldInterpreterPath.getText()));

    if (selectedFile != null) {
      jTextFieldInterpreterPath.setText(selectedFile.getAbsolutePath());
    }
  }

  public String getInterpreterPath() {
    return jTextFieldInterpreterPath.getText();
  }

  public void show() {
    dialog = new JDialog(wm.getMainScreenFrame(), "Initial Setup");
    dialog.setModal(true);
    dialog.getContentPane().add(panelOptions);
    dialog.setMinimumSize(new Dimension(500,600));
    dialog.setSize(500,600);
    dialog.setLocationRelativeTo(wm.getMainScreenFrame());
    dialog.setVisible(true);
  }

  public void close() {
    if (dialog != null)
      dialog.dispose();
  }
}
