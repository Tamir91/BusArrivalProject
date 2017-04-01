package MMN15;

/**
 * This class bild and work with linked list BusStopList. 
 * 
 * @author Aleksey Yurovskiy 
 * @ID 327153904
 */
public class BusStopList
{
    BusArrivalNode _head;

    /** This is constractor.
     * 
     */
    public BusStopList(){
        _head = null;
    }

    /** This method add new bus arrival into bus list if it sucsesfull return true.
     *  The method add arrival only if list hasn't similar arrival. Time complexity O(1)
     *  Space Complexity O(1)
     * @param int lineNumber - bus number;
     *        int noOfPassengers - number of passengers;
     *        Time1 arrivalTime - arrival time bus.
     * @return true if add sucsesfull.
     */
    public boolean add(int lineNumber,int noOfPassengers, Time1 arrivalTime){
        BusArrival busArr = new BusArrival(lineNumber, noOfPassengers, arrivalTime);

        //check if we not add similar BusArrival.//
        if( equalsInList(busArr) )
            return false;// not added node because busArr in list.

        if(_head == null)
            _head = new BusArrivalNode(busArr);
        else{
            BusArrivalNode busArrivalNode = new BusArrivalNode(busArr, _head);
            _head = busArrivalNode;
        }
        return true;
    }

    private boolean equalsInList(BusArrival b){
        //This method return true if it find BusArrival b in BusStopList.
        //Time complexity O(n). Space Complexity O(1)

        BusArrivalNode pointer = _head;

        while (pointer != null && !pointer.getBusArr().equals(b)){
            pointer = pointer.getNext();
        }
        if(pointer == null){
            return false;// if not find Bus Arrival return false.
        }
        return true;     // if find Bus Arrival return true.
    }

    /** This method remove all nodes with number's line "lineNum" from BusStopList.
     * Time complexity O(n). Space Complexity O(1)
     * @param int lineNum - removed node with lineNum.
     */
    public void removeAllLine(int lineNum){
        BusArrivalNode pointer = _head;
        BusArrivalNode prev = null;

        while(pointer != null){
            while (pointer!= null && pointer.getBusArr‬‬().getLineNum() != lineNum){
                prev = pointer;
                pointer = pointer.getNext();
            }

            if(prev == null)
                _head = _head.getNext();
            else if(pointer != null)
                prev.setNext(pointer.getNext() );
            if(pointer!= null)
                pointer = pointer.getNext();       
        }
    }

    /** This method return string representation of bus stop list. Time complexity O(n)
     *  Space Complexity O(1)
     *  @return String - str.
     */
    public String toString(){
        BusArrivalNode pointer = _head;
        String str = "";
        while( pointer != null){
            str += pointer.getBusArr‬‬().toString() + "\n";            
            pointer = pointer.getNext();
        }
        return str;
    }

    /**
     * This method return most popular line in list. Time complexity O(n) 
     * Space Complexity O(n)
     * @return int - nuber most popular line.
     */
    public int getPopularLine()
    {
        final int MAXIMUM_LINES = 99;
        int[] arrLine = new int [MAXIMUM_LINES + 1];// +1 because line number 99 included.
        BusArrivalNode pointer = _head;

        while(pointer != null){
            arrLine[pointer.getBusArr().getLineNum()] += + 1;
            pointer = pointer.getNext();
        }
        return getPopularLine(arrLine);
    }

    private int getPopularLine(int[] arrLine){
        /*  This method search biggest digit in array arrLine and return it.
        Time complexity O(n). Space Complexity O(1)                       */

        final int MAXIMUM_LINES = 99;
        int curIndexLine;
        int popularLine = 0;

        //Every cell of array this is bus line.
        for (curIndexLine = 0; curIndexLine < MAXIMUM_LINES; curIndexLine++){
            if(arrLine[curIndexLine] < arrLine[curIndexLine + 1]){
                popularLine = curIndexLine + 1;
            }
        }
        return popularLine;
    }

    /** This method return average waiting time for arrival bus any line. Time complexity O(n)
     *  Space Complexity O(1)
     *  @return long - seconds.
     */
    public long getAverageTime(){
        long elapsedTime = 0;
        int count = 0;//need for founding average.
        final int SEC_IN_MINUTE = 60;

        BusArrivalNode pointer = _head.getNext();
        BusArrivalNode prev = _head;

        while(pointer!= null){
            elapsedTime += prev.getBusArr‬‬().elapsedTime(pointer.getBusArr‬‬());

            prev = pointer;
            pointer = pointer.getNext();
            count++;
        }
        return elapsedTime/ count * SEC_IN_MINUTE;
    }

    /** This methos return total number of passengers in list. Time complexity O(n)
     *  Space Complexity O(1)
     *  @return int - number passengers in list.
     */
    public int totalPassengers(){
        int totalPassengers = 0;
        BusArrivalNode p = _head;

        while(p != null){
            totalPassengers += p.getBusArr‬‬().getNoOfPass();
            p = p.getNext();
        }
        return totalPassengers;
    }

    /** This method return bus arrival with max number passengers in list. Time complexity O(n)
     *  Space Complexity O(1)
     * @return BusArrival - max number passengers.
     */
    public BusArrival maxPassengers(){
        int pass = 0;
        BusArrivalNode maxPassengersResult = _head;
        BusArrivalNode pointer = _head.getNext();

        while(pointer != null){
            if(pointer.getBusArr‬‬().getNoOfPass() > maxPassengersResult.getBusArr‬‬().getNoOfPass())
                maxPassengersResult = pointer;
            pointer = pointer.getNext();
        }
        return new BusArrival(maxPassengersResult.getBusArr‬‬());
    }
}

