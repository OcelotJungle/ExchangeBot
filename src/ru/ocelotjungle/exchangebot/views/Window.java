package ru.ocelotjungle.exchangebot.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ru.ocelotjungle.exchangebot.common.Utils;

@SuppressWarnings({ "serial", "rawtypes"})
public class Window extends JFrame {

	private JPanel contentPane;
	private static Window instance;
	public JButton btnReloadList, btnReloadInfo, btnMakeProfit;
	public JToggleButton tglbtnForAll;
	public JTextField exchangeSize;
	public JList chainList, balanceList, limitList;
	public JTextArea debugInfo;

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
	
	public static Window getInstance() {
		return instance;
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		instance = this;
		initComponents();
		createEvents();
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
		setBounds(100, 100, 550, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		chainList = new JList();
		chainList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chainList.setToolTipText("");
		chainList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		balanceList = new JList();
		balanceList.setFont(new Font("Tahoma", Font.BOLD, 16));
		balanceList.setModel(new AbstractListModel() {
			String[] values = new String[] {"0.00000000B", "0.00000000E", "0.00000000D", "0.00000000W", "0.00000000$", "0.00000000₽"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		balanceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		balanceList.setVisibleRowCount(6);
		balanceList.setToolTipText("");
		balanceList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		limitList = new JList();
		limitList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnReloadList = new JButton("Reload list");
		btnReloadList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Utils.buttonReloadListClick();
			}
		});
		
		btnReloadInfo = new JButton("Reload info");
		btnReloadInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Utils.buttonReloadInfoClick();
			}
		});
		
		exchangeSize = new JTextField();
		exchangeSize.setBorder(new LineBorder(new Color(0, 0, 0)));
		exchangeSize.setFont(new Font("Tahoma", Font.BOLD, 12));
		exchangeSize.setColumns(10);
		
		btnMakeProfit = new JButton("Make profit");
		btnMakeProfit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Utils.buttonMakeProfitClick(exchangeSize.getText(), tglbtnForAll.isSelected());
			}
		});
		
		debugInfo = new JTextArea();
		debugInfo.setWrapStyleWord(true);
		debugInfo.setLineWrap(true);
		debugInfo.setFont(new Font("Monospaced", Font.PLAIN, 11));
		debugInfo.setEditable(false);
		debugInfo.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		tglbtnForAll = new JToggleButton("For all");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(chainList, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(exchangeSize)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnReloadList)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnReloadInfo)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnMakeProfit)
									.addGap(18)
									.addComponent(tglbtnForAll)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(debugInfo, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(limitList, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
						.addComponent(balanceList, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(balanceList)
					.addGap(7)
					.addComponent(limitList, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(chainList, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnReloadList)
								.addComponent(btnReloadInfo))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMakeProfit)
								.addComponent(tglbtnForAll))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(exchangeSize, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addComponent(debugInfo)))
		);
		contentPane.setLayout(gl_contentPane);

	}

	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
