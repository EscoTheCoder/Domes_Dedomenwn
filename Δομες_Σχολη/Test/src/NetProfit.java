import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class NetProfit {

    String fileName;
    public DoubleQueueImpl<double[]> Buy_Stocks = new DoubleQueueImpl<double[]>();
    public DoubleQueueImpl<double[]> Sell_Stocks = new DoubleQueueImpl<double[]>();

    NetProfit(String fileName) {
        this.fileName = fileName;
    }


    public void read_from_file(){

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                for(int i=0; i<4; i++) {
                    System.out.print(parts[i]+ " ");
                }
                System.out.println();

                String command = parts[0];

                double quantity = Double.parseDouble(parts[1]);
                String price_text = parts[2]; //den xrhsimopoieitai pouthena
                double price = Double.parseDouble(parts[3]);


                double[] quantity_price = new double[2];

                quantity_price[0]=quantity;
                quantity_price[1]=price;

                if(command.equals("buy")){
                    Buy_Stocks.put(quantity_price);
                }
                else if (command.equals("sell")) {
                    Sell_Stocks.put(quantity_price);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public float calculate_Sum() {
        float netProfit = 0;

        while (!Sell_Stocks.isEmpty()) {
            double[] sellOrder = Sell_Stocks.get();
            double sellQuantity = sellOrder[0];
            double sellPrice = sellOrder[1];

            while (sellQuantity > 0) {
                if (Buy_Stocks.isEmpty()) {
                    throw new IllegalStateException("Den uparxoun arketes metoxes gia na ginei h pwslhsh pou zhthses.");
                }

                double[] buyOrder = Buy_Stocks.peek(); //1h agora apo thn queue
                double buyQuantity = buyOrder[0];
                double buyPrice = buyOrder[1];

                if (buyQuantity <= sellQuantity) {
                    //POULAME OLH THN POSOTHTA AUTHS THS AGORAS
                    netProfit += buyQuantity * (sellPrice - buyPrice);
                    sellQuantity -= buyQuantity;
                    Buy_Stocks.get(); // AFAIROUME THN AGORA AUTH APO THN QUEUE
                } else {
                    //MONO ENA MEROS THS AGORAS KALUPTEI THN PWLHSH
                    netProfit += sellQuantity * (sellPrice - buyPrice);
                    buyOrder[0] -= sellQuantity; ////ENHMERWNOUME THN POSOTHTA POU APOMENEI STHN AGORA
                    sellQuantity = 0;
                }

            }
        }
        return netProfit;
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("java NetProfit test.txt");
            return;
        }


        String fileName = args[0];


        NetProfit netProfitCalculator = new NetProfit(fileName);
        netProfitCalculator.read_from_file();
        try {
            double result = Math.ceil(netProfitCalculator.calculate_Sum()); //STROGILOPOIHSH PROS TA PANW
            System.out.println("TO KATHARO KERDOS EINAI : " + result + " EURO.");
        }
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
