package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel {
	private String entetes[];
	private Object [][] donnees;
	
	public Tableau(String[] entetes, Object[][] donnees)
	{
		super();
		this.entetes = entetes;
		this.donnees = donnees;
	}

	public int getRowCount() {
		return this.donnees.length;
	}

	public int getColumnCount() {
		return this.entetes.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return this.donnees[rowIndex][columnIndex];
	}
	
	@Override
	public String getColumnName(int column) {
		return this.entetes[column];
	}
	public void ajouterLigne(Object Ligne[])
	{
		Object matrice [][] = new Object[this.getRowCount()+1][this.getColumnCount()];
		for (int i =0; i <this.getRowCount(); i++)
		{
			matrice[i] = this.donnees[i];
		}
		matrice[this.getRowCount()] = Ligne;
		this.donnees = matrice;
		this.fireTableDataChanged();
	}
	public void supprimerLigne(int numLigne)
	{
		Object matrice [][] = new Object[this.getRowCount()-1][this.getColumnCount()];
		int j = 0;
		for (int i =0; i <this.getRowCount(); i++)
		{
			if(numLigne != i)
			{
				matrice[j] = this.donnees[i];
				j++;
			}
		}
		this.donnees = matrice;
		this.fireTableDataChanged();
	}
	public void modifierLigne(int numLigne, Object[] Ligne)
	{
		Object matrice [][] = new Object[this.getRowCount()][this.getColumnCount()];
		for (int i =0; i <this.getRowCount(); i++)
		{
			if(numLigne == i)
			{
				matrice[i] = Ligne;
			} else {
				matrice[i] = this.donnees[i];
			}
		}
		this.donnees = matrice;
		this.fireTableDataChanged();
	}
	
	

}
