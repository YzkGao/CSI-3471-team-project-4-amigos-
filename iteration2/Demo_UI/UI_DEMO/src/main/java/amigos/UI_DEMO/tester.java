package amigos.UI_DEMO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tester {
	
	public static void main(String[] args) {
		final mainPage f1 = new mainPage();
		final addPage f2 = new addPage();
		final amountPage f3 = new amountPage();
		final viewPage f4 = new viewPage();
		
		
		f1.f.setVisible(true);
		
		f1.add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f1.f.setVisible(false);
				f2.f.setVisible(true);
			}
		});
		f1.view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f1.f.setVisible(false);
				f4.f.setVisible(true);
			}
		});
		
		
		
		f2.travel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.category = "Travel";
				f2.categoryLabel1.setText(f2.category);
			}
		});
		f2.shopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.category = "Shopping";
				f2.categoryLabel1.setText(f2.category);
			}
		});
		f2.study.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.category = "Study";
				f2.categoryLabel1.setText(f2.category);
			}
		});
		f2.work.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.category = "Work";
				f2.categoryLabel1.setText(f2.category);
			}
		});
		f2.entertainment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.category = "Entertainment";
				f2.categoryLabel1.setText(f2.category);
			}
		});
		f2.others.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.category = "Others";
				f2.categoryLabel1.setText(f2.category);
			}
		});
		
		f2.addAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f3.f.setVisible(true);
			}
		});
		
		f2.expense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.type = "expense";
				f2.typeLabel1.setText(f2.type);
			}
		});
		f2.income.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.type = "income";
				f2.typeLabel1.setText(f2.type);
			}
		});
		
		f2.back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f2.f.setVisible(false);
				f1.f.setVisible(true);
			}
		});
		
		
		f4.back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f4.f.setVisible(false);
				f1.f.setVisible(true);
			}
		});
	}

}
