public class App {
    public static void main(String[] args) throws Exception {
        RejseKort r;
        r = new RejseKort();
        r.checkIn(0, 0, 0);
		printCheckInStatus(r, 50);
		r.checkOut(0, 0, 100);
		printCheckInStatus(r, 150);
        System.out.println();
    }
    
    static void printCheckInStatus(RejseKort r, int time) {
        if (r.isCheckedIn(time)) {
            System.out.println("Card counts as a valid ticket at time " + time);
        } else {
            System.out.println("Card does not count as a valid ticket at time " + time);
        }
        }
}
