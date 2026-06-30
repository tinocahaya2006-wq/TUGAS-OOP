package nilaimahasiswa.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class UITheme {

    public static final Color SIDEBAR = new Color(22, 47, 79);
    public static final Color SIDEBAR_HOVER = new Color(33, 66, 107);
    public static final Color PRIMARY = new Color(33, 110, 196);
    public static final Color PRIMARY_DARK = new Color(24, 84, 152);
    public static final Color BACKGROUND = new Color(244, 246, 250);
    public static final Color CARD = Color.WHITE;
    public static final Color TEXT_DARK = new Color(34, 41, 53);
    public static final Color TEXT_MUTED = new Color(120, 130, 145);
    public static final Color DANGER = new Color(214, 69, 65);
    public static final Color SUCCESS = new Color(46, 160, 100);

    public static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FONT_SUBTITLE = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_LABEL = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONT_BUTTON = new Font("Segoe UI", Font.BOLD, 13);
    public static final Font FONT_NAV = new Font("Segoe UI", Font.PLAIN, 14);

    public static void styleButtonPrimer(JButton btn) {
        btn.setBackground(PRIMARY);
        btn.setForeground(Color.WHITE);
        btn.setFont(FONT_BUTTON);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void styleButtonOutline(JButton btn, Color warna) {
        btn.setBackground(Color.WHITE);
        btn.setForeground(warna);
        btn.setFont(FONT_BUTTON);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(warna, 1, false));
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void styleTable(JTable table) {
        table.setRowHeight(28);
        table.setFont(FONT_LABEL);
        table.setSelectionBackground(new Color(214, 232, 250));
        table.setSelectionForeground(TEXT_DARK);
        table.setGridColor(new Color(230, 233, 238));

        JTableHeader header = table.getTableHeader();
        header.setFont(FONT_BUTTON);
        header.setBackground(SIDEBAR);
        header.setForeground(Color.BLACK);
        header.setPreferredSize(new Dimension(0, 32));
    }

    /**
     * Sama seperti styleTable(table), tapi sekaligus mengatur lebar kolom
     * berdasarkan bobot relatif (proporsi), supaya kolom dengan isi singkat
     * (mis. "Nilai", "Semester") tidak ikut melebar penuh saat window besar.
     * Jumlah elemen bobot harus sama dengan jumlah kolom tabel.
     */
    public static void styleTable(JTable table, int... bobotKolom) {
        styleTable(table);
        javax.swing.table.TableColumnModel cm = table.getColumnModel();
        int total = 0;
        for (int b : bobotKolom) total += b;
        if (total <= 0 || cm.getColumnCount() != bobotKolom.length) return;
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        for (int i = 0; i < bobotKolom.length; i++) {
            int width = Math.round(600f * bobotKolom[i] / total);
            cm.getColumn(i).setPreferredWidth(width);
        }
    }
}
