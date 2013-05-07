/* Built with WindowBuilder Pro */
// note: matchup combo boxes dont show in builder*/

// TODO: REFACTOR: Create matchup textfields programmatically

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
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
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
	private CardLayout card_cardpanel;
	private CardLayout card_matches;
	
	private final JTextArea ta_p1 = new JTextArea();	private final JTextArea ta_p4 = new JTextArea();
	private final JTextArea ta_p2 = new JTextArea();	private final JTextArea ta_p5 = new JTextArea();
	private final JTextArea ta_p3 = new JTextArea();	private final JTextArea ta_p6 = new JTextArea();
	
	private final JRadioButton rb_5 = new JRadioButton("5");
	private final JRadioButton rb_6 = new JRadioButton("6");
	
	private final Action action = new SubmitAction();
	private final Action action_1 = new Radio5Action();
	private final Action action_2 = new Radio6Action();
	
	private JTextField	txtM1,	txtM6,	txtM11,
						txtM2,	txtM7,	txtM12,
						txtM3,	txtM8,	txtM13,
						txtM4,	txtM9,	txtM14,
						txtM5,	txtM10,	txtM15;

	private JTable table;
	
	private final JButton bt_submit = new JButton("Submit");
	private JButton bt_pg1;
	private JButton bt_pg2;
	
	JPanel page1, page2, rb_fakes_here;
	
	private List<JComboBox<String>> CBList = new ArrayList<JComboBox<String>>(30);

	private final ButtonGroup bg_numplayers = new ButtonGroup();
	
	private List<JRadioButton> RBList = new ArrayList<JRadioButton>(30);
	private List<JRadioButton> FRBList = new ArrayList<JRadioButton>(15);
	private List<ButtonGroup> BGList = new ArrayList<ButtonGroup>(15);
	
	private JPanel topemptypanel;
	private JPanel topbtpanel;
	
	private ArrayList<Integer> lastpressedradio = new ArrayList<Integer>(15);	// 1=left,0=right,-1=fake
	private int pendingnumplayers=6;
	private boolean sizeswitched = true;
	private int[] defaultfiveman =	{	0,1,	2,3,	0,4,	3,1,	2,4,	3,0,	1,4,	2,0,	3,4,	2,1};
	private int[] defaultsixman =	{	0,1,	2,3,	4,5,	0,2,	1,4,	3,5,	0,4,	1,3,	2,5,	0,3,
										1,5,	2,4,	0,5,	3,4,	1,2};

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
		lbl_gs.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
		
		bg_numplayers.add(rb_5);
		rb_5.setAction(action_1);
		rb_5.setBounds(145, 11, 40, 30);
		config.add(rb_5);
		
		rb_6.setAction(action_2);
		rb_6.setSelected(true);
		bg_numplayers.add(rb_6);
		rb_6.setBounds(200, 11, 40, 30);
		config.add(rb_6);
		
		bt_submit.setAction(action);
		bt_submit.setBounds(65, 325, 200, 70);
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
		
		txtM1 = new JTextField();
		txtM1.setEditable(false);
		txtM1.setHorizontalAlignment(SwingConstants.CENTER);
		txtM1.setText("M1");
		GridBagConstraints gbc_txtM1 = new GridBagConstraints();
		gbc_txtM1.fill = GridBagConstraints.BOTH;
		gbc_txtM1.insets = new Insets(0, 0, 5, 5);
		gbc_txtM1.gridx = 2;
		gbc_txtM1.gridy = 1;
		page1.add(txtM1, gbc_txtM1);
		txtM1.setColumns(10);
		
		txtM2 = new JTextField();
		txtM2.setEditable(false);
		txtM2.setText("M2");
		txtM2.setHorizontalAlignment(SwingConstants.CENTER);
		txtM2.setColumns(10);
		GridBagConstraints gbc_txtM2 = new GridBagConstraints();
		gbc_txtM2.fill = GridBagConstraints.BOTH;
		gbc_txtM2.insets = new Insets(0, 0, 5, 5);
		gbc_txtM2.gridx = 2;
		gbc_txtM2.gridy = 2;
		page1.add(txtM2, gbc_txtM2);
		
		txtM3 = new JTextField();
		txtM3.setEditable(false);
		txtM3.setText("M3");
		txtM3.setHorizontalAlignment(SwingConstants.CENTER);
		txtM3.setColumns(10);
		GridBagConstraints gbc_txtM3 = new GridBagConstraints();
		gbc_txtM3.fill = GridBagConstraints.BOTH;
		gbc_txtM3.insets = new Insets(0, 0, 5, 5);
		gbc_txtM3.gridx = 2;
		gbc_txtM3.gridy = 3;
		page1.add(txtM3, gbc_txtM3);

		txtM4 = new JTextField();
		txtM4.setEditable(false);
		txtM4.setText("M4");
		txtM4.setHorizontalAlignment(SwingConstants.CENTER);
		txtM4.setColumns(10);
		GridBagConstraints gbc_txtM4 = new GridBagConstraints();
		gbc_txtM4.fill = GridBagConstraints.BOTH;
		gbc_txtM4.insets = new Insets(0, 0, 5, 5);
		gbc_txtM4.gridx = 2;
		gbc_txtM4.gridy = 4;
		page1.add(txtM4, gbc_txtM4);
		
		txtM5 = new JTextField();
		txtM5.setEditable(false);
		txtM5.setText("M5");
		txtM5.setHorizontalAlignment(SwingConstants.CENTER);
		txtM5.setColumns(10);
		GridBagConstraints gbc_txtM5 = new GridBagConstraints();
		gbc_txtM5.fill = GridBagConstraints.BOTH;
		gbc_txtM5.insets = new Insets(0, 0, 5, 5);
		gbc_txtM5.gridx = 2;
		gbc_txtM5.gridy = 5;
		page1.add(txtM5, gbc_txtM5);
		
		txtM6 = new JTextField();
		txtM6.setEditable(false);
		txtM6.setText("M6");
		txtM6.setHorizontalAlignment(SwingConstants.CENTER);
		txtM6.setColumns(10);
		GridBagConstraints gbc_txtM6 = new GridBagConstraints();
		gbc_txtM6.fill = GridBagConstraints.BOTH;
		gbc_txtM6.insets = new Insets(0, 0, 5, 5);
		gbc_txtM6.gridx = 2;
		gbc_txtM6.gridy = 6;
		page1.add(txtM6, gbc_txtM6);
		
		txtM7 = new JTextField();
		txtM7.setEditable(false);
		txtM7.setText("M7");
		txtM7.setHorizontalAlignment(SwingConstants.CENTER);
		txtM7.setColumns(10);
		GridBagConstraints gbc_txtM7 = new GridBagConstraints();
		gbc_txtM7.fill = GridBagConstraints.BOTH;
		gbc_txtM7.insets = new Insets(0, 0, 5, 5);
		gbc_txtM7.gridx = 2;
		gbc_txtM7.gridy = 7;
		page1.add(txtM7, gbc_txtM7);

		txtM8 = new JTextField();
		txtM8.setEditable(false);
		txtM8.setText("M8");
		txtM8.setHorizontalAlignment(SwingConstants.CENTER);
		txtM8.setColumns(10);
		GridBagConstraints gbc_txtM8 = new GridBagConstraints();
		gbc_txtM8.fill = GridBagConstraints.BOTH;
		gbc_txtM8.insets = new Insets(0, 0, 5, 5);
		gbc_txtM8.gridx = 2;
		gbc_txtM8.gridy = 8;
		page1.add(txtM8, gbc_txtM8);
		
		txtM9 = new JTextField();
		txtM9.setEditable(false);
		txtM9.setText("M9");
		txtM9.setHorizontalAlignment(SwingConstants.CENTER);
		txtM9.setColumns(10);
		GridBagConstraints gbc_txtM9 = new GridBagConstraints();
		gbc_txtM9.fill = GridBagConstraints.BOTH;
		gbc_txtM9.insets = new Insets(0, 0, 5, 5);
		gbc_txtM9.gridx = 2;
		gbc_txtM9.gridy = 9;
		page1.add(txtM9, gbc_txtM9);
		
		txtM10 = new JTextField();
		txtM10.setEditable(false);
		txtM10.setText("M10");
		txtM10.setHorizontalAlignment(SwingConstants.CENTER);
		txtM10.setColumns(10);
		GridBagConstraints gbc_txtM10 = new GridBagConstraints();
		gbc_txtM10.fill = GridBagConstraints.BOTH;
		gbc_txtM10.insets = new Insets(0, 0, 5, 5);
		gbc_txtM10.gridx = 2;
		gbc_txtM10.gridy = 10;
		page1.add(txtM10, gbc_txtM10);
		
		bt_pg1 = new JButton("11-15");
		bt_pg1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card_matches.show(matches,"page2");
			}
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
		
		
		/* init lists */
		for(int i=0;i<15;++i) {
			lastpressedradio.add(-1);
			BGList.add(new ButtonGroup());
		}
		initCBRBLists();
		initFRBList();
		
		txtM11 = new JTextField();
		txtM11.setEditable(false);
		txtM11.setText("M11");
		txtM11.setHorizontalAlignment(SwingConstants.CENTER);
		txtM11.setColumns(10);
		GridBagConstraints gbc_txtM11 = new GridBagConstraints();
		gbc_txtM11.fill = GridBagConstraints.BOTH;
		gbc_txtM11.insets = new Insets(0, 0, 5, 5);
		gbc_txtM11.gridx = 2;
		gbc_txtM11.gridy = 1;
		page2.add(txtM11, gbc_txtM11);
		
		txtM12 = new JTextField();
		txtM12.setEditable(false);
		txtM12.setText("M12");
		txtM12.setHorizontalAlignment(SwingConstants.CENTER);
		txtM12.setColumns(10);
		GridBagConstraints gbc_txtM12 = new GridBagConstraints();
		gbc_txtM12.fill = GridBagConstraints.BOTH;
		gbc_txtM12.insets = new Insets(0, 0, 5, 5);
		gbc_txtM12.gridx = 2;
		gbc_txtM12.gridy = 2;
		page2.add(txtM12, gbc_txtM12);
		
		txtM13 = new JTextField();
		txtM13.setEditable(false);
		txtM13.setText("M13");
		txtM13.setHorizontalAlignment(SwingConstants.CENTER);
		txtM13.setColumns(10);
		GridBagConstraints gbc_txtM13 = new GridBagConstraints();
		gbc_txtM13.fill = GridBagConstraints.BOTH;
		gbc_txtM13.insets = new Insets(0, 0, 5, 5);
		gbc_txtM13.gridx = 2;
		gbc_txtM13.gridy = 3;
		page2.add(txtM13, gbc_txtM13);
		
		txtM14 = new JTextField();
		txtM14.setEditable(false);
		txtM14.setText("M14");
		txtM14.setHorizontalAlignment(SwingConstants.CENTER);
		txtM14.setColumns(10);
		GridBagConstraints gbc_txtM14 = new GridBagConstraints();
		gbc_txtM14.fill = GridBagConstraints.BOTH;
		gbc_txtM14.insets = new Insets(0, 0, 5, 5);
		gbc_txtM14.gridx = 2;
		gbc_txtM14.gridy = 4;
		page2.add(txtM14, gbc_txtM14);
		txtM15 = new JTextField();
		txtM15.setEditable(false);
		txtM15.setText("M15");
		txtM15.setHorizontalAlignment(SwingConstants.CENTER);
		txtM15.setColumns(10);
		GridBagConstraints gbc_txtM15 = new GridBagConstraints();
		gbc_txtM15.fill = GridBagConstraints.BOTH;
		gbc_txtM15.insets = new Insets(0, 0, 5, 5);
		gbc_txtM15.gridx = 2;
		gbc_txtM15.gridy = 5;
		page2.add(txtM15, gbc_txtM15);
		
		bt_pg2 = new JButton("1-10");
		bt_pg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_matches.show(matches,"page1");
			}
		});
		GridBagConstraints gbc_bt_pg2 = new GridBagConstraints();
		gbc_bt_pg2.gridwidth = 3;
		gbc_bt_pg2.insets = new Insets(0, 0, 0, 5);
		gbc_bt_pg2.gridx = 1;
		gbc_bt_pg2.gridy = 12;
		page2.add(bt_pg2, gbc_bt_pg2);
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
			public void actionPerformed(ActionEvent e) {
				card_cardpanel.show(cardpanel,"config");
			}
		});
		
		bt_matches.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_cardpanel.show(cardpanel,"matches");
				if (rb_5.isSelected())
					card_matches.show(matches,"page1");
			}
		});
		
		bt_results.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_cardpanel.show(cardpanel,"results");
			}
		});

		/* Listeners execute RBLogic which decides whether or not to select the third hidden button */
		for (int i=0;i<30;++i) {
			RBList.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbLogic(e);
				}
			});
		}
	}
	
	private class SubmitAction extends AbstractAction {
		private static final long serialVersionUID = 2L;
		public SubmitAction() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Submit player data.");
		}
		public void actionPerformed(ActionEvent e) {
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
	}
	
	private class Radio5Action extends AbstractAction {		// when radio5 is selected -> disable player 6 textarea
		private static final long serialVersionUID = 3L;
		public Radio5Action() {
			putValue(NAME, "5");
			putValue(SHORT_DESCRIPTION, "5 man group");
		}
		public void actionPerformed(ActionEvent e) {
			pendingnumplayers=5;
			ta_p6.setBackground(Color.LIGHT_GRAY);
			ta_p6.setEnabled(false);
			bt_pg1.setEnabled(false);
		}
	}
	
	private class Radio6Action extends AbstractAction {		// when radio6 is selected -> enable player 6 textarea
		private static final long serialVersionUID = 4L;
		public Radio6Action() {
			putValue(NAME, "6");
			putValue(SHORT_DESCRIPTION, "6 man group");
		}
		public void actionPerformed(ActionEvent e) {
			pendingnumplayers=6;
			ta_p6.setBackground(Color.WHITE);
			ta_p6.setEnabled(true);
			bt_pg1.setEnabled(true);
		}
	}
	
	private void rbLogic(ActionEvent e) {
		boolean left = RBList.indexOf(((JRadioButton) e.getSource()))%2==0;
		int index = RBList.indexOf(((JRadioButton) e.getSource()))/2;
		
		if (left) {
			System.out.println("Match " + (index+1) + " left pressed");		// DEMO
	        if(lastpressedradio.get(index)==1) {
	        	FRBList.get(index).setSelected(true);
	        	lastpressedradio.set(index,-1);
	        }
	        else
	        	lastpressedradio.set(index,1);
		}
		else {
			System.out.println("Match " + (index+1) + " right pressed");	// DEMO
			if(lastpressedradio.get(index)==0) {
				FRBList.get(index).setSelected(true);
				lastpressedradio.set(index,-1);
	        }
	        else
	        	lastpressedradio.set(index,0);
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
		int tempindex;

		for (int i=0; i<30;++i) {
			tempindex=CBList.get(i).getSelectedIndex();		// get all selected indexes
			CBList.get(i).removeAllItems();					// delete all entries
			for(Player p : UpDown.roster) {					// add all entries
				CBList.get(i).addItem(p.getName());
			}
			if (UpDown.numplayers==5 && i>=20)
				break;
			if (!sizeswitched)								// set to previous selection unless size changed
				CBList.get(i).setSelectedIndex(tempindex);
			else if (UpDown.numplayers==5)
				CBList.get(i).setSelectedIndex(defaultfiveman[i]);
			else if (UpDown.numplayers==6)
				CBList.get(i).setSelectedIndex(defaultsixman[i]);
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
	
	private void initCBRBLists() {
		JComboBox<String> tempbox;
		JRadioButton temprb;
		GridBagConstraints gbc;
		int x_cb,x_rb,y;
		for (int i=0;i<30;++i)
		{
			x_cb=0; x_rb=0; y=0;
			tempbox = new JComboBox<String>();
			temprb = new JRadioButton();
			gbc = new GridBagConstraints();
			gbc.insets = new Insets(0, 0, 5, 5);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			if (i<20 && i%2==0) {		// first page left
				x_cb=1; x_rb=0; y=(i/2)+1;
				tempbox.setName("cb_m" + y + "_left");
				temprb.setName("rb_m" + y + "_left");
			}
			else if (i<20) {			// first page right
				x_cb=3; x_rb=4; y=(i/2)+1;
				tempbox.setName("cb_m" + y + "_right");
				temprb.setName("rb_m" + y + "_right");
			}
			else if (i%2==0) {			// second page left
				x_cb=1; x_rb=0; y=((i-20)/2)+1;
				tempbox.setName("cb_m" + y + "_left");
				temprb.setName("rb_m" + y + "_left");
			}
			else {						// second page right
				x_cb=3; x_rb=4; y=((i-21)/2)+1;
				tempbox.setName("cb_m" + y + "_right");
				temprb.setName("rb_m" + y + "_right");
			}
			gbc.gridx = x_cb;
			gbc.gridy = y;
			CBList.add(tempbox);
			RBList.add(temprb);
			BGList.get(i/2).add(RBList.get(i));
			if (i<20) {
				page1.add(CBList.get(i), gbc);
				gbc.gridx = x_rb;
				page1.add(RBList.get(i), gbc);
			}
			else {
				page2.add(CBList.get(i), gbc);
				gbc.gridx = x_rb;
				page2.add(RBList.get(i), gbc);
			}
		}
	}
	
	private void initFRBList() {
		JRadioButton temprb;
		for (int i=0;i<15;++i) {
			temprb = new JRadioButton("rb_m" + i + "_fake",true);
			FRBList.add(temprb);
			BGList.get(i).add(FRBList.get(i));
		}
	}
	
	public void enable() {
		guiframe.setVisible(true);
	}
	public void disable() {
		guiframe.setVisible(false);
	}
}