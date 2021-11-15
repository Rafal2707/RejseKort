public class RejseKort {
    private int balance;
    private boolean checked;
    private int timeOfCheckIn;
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;


    public RejseKort(){
        balance = 100;
        checked = false;

    }
    public void depositMoney(int dkk){
        if(dkk >= 0){
            balance +=dkk;
            System.out.println(dkk+ " DKK deposited. New balance: "+ balance + " DKK");
        }
        else System.out.println("Error: Cannot deposit negative amount");
    }

    public boolean isCheckedIn(int timeStamp){
        if(checked && timeStamp-timeOfCheckIn <= 120){
            checked = true;
        }
        return checked;
    }

    public void findMax(int x, int y){
        if(x < minX){
            minX = x;
        }
        if(y < minY){
            minY = y;
        }
        if(x > maxX){
            maxX = x;
        }
        if(y > maxY){
            maxY = y;
        }
    }
    public void checkIn(int x, int y, int timeStamp){
        if(balance < 100){
            System.out.println("Not enough money in account to check in. Please deposit at least "+ (100-balance) + " DKK");
        }
        if(balance >= 100){
            if(minX == 0 && minY==0){
                minX = x;
                minY = y;
            }
            findMax(x, y);
            if(checked == true){
                System.out.println("Continued journey ("+ (timeStamp-timeOfCheckIn) +" minutes since last check in)");
            }
            if(checked == false && balance >= 100){
                checked = true;
                System.out.println("Checked in");
            }
            timeOfCheckIn = timeStamp;
        }

    }
    public void checkOut(int x, int y, int timeStamp){
        findMax(x, y);
        int price = 12 + (maxX - minX + maxY - minY) * 3;
        if(balance  >= 100 && checked == true){
            if(price > 50){
                price  = 50;
            }
            System.out.println("Checked out! "+ (timeStamp-timeOfCheckIn) + " minutes since last check in. Price is "+ price + " DKK, remaining balance is "+(balance-price) + " DKK");
            balance = balance - price;
        }
        if(checked == false){
            System.out.println("Error: Cannot check out; Not currently checked in");
        }
        checked = false;
        }
}

