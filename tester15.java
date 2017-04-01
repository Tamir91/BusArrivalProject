package MMN15;

/**
 * Write a description of class tester15 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tester15
{
    public static void main(String[] args) 
    {

        // compilation tester for class BusStopList
        BusStopList busStopList = new BusStopList();

        int line = 10, pass = 14;
        Time1 t = new Time1 (9, 30 , 00);
        Time1 t1 = new Time1 (9, 40 , 00);
        Time1 t2 = new Time1 (10, 00 , 00);
        Time1 t3 = new Time1 (10, 30 , 00);

        busStopList.add(1, 10, t);
        busStopList.add(2, 11, t1);
        busStopList.add(3, 12, t2);
        busStopList.add(4, 20, t3);
        busStopList.add(5, 14, t3);
        busStopList.add(6, 15, t3);
        busStopList.add(99, 16, t3);
        busStopList.add(99, 17, t3);
        //busStopList.removeAllLine(9);
        //         
        System.out.println( "Is popular line: " + busStopList.getPopularLine());
        // 
        System.out.print(busStopList);

        // 
        //         int popularLineResult;
        //         popularLineResult = busStopList.getPopularLine();
        // 
        //         long getAverageTimeResult;
        //         getAverageTimeResult = busStopList.getAverageTime();
        //         System.out.println("\nAverageTime = " + getAverageTimeResult);
        // 
        //         int totalPassengersResult;
        //         totalPassengersResult = busStopList.totalPassengers();
        //         System.out.println("totalPassengersResult " + totalPassengersResult);
        // 
        //         BusArrival maxPassengersResult;
        //         maxPassengersResult = busStopList.maxPassengers();
        // 
        //         System.out.println("maxPassengersResult " + maxPassengersResult);

        // compilation tester for class BusArrivalNode
                 BusArrivalNode node;
        BusArrival ziv = new BusArrival(10, 20,t );

        node = new BusArrivalNode( ziv, null);
        
        //busStopList.maxPassengers().setNext(node);

    } // main
}
