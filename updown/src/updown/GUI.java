// TODO: Feature - Core: Sort by rank or PID.
// TODO: Feature - Core: GUI and algorithm to determine possible outcomes.

package updown;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class GUI {
	private JFrame guiframe = new JFrame();
	private JPanel contentpane = new JPanel();
	private JPanel topbar = new JPanel();
	private JPanel topemptypanel = new JPanel();
	private JPanel topbtpanel = new JPanel();
	private	JPanel page1, page2;
	
	private final JPanel cardpanel = new JPanel();
	private JPanel config = new JPanel();
	private final JPanel matches = new JPanel();
	private JPanel results = new JPanel();
	
	private CardLayout cardlayout_cardpanel = new CardLayout();
	private CardLayout cardlayout_matches = new CardLayout();
	
	private JButton bt_config, bt_matches, bt_results;
	
	private final JRadioButton rb_fiveman = new JRadioButton();
	private final JRadioButton fb_sixman = new JRadioButton();
	private List<JTextArea> TAList = new ArrayList<JTextArea>(6);
	private JLabel lbl_gs;
	private List<JLabel> LBLList = new ArrayList<JLabel>(6);
	private final JButton bt_submit = new JButton();
	
	private List<JTextField> TFList = new ArrayList<JTextField>(15);
	private List<JComboBox<String>> CBLeftList = new ArrayList<JComboBox<String>>(15);
	private List<JComboBox<String>> CBRightList = new ArrayList<JComboBox<String>>(15);
	private List<JRadioButton> RBLeftList = new ArrayList<JRadioButton>(15);
	private List<JRadioButton> RBRightList = new ArrayList<JRadioButton>(15);
	private List<JRadioButton> RBFakeList = new ArrayList<JRadioButton>(15);
	private JButton bt_pg1, bt_pg2;
	
	private JTable table = new JTable();
	
	private final ButtonGroup bg_numplayers = new ButtonGroup();
	private List<ButtonGroup> BGList = new ArrayList<ButtonGroup>(15);
	private ArrayList<Integer> lastpressedradio = new ArrayList<Integer>(15);	// 1=left,0=right,-1=fake
	
	private int[] defaultfiveman =	{	0,1,	2,3,	0,4,	3,1,	2,4,	3,0,	1,4,	2,0,	3,4,	2,1};
	private int[] defaultsixman =	{	0,1,	2,3,	4,5,	0,2,	1,4,	3,5,	0,4,	1,3,	2,5,	0,3,
										1,5,	2,4,	0,5,	3,4,	1,2};
	
	private int pendingnumplayers=6;
	private boolean sizeswitched = true;

	public GUI() {
		setupGuiFrame();
		setupContentPane();
		
		setupTopEmptyPanel();
		setupBTPanel();
		setupTopBar();
		
		setupConfig();
		
		setupMatches();
		setupPage1();
		setupPage2();
		
		setupResults();
		setupEmptyPanel();
		
		setupCardPanel();
		
		initTopBT();			// buttons at the top
		
		initConfigTA();			// text areas in config panel
		initConfigLBL();		// labels in config panel
		initConfigRB();			// radio buttons in config panel
		initConfigbtsubmit();	// submit button in config panel
		
		initMUnotBT();			// components besides buttons in matchup panel
		initMUBT();				// buttons in matchup panel
		
		initResultsTable();		// table in results panel
		
		setupTraversalPolicy();	// tab/shift+tab (only used for config page)
		
		initRoster();			// populates roster (6 empty players)
		initMatches();			// populates matchup (15 empty matches)
	}
	
	/* */
	
	private void initRoster() {
		for(int i=0;i<6;++i)
			UpDown.addPlayer(new Player());
	}
	
	private void initMatches() {
		for(int i=0;i<15;++i)
			UpDown.addMatch(new Match());
	}
	
	private void updateRoster() {
		fixTextLength();	// only allow 8 characters (breaks gridbaglayout otherwise)
			
		if (UpDown.getNumPlayers()==6 && sizeswitched) {			// 5 man --> 6
			if (UpDown.getNumPlayers() != UpDown.getRosterSize())
				UpDown.addPlayer(new Player());							// add new player
			UpDown.resetPlayers();
		}
		else if (UpDown.getNumPlayers()==5 && sizeswitched) {		// 6 man --> 5
			if (UpDown.getNumPlayers() != UpDown.getRosterSize())
				UpDown.remPlayer(5);									// remove player 6
			UpDown.resetPlayers();
	 	}
		
		for(int i=0;i<UpDown.getNumPlayers();++i)
			UpDown.setPlayer(TAList.get(i).getText(),i);
	}
	
	private void updateComboBoxes() {
		int tempindexleft,tempindexright;
		
		for(int i=0; i<15;++i) {
			tempindexleft=CBLeftList.get(i).getSelectedIndex();		// get all selected indexes
			tempindexright=CBRightList.get(i).getSelectedIndex();
			CBLeftList.get(i).removeAllItems();						// delete all entries
			CBRightList.get(i).removeAllItems();
			for(Player p : UpDown.getAllPlayer()) {					// add all entries
				CBLeftList.get(i).addItem(p.getName());
				CBRightList.get(i).addItem(p.getName());
			}
			if (UpDown.getNumPlayers()==5 && i>=10)
				break;
			if (!sizeswitched) {									// set to previous selection unless size changed
				CBLeftList.get(i).setSelectedIndex(tempindexleft);
				CBRightList.get(i).setSelectedIndex(tempindexright);
			}
			else if (UpDown.getNumPlayers()==5) {
				CBLeftList.get(i).setSelectedIndex(defaultfiveman[i*2]);
				CBRightList.get(i).setSelectedIndex(defaultfiveman[(i*2)+1]);
				resetSelection();
			}
			else if (UpDown.getNumPlayers()==6) {
				CBLeftList.get(i).setSelectedIndex(defaultsixman[i*2]);
				CBRightList.get(i).setSelectedIndex(defaultsixman[(i*2)+1]);
				resetSelection();
			}
		}
	}
	
	private void resetSelection() {
		for(int i=0;i<15;++i) {
			lastpressedradio.set(i,-1);
			RBFakeList.get(i).setSelected(true);
		}		
	}
	
	private void updateMatches() {
		
		if (sizeswitched) {
			fixMatchLength();
			resetMatches();
		}
		
		for(int i=0;i<10;++i) {
			UpDown.setMatchLeft(UpDown.getPlayer(CBLeftList.get(i).getSelectedIndex()),i);		// get the player which is selected in the CB
			UpDown.setMatchRight(UpDown.getPlayer(CBRightList.get(i).getSelectedIndex()),i);	// get the player which is selected in the CB
		}
		
		if (UpDown.getNumPlayers()==6) {
			for(int i=10;i<15;++i) {
				UpDown.setMatchLeft(UpDown.getPlayer(CBLeftList.get(i).getSelectedIndex()),i);		// get the player which is selected in the CB
				UpDown.setMatchRight(UpDown.getPlayer(CBRightList.get(i).getSelectedIndex()),i);	// get the player which is selected in the CB
			}
		}
	}
	
	private void resetMatches() {
		for(int i=0;i<UpDown.getNumMatches();++i)
			UpDown.clearMatch(i);
	}
	
	private void fixMatchLength() {
		if (UpDown.getNumPlayers()==6) {
			if (UpDown.getNumMatches()==10) {
				for(int i=0;i<5;++i)
					UpDown.addMatch(new Match());
			}
		}
		else {
			if (UpDown.getNumMatches()==15) {
				for(int i=0;i<5;++i)
					UpDown.delMatch();
			}
		}
	}
	
	private void updateResults() {
		if (UpDown.getNumPlayers()==5 && table.getRowCount()==6) {
			( (MyTableModel) table.getModel() ).removeRow();
			( (MyTableModel) table.getModel() ).removeColumn();
			setTableFormat(5);
		}
		else if (UpDown.getNumPlayers()==6 && table.getRowCount()==5) {
			( (MyTableModel) table.getModel() ).addRow();
			( (MyTableModel) table.getModel() ).addColumn();
			setTableFormat(6);
		}
		
		for(int i=0;i<UpDown.getNumPlayers();++i) {
			table.setValueAt("P"+(i+1),i,1);							// set pid
			table.setValueAt(UpDown.getPlayer(i).getName(),i,2);		// set name
			table.setValueAt(UpDown.getPlayer(i).getBeatSize(),i,3);	// set wins
			table.setValueAt(UpDown.getPlayer(i).getLostSize(),i,4);	// set losses
		
			for(int j=i;j<UpDown.getNumPlayers();++j) {					// set result (1=won 0=lost null=not played)
				if (i!=j)
					if (UpDown.getPlayer(i).beatContains(UpDown.getPlayer(j))) {
						table.setValueAt(1,i,(5+j));
						table.setValueAt(0,j,(5+i));
					}
					else if (UpDown.getPlayer(i).lostContains(UpDown.getPlayer(j))) {
						table.setValueAt(0,i,(5+j));
						table.setValueAt(1,j,(5+i));
					}
					else {
						table.setValueAt(null,i,(5+j));
						table.setValueAt(null,j,(5+i));
					}
			}
			table.setValueAt(UpDown.getRank(i),i,0);					// set rank
		}
	}
	
	private boolean notAllBlankNames() {
		for(int i=0;i<UpDown.getNumPlayers();++i) {
			if (!TAList.get(i).getText().isEmpty())
				return true;
		}
		return false;	
	}
	
	private void fixTextLength() {
		for(int i=0;i<6;++i) {
			if (TAList.get(i).getText().length()>8)
				TAList.get(i).setText(TAList.get(i).getText().substring(0, 8));
		}
	}
	
	/* - - - actionListeners - - - */
	private void submitAction(ActionEvent e) {		// acts as control. changes to config dont go through until submit button is pressed
		if (UpDown.getNumPlayers()!=pendingnumplayers) {	// swiitching group size
			sizeswitched=true;
			UpDown.setNumPlayers(pendingnumplayers);
			bt_pg1.setEnabled(!bt_pg1.isEnabled());	// enable/disable button to second page in matchup panel
		}

		if (notAllBlankNames()) {
			updateRoster();
			updateComboBoxes();
			updateMatches();
			sizeswitched=false;
		}
	}
	
	private void configRBAction(ActionEvent e) {		// sets numberplayers and whether player 6 config TA is editable
		if ( (JRadioButton) e.getSource() == rb_fiveman) {
			pendingnumplayers=5;
			TAList.get(5).setBackground(Color.LIGHT_GRAY);
			TAList.get(5).setEnabled(false);
		}
		else {
			pendingnumplayers=6;
			TAList.get(5).setBackground(Color.WHITE);
			TAList.get(5).setEnabled(true);
		}
	}
	
	private void matchupRBAction(ActionEvent e) {	// allows both radio buttons to be off (selects 3rd hidden radio if selected radio is pressed)
		int index,right=0;
		
		if (RBLeftList.contains((JRadioButton) e.getSource())) {
			index=RBLeftList.indexOf((JRadioButton) e.getSource());
			UpDown.setResult(index, 1);
		}
		else {
			index=RBRightList.indexOf((JRadioButton) e.getSource());
			UpDown.setResult(index, 0);
			right=1;
		}
		if (lastpressedradio.get(index)==1-right) {		// 1=left 0=right
        	RBFakeList.get(index).setSelected(true);
        	UpDown.setResult(index, -1);
        	lastpressedradio.set(index,-1);
        }
        else
        	lastpressedradio.set(index,1-right);
	}
	
	/* - - - GUI Panel/Layout Setups - - - */
	private void setupGuiFrame() {
		guiframe.setTitle("UpDown");
		guiframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiframe.setBounds(100, 100, 320, 479);
		guiframe.setResizable(false);
		guiframe.setContentPane(contentpane);
	}
	
	private void setupContentPane() {
		contentpane.setBorder(null);
		contentpane.setLayout(new BorderLayout(0, 0));
		contentpane.add(topbar, BorderLayout.NORTH);
		contentpane.add(cardpanel, BorderLayout.CENTER);
	}

	private void setupTopEmptyPanel() {
		topemptypanel.setBorder(new EmptyBorder(15, 0, 0, 0));
		topemptypanel.setLayout(new BorderLayout(0, 0));
	}
		
	private void setupBTPanel() {
		topbtpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
	}
	
	private void setupTopBar() {
		topbar.setLayout(new BorderLayout(0, 0));
		topbar.add(topemptypanel, BorderLayout.NORTH);
		topbar.add(topbtpanel, BorderLayout.CENTER);
	}
	
	private void setupConfig() {
		config.setLayout(null);
	}

	private void setupPage1() {
		page1 = new JPanel();
		matches.add(page1, "page1");
		GridBagLayout gbl_page1 = new GridBagLayout();
		gbl_page1.columnWidths = new int[]{37, 100, 40, 100, 37, 0};
		gbl_page1.rowHeights = new int[] {15, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 30, 23, 0};
		gbl_page1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_page1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		page1.setLayout(gbl_page1);
	}
	
	private void setupPage2() {
		page2 = new JPanel();
		matches.add(page2, "page2");
		GridBagLayout gbl_page2 = new GridBagLayout();
		gbl_page2.columnWidths = new int[]{37, 100, 40, 100, 37, 0};
		gbl_page2.rowHeights = new int[]{15, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 30, 23, 0};
		gbl_page2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_page2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		page2.setLayout(gbl_page2);
	}
	
	private void setupMatches() {
		matches.setLayout(cardlayout_matches);
		cardlayout_matches.show(matches,"page1");
	}
	
	private void setupResults() {
		results.setLayout(new BorderLayout(0, 0));
		results.setBorder(new EmptyBorder(0, 0, 0, 0));
	}
	
	private void setupCardPanel() {
		cardpanel.setLayout(cardlayout_cardpanel);
		cardpanel.add(matches,"matches");
		cardpanel.add(config, "config");
		cardpanel.add(results, "results");
		cardlayout_cardpanel.show(cardpanel,"config");
	}
	
	
	private void setupEmptyPanel() {
		JPanel emptypanel = new JPanel();
		emptypanel.setBorder(new EmptyBorder(15, 0, 0, 0));
		emptypanel.setLayout(new BorderLayout(0, 0));
		results.add(emptypanel, BorderLayout.NORTH);
	}
	
	private void setupTraversalPolicy() {
		guiframe.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{	TAList.get(0), TAList.get(1), TAList.get(2), TAList.get(3), TAList.get(4), TAList.get(5),
				bt_submit, rb_fiveman, fb_sixman, bt_config, bt_matches, bt_results }));
	}
	
	/* - - - GUI Component Inits - - - */
	private void initTopBT() {				// creates buttons on the top (seen on all pages)
		/* These switch between the main panels (config/matches/results) */
		bt_config =new JButton(" Config ");
		bt_config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { cardlayout_cardpanel.show(cardpanel,"config"); }
		});
		topbtpanel.add(bt_config);
		
		
		bt_matches = new JButton("Matches");
		bt_matches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardlayout_cardpanel.show(cardpanel,"matches");
				if (UpDown.getNumPlayers()==5)	// force it matchup card to show page1 if 5 players (shouldn't be able to see page2)
					cardlayout_matches.show(matches,"page1");
			}
		});
		topbtpanel.add(bt_matches);
		
		bt_results = new JButton("Results");
		bt_results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpDown.clearRankings();
				UpDown.computeRankings();
				updateResults();
				cardlayout_cardpanel.show(cardpanel,"results"); }
		});
		topbtpanel.add(bt_results);
	}
	
	private void initConfigTA() {			// creates textareas on config page
		JTextArea tempta = new JTextArea();

		Font font = tempta.getFont();
		float size = font.getSize() + 8.0f;
		
		int y=54;	// y of first element
		for(int i=0;i<6;++i) {
			tempta = new JTextArea();
			tempta.setBounds(65, y, 200, 30);
			tempta.setFont(font.deriveFont(size));
			TAList.add(tempta);
			TAList.get(i).addKeyListener(new KeyAdapter() {
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_TAB) {
	                    if (e.getModifiers() > 0) {
	                    	((JTextArea) e.getSource()).transferFocusBackward();
	                    } else {
	                    	((JTextArea) e.getSource()).transferFocus();
	                    }
	                    e.consume();
	                }
	            }
			});
			TAList.get(i).addFocusListener(new java.awt.event.FocusAdapter() {
	    	    public void focusGained(final java.awt.event.FocusEvent evt) {
	    	    	SwingUtilities.invokeLater( new Runnable() {
	    				@Override
	    				public void run() {
	    					((JTextComponent) evt.getComponent()).selectAll();		
	    				}
	    			});
	    	    }
	    	});
			config.add(TAList.get(i));
			y+=45;	// offset between the tops of text areas
		}
	}
	
	private void initConfigLBL() {			// creates labels on config page
		JLabel templbl;
		
		lbl_gs = new JLabel("Group Size");
		lbl_gs.setBounds(65, 10, 65, 30);
		config.add(lbl_gs);
		
		int y=54;
		for(int i=0;i<6;++i) {
			templbl = new JLabel("Player " + (i+1));
			templbl.setBounds(10, y, 50, 30);
			LBLList.add(templbl);
			config.add(LBLList.get(i));
			y+=45;
		}	
	}
	
	private void initConfigRB() {			// creates radio buttons on config page
		rb_fiveman.setText("5");
		rb_fiveman.setBounds(145, 11, 40, 30);
		rb_fiveman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { configRBAction(e);	}
		});
		bg_numplayers.add(rb_fiveman);	
		config.add(rb_fiveman);
		
		fb_sixman.setText("6");
		fb_sixman.setBounds(200, 11, 40, 30);
		fb_sixman.setSelected(true);
		fb_sixman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { configRBAction(e); }
		});
		bg_numplayers.add(fb_sixman);
		config.add(fb_sixman);
	}
	
	private void initConfigbtsubmit() {		// creates submit button on config page
		bt_submit.setText("Submit");
		bt_submit.setBounds(65, 325, 200, 70);
		bt_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { submitAction(e); }
		});
		bt_submit.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    	bt_submit.transferFocusBackward();
                    } else {
                    	bt_submit.transferFocus();
                    }
                    e.consume();
                }
            }
		});
		config.add(bt_submit);
	}
	
	private void initMUnotBT() {		// creates non-button components on matchup page
		JComboBox<String> tempbox;
		JRadioButton temprb;
		JTextField temptxt;
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(0, 0, 5, 5);
		
		for(int i=0;i<15;++i) {
			temprb = new JRadioButton();
			tempbox = new JComboBox<String>();
			temptxt = new JTextField();
			
			// left radio
			temprb.setName("rb_m" + (i+1) + "_left");
			RBLeftList.add(temprb);

			// left combo box
			tempbox.setName("cb_m" + (i+1) + "_left");
			CBLeftList.add(tempbox);
			
			// text field
			temptxt.setEditable(false);
			temptxt.setColumns(10);
			temptxt.setHorizontalAlignment(SwingConstants.CENTER);
			temptxt.setText("M" + (i+1));
			temptxt.setName("tf_m" + (i+1));
			TFList.add(temptxt);
			
			// right combo box
			tempbox = new JComboBox<String>();
			tempbox.setName("cb_m" + (i+1) + "_left");
			CBRightList.add(tempbox);
			
			// left radio
			temprb = new JRadioButton();
			temprb.setName("rb_m" + (i+1) + "_left");	
			RBRightList.add(temprb);
			
			
			if (i<10) {
				gbc.gridy=i+1;	// skip a row for spacing
				gbc.gridx=0; gbc.fill=GridBagConstraints.EAST; page1.add(RBLeftList.get(i),gbc);	// left radio
				gbc.gridx=1; gbc.fill=GridBagConstraints.BOTH; page1.add(CBLeftList.get(i),gbc);	// left combo box
				gbc.gridx=2; gbc.fill=GridBagConstraints.BOTH; page1.add(TFList.get(i),gbc);		// text field
				gbc.gridx=3; gbc.fill=GridBagConstraints.BOTH; page1.add(CBRightList.get(i),gbc);	// right combo box
				gbc.gridx=4; gbc.fill=GridBagConstraints.WEST; page1.add(RBRightList.get(i),gbc);	// left radio
			}
			else {
				gbc.gridy=i-9;	// skip a row for spacing
				gbc.gridx=0; gbc.fill=GridBagConstraints.EAST; page2.add(RBLeftList.get(i),gbc);	// left radio
				gbc.gridx=1; gbc.fill=GridBagConstraints.BOTH; page2.add(CBLeftList.get(i),gbc);	// left combo box
				gbc.gridx=2; gbc.fill=GridBagConstraints.BOTH; page2.add(TFList.get(i),gbc);		// text field
				gbc.gridx=3; gbc.fill=GridBagConstraints.BOTH; page2.add(CBRightList.get(i),gbc);	// right combo box
				gbc.gridx=4; gbc.fill=GridBagConstraints.WEST; page2.add(RBRightList.get(i),gbc);	// left radio
			}
			
			// Fake radio button
			temprb = new JRadioButton("rb_m" + i + "_fake",true);
			RBFakeList.add(temprb);

			// Add the three radio buttons to group
			BGList.add(new ButtonGroup());
			BGList.get(i).add(RBLeftList.get(i));
			BGList.get(i).add(RBRightList.get(i));
			BGList.get(i).add(RBFakeList.get(i));
			lastpressedradio.add(-1);
			
			/* Listeners execute matchupRBAction which decides whether or not to select the third hidden button */
			RBLeftList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { matchupRBAction(e); }
			});
			RBRightList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { matchupRBAction(e); }
			});
		}
	}
	private void initMUBT() {		// creates buttons on matchup page
		bt_pg1 = new JButton("11-15");
		bt_pg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { cardlayout_matches.show(matches,"page2"); }
		});
		GridBagConstraints gbc_bt_pg1 = new GridBagConstraints();
		gbc_bt_pg1.gridwidth = 5;
		gbc_bt_pg1.gridx = 0;
		gbc_bt_pg1.gridy = 12;
		page1.add(bt_pg1, gbc_bt_pg1);
		
		bt_pg2 = new JButton("1-10");
		bt_pg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { cardlayout_matches.show(matches,"page1"); }
		});
		GridBagConstraints gbc_bt_pg2 = new GridBagConstraints();
		gbc_bt_pg2.gridwidth = 3;
		gbc_bt_pg2.insets = new Insets(0, 0, 0, 5);
		gbc_bt_pg2.gridx = 1;
		gbc_bt_pg2.gridy = 12;
		page2.add(bt_pg2, gbc_bt_pg2);
	}
	
	private void initResultsTable() {		// creates table on results page
		JScrollPane scrollpane_table = new JScrollPane();
		scrollpane_table.setBorder(new EmptyBorder(0,0,0,0));
		results.add(scrollpane_table, BorderLayout.CENTER);
		
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrollpane_table.setViewportView(table);
		table.setModel(new MyTableModel());
		
		setTableFormat(6);
	}
	
	private void setTableFormat(int size){
		table.getColumnModel().getColumn(5).setCellRenderer(new MyTableCellRenderer());
		table.getColumnModel().getColumn(6).setCellRenderer(new MyTableCellRenderer());
		table.getColumnModel().getColumn(7).setCellRenderer(new MyTableCellRenderer());
		table.getColumnModel().getColumn(8).setCellRenderer(new MyTableCellRenderer());
		table.getColumnModel().getColumn(9).setCellRenderer(new MyTableCellRenderer());
		
		table.setRowHeight(22);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(26);
		table.getColumnModel().getColumn(1).setMinWidth(26);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setMinWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setMinWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setMinWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(22);
		table.getColumnModel().getColumn(5).setMinWidth(22);
		table.getColumnModel().getColumn(6).setPreferredWidth(22);
		table.getColumnModel().getColumn(6).setMinWidth(22);
		table.getColumnModel().getColumn(7).setPreferredWidth(22);
		table.getColumnModel().getColumn(7).setMinWidth(22);
		table.getColumnModel().getColumn(8).setPreferredWidth(22);
		table.getColumnModel().getColumn(8).setMinWidth(22);
		table.getColumnModel().getColumn(9).setPreferredWidth(22);
		table.getColumnModel().getColumn(9).setMinWidth(22);
		
		if (size==6) {
			table.getColumnModel().getColumn(10).setCellRenderer(new MyTableCellRenderer());
			
			table.getColumnModel().getColumn(10).setPreferredWidth(22);
			table.getColumnModel().getColumn(10).setMinWidth(22);
		}
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		for(int i=0;i<5;i++){
			if (i!=2)	// don't center the name column
				table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    }
	}
	
	/* - - - Other - - - */
	public void enable() { guiframe.setVisible(true); }
	public void disable() { guiframe.setVisible(false); }
	
	/* - - - Related Classes - - - */
	public class MyData {
        private String rank;
        private String pid;
        private String name;
        private Integer wins;
        private Integer losses;
        private List<Integer> resultList = new ArrayList<Integer>(6);

        public MyData() {
        	rank = null;
        	pid = null;	// player ID (ie P1/P2/P3/P4/P5/P6)
        	name = null;
            wins = 0;
            losses = 0;
            for(int i=0;i<6;++i)
            	resultList.add(null);	// 1=beat, 0=lost, null=unplayed
        }
        
        /* */

        public Integer	getResult(int oppnum) { return resultList.get(oppnum); }
        public void		setResult(int oppnum, Integer result) { resultList.set(oppnum,result); }
        
        public String	getRank() { return rank; }
        public void		setRank(String rank_in) { rank=rank_in; }
        
        public String	getPID() { return pid; }
        public void		setPID(String pid_in) { pid=pid_in; }
        
        public String	getName() { return name; }
        public void		setName(String name_in) { name=name_in; }
        
        public Integer	getWins() { return wins; }
        public void		setWins(int wins_in) { wins=wins_in; }
        
        public Integer	getLosses() { return losses; }
        public void		setLosses(int losses_in) { losses=losses_in; }
        
        public void changeNumOpp(int size) {	// change numer of opponents (ie results)
        	while (resultList.size()>size)
        		resultList.remove(resultList.size()-1);
        	while (resultList.size()<size)
        		resultList.add(null);
        }
    }

    public class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private List<MyData> data;
        private List<String> columnnames;

        public MyTableModel() {
        	columnnames = new ArrayList<>(11);
        	columnnames.add("R");
        	columnnames.add("PID");
        	columnnames.add("Name");
        	columnnames.add("W");
        	columnnames.add("L");
        	columnnames.add("P1");
        	columnnames.add("P2");
        	columnnames.add("P3");
        	columnnames.add("P4");
        	columnnames.add("P5");
        	columnnames.add("P6");
        	data = new ArrayList<>(6);
            for(int index = 0; index < 6; index++)
                data.add(new MyData());
        }
        
        /* */

        @Override
        public int getRowCount() {
            return data.size();
        }
        
        public void addRow() {
        	data.add(new MyData());
        	((AbstractTableModel) table.getModel()).fireTableRowsDeleted(data.size()-1,data.size()-1);
        }
        
        public void removeRow() {
        	data.remove(data.size()-1);
        	((AbstractTableModel) table.getModel()).fireTableRowsDeleted(data.size(),data.size());
        }
        
        public void addColumn() {
        	columnnames.add("P6");
        	for(int i=0;i<getRowCount();++i)
        		data.get(i).changeNumOpp(6);
        	((AbstractTableModel) table.getModel()).fireTableStructureChanged();
        }

        public void removeColumn() {
        	columnnames.remove(10);
        	for(int i=0;i<getRowCount();++i)
        		data.get(i).changeNumOpp(5);
        	((AbstractTableModel) table.getModel()).fireTableStructureChanged();
        }
        
        @Override
        public int getColumnCount() {
            return columnnames.size();
        }
        
        @Override
        public String getColumnName(int column) {
        	return columnnames.get(column);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            MyData myData = data.get(rowIndex);
            Object value = null;
            switch (columnIndex) {
                case 0:
                    value = myData.getRank();
                    break;
                case 1:
                    value = myData.getPID();
                    break;
                case 2:
                    value = myData.getName();
                    break;
                case 3:
                    value = myData.getWins();
                    break;
                case 4:
                    value = myData.getLosses();
                    break;
                case 5:
                    value = myData.getResult(0);
                    break;
                case 6:
                	value = myData.getResult(1);
                    break;
                case 7:
                	value = myData.getResult(2);
                    break;
                case 8:
                	value = myData.getResult(3);
                    break;
                case 9:
                	value = myData.getResult(4);
                    break;
                case 10:
                	value = myData.getResult(5);
                    break;
            }
            return value;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
        	Class<?> classtype;
        	switch (columnIndex) {
	        	case 1:	// PID
	            	classtype = String.class;
	                break;
	            case 2:	// Name
	            	classtype = String.class;
	                break;
	            default:
	            	classtype = Integer.class;
        	}
        	return classtype;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            MyData myData = data.get(rowIndex);
            switch (columnIndex) {
	            case 0:
	                myData.setRank((String) aValue);
	                break;
	            case 1:
	                myData.setPID((String) aValue);
	                break;
	            case 2:
	                myData.setName((String) aValue);
	                break;
	            case 3:
	                myData.setWins((Integer) aValue);
	                break;
	            case 4:
	                myData.setLosses((Integer) aValue);
	                break;
	            case 5:
	                myData.setResult(0,(Integer) aValue);
	                break;
	            case 6:
	            	myData.setResult(1,(Integer) aValue);
	                break;
	            case 7:
	            	myData.setResult(2,(Integer) aValue);
	                break;
	            case 8:
	            	myData.setResult(3,(Integer) aValue);
	                break;
	            case 9:
	            	myData.setResult(4,(Integer) aValue);
	                break;
	            case 10:
	            	myData.setResult(5,(Integer) aValue);
	                break;
	        }
            ((AbstractTableModel) table.getModel()).fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    public class MyTableCellRenderer extends DefaultTableCellRenderer {
		private static final long serialVersionUID = 2L;

		@Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            TableModel model = table.getModel();
            if (model instanceof MyTableModel) {
                MyTableModel myModel = (MyTableModel) model;
                if (myModel.getValueAt(row,column) instanceof Integer && myModel.getValueAt(row,column).equals(1)) {	
                	setBackground(Color.GREEN);             	
                }
                else if (myModel.getValueAt(row,column) instanceof Integer && myModel.getValueAt(row,column).equals(0)) {
                    setBackground(Color.RED);
                }
                else
                	setBackground(Color.WHITE);
                setForeground(getBackground());
                setOpaque(true);
            }
            return this;
        }
    }
}	