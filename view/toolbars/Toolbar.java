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
 * @author Dean Ashton, Sergei Krot
 *
 */

package view.toolbars;

import managers.ActionManager;
import managers.SettingsManager;
//Speech Manager
import managers.SpeechManager;

//Mouse Listener
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import java.awt.Font;

import javax.swing.ImageIcon;
import utils.Resources;


/**
 * The toolbar used within HEAT
 */
public class Toolbar {
  /* The toolbar */
  private JToolBar toolBar = new JToolBar();
  private ActionManager am = ActionManager.getInstance();
  
  /* some icons */
  private ImageIcon iiCompileSuccess = Resources.getIcon("buttonok22");
  private ImageIcon iiCompileUnknown = Resources.getIcon("buttonquestion22");
  private ImageIcon iiCompileFail = Resources.getIcon("buttoncancel22");
  private ImageIcon iiWorking = Resources.getIcon("effect22");

  /* The buttons in use */
  private JButton openButton = new JButton(am.getToolbarOpenFileAction());
  private JButton closeButton = new JButton(am.getToolbarCloseFileAction());
  private JButton undoButton = new JButton(am.getToolbarUndoAction());
  private JButton redoButton = new JButton (am.getToolbarRedoAction());
  private JButton cutButton = new JButton(am.getToolbarEditCutAction());
  private JButton copyButton = new JButton(am.getToolbarEditCopyAction());
  private JButton pasteButton = new JButton(am.getToolbarEditPasteAction());
  private JButton searchButton = new JButton(am.getToolbarSearchAction());
  private JButton compileButton = new JButton(am.getToolbarCompileAction());
  private JButton interruptButton = new JButton(am.getToolbarInterruptAction());
  private JButton testButton = new JButton(am.getToolbarTestAction());
  private JButton treeWindowButton = new JButton(am.getToggleTreeAction());
  private JButton outputWindowButton = new JButton(am.getToggleOutputAction());
  private JButton statusButton = new JButton();
  
  /* Speech Manager */
  private SpeechManager sm = new SpeechManager();

