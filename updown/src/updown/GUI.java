// TODO: REFACTOR: Create config textfields and labels programmatically

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class GUI {
	private JFrame guiframe = new JFrame();
	private JPanel contentpane;
	private JPanel topemptypanel;
	private JPanel topbtpanel;
	private JPanel page1, page2;
	private CardLayout card_cardpanel;
	private CardLayout card_matches;
	
	private final JTextArea ta_p1 = new JTextArea();	private final JTextArea ta_p4 = new JTextArea();
	private final JTextArea ta_p2 = new JTextArea();	private final JTextArea ta_p5 = new JTextArea();
	private final JTextArea ta_p3 = new JTextArea();	private final JTextArea ta_p6 = new JTextArea();
	
	private final JRadioButton rb_5 = new JRadioButton();
	private final JRadioButton rb_6 = new JRadioButton();
	
	private JTable table;
	
	private final JButton bt_submit = new JButton();
	private JButton bt_pg1;
	private JButton bt_pg2;
	
	private List<JTextField> TFList = new ArrayList<JTextField>(15);
	
	private List<JComboBox<String>> CBLeftList = new ArrayList<JComboBox<String>>(15);
	private List<JComboBox<String>> CBRightList = new ArrayList<JComboBox<String>>(15);
	private List<JRadioButton> RBLeftList = new ArrayList<JRadioButton>(15);
	private List<JRadioButton> RBRightList = new ArrayList<JRadioButton>(15);
	private List<JRadioButton> RBFakeList = new ArrayList<JRadioButton>(15);
	
	private final ButtonGroup bg_numplayers = new ButtonGroup();
	private List<ButtonGroup> BGList = new ArrayList<ButtonGroup>(15);
	private ArrayList<Integer> lastpressedradio = new ArrayList<Integer>(15);	// 1=left,0=right,-1=fake
	
	private int[] defaultfiveman =	{	0,1,	2,3,	0,4,	3,1,	2,4,	3,0,	1,4,	2,0,	3,4,	2,1};
	private int[] defaultsixman =	{	0,1,	2,3,	4,5,	0,2,	1,4,	3,5,	0,4,	1,3,	2,5,	0,3,
										1,5,	2,4,	0,5,	3,4,	1,2};
	
	private int pendingnumplayers=6;
	private boolean sizeswitched = true;

	public GUI() {
		guiframe.setTitle("UpDown");
		guiframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiframe.setBounds(100, 100, 320, 479);
		guiframe.setResizable(false);
		contentpane = new JPanel();
		contentpane.setBorder(null);
		guiframe.setContentPane(contentpane);
		card_cardpanel = new CardLayout();
		card_matches = new CardLayout();
		
		JPanel topbar = new JPanel();
		topbar.setLayout(new BorderLayout(0, 0));
		
		topemptypanel = new JPanel();
		topemptypanel.setBorder(new EmptyBorder(15, 0, 0, 0));
		topbar.add(topemptypanel, BorderLayout.NORTH);
		topemptypanel.setLayout(new BorderLayout(0, 0));
		
		topbtpanel = new JPanel();
		topbar.add(topbtpanel, BorderLayout.CENTER);
		topbtpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
		
		JButton bt_config = new JButton(" Config ");
		topbtpanel.add(bt_config);
		
		JButton bt_matches = new JButton("Matches");
		topbtpanel.add(bt_matches);
		
		JButton bt_results = new JButton("Results");
		topbtpanel.add(bt_results);
				
		final JPanel cardpanel = new JPanel();
		cardpanel.setLayout(card_cardpanel);
		card_cardpanel.show(cardpanel,"config");
		JPanel config = new JPanel();
		cardpanel.add(config, "config");
		config.setLayout(null);
		
		JLabel lbl_gs = new JLabel("Group Size");
		lbl_gs.setBounds(65, 10, 65, 30);
		config.add(lbl_gs);
		
		JLabel lbl_p1 = new JLabel("Player 1");
		lbl_p1.setBounds(10, 54, 50, 30);
		config.add(lbl_p1);
		
		JLabel lbl_p2 = new JLabel("Player 2");
		lbl_p2.setBounds(10, 99, 50, 30);
		config.add(lbl_p2);
		
		JLabel lbl_p3 = new JLabel("Player 3");
		lbl_p3.setBounds(10, 144, 50, 30);
		config.add(lbl_p3);
		
		JLabel lbl_p4 = new JLabel("Player 4");
		lbl_p4.setBounds(10, 189, 50, 30);
		config.add(lbl_p4);
		
		JLabel lbl_p5 = new JLabel("Player 5");
		lbl_p5.setBounds(10, 233, 50, 30);
		config.add(lbl_p5);
		
		JLabel lbl_p6 = new JLabel("Player 6");
		lbl_p6.setBounds(10, 277, 50, 30);
		config.add(lbl_p6);
		
		ta_p1.setBounds(65, 54, 200, 30);
		Font font = ta_p1.getFont();
		float size = font.getSize() + 8.0f;
		ta_p1.setFont(font.deriveFont(size));
		config.add(ta_p1);
		ta_p1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    	ta_p1.transferFocusBackward();
                    } else {
                    	ta_p1.transferFocus();
                    }
                    e.consume();
                }
            }
		});
		ta_p1.addFocusListener(new java.awt.event.FocusAdapter() {
    	    public void focusGained(java.awt.event.FocusEvent evt) {
    	    	SwingUtilities.invokeLater( new Runnable() {
    				@Override
    				public void run() {
    					ta_p1.selectAll();		
    				}
    			});
    	    }
    	});
		
		ta_p2.setBounds(65, 99, 200, 30);
		ta_p2.setFont(font.deriveFont(size));
		config.add(ta_p2);
		ta_p2.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    	ta_p2.transferFocusBackward();
                    } else {
                    	ta_p2.transferFocus();
                    }
                    e.consume();
                }
            }
		});
		ta_p2.addFocusListener(new java.awt.event.FocusAdapter() {
    	    public void focusGained(java.awt.event.FocusEvent evt) {
    	    	SwingUtilities.invokeLater( new Runnable() {
    				@Override
    				public void run() {
    					ta_p2.selectAll();		
    				}
    			});
    	    }
    	});
		
		ta_p3.setBounds(65, 144, 200, 30);
		ta_p3.setFont(font.deriveFont(size));
		config.add(ta_p3);
		ta_p3.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    	ta_p3.transferFocusBackward();
                    } else {
                    	ta_p3.transferFocus();
                    }
                    e.consume();
                }
            }
		});
		ta_p3.addFocusListener(new java.awt.event.FocusAdapter() {
    	    public void focusGained(java.awt.event.FocusEvent evt) {
    	    	SwingUtilities.invokeLater( new Runnable() {
    				@Override
    				public void run() {
    					ta_p3.selectAll();		
    				}
    			});
    	    }
    	});
				
		ta_p4.setBounds(65, 189, 200, 30);
		ta_p4.setFont(font.deriveFont(size));
		config.add(ta_p4);
		ta_p4.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    	ta_p4.transferFocusBackward();
                    } else {
                    	ta_p4.transferFocus();
                    }
                    e.consume();
                }
            }
		});
		ta_p4.addFocusListener(new java.awt.event.FocusAdapter() {
    	    public void focusGained(java.awt.event.FocusEvent evt) {
    	    	SwingUtilities.invokeLater( new Runnable() {
    				@Override
    				public void run() {
    					ta_p4.selectAll();		
    				}
    			});
    	    }
    	});
				
		ta_p5.setBounds(65, 233, 200, 30);
		ta_p5.setFont(font.deriveFont(size));
		config.add(ta_p5);
		ta_p5.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    	ta_p5.transferFocusBackward();
                    } else {
                    	ta_p5.transferFocus();
                    }
                    e.consume();
                }
            }
		});
		ta_p5.addFocusListener(new java.awt.event.FocusAdapter() {
    	    public void focusGained(java.awt.event.FocusEvent evt) {
    	    	SwingUtilities.invokeLater( new Runnable() {
    				@Override
    				public void run() {
    					ta_p5.selectAll();		
    				}
    			});
    	    }
    	});
				
		ta_p6.setBounds(65, 277, 200, 30);
		ta_p6.setFont(font.deriveFont(size));
		config.add(ta_p6);
		ta_p6.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                    	ta_p6.transferFocusBackward();
                    } else {
                    	ta_p6.transferFocus();
                    }
                    e.consume();
                }
            }
        });
		ta_p6.addFocusListener(new java.awt.event.FocusAdapter() {
    	    public void focusGained(java.awt.event.FocusEvent evt) {
    	    	SwingUtilities.invokeLater( new Runnable() {
    				@Override
    				public void run() {
    					ta_p6.selectAll();		
    				}
    			});
    	    }
    	});
		
		rb_5.setText("5");
		rb_5.setBounds(145, 11, 40, 30);
		rb_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { configRBAction(e);	}
		});
		bg_numplayers.add(rb_5);	
		config.add(rb_5);
		
		rb_6.setText("6");
		rb_6.setBounds(200, 11, 40, 30);
		rb_6.setSelected(true);
		rb_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { configRBAction(e); }
		});
		bg_numplayers.add(rb_6);
		config.add(rb_6);
		
		bt_submit.setText("Submit");
		bt_submit.setBounds(65, 325, 200, 70);
		bt_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { submitAction(e); }
		});
		config.add(bt_submit);
		
		guiframe.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ta_p1, ta_p2, ta_p3, ta_p4, ta_p5, ta_p6, bt_submit, rb_5, rb_6, bt_config, bt_matches, bt_results }));
		
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
		
		final JPanel matches = new JPanel();
		cardpanel.add(matches,"matches");
		matches.setLayout(card_matches);
		card_matches.show(matches,"page1");
		
		page1 = new JPanel();
		matches.add(page1, "page1");
		GridBagLayout gbl_page1 = new GridBagLayout();
		gbl_page1.columnWidths = new int[]{37, 100, 40, 100, 37, 0};
		gbl_page1.rowHeights = new int[] {15, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 30, 23, 0};
		gbl_page1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_page1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		page1.setLayout(gbl_page1);
		
		bt_pg1 = new JButton("11-15");
		bt_pg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { card_matches.show(matches,"page2"); }
		});
		GridBagConstraints gbc_bt_pg1 = new GridBagConstraints();
		gbc_bt_pg1.gridwidth = 5;
		gbc_bt_pg1.gridx = 0;
		gbc_bt_pg1.gridy = 12;
		page1.add(bt_pg1, gbc_bt_pg1);
		
		page2 = new JPanel();
		matches.add(page2, "page2");
		GridBagLayout gbl_page2 = new GridBagLayout();
		gbl_page2.columnWidths = new int[]{37, 100, 40, 100, 37, 0};
		gbl_page2.rowHeights = new int[]{15, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 30, 23, 0};
		gbl_page2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_page2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		page2.setLayout(gbl_page2);
		
		bt_pg2 = new JButton("1-10");
		bt_pg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { card_matches.show(matches,"page1"); }
		});
		GridBagConstraints gbc_bt_pg2 = new GridBagConstraints();
		gbc_bt_pg2.gridwidth = 3;
		gbc_bt_pg2.insets = new Insets(0, 0, 0, 5);
		gbc_bt_pg2.gridx = 1;
		gbc_bt_pg2.gridy = 12;
		page2.add(bt_pg2, gbc_bt_pg2);
		
		/* GUI related list inits */
		for(int i=0;i<15;++i) {
			lastpressedradio.add(-1);
			BGList.add(new ButtonGroup());
		}
		initMULayout();
		
		contentpane.setLayout(new BorderLayout(0, 0));
		contentpane.add(topbar, BorderLayout.NORTH);
		contentpane.add(cardpanel, BorderLayout.CENTER);
		
		JPanel results = new JPanel();
		cardpanel.add(results, "results");
		results.setLayout(new BorderLayout(0, 0));
		
		JPanel emptypanel = new JPanel();
		emptypanel.setBorder(new EmptyBorder(15, 0, 0, 0));
		results.add(emptypanel, BorderLayout.NORTH);
		emptypanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollpane_table = new JScrollPane();
		results.add(scrollpane_table);
		
		table = new JTable();
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		scrollpane_table.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"R", "#", "Name", "W", "L", "P1", "P2", "P3", "P4", "P5", "P6"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(0).setMinWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setMinWidth(100);
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
		table.getColumnModel().getColumn(10).setPreferredWidth(22);
		table.getColumnModel().getColumn(10).setMinWidth(22);
		table.setRowHeight(30);
		
		/* These switch between the main panels (config/matches/results) */
		bt_config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { card_cardpanel.show(cardpanel,"config"); }
		});
		
		bt_matches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_cardpanel.show(cardpanel,"matches");
				if (UpDown.numplayers==5)	// force it matchup card to show page1 if 5 players (shouldn't be able to see page2)
					card_matches.show(matches,"page1");
			}
		});
		
		bt_results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { card_cardpanel.show(cardpanel,"results"); }
		});

		/* Listeners execute matchupRBAction which decides whether or not to select the third hidden button */
		for (int i=0;i<15;++i) {
			RBLeftList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { matchupRBAction(e); }
			});
			RBRightList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) { matchupRBAction(e); }
			});
		}
	}
	
	private void initRoster() {
		fixTextLength();	// only allow 8 characters (breaks gridbaglayout otherwise)
		UpDown.roster.add(new Player(ta_p1.getText()));
	 	UpDown.roster.add(new Player(ta_p2.getText()));
	 	UpDown.roster.add(new Player(ta_p3.getText()));
	 	UpDown.roster.add(new Player(ta_p4.getText()));
	 	UpDown.roster.add(new Player(ta_p5.getText()));
	 	if (UpDown.numplayers==6) {
	 		UpDown.roster.add(new Player(ta_p6.getText()));
	 	}
	}
	
	private void updateRoster() {
		fixTextLength();	// only allow 8 characters (breaks gridbaglayout otherwise)
		UpDown.roster.get(0).setName(ta_p1.getText());
		UpDown.roster.get(1).setName(ta_p2.getText());
		UpDown.roster.get(2).setName(ta_p3.getText());
		UpDown.roster.get(3).setName(ta_p4.getText());
		UpDown.roster.get(4).setName(ta_p5.getText());
		if (UpDown.numplayers==6 && sizeswitched) {				// 5 man switching to 6
			UpDown.roster.add(new Player(ta_p6.getText()));			// add new player
		}
		else if (UpDown.roster.size()==6 && sizeswitched) {		// 6 man switching to 5
			UpDown.roster.remove(5);								// remove player 6
	 	}
		else if (UpDown.roster.size()==6) {						// 6 man staying 6
			UpDown.roster.get(5).setName(ta_p6.getText());			// update player 6
	 	}
	}
	
	private void updateComboBoxes() {
		int tempindexleft,tempindexright;
		
		for (int i=0; i<15;++i) {
			tempindexleft=CBLeftList.get(i).getSelectedIndex();		// get all selected indexes
			tempindexright=CBRightList.get(i).getSelectedIndex();
			CBLeftList.get(i).removeAllItems();						// delete all entries
			CBRightList.get(i).removeAllItems();
			for(Player p : UpDown.roster) {							// add all entries
				CBLeftList.get(i).addItem(p.getName());
				CBRightList.get(i).addItem(p.getName());
			}
			if (UpDown.numplayers==5 && i>=10)
				break;
			if (!sizeswitched) {									// set to previous selection unless size changed
				CBLeftList.get(i).setSelectedIndex(tempindexleft);
				CBRightList.get(i).setSelectedIndex(tempindexright);
			}
			else if (UpDown.numplayers==5) {
				CBLeftList.get(i).setSelectedIndex(defaultfiveman[i*2]);
				CBRightList.get(i).setSelectedIndex(defaultfiveman[(i*2)+1]);
			}
			else if (UpDown.numplayers==6) {
				CBLeftList.get(i).setSelectedIndex(defaultsixman[i*2]);
				CBRightList.get(i).setSelectedIndex(defaultsixman[(i*2)+1]);
			}
		}
		sizeswitched=false;
	}
	
	private boolean notAllBlankNames() {
		if (UpDown.numplayers==5) {
			if (!ta_p1.getText().isEmpty() && !ta_p2.getText().isEmpty() && !ta_p3.getText().isEmpty() && !ta_p4.getText().isEmpty() && !ta_p5.getText().isEmpty())
				return true;
		}
		else {
			if (!ta_p1.getText().isEmpty() && !ta_p2.getText().isEmpty() && !ta_p3.getText().isEmpty() && !ta_p4.getText().isEmpty() && !ta_p5.getText().isEmpty() & !ta_p6.getText().isEmpty())
				return true;
		}
		return false;			
	}
	
	private void fixTextLength() {
		if (ta_p1.getText().length()>8)
			ta_p1.setText(ta_p1.getText().substring(0, 8));
		
		if (ta_p2.getText().length()>8)
			ta_p2.setText(ta_p2.getText().substring(0, 8));

		if (ta_p3.getText().length()>8)
			ta_p3.setText(ta_p3.getText().substring(0, 8));
		
		if (ta_p4.getText().length()>8)
			ta_p4.setText(ta_p4.getText().substring(0, 8));

		if (ta_p5.getText().length()>8)
			ta_p5.setText(ta_p5.getText().substring(0, 8));

		if (ta_p6.getText().length()>8)
			ta_p6.setText(ta_p6.getText().substring(0, 8));
	}
	
	/* - - - actionListeners - - - */
	private void submitAction(ActionEvent e) {
		if (UpDown.numplayers!=pendingnumplayers)
		{
			sizeswitched=true;
			UpDown.numplayers=pendingnumplayers;
		}
		if (notAllBlankNames()) {
			if (UpDown.roster.isEmpty())
				initRoster();
			else
				updateRoster();
			updateComboBoxes();
			System.out.println("");																// DEMO
			for(int i=1;i<UpDown.roster.size()+1;++i) {											// DEMO
				System.out.println("Player " + i + ": " + UpDown.roster.get(i-1).getName());	// DEMO
			}
		}
	}
	
	private void configRBAction(ActionEvent e) {		// when radio5 is selected -> disable player 6 textarea
		if ( (JRadioButton) e.getSource() == rb_5) {
			pendingnumplayers=5;
			ta_p6.setBackground(Color.LIGHT_GRAY);
			ta_p6.setEnabled(false);
			bt_pg1.setEnabled(false);
		}
		else {
			pendingnumplayers=6;
			ta_p6.setBackground(Color.WHITE);
			ta_p6.setEnabled(true);
			bt_pg1.setEnabled(true);
		}
	}
	
	private void matchupRBAction(ActionEvent e) {
		int index,right=0;
		
		if (RBLeftList.contains((JRadioButton) e.getSource())) {
			index=RBLeftList.indexOf((JRadioButton) e.getSource());		
			System.out.println("Match " + (index+1) + " left pressed");		// DEMO
		}
		else {
			index=RBRightList.indexOf((JRadioButton) e.getSource());
			System.out.println("Match " + (index+1) + " right pressed");	// DEMO
			right=1;
		}
		if(lastpressedradio.get(index)==1-right) {		// 1=left 0=right
        	RBFakeList.get(index).setSelected(true);
        	lastpressedradio.set(index,-1);
        }
        else
        	lastpressedradio.set(index,1-right);
	}
	
	/* - - - GUI Inits - - - */
	private void initMULayout() {
		JComboBox<String> tempbox;
		JRadioButton temprb;
		JTextField temptxt;
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.insets = new Insets(0, 0, 5, 5);
		
		for (int i=0;i<15;++i) {
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
				gbc.gridx=0; gbc.fill=GridBagConstraints.EAST; page1.add(RBLeftList.get(i),gbc);
				gbc.gridx=1; gbc.fill=GridBagConstraints.BOTH; page1.add(CBLeftList.get(i),gbc);
				gbc.gridx=2; gbc.fill=GridBagConstraints.BOTH; page1.add(TFList.get(i),gbc);
				gbc.gridx=3; gbc.fill=GridBagConstraints.BOTH; page1.add(CBRightList.get(i),gbc);
				gbc.gridx=4; gbc.fill=GridBagConstraints.WEST; page1.add(RBRightList.get(i),gbc);
			}
			else {
				gbc.gridy=i-9;	// skip a row for spacing
				gbc.gridx=0; gbc.fill=GridBagConstraints.EAST; page2.add(RBLeftList.get(i),gbc);
				gbc.gridx=1; gbc.fill=GridBagConstraints.BOTH; page2.add(CBLeftList.get(i),gbc);
				gbc.gridx=2; gbc.fill=GridBagConstraints.BOTH; page2.add(TFList.get(i),gbc);
				gbc.gridx=3; gbc.fill=GridBagConstraints.BOTH; page2.add(CBRightList.get(i),gbc);
				gbc.gridx=4; gbc.fill=GridBagConstraints.WEST; page2.add(RBRightList.get(i),gbc);
			}
			
			// Fake radio button
			temprb = new JRadioButton("rb_m" + i + "_fake",true);
			RBFakeList.add(temprb);

			// Add the three radio buttons to group
			BGList.get(i).add(RBLeftList.get(i));
			BGList.get(i).add(RBRightList.get(i));
			BGList.get(i).add(RBFakeList.get(i));
		}
	}
	
	/* - - - Other - - - */
	public void enable() { guiframe.setVisible(true); }
	public void disable() { guiframe.setVisible(false); }
}