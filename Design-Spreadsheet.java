class Spreadsheet {
    private final Map<String, Integer> cells;
    public Spreadsheet(int rows) {
        cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        return getCellValue(parts[0]) + getCellValue(parts[1]);
    }
    private int getCellValue(String s) {
        if (Character.isDigit(s.charAt(0))) return Integer.parseInt(s);
        return cells.getOrDefault(s, 0);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */