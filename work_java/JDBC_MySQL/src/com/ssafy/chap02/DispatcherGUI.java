package com.ssafy.chap02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

public class DispatcherGUI {

	int menu;
	Scanner s;
	DBManager man;

	public DispatcherGUI() throws SQLException {
		s = new Scanner(System.in);
		man = new DBManager();
	}

	private void go() {
		createGUI();
	}
	CustomerVO selected = new CustomerVO();

	private void createGUI() {
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		JPanel pUp = new JPanel();
		JPanel pDown = new JPanel();
		JButton bI = new JButton();
		bI.setText("Insert");
		JButton bU = new JButton();
		bU.setText("Update");
		JButton bD = new JButton();
		bD.setText("Delete");
		JTextField tfName = new JTextField();
		tfName.setColumns(10);
		JTextField tfAge = new JTextField();
		tfAge.setColumns(10);
		JTextField tfAddr = new JTextField();
		tfAddr.setColumns(10);
		JTextArea taList = new JTextArea();
//		JList jlist = new JList();
//		DefaultListModel<String> model = new DefaultListModel<>();
//		jlist.setModel(model); //데이터를 모델이 갖고 있음 
		
		pUp.add(tfName);
		pUp.add(tfAge);
		pUp.add(tfAddr);
		pDown.add(bI);
		pDown.add(bU);
		pDown.add(bD);
		f.add(pUp, BorderLayout.NORTH);
		f.add(pDown, BorderLayout.SOUTH);
		f.add(taList);

		f.setSize(500, 500);
		f.setLocation(1000, 500);
		f.setVisible(true);
		
		ArrayList<CustomerVO> list = man.queryCustomer();
		for (CustomerVO c : list) {
			taList.append(c.toString()+"\n");
			//model.addElement(c.toString());
		}

		// event
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
		bI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//안에 집어 넣을 것 외우기^.^
				String name = tfName.getText();
				int age = Integer.parseInt(tfAge.getText());
				String addr = tfAddr.getText();
				man.insertCustomer(name, age, addr);
				ArrayList<CustomerVO> list = man.queryCustomer();
				taList.setText(null);
				for (CustomerVO c : list) {
					taList.append(c.toString()+"\n");
					//model.addElement(c.toString());
				}
			}
		});
		bU.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(selected != null) {
					man.updateCustomer(selected.getNum(), tfName.getText(), Integer.parseInt(tfAge.getText()), tfAddr.getText());
				}
			}
		});
		
		bD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(selected != null) {
					man.deleteCustomer(selected.getNum());
				}
			}
		});
		
		
		
	}
	
	

	public static void main(String[] args) {
		try {
			new DispatcherGUI().go();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
