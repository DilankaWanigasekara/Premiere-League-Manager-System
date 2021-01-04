package com.premierleague.backend.console_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Source : https://www.logicbig.com/how-to/code-snippets/jcode-java-cmd-command-line-table.html
// This creates a table showing all team statistics in the premiere league
public class Table {
    private static final String HORIZONTAL = "-";
    private String vertical;
    private String join;
    private String[] headers;
    private List<String[]> rows = new ArrayList<>();
    private boolean rightAlign;

    public Table() {
        setShowVerticalLines(false);
    }

    public void setRightAlign(boolean rightAlign) {
        this.rightAlign = rightAlign;
    }

    public void setShowVerticalLines(boolean showVerticalLines) {
        vertical = showVerticalLines ? "|" : "";
        join = showVerticalLines ? "+" : " ";
    }

    public void setHeaders(String... headers) {
        this.headers = headers;
    }

    public void addRow( String... cells) {
        rows.add(cells);
    }

    public void print() {
        int[] maxWidths = headers != null ?
                Arrays.stream(headers).mapToInt(String::length).toArray() : null;

        for (String[] cells : rows) {
            if (maxWidths == null) {
                maxWidths = new int[cells.length];
            }
            if (cells.length != maxWidths.length) {
                throw new IllegalArgumentException("Number of row-cells and headers should be consistent");
            }
            for (int i = 0; i < cells.length; i++) {
                maxWidths[i] = Math.max(maxWidths[i], cells[i].length());
            }
        }

        if (headers != null) {
            printLine(maxWidths);
            printRow(headers, maxWidths);
            printLine(maxWidths);
        }
        for (String[] cells : rows) {
            printRow(cells, maxWidths);
        }
        if (headers != null) {
            printLine(maxWidths);
        }
    }

    private void printLine(int[] columnWidths) {
        for (int i = 0; i < columnWidths.length; i++) {
            String line = String.join("", Collections.nCopies(columnWidths[i] +
                    vertical.length() + 1, HORIZONTAL));
            System.out.print(join + line + (i == columnWidths.length - 1 ? join : ""));
        }
        System.out.println();
    }

    private void printRow(String[] cells, int[] maxWidths) {
        for (int i = 0; i < cells.length; i++) {
            String s = cells[i];
            String verStrTemp = i == cells.length - 1 ? vertical : "";
            if (rightAlign) {
                System.out.printf("%s %" + maxWidths[i] + "s %s", vertical, s, verStrTemp);
            } else {
                System.out.printf("%s %-" + maxWidths[i] + "s %s", vertical, s, verStrTemp);
            }
        }
        System.out.println();
    }


}


