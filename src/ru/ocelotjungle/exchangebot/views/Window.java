package ru.ocelotjungle.exchangebot.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ru.ocelotjungle.exchangebot.common.ChainInitializer;

import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

@SuppressWarnings({ "serial", "rawtypes"})
public class Window extends JFrame {

	private JPanel contentPane;
	public JTextField tfCount;
	public JTextField tfFee;
	public JList listChains;
	public JList listBalances;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		initComponents();
		createEvents();
		ChainInitializer.initialize(this);;
	}

	/**
	 * Hello
	 */
	@SuppressWarnings({ "unchecked" })
	private void initComponents() {
		setResizable(false);
		setTitle("Yobit Profit Bot");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/ru/ocelotjungle/exchangebot/resources/yobit.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		listChains = new JList();
		listChains.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listChains.setFont(new Font("Arial", Font.BOLD, 12));
		listChains.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		listBalances = new JList();
		listBalances.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listBalances.setToolTipText("");
		listBalances.setFont(new Font("Arial", Font.ITALIC, 12));
		listBalances.setBorder(new LineBorder(new Color(0, 0, 0)));
		listBalances.setModel(new AbstractListModel() {
			String[] values = new String[] {"  0.00000000B", "  0.00000000E", "  0.00000000D", "  0.00000000W", "  0.00000000$", "  0.00000000₽"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listBalances.setVisibleRowCount(6);
		
		JButton btnRefresh = new JButton("Refresh");
		
		JButton btnReload = new JButton("Reload");
		
		JButton btnDoProfit = new JButton("Do profit");
		btnDoProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		tfCount = new JTextField();
		tfCount.setColumns(10);
		
		JButton btnForAll = new JButton("For all");
		
		JLabel lblFee = new JLabel("Fee:");
		
		tfFee = new JTextField();
		tfFee.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(listChains, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnRefresh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReload))
						.addComponent(listBalances, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(btnDoProfit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnForAll))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblFee)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfCount, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(listChains, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(listBalances)
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDoProfit)
								.addComponent(btnForAll))
							.addGap(9)
							.addComponent(tfCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFee)
								.addComponent(tfFee, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRefresh)
								.addComponent(btnReload))))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
