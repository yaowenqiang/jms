public class StockProgram {
    private static StockList stockList =  new StockList();
    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 8.05, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.15, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.05, 200);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 90.99, 36);
        stockList.addStock(temp);
        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);
        temp = new StockItem("vase", 8.75, 44);
        stockList.addStock(temp);
        System.out.println(stockList);
        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket myBasket = new Basket("jack");
        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        sellItem(myBasket, "car", 1);
        sellItem(myBasket, "car", 1);
        sellItem(myBasket, "spanner", 1);
        sellItem(myBasket, "juice", 4);
        sellItem(myBasket, "cup", 4);
        sellItem(myBasket, "bread", 1);
        System.out.println(myBasket);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }


}