  /**
   * Creates a new Toolbar object.
   */
  public Toolbar() {
    try {
      createToolbar();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates the toolbar component
   *
   * @throws Exception If a button could not be added
   */
  public void createToolbar() throws Exception {
	  
	// check if the speech is set in the settings
	SettingsManager settingsManager = SettingsManager.getInstance();
	if (settingsManager.getSetting("ACCESSIBILITY_TEXT_TO_SPEECH").equals("True")) {
	  	addSpeech();
	}
		
    toolBar.setFloatable(false);
    toolBar.add(openButton);
    toolBar.add(closeButton);
    toolBar.addSeparator();
    toolBar.add(undoButton);
    toolBar.add(redoButton);
    toolBar.addSeparator();
    toolBar.add(cutButton);
    toolBar.add(copyButton);
    toolBar.add(pasteButton);
    toolBar.add(searchButton);
    toolBar.addSeparator();
    toolBar.add(compileButton);
    toolBar.add(interruptButton);
    toolBar.add(testButton);
    toolBar.addSeparator();
    toolBar.add(treeWindowButton);
    toolBar.add(outputWindowButton);
    toolBar.add(javax.swing.Box.createHorizontalGlue());
    toolBar.add(statusButton);
    statusButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    statusButton.setFocusable(false);
    statusButton.setBorderPainted(false);
    statusButton.setContentAreaFilled(false);
    statusButton.setText("Status");
    statusButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    setCompileStatus(1);
    
  }
  
  public void addSpeech() {
	  
	  openButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarOpenFileAction().getDescription());
          }
	  });
	  
	  closeButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarCloseFileAction().getDescription());
          }
	  });
	  
	  undoButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarUndoAction().getDescription());
          }
	  });
	  
	  redoButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarRedoAction().getDescription());
          }
	  });
	  
	  cutButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarEditCutAction().getDescription());
          }
	  });
	  
	  copyButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarEditCopyAction().getDescription());
          }
	  });
	  
	  pasteButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarEditPasteAction().getDescription());
          }
	  });
	  
	  searchButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarSearchAction().getDescription());
          }
	  });
	  
	  compileButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarCompileAction().getDescription());
          }
	  });
	  
	  interruptButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarInterruptAction().getDescription());
          }
	  });
	  
	  testButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToolbarTestAction().getDescription());
          }
	  });
	  
	  treeWindowButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToggleTreeAction().getDescription());
          }
	  });
	  
	  outputWindowButton.addMouseListener(new MouseListener(){
		  
		  @Override
          public void mouseExited(java.awt.event.MouseEvent e) {
		  }
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {}
          @Override
          public void mousePressed(java.awt.event.MouseEvent e) {}
          @Override
          public void mouseReleased(java.awt.event.MouseEvent e) {}

          @Override
          public void mouseEntered(java.awt.event.MouseEvent e) {
        	  sm.speak(am.getToggleOutputAction().getDescription());
          }
	  });
  }
  
  

  /* Enlarge the buttons on the toolbar */
  public void enlargeGUI() {
	  
	  iiCompileSuccess = Resources.getIcon("buttonok44");
	  iiCompileUnknown = Resources.getIcon("buttonquestion44");
	  iiCompileFail = Resources.getIcon("buttoncancel44");
	  iiWorking = Resources.getIcon("effect44");
	  
	  
	  openButton.setIcon(Resources.getIcon("fileopen44"));
	  closeButton.setIcon(Resources.getIcon("fileclose44"));
	  undoButton.setIcon(Resources.getIcon("undo44"));
	  redoButton.setIcon(Resources.getIcon("redo44"));
	  cutButton.setIcon(Resources.getIcon("editcut44"));
	  copyButton.setIcon(Resources.getIcon("editcopy44"));
	  pasteButton.setIcon(Resources.getIcon("editpaste44"));
	  searchButton.setIcon(Resources.getIcon("filefind44"));
	  compileButton.setIcon(Resources.getIcon("reload44"));
	  interruptButton.setIcon(Resources.getIcon("stop44"));
	  testButton.setIcon(Resources.getIcon("debug44"));
	  treeWindowButton.setIcon(Resources.getIcon("tree_window_44"));
	  outputWindowButton.setIcon(Resources.getIcon("output_window_44"));
	  statusButton.setIcon(Resources.getIcon("effect44"));
	  
	  statusButton.setFont(new Font("Arial", Font.PLAIN, 22));
	  
  }
  
  /* Reduce the size of the buttons on the toolbar */
  public void shrinkGUI() {
	  
	  iiCompileSuccess = Resources.getIcon("buttonok22");
	  iiCompileUnknown = Resources.getIcon("buttonquestion22");
	  iiCompileFail = Resources.getIcon("buttoncancel22");
	  iiWorking = Resources.getIcon("effect22");
	  
	  
	  openButton.setIcon(Resources.getIcon("fileopen22"));
	  closeButton.setIcon(Resources.getIcon("fileclose22"));
	  undoButton.setIcon(Resources.getIcon("undo22"));
	  redoButton.setIcon(Resources.getIcon("redo22"));
	  cutButton.setIcon(Resources.getIcon("editcut22"));
	  copyButton.setIcon(Resources.getIcon("editcopy22"));
	  pasteButton.setIcon(Resources.getIcon("editpaste22"));
	  searchButton.setIcon(Resources.getIcon("filefind22"));
	  compileButton.setIcon(Resources.getIcon("reload22"));
	  interruptButton.setIcon(Resources.getIcon("stop22"));
	  testButton.setIcon(Resources.getIcon("debug22"));
	  treeWindowButton.setIcon(Resources.getIcon("tree_window_22"));
	  outputWindowButton.setIcon(Resources.getIcon("output_window_22"));
	  statusButton.setIcon(Resources.getIcon("effect22"));
	  
	  statusButton.setFont(new Font("Arial", Font.PLAIN, 12));
	  
  }

  /**
   * Returns the toolbar
   *
   * @return the toolbar object
   */
  public JToolBar getToolBar() {
    return toolBar;
  }
  
  public void setInterruptEnabled(boolean enabled) {
    interruptButton.setEnabled(enabled);
  }
  
  public void setTestEnabled(boolean enabled) {
    testButton.setEnabled(enabled);
  }
  
  public void setCompileEnabled(boolean enabled) {
    compileButton.setEnabled(enabled);
  }
  
  public void setCloseEnabled(boolean enabled) {
    closeButton.setEnabled(enabled);
  }
  /**
   * Sets the compile status icon
   *
   * @param status compilation status, 0=Fail, 1=Success, 2=Unknown
   */
  public void setCompileStatus(int status) {
	  switch (status) {
	  	case 0: statusButton.setIcon(iiCompileFail); break;
	  	case 1: statusButton.setIcon(iiCompileSuccess); break;
	  	case 2: statusButton.setIcon(iiCompileUnknown); break;
	  	case 3: statusButton.setIcon(iiWorking); break;
	  }
  } 
  
}
