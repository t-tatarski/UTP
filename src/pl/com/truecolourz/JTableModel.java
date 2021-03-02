package pl.com.truecolourz;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JTableModel extends AbstractTableModel {

    final String PTHICO = "/private/var/root/Downloads/utp_task1/src/pl/com/truecolourz/Resources/";
    final String PATHFILE = "/private/var/root/Downloads/utp_task1/src/pl/com/truecolourz/";

    String[] dataLine;
    String[] titleRow;

    private static final String[] COLUMNS = {"PANSTWO", "STOLICA", "LICZBA LUDNOSCI","FLAGA"};
    Object [][] data = {
            {"niemcy","berlin", 80000000, new ImageIcon(PTHICO+"de.png")},
            {"japonia","tokyo", 120000000, new ImageIcon(PTHICO+"jp.png")},
            {"polska","warszawa", 38000000, new ImageIcon(PTHICO+"pl.png")},
            {"rosja","moskwa", 140000000, new ImageIcon(PTHICO+"ru.png")},
            {"rumunia","bukareszt", 35000000, new ImageIcon(PTHICO+"rom.png")},
            {"szwecja","malmo", 6000000, new ImageIcon(PTHICO+"sv.png")},
            {"anglia","londyn", 70000000, new ImageIcon(PTHICO+"gb.png")},
    };

    public JTableModel() throws IOException {

        FileReader fileReader = new FileReader(PATHFILE + "/datasource.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        String strTitleLine = bf.readLine(); // wczytanie pierwszej linii
        titleRow = strTitleLine.split(" ");  // powinno byc [\\t]
        for (String s : titleRow
        ) {
            System.out.print("T > " + s);
        }

    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }
    @Override
    public String getColumnName(int col) {
        return COLUMNS[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    @Override
    public Class<?> getColumnClass(int column) {
        if (column==2) return Integer.class;
        if (column==3) return ImageIcon.class;
        return Object.class;
    }

}
