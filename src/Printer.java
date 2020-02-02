public class Printer {
    private int tonerLevel;
    private int pagePrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel >=1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.duplex = duplex;
        this.pagePrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 200 ) {
            if (this.tonerLevel + tonerAmount > 100) {
                return -1;
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        } else {
            return -1;
        }
    }

    public int printPages(int pages) {
        int pagesToPrint = pages;
        if(this.duplex) {
            pagesToPrint /= 2;
            System.out.println("Printing in duplex mode");
        }
        this.pagePrinted += pagesToPrint;
        return pagesToPrint;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagePrinted() {
        return pagePrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
