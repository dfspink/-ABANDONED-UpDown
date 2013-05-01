/* Built with WindowBuilder Pro */

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
	
	private final JTextArea ta_p1 = new JTextArea();
	private final JTextArea ta_p2 = new JTextArea();
	private final JTextArea ta_p3 = new JTextArea();
	private final JTextArea ta_p4 = new JTextArea();
	private final JTextArea ta_p5 = new JTextArea();
	private final JTextArea ta_p6 = new JTextArea();
	
	private final JRadioButton rb_5 = new JRadioButton("5");
	private final JRadioButton rb_6 = new JRadioButton("6");
	
	private final Action action = new SubmitAction();
	private final Action action_1 = new Radio5Action();
	private final Action action_2 = new Radio6Action();
	
	private JTextField txtM1;	private JTextField txtM6;	private JTextField txtM11;
	private JTextField txtM2;	private JTextField txtM7;	private JTextField txtM12;
	private JTextField txtM3;	private JTextField txtM8;	private JTextField txtM13;
	private JTextField txtM4;	private JTextField txtM9;	private JTextField txtM14;
	private JTextField txtM5;	private JTextField txtM10;	private JTextField txtM15;

	private JTable table;
	
	private final JButton bt_submit = new JButton("Submit");
	private JButton bt_pg1;
	private JButton bt_pg2;
	
	private JComboBox<String> cb_m1_left;	private JComboBox<String> cb_m1_right;
	private JComboBox<String> cb_m2_left;	private JComboBox<String> cb_m2_right;
	private JComboBox<String> cb_m3_left;	private JComboBox<String> cb_m3_right;
	private JComboBox<String> cb_m4_left;	private JComboBox<String> cb_m4_right;
	private JComboBox<String> cb_m5_left;	private JComboBox<String> cb_m5_right;
	private JComboBox<String> cb_m6_left;	private JComboBox<String> cb_m6_right;
	private JComboBox<String> cb_m7_left;	private JComboBox<String> cb_m7_right;
	private JComboBox<String> cb_m8_left;	private JComboBox<String> cb_m8_right;
	private JComboBox<String> cb_m9_left;	private JComboBox<String> cb_m9_right;
	private JComboBox<String> cb_m10_left;	private JComboBox<String> cb_m10_right;
	private JComboBox<String> cb_m11_left;	private JComboBox<String> cb_m11_right;
	private JComboBox<String> cb_m12_left;	private JComboBox<String> cb_m12_right;
	private JComboBox<String> cb_m13_left;	private JComboBox<String> cb_m13_right;
	private JComboBox<String> cb_m14_left;	private JComboBox<String> cb_m14_right;
	private JComboBox<String> cb_m15_left;	private JComboBox<String> cb_m15_right;

	private final ButtonGroup bg_numplayers = new ButtonGroup();
	private final ButtonGroup bg_m1 = new ButtonGroup();	private final ButtonGroup bg_m9 = new ButtonGroup();
	private final ButtonGroup bg_m2 = new ButtonGroup();	private final ButtonGroup bg_m10 = new ButtonGroup();
	private final ButtonGroup bg_m3 = new ButtonGroup();	private final ButtonGroup bg_m11 = new ButtonGroup();
	private final ButtonGroup bg_m4 = new ButtonGroup();	private final ButtonGroup bg_m12 = new ButtonGroup();
	private final ButtonGroup bg_m5 = new ButtonGroup();	private final ButtonGroup bg_m13 = new ButtonGroup();
	private final ButtonGroup bg_m6 = new ButtonGroup();	private final ButtonGroup bg_m14 = new ButtonGroup();
	private final ButtonGroup bg_m7 = new ButtonGroup();	private final ButtonGroup bg_m15 = new ButtonGroup();
	private final ButtonGroup bg_m8 = new ButtonGroup();
	
	private JRadioButton rb_m1_left;	private JRadioButton rb_m1_right;	private JRadioButton rb_m1_fake;
	private JRadioButton rb_m2_left;	private JRadioButton rb_m2_right;	private JRadioButton rb_m2_fake;
	private JRadioButton rb_m3_left;	private JRadioButton rb_m3_right;	private JRadioButton rb_m3_fake;
	private JRadioButton rb_m4_left;	private JRadioButton rb_m4_right;	private JRadioButton rb_m4_fake;
	private JRadioButton rb_m5_left;	private JRadioButton rb_m5_right;	private JRadioButton rb_m5_fake;
	private JRadioButton rb_m6_left;	private JRadioButton rb_m6_right;	private JRadioButton rb_m6_fake;
	private JRadioButton rb_m7_left;	private JRadioButton rb_m7_right;	private JRadioButton rb_m7_fake;
	private JRadioButton rb_m8_left;	private JRadioButton rb_m8_right;	private JRadioButton rb_m8_fake;
	private JRadioButton rb_m9_left;	private JRadioButton rb_m9_right;	private JRadioButton rb_m9_fake;
	private JRadioButton rb_m10_left;	private JRadioButton rb_m10_right;	private JRadioButton rb_m10_fake;
	private JRadioButton rb_m11_left;	private JRadioButton rb_m11_right;	private JRadioButton rb_m11_fake;
	private JRadioButton rb_m12_left;	private JRadioButton rb_m12_right;	private JRadioButton rb_m12_fake;
	private JRadioButton rb_m13_left;	private JRadioButton rb_m13_right;	private JRadioButton rb_m13_fake;
	private JRadioButton rb_m14_left;	private JRadioButton rb_m14_right;	private JRadioButton rb_m14_fake;
	private JRadioButton rb_m15_left;	private JRadioButton rb_m15_right;	private JRadioButton rb_m15_fake;
	
	private ArrayList<Integer> lastpressedradio = new ArrayList<Integer>(15);	// 1=left,0=right,-1=fake	
	private JPanel topemptypanel;
	private JPanel topbtpanel;
	
	public GUI() {
		for(int i=0;i<15;++i)
			lastpressedradio.add(-1);
		guiframe.setTitle("Up/Down");
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
		
		config.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ta_p1, ta_p2, ta_p3, ta_p4, ta_p5, ta_p6, rb_5, rb_6, bt_submit}));
		guiframe.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{ta_p1, ta_p2, ta_p3, ta_p4, ta_p5, ta_p6, rb_5, rb_6, bt_submit}));
		
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
		
		JPanel page1 = new JPanel();
		matches.add(page1, "page1");
		GridBagLayout gbl_page1 = new GridBagLayout();
		gbl_page1.columnWidths = new int[]{37, 100, 40, 100, 37, 0};
		gbl_page1.rowHeights = new int[] {15, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 30, 23, 0};
		gbl_page1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_page1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		page1.setLayout(gbl_page1);
		
		rb_m1_left = new JRadioButton("");
		bg_m1.add(rb_m1_left);
		GridBagConstraints gbc_rb_m1_left = new GridBagConstraints();
		gbc_rb_m1_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m1_left.gridx = 0;
		gbc_rb_m1_left.gridy = 1;
		page1.add(rb_m1_left, gbc_rb_m1_left);
		
		cb_m1_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m1_left = new GridBagConstraints();
		gbc_cb_m1_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m1_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m1_left.gridx = 1;
		gbc_cb_m1_left.gridy = 1;
		page1.add(cb_m1_left, gbc_cb_m1_left);
		
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
		
		cb_m1_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m1_right = new GridBagConstraints();
		gbc_cb_m1_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m1_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m1_right.gridx = 3;
		gbc_cb_m1_right.gridy = 1;
		page1.add(cb_m1_right, gbc_cb_m1_right);
		
		rb_m1_right = new JRadioButton("");
		bg_m1.add(rb_m1_right);
		GridBagConstraints gbc_rb_m1_right = new GridBagConstraints();
		gbc_rb_m1_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m1_right.gridx = 4;
		gbc_rb_m1_right.gridy = 1;
		page1.add(rb_m1_right, gbc_rb_m1_right);
		
		rb_m2_left = new JRadioButton("");
		bg_m2.add(rb_m2_left);
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.insets = new Insets(0, 0, 5, 5);
		gbc_radioButton.gridx = 0;
		gbc_radioButton.gridy = 2;
		page1.add(rb_m2_left, gbc_radioButton);
		
		cb_m2_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m2_left = new GridBagConstraints();
		gbc_cb_m2_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m2_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m2_left.gridx = 1;
		gbc_cb_m2_left.gridy = 2;
		page1.add(cb_m2_left, gbc_cb_m2_left);
		
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
		
		cb_m2_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m2_right = new GridBagConstraints();
		gbc_cb_m2_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m2_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m2_right.gridx = 3;
		gbc_cb_m2_right.gridy = 2;
		page1.add(cb_m2_right, gbc_cb_m2_right);
		
		rb_m2_right = new JRadioButton("");
		bg_m2.add(rb_m2_right);
		GridBagConstraints gbc_rb_m2_right = new GridBagConstraints();
		gbc_rb_m2_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m2_right.gridx = 4;
		gbc_rb_m2_right.gridy = 2;
		page1.add(rb_m2_right, gbc_rb_m2_right);
		
		rb_m3_left = new JRadioButton("");
		bg_m3.add(rb_m3_left);
		GridBagConstraints gbc_rb_m3_left = new GridBagConstraints();
		gbc_rb_m3_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m3_left.gridx = 0;
		gbc_rb_m3_left.gridy = 3;
		page1.add(rb_m3_left, gbc_rb_m3_left);
		
		cb_m3_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m3_left = new GridBagConstraints();
		gbc_cb_m3_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m3_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m3_left.gridx = 1;
		gbc_cb_m3_left.gridy = 3;
		page1.add(cb_m3_left, gbc_cb_m3_left);
		
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
		
		cb_m3_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m3_right = new GridBagConstraints();
		gbc_cb_m3_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m3_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m3_right.gridx = 3;
		gbc_cb_m3_right.gridy = 3;
		page1.add(cb_m3_right, gbc_cb_m3_right);
		
		rb_m3_right = new JRadioButton("");
		bg_m3.add(rb_m3_right);
		GridBagConstraints gbc_rb_m3_right = new GridBagConstraints();
		gbc_rb_m3_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m3_right.gridx = 4;
		gbc_rb_m3_right.gridy = 3;
		page1.add(rb_m3_right, gbc_rb_m3_right);
		
		rb_m4_left = new JRadioButton("");
		bg_m4.add(rb_m4_left);
		GridBagConstraints gbc_rb_m4_left = new GridBagConstraints();
		gbc_rb_m4_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m4_left.gridx = 0;
		gbc_rb_m4_left.gridy = 4;
		page1.add(rb_m4_left, gbc_rb_m4_left);
		
		cb_m4_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m4_left = new GridBagConstraints();
		gbc_cb_m4_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m4_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m4_left.gridx = 1;
		gbc_cb_m4_left.gridy = 4;
		page1.add(cb_m4_left, gbc_cb_m4_left);
		
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
		
		cb_m4_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m4_right = new GridBagConstraints();
		gbc_cb_m4_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m4_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m4_right.gridx = 3;
		gbc_cb_m4_right.gridy = 4;
		page1.add(cb_m4_right, gbc_cb_m4_right);
		
		rb_m4_right = new JRadioButton("");
		bg_m4.add(rb_m4_right);
		GridBagConstraints gbc_rb_m4_right = new GridBagConstraints();
		gbc_rb_m4_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m4_right.gridx = 4;
		gbc_rb_m4_right.gridy = 4;
		page1.add(rb_m4_right, gbc_rb_m4_right);
		
		rb_m5_left = new JRadioButton("");
		bg_m5.add(rb_m5_left);
		GridBagConstraints gbc_rb_m5_left = new GridBagConstraints();
		gbc_rb_m5_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m5_left.gridx = 0;
		gbc_rb_m5_left.gridy = 5;
		page1.add(rb_m5_left, gbc_rb_m5_left);
		
		cb_m5_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m5_left = new GridBagConstraints();
		gbc_cb_m5_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m5_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m5_left.gridx = 1;
		gbc_cb_m5_left.gridy = 5;
		page1.add(cb_m5_left, gbc_cb_m5_left);
		
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
		
		cb_m5_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m5_right = new GridBagConstraints();
		gbc_cb_m5_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m5_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m5_right.gridx = 3;
		gbc_cb_m5_right.gridy = 5;
		page1.add(cb_m5_right, gbc_cb_m5_right);
		
		rb_m5_right = new JRadioButton("");
		bg_m5.add(rb_m5_right);
		GridBagConstraints gbc_rb_m5_right = new GridBagConstraints();
		gbc_rb_m5_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m5_right.gridx = 4;
		gbc_rb_m5_right.gridy = 5;
		page1.add(rb_m5_right, gbc_rb_m5_right);
		
		rb_m6_left = new JRadioButton("");
		bg_m6.add(rb_m6_left);
		GridBagConstraints gbc_rb_m6_left = new GridBagConstraints();
		gbc_rb_m6_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m6_left.gridx = 0;
		gbc_rb_m6_left.gridy = 6;
		page1.add(rb_m6_left, gbc_rb_m6_left);
		
		cb_m6_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m6_left = new GridBagConstraints();
		gbc_cb_m6_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m6_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m6_left.gridx = 1;
		gbc_cb_m6_left.gridy = 6;
		page1.add(cb_m6_left, gbc_cb_m6_left);
		
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
		
		cb_m6_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m6_right = new GridBagConstraints();
		gbc_cb_m6_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m6_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m6_right.gridx = 3;
		gbc_cb_m6_right.gridy = 6;
		page1.add(cb_m6_right, gbc_cb_m6_right);
		
		rb_m6_right = new JRadioButton("");
		bg_m6.add(rb_m6_right);
		GridBagConstraints gbc_rb_m6_right = new GridBagConstraints();
		gbc_rb_m6_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m6_right.gridx = 4;
		gbc_rb_m6_right.gridy = 6;
		page1.add(rb_m6_right, gbc_rb_m6_right);
		
		rb_m7_left = new JRadioButton("");
		bg_m7.add(rb_m7_left);
		GridBagConstraints gbc_rb_m7_left = new GridBagConstraints();
		gbc_rb_m7_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m7_left.gridx = 0;
		gbc_rb_m7_left.gridy = 7;
		page1.add(rb_m7_left, gbc_rb_m7_left);
		
		cb_m7_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m7_left = new GridBagConstraints();
		gbc_cb_m7_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m7_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m7_left.gridx = 1;
		gbc_cb_m7_left.gridy = 7;
		page1.add(cb_m7_left, gbc_cb_m7_left);
		
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
		
		cb_m7_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m7_right = new GridBagConstraints();
		gbc_cb_m7_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m7_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m7_right.gridx = 3;
		gbc_cb_m7_right.gridy = 7;
		page1.add(cb_m7_right, gbc_cb_m7_right);
		
		rb_m7_right = new JRadioButton("");
		bg_m7.add(rb_m7_right);
		GridBagConstraints gbc_rb_m7_right = new GridBagConstraints();
		gbc_rb_m7_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m7_right.gridx = 4;
		gbc_rb_m7_right.gridy = 7;
		page1.add(rb_m7_right, gbc_rb_m7_right);
		
		rb_m8_left = new JRadioButton("");
		bg_m8.add(rb_m8_left);
		GridBagConstraints gbc_rb_m8_left = new GridBagConstraints();
		gbc_rb_m8_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m8_left.gridx = 0;
		gbc_rb_m8_left.gridy = 8;
		page1.add(rb_m8_left, gbc_rb_m8_left);
		
		cb_m8_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m8_left = new GridBagConstraints();
		gbc_cb_m8_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m8_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m8_left.gridx = 1;
		gbc_cb_m8_left.gridy = 8;
		page1.add(cb_m8_left, gbc_cb_m8_left);
		
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
		
		cb_m8_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m8_right = new GridBagConstraints();
		gbc_cb_m8_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m8_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m8_right.gridx = 3;
		gbc_cb_m8_right.gridy = 8;
		page1.add(cb_m8_right, gbc_cb_m8_right);
		
		rb_m8_right = new JRadioButton("");
		bg_m8.add(rb_m8_right);
		GridBagConstraints gbc_rb_m8_right = new GridBagConstraints();
		gbc_rb_m8_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m8_right.gridx = 4;
		gbc_rb_m8_right.gridy = 8;
		page1.add(rb_m8_right, gbc_rb_m8_right);
		
		rb_m9_left = new JRadioButton("");
		bg_m9.add(rb_m9_left);
		GridBagConstraints gbc_rb_m9_left = new GridBagConstraints();
		gbc_rb_m9_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m9_left.gridx = 0;
		gbc_rb_m9_left.gridy = 9;
		page1.add(rb_m9_left, gbc_rb_m9_left);
		
		cb_m9_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m9_left = new GridBagConstraints();
		gbc_cb_m9_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m9_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m9_left.gridx = 1;
		gbc_cb_m9_left.gridy = 9;
		page1.add(cb_m9_left, gbc_cb_m9_left);
		
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
		
		cb_m9_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m9_right = new GridBagConstraints();
		gbc_cb_m9_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m9_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m9_right.gridx = 3;
		gbc_cb_m9_right.gridy = 9;
		page1.add(cb_m9_right, gbc_cb_m9_right);
		
		rb_m9_right = new JRadioButton("");
		bg_m9.add(rb_m9_right);
		GridBagConstraints gbc_rb_m9_right = new GridBagConstraints();
		gbc_rb_m9_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m9_right.gridx = 4;
		gbc_rb_m9_right.gridy = 9;
		page1.add(rb_m9_right, gbc_rb_m9_right);
		
		rb_m10_left = new JRadioButton("");
		bg_m10.add(rb_m10_left);
		GridBagConstraints gbc_rb_m10_left = new GridBagConstraints();
		gbc_rb_m10_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m10_left.gridx = 0;
		gbc_rb_m10_left.gridy = 10;
		page1.add(rb_m10_left, gbc_rb_m10_left);
		
		cb_m10_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m10_left = new GridBagConstraints();
		gbc_cb_m10_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m10_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m10_left.gridx = 1;
		gbc_cb_m10_left.gridy = 10;
		page1.add(cb_m10_left, gbc_cb_m10_left);
		
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
		
		cb_m10_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m10_right = new GridBagConstraints();
		gbc_cb_m10_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m10_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m10_right.gridx = 3;
		gbc_cb_m10_right.gridy = 10;
		page1.add(cb_m10_right, gbc_cb_m10_right);
		
		rb_m10_right = new JRadioButton("");
		bg_m10.add(rb_m10_right);
		GridBagConstraints gbc_rb_m10_right = new GridBagConstraints();
		gbc_rb_m10_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m10_right.gridx = 4;
		gbc_rb_m10_right.gridy = 10;
		page1.add(rb_m10_right, gbc_rb_m10_right);
		
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
		
		JPanel page2 = new JPanel();
		matches.add(page2, "page2");
		GridBagLayout gbl_page2 = new GridBagLayout();
		gbl_page2.columnWidths = new int[]{37, 100, 40, 100, 37, 0};
		gbl_page2.rowHeights = new int[]{15, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 30, 23, 0};
		gbl_page2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_page2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		page2.setLayout(gbl_page2);
		
		rb_m11_left = new JRadioButton("");
		bg_m11.add(rb_m11_left);
		GridBagConstraints gbc_rb_m11_left = new GridBagConstraints();
		gbc_rb_m11_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m11_left.gridx = 0;
		gbc_rb_m11_left.gridy = 1;
		page2.add(rb_m11_left, gbc_rb_m11_left);
		
		cb_m11_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m11_left = new GridBagConstraints();
		gbc_cb_m11_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m11_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m11_left.gridx = 1;
		gbc_cb_m11_left.gridy = 1;
		page2.add(cb_m11_left, gbc_cb_m11_left);
		
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
		
		cb_m11_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m11_right = new GridBagConstraints();
		gbc_cb_m11_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m11_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m11_right.gridx = 3;
		gbc_cb_m11_right.gridy = 1;
		page2.add(cb_m11_right, gbc_cb_m11_right);
		
		rb_m11_right = new JRadioButton("");
		bg_m11.add(rb_m11_right);
		GridBagConstraints gbc_rb_m11_right = new GridBagConstraints();
		gbc_rb_m11_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m11_right.gridx = 4;
		gbc_rb_m11_right.gridy = 1;
		page2.add(rb_m11_right, gbc_rb_m11_right);
		
		rb_m12_left = new JRadioButton("");
		bg_m12.add(rb_m12_left);
		GridBagConstraints gbc_rb_m12_left = new GridBagConstraints();
		gbc_rb_m12_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m12_left.gridx = 0;
		gbc_rb_m12_left.gridy = 2;
		page2.add(rb_m12_left, gbc_rb_m12_left);
		
		cb_m12_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m12_left = new GridBagConstraints();
		gbc_cb_m12_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m12_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m12_left.gridx = 1;
		gbc_cb_m12_left.gridy = 2;
		page2.add(cb_m12_left, gbc_cb_m12_left);
		
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
		
		cb_m12_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m12_right = new GridBagConstraints();
		gbc_cb_m12_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m12_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m12_right.gridx = 3;
		gbc_cb_m12_right.gridy = 2;
		page2.add(cb_m12_right, gbc_cb_m12_right);
		
		rb_m12_right = new JRadioButton("");
		bg_m12.add(rb_m12_right);
		GridBagConstraints gbc_rb_m12_right = new GridBagConstraints();
		gbc_rb_m12_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m12_right.gridx = 4;
		gbc_rb_m12_right.gridy = 2;
		page2.add(rb_m12_right, gbc_rb_m12_right);
		
		rb_m13_left = new JRadioButton("");
		bg_m13.add(rb_m13_left);
		GridBagConstraints gbc_rb_m13_left = new GridBagConstraints();
		gbc_rb_m13_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m13_left.gridx = 0;
		gbc_rb_m13_left.gridy = 3;
		page2.add(rb_m13_left, gbc_rb_m13_left);
		
		cb_m13_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m13_left = new GridBagConstraints();
		gbc_cb_m13_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m13_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m13_left.gridx = 1;
		gbc_cb_m13_left.gridy = 3;
		page2.add(cb_m13_left, gbc_cb_m13_left);
		
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
		
		cb_m13_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m13_right = new GridBagConstraints();
		gbc_cb_m13_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m13_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m13_right.gridx = 3;
		gbc_cb_m13_right.gridy = 3;
		page2.add(cb_m13_right, gbc_cb_m13_right);
		
		rb_m13_right = new JRadioButton("");
		bg_m13.add(rb_m13_right);
		GridBagConstraints gbc_rb_m13_right = new GridBagConstraints();
		gbc_rb_m13_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m13_right.gridx = 4;
		gbc_rb_m13_right.gridy = 3;
		page2.add(rb_m13_right, gbc_rb_m13_right);
		
		rb_m14_left = new JRadioButton("");
		bg_m14.add(rb_m14_left);
		GridBagConstraints gbc_rb_m14_left = new GridBagConstraints();
		gbc_rb_m14_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m14_left.gridx = 0;
		gbc_rb_m14_left.gridy = 4;
		page2.add(rb_m14_left, gbc_rb_m14_left);
		
		cb_m14_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m14_left = new GridBagConstraints();
		gbc_cb_m14_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m14_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m14_left.gridx = 1;
		gbc_cb_m14_left.gridy = 4;
		page2.add(cb_m14_left, gbc_cb_m14_left);
		
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
		
		cb_m14_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m14_right = new GridBagConstraints();
		gbc_cb_m14_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m14_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m14_right.gridx = 3;
		gbc_cb_m14_right.gridy = 4;
		page2.add(cb_m14_right, gbc_cb_m14_right);
		
		rb_m14_right = new JRadioButton("");
		bg_m14.add(rb_m14_right);
		GridBagConstraints gbc_rb_m14_right = new GridBagConstraints();
		gbc_rb_m14_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m14_right.gridx = 4;
		gbc_rb_m14_right.gridy = 4;
		page2.add(rb_m14_right, gbc_rb_m14_right);
		
		rb_m15_left = new JRadioButton("");
		bg_m15.add(rb_m15_left);
		GridBagConstraints gbc_rb_m15_left = new GridBagConstraints();
		gbc_rb_m15_left.insets = new Insets(0, 0, 5, 5);
		gbc_rb_m15_left.gridx = 0;
		gbc_rb_m15_left.gridy = 5;
		page2.add(rb_m15_left, gbc_rb_m15_left);
		
		cb_m15_left = new JComboBox<String>();
		GridBagConstraints gbc_cb_m15_left = new GridBagConstraints();
		gbc_cb_m15_left.fill = GridBagConstraints.BOTH;
		gbc_cb_m15_left.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m15_left.gridx = 1;
		gbc_cb_m15_left.gridy = 5;
		page2.add(cb_m15_left, gbc_cb_m15_left);
		
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
		
		cb_m15_right = new JComboBox<String>();
		GridBagConstraints gbc_cb_m15_right = new GridBagConstraints();
		gbc_cb_m15_right.fill = GridBagConstraints.BOTH;
		gbc_cb_m15_right.insets = new Insets(0, 0, 5, 5);
		gbc_cb_m15_right.gridx = 3;
		gbc_cb_m15_right.gridy = 5;
		page2.add(cb_m15_right, gbc_cb_m15_right);
		
		bt_pg2 = new JButton("1-10");
		bt_pg2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card_matches.show(matches,"page1");
			}
		});
		
		rb_m15_right = new JRadioButton("");
		bg_m15.add(rb_m15_right);
		GridBagConstraints gbc_rb_m15_right = new GridBagConstraints();
		gbc_rb_m15_right.insets = new Insets(0, 0, 5, 0);
		gbc_rb_m15_right.gridx = 4;
		gbc_rb_m15_right.gridy = 5;
		page2.add(rb_m15_right, gbc_rb_m15_right);
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
		
		JPanel rb_fakes_here = new JPanel();
		cardpanel.add(rb_fakes_here, "fakes");
		
		rb_m1_fake = new JRadioButton("",true);
		bg_m1.add(rb_m1_fake);
		rb_fakes_here.add(rb_m1_fake);
		
		rb_m2_fake = new JRadioButton("",true);
		bg_m2.add(rb_m2_fake);
		rb_fakes_here.add(rb_m2_fake);
		
		rb_m3_fake = new JRadioButton("",true);
		bg_m3.add(rb_m3_fake);
		rb_fakes_here.add(rb_m3_fake);
		
		rb_m4_fake = new JRadioButton("",true);
		bg_m4.add(rb_m4_fake);
		rb_fakes_here.add(rb_m4_fake);
		
		rb_m5_fake = new JRadioButton("",true);
		bg_m5.add(rb_m5_fake);
		rb_fakes_here.add(rb_m5_fake);
		
		rb_m6_fake = new JRadioButton("",true);
		bg_m6.add(rb_m6_fake);
		rb_fakes_here.add(rb_m6_fake);
		
		rb_m7_fake = new JRadioButton("",true);
		bg_m7.add(rb_m7_fake);
		rb_fakes_here.add(rb_m7_fake);
		
		rb_m8_fake = new JRadioButton("",true);
		bg_m8.add(rb_m8_fake);
		rb_fakes_here.add(rb_m8_fake);
		
		rb_m9_fake = new JRadioButton("",true);
		bg_m9.add(rb_m9_fake);
		rb_fakes_here.add(rb_m9_fake);
		
		rb_m10_fake = new JRadioButton("",true);
		bg_m10.add(rb_m10_fake);
		rb_fakes_here.add(rb_m10_fake);
		
		rb_m11_fake = new JRadioButton("",true);
		bg_m11.add(rb_m11_fake);
		rb_fakes_here.add(rb_m11_fake);
		
		rb_m12_fake = new JRadioButton("",true);
		bg_m12.add(rb_m12_fake);
		rb_fakes_here.add(rb_m12_fake);
		
		rb_m13_fake = new JRadioButton("",true);
		bg_m13.add(rb_m13_fake);
		rb_fakes_here.add(rb_m13_fake);
		
		rb_m14_fake = new JRadioButton("",true);
		bg_m14.add(rb_m14_fake);
		rb_fakes_here.add(rb_m14_fake);
		
		rb_m15_fake = new JRadioButton("",true);
		bg_m15.add(rb_m15_fake);
		rb_fakes_here.add(rb_m15_fake);
		
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

		/* These listeners execute the respective method that decides whether or not to select the third hidden button */
		rb_m1_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m1left();
			}
		});
		rb_m1_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m1right();
			}
		});
		rb_m2_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m2left();
			}
		});
		rb_m2_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m2right();
			}
		});
		rb_m3_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m3left();
			}
		});
		rb_m3_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m3right();
			}
		});
		rb_m4_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m4left();
			}
		});
		rb_m4_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m4right();
			}
		});
		rb_m5_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m5left();
			}
		});
		rb_m5_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m5right();
			}
		});
		rb_m6_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m6left();
			}
		});
		rb_m6_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m6right();
			}
		});
		rb_m7_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m7left();
			}
		});
		rb_m7_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m7right();
			}
		});
		rb_m8_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m8left();
			}
		});
		rb_m8_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m8right();
			}
		});
		rb_m9_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m9left();
			}
		});
		rb_m9_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m9right();
			}
		});
		rb_m10_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m10left();
			}
		});
		rb_m10_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m10right();
			}
		});
		rb_m11_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m11left();
			}
		});
		rb_m11_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m11right();
			}
		});
		rb_m12_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m12left();
			}
		});
		rb_m12_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m12right();
			}
		});
		rb_m13_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m13left();
			}
		});
		rb_m13_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m13right();
			}
		});
		rb_m14_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m14left();
			}
		});
		rb_m14_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m14right();
			}
		});
		rb_m15_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m15left();
			}
		});
		rb_m15_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m15right();
			}
		});
	}
	private class SubmitAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		public SubmitAction() {
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Submit player data.");
		}
		public void actionPerformed(ActionEvent e) {
			
			if (UpDown.roster.size()==0) {
				initRoster();				
			}
			else {
				updateRoster();	
			}
			updateComboBoxes();
			System.out.println("");															// debug
			for(int i=0;i<UpDown.roster.size();++i) {										// debug
				System.out.println("Player " + i + ": " + UpDown.roster.get(i).getName());	// debug
			}
		}
	}
			
		
	private class Radio5Action extends AbstractAction {		// when radio5 is selected -> disable player 6 textarea
		private static final long serialVersionUID = 2L;
		public Radio5Action() {
			putValue(NAME, "5");
			putValue(SHORT_DESCRIPTION, "5 man group");
		}
		public void actionPerformed(ActionEvent e) {
			UpDown.numplayers=5;
			ta_p6.setBackground(Color.LIGHT_GRAY);
			ta_p6.setEnabled(false);
			bt_pg1.setEnabled(false);
		}
	}
	
	private class Radio6Action extends AbstractAction {		// when radio6 is selected -> enable player 6 textarea
		private static final long serialVersionUID = 3L;
		public Radio6Action() {
			putValue(NAME, "6");
			putValue(SHORT_DESCRIPTION, "6 man group");
		}
		public void actionPerformed(ActionEvent e) {
			UpDown.numplayers=6;
			ta_p6.setBackground(Color.WHITE);
			ta_p6.setEnabled(true);
			bt_pg1.setEnabled(true);
		}
	}
	
	
	/* These handle logic for selecting the hidden third radio button */
	private void m1left() {
        System.out.println("rb_m1_left pressed");
        if(lastpressedradio.get(0)==1) {
        	rb_m1_fake.setSelected(true);
        	lastpressedradio.set(0,-1);
        }
        else
        	lastpressedradio.set(0,1);
    }
	private void m1right() {
        System.out.println("rb_m1_right pressed");
        if(lastpressedradio.get(0)==0) {
        	rb_m1_fake.setSelected(true);
        	lastpressedradio.set(0,-1);
        }
        else
        	lastpressedradio.set(0,0);
    }
	private void m2left() {
        System.out.println("rb_m2_left pressed");
        if(lastpressedradio.get(1)==1) {
        	rb_m2_fake.setSelected(true);
        	lastpressedradio.set(1,-1);
        }
        else
        	lastpressedradio.set(1,1);
    }
	private void m2right() {
        System.out.println("rb_m2_right pressed");
        if(lastpressedradio.get(1)==0) {
        	rb_m2_fake.setSelected(true);
        	lastpressedradio.set(1,-1);
        }
        else
        	lastpressedradio.set(1,0);
    }
	private void m3left() {
        System.out.println("rb_m3_left pressed");
        if(lastpressedradio.get(2)==1) {
        	rb_m3_fake.setSelected(true);
        	lastpressedradio.set(2,-1);
        }
        else
        	lastpressedradio.set(2,1);
    }
	private void m3right() {
        System.out.println("rb_m3_right pressed");
        if(lastpressedradio.get(2)==0) {
        	rb_m3_fake.setSelected(true);
        	lastpressedradio.set(2,-1);
        }
        else
        	lastpressedradio.set(2,0);
    }
	private void m4left() {
        System.out.println("rb_m4_left pressed");
        if(lastpressedradio.get(3)==1) {
        	rb_m4_fake.setSelected(true);
        	lastpressedradio.set(3,-1);
        }
        else
        	lastpressedradio.set(3,1);
    }
	private void m4right() {
        System.out.println("rb_m4_right pressed");
        if(lastpressedradio.get(3)==0) {
        	rb_m4_fake.setSelected(true);
        	lastpressedradio.set(3,-1);
        }
        else
        	lastpressedradio.set(3,0);
    }
	private void m5left() {
        System.out.println("rb_m5_left pressed");
        if(lastpressedradio.get(4)==1) {
        	rb_m5_fake.setSelected(true);
        	lastpressedradio.set(4,-1);
        }
        else
        	lastpressedradio.set(4,1);
    }
	private void m5right() {
        System.out.println("rb_m5_right pressed");
        if(lastpressedradio.get(4)==0) {
        	rb_m5_fake.setSelected(true);
        	lastpressedradio.set(4,-1);
        }
        else
        	lastpressedradio.set(4,0);
    }
	private void m6left() {
        System.out.println("rb_m6_left pressed");
        if(lastpressedradio.get(5)==1) {
        	rb_m6_fake.setSelected(true);
        	lastpressedradio.set(5,-1);
        }
        else
        	lastpressedradio.set(5,1);
    }
	private void m6right() {
        System.out.println("rb_m6_right pressed");
        if(lastpressedradio.get(5)==0) {
        	rb_m6_fake.setSelected(true);
        	lastpressedradio.set(5,-1);
        }
        else
        	lastpressedradio.set(5,0);
    }
	private void m7left() {
        System.out.println("rb_m7_left pressed");
        if(lastpressedradio.get(6)==1) {
        	rb_m7_fake.setSelected(true);
        	lastpressedradio.set(6,-1);
        }
        else
        	lastpressedradio.set(6,1);
    }
	private void m7right() {
        System.out.println("rb_m7_right pressed");
        if(lastpressedradio.get(6)==0) {
        	rb_m7_fake.setSelected(true);
        	lastpressedradio.set(6,-1);
        }
        else
        	lastpressedradio.set(6,0);
    }
	private void m8left() {
        System.out.println("rb_m8_left pressed");
        if(lastpressedradio.get(7)==1) {
        	rb_m8_fake.setSelected(true);
        	lastpressedradio.set(7,-1);
        }
        else
        	lastpressedradio.set(7,1);
    }
	private void m8right() {
        System.out.println("rb_m8_right pressed");
        if(lastpressedradio.get(7)==0) {
        	rb_m8_fake.setSelected(true);
        	lastpressedradio.set(7,-1);
        }
        else
        	lastpressedradio.set(7,0);
    }
	private void m9left() {
        System.out.println("rb_m9_left pressed");
        if(lastpressedradio.get(8)==1) {
        	rb_m9_fake.setSelected(true);
        	lastpressedradio.set(8,-1);
        }
        else
        	lastpressedradio.set(8,1);
    }
	private void m9right() {
        System.out.println("rb_m9_right pressed");
        if(lastpressedradio.get(8)==0) {
        	rb_m9_fake.setSelected(true);
        	lastpressedradio.set(8,-1);
        }
        else
        	lastpressedradio.set(8,0);
    }
	private void m10left() {
        System.out.println("rb_m10_left pressed");
        if(lastpressedradio.get(9)==1) {
        	rb_m10_fake.setSelected(true);
        	lastpressedradio.set(9,-1);
        }
        else
        	lastpressedradio.set(9,1);
    }
	private void m10right() {
        System.out.println("rb_m10_right pressed");
        if(lastpressedradio.get(9)==0) {
        	rb_m10_fake.setSelected(true);
        	lastpressedradio.set(9,-1);
        }
        else
        	lastpressedradio.set(9,0);
    }
	private void m11left() {
        System.out.println("rb_m11_left pressed");
        if(lastpressedradio.get(10)==1) {
        	rb_m11_fake.setSelected(true);
        	lastpressedradio.set(10,-1);
        }
        else
        	lastpressedradio.set(10,1);
    }
	private void m11right() {
        System.out.println("rb_m11_right pressed");
        if(lastpressedradio.get(10)==0) {
        	rb_m11_fake.setSelected(true);
        	lastpressedradio.set(10,-1);
        }
        else
        	lastpressedradio.set(10,0);
    }
	private void m12left() {
        System.out.println("rb_m12_left pressed");
        if(lastpressedradio.get(11)==1) {
        	rb_m12_fake.setSelected(true);
        	lastpressedradio.set(11,-1);
        }
        else
        	lastpressedradio.set(11,1);
    }
	private void m12right() {
        System.out.println("rb_m12_right pressed");
        if(lastpressedradio.get(11)==0) {
        	rb_m12_fake.setSelected(true);
        	lastpressedradio.set(11,-1);
        }
        else
        	lastpressedradio.set(11,0);
    }
	private void m13left() {
        System.out.println("rb_m13_left pressed");
        if(lastpressedradio.get(12)==1) {
        	rb_m13_fake.setSelected(true);
        	lastpressedradio.set(12,-1);
        }
        else
        	lastpressedradio.set(12,1);
    }
	private void m13right() {
        System.out.println("rb_m13_right pressed");
        if(lastpressedradio.get(12)==0) {
        	rb_m13_fake.setSelected(true);
        	lastpressedradio.set(12,-1);
        }
        else
        	lastpressedradio.set(12,0);
    }
	private void m14left() {
        System.out.println("rb_m14_left pressed");
        if(lastpressedradio.get(13)==1) {
        	rb_m14_fake.setSelected(true);
        	lastpressedradio.set(13,-1);
        }
        else
        	lastpressedradio.set(13,1);
    }
	private void m14right() {
        System.out.println("rb_m14_right pressed");
        if(lastpressedradio.get(13)==0) {
        	rb_m14_fake.setSelected(true);
        	lastpressedradio.set(13,-1);
        }
        else
        	lastpressedradio.set(13,0);
    }
	private void m15left() {
        System.out.println("rb_m15_left pressed");
        if(lastpressedradio.get(14)==1) {
        	rb_m15_fake.setSelected(true);
        	lastpressedradio.set(14,-1);
        }
        else
        	lastpressedradio.set(14,1);
    }
	private void m15right() {
        System.out.println("rb_m15_right pressed");
        if(lastpressedradio.get(14)==0) {
        	rb_m15_fake.setSelected(true);
        	lastpressedradio.set(14,-1);
        }
        else
        	lastpressedradio.set(14,0);
    }
	
	/* */
	private void initRoster() {
		fixTextLength();	// only allow 8 characters (breaks gridbaglayout otherwise)
		UpDown.roster.add(new Player(ta_p1.getText()));
	 	UpDown.roster.add(new Player(ta_p2.getText()));
	 	UpDown.roster.add(new Player(ta_p3.getText()));
	 	UpDown.roster.add(new Player(ta_p4.getText()));
	 	UpDown.roster.add(new Player(ta_p5.getText()));
	 	if (rb_6.isSelected()) {
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
		if (UpDown.roster.size()==5 && rb_6.isSelected())
			UpDown.roster.add(new Player(ta_p6.getText()));
		else if (UpDown.roster.size()==6 && rb_6.isSelected()) {
	 		UpDown.roster.get(5).setName(ta_p6.getText());
	 	}
		else if (UpDown.roster.size()==6 && rb_5.isSelected()) {
	 		UpDown.roster.remove(5);
	 	}
	}
	private void updateComboBoxes(){
		String tempname;	// used to remove p.getName() spam
		
		// TODO: make it so ordering is maintained (ie If #3 was selected, then its name changed, when you go back to matches
		//											it should still have #3 selected but with the new name)
		cb_m1_left.removeAllItems();	cb_m1_right.removeAllItems();
		cb_m2_left.removeAllItems();	cb_m2_right.removeAllItems();
		cb_m3_left.removeAllItems();	cb_m3_right.removeAllItems();
		cb_m4_left.removeAllItems();	cb_m4_right.removeAllItems();
		cb_m5_left.removeAllItems();	cb_m5_right.removeAllItems();
		cb_m6_left.removeAllItems();	cb_m6_right.removeAllItems();
		cb_m7_left.removeAllItems();	cb_m7_right.removeAllItems();
		cb_m8_left.removeAllItems();	cb_m8_right.removeAllItems();
		cb_m9_left.removeAllItems();	cb_m9_right.removeAllItems();
		cb_m10_left.removeAllItems();	cb_m10_right.removeAllItems();
		cb_m11_left.removeAllItems();	cb_m11_right.removeAllItems();
		cb_m12_left.removeAllItems();	cb_m12_right.removeAllItems();
		cb_m13_left.removeAllItems();	cb_m13_right.removeAllItems();
		cb_m14_left.removeAllItems();	cb_m14_right.removeAllItems();
		cb_m15_left.removeAllItems();	cb_m15_right.removeAllItems();
		for(Player p:UpDown.roster)
		{
			tempname=p.getName();
			if(!tempname.isEmpty())
			{
				cb_m1_left.addItem(tempname);	cb_m1_right.addItem(tempname);
				cb_m2_left.addItem(tempname);	cb_m2_right.addItem(tempname);
				cb_m3_left.addItem(tempname);	cb_m3_right.addItem(tempname);
				cb_m4_left.addItem(tempname);	cb_m4_right.addItem(tempname);
				cb_m5_left.addItem(tempname);	cb_m5_right.addItem(tempname);
				cb_m6_left.addItem(tempname);	cb_m6_right.addItem(tempname);
				cb_m7_left.addItem(tempname);	cb_m7_right.addItem(tempname);
				cb_m8_left.addItem(tempname);	cb_m8_right.addItem(tempname);
				cb_m9_left.addItem(tempname);	cb_m9_right.addItem(tempname);
				cb_m10_left.addItem(tempname);	cb_m10_right.addItem(tempname);
				cb_m11_left.addItem(tempname);	cb_m11_right.addItem(tempname);
				cb_m12_left.addItem(tempname);	cb_m12_right.addItem(tempname);
				cb_m13_left.addItem(tempname);	cb_m13_right.addItem(tempname);
				cb_m14_left.addItem(tempname);	cb_m14_right.addItem(tempname);
				cb_m15_left.addItem(tempname);	cb_m15_right.addItem(tempname);
			}
		}
	}
	private void fixTextLength()
	{
		if (ta_p1.getText().length()>8)
		{
			ta_p1.setText(ta_p1.getText().substring(0, 8));
		}
		if (ta_p2.getText().length()>8)
		{
			ta_p2.setText(ta_p2.getText().substring(0, 8));
		}
		if (ta_p3.getText().length()>8)
		{
			ta_p3.setText(ta_p3.getText().substring(0, 8));
		}
		if (ta_p4.getText().length()>8)
		{
			ta_p4.setText(ta_p4.getText().substring(0, 8));
		}
		if (ta_p5.getText().length()>8)
		{
			ta_p5.setText(ta_p5.getText().substring(0, 8));
		}
		if (ta_p6.getText().length()>8)
		{
			ta_p6.setText(ta_p6.getText().substring(0, 8));
		}
	}
	public void enable() {
		guiframe.setVisible(true);
	}
	public void disable() {
		guiframe.setVisible(false);
	}
}