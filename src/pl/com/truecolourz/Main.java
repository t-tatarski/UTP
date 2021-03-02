package pl.com.truecolourz;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
UTP task 1 TomaszT so0168
 */

public class Main {
    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TableMk();
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Wyswietlenie tabeli nie powiodło się");
                }
            }
        });
    }

    public static String[][] getDataFromFile() throws IOException {
        List<String> list = new ArrayList<>();
        String[] dataLine;
        String[] titleLine;

        //
        final String PATHF = "/private/var/root/Downloads/utp_task1/src/pl/com/truecolourz/";

        FileReader fileReader = new FileReader(PATHF + "/datasource.txt");
        BufferedReader bf = new BufferedReader(fileReader);
        String strTitleLine = bf.readLine(); // wczytanie pierwszej linii
        titleLine = strTitleLine.split(" ");  // powinno byc [\\t]
        for (String s : titleLine
        ) {
            System.out.print("T > " + s);
        }
        String dataLns;

        while ((dataLns = bf.readLine()) != null) {
            dataLine = dataLns.split("    ");  // powinno byc [\\t]
            for (String sss : dataLine
            ) {
                System.out.print("> " + sss);
            }
            System.out.println("\n--------------------------------");
            list.add(dataLns);
        }
        System.out.println("");
        String[][] resultArray = new String[list.size() - 1][];
        for (int i = 0; i < list.size() - 1; i++) {

            String[] tmparr = list.get(i).split("\\t");
            System.out.println(tmparr[0]);
            System.out.print(tmparr.length + "");
            for (int j = 0; j < 3; j++) {
                resultArray[i] = tmparr;
                System.out.print(" + " + resultArray[i][j]);
            }
        }
        System.out.println("\n================================");
        return resultArray;
    }

    public static class TableMk extends JFrame {
        public TableMk() throws IOException {

            JTable jTable = new JTable(new JTableModel());
            jTable.setRowHeight(65);
            jTable.setGridColor(Color.BLUE);

            jTable.setDefaultRenderer(Integer.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    component.setForeground(((Integer) value) < 100000000 ? Color.BLACK : Color.RED);
                    return component;
                }
            });
            this.add(new JScrollPane(jTable));
            this.setTitle("panstwa dane");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            this.setVisible(true);
        }
    }
}
