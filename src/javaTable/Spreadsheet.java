package javaTable;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class Spreadsheet extends AbstractTableModel {
	private Integer ini = new Integer(0);
	private static String cities = "Berlin, Frankfurt, München, Hannover, Hamburg, Wismar";
	private static int cityCount = cityCount(cities);
	private static String functions = "Summe";
	private static int colCount = 5;
	private static Object[] cityCollection = cityArray(cities);
	private static int rowCount = cityCount;
	private Object data[][] = new Object[getRowCount()][getColumnCount()];
	
	Spreadsheet() {
		initialiseColumns(data);
	}
	
	@Override
	public int getColumnCount() {
		return colCount;
	}

	@Override
	public int getRowCount() {
		return rowCount;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
//	Math.round(((Integer) data[x][y]).doubleValue()/Integer) data[a][b]).doubleValue()*100.0);
	
	@Override
	public void setValueAt(Object o, int row, int col) {
		if(isCellEditable(row, col)) {
			data[row][col] = o;
			for(int i = 1; i < 3; row++) {
				data[row][3] = (Integer)((int) data[i][1] - (int)data[i][2]);
				System.out.println("Counting row: " + i);
			}
			//calculate and set sum in data[3][col]
			//calculate and set sum in data[3][3]
			//calculate and set sum in data[0-3][4] neu
			fireTableDataChanged();
		}
	}
	
	public String getColumnName(int column) {
		String[] colName = {"Verkaufsregion", "Umsatz", "Kosten", "Gewinn/Verlust", "Gewinnanteil in %"};
		return colName[column];
	}
	
	@Override
	public boolean isCellEditable (int rowIndex, int columnIndex) {
		boolean rowOk = false;
		boolean columnOk = false;
		if(rowIndex >= 1 && rowIndex <= 3)
			rowOk = true;
		if(columnIndex >= 1 && columnIndex <= 2)
			columnOk = true;
		if(rowOk && columnOk)
			return true;
		System.out.println("Cells not editable");
		return false;
	}
	
	private static int cityCount(String cities) {
		int len = cities.length();
		int quantity = 1;
		//Get the number of cities
		for(int i = 0; i < len; i++){
			if(cities.charAt(i) == ',')
				quantity++;
		}
		return quantity;
	}
	
	private static Object[] cityArray(String cities) {
		Object[] c = new Object[cityCount(cities)];
		int i = 0;
		int j = 0;
		while(i < cityCount) {
			String city = "";
			boolean wordAdded = false;
			while(j < cities.length() && !wordAdded) {
				if(cities.charAt(j) != ',') {
					city += cities.charAt(j);
				}
				else {
				c[i] = city;
				wordAdded = true;
				j++;
				}
				//Get the last city saved as well
				if(j == cities.length()-1)
					c[i] = city;
				j++; 
			}
			System.out.println(city);
			i++;
		}
		return c;
	}
	private static void initialiseColumns(Object[][] data) {
		//Insert cities into into the columns
		for(int i = 0; i < cityCount; i++) {
			data[i][0] = cityCollection[i];
		}
	}

}
