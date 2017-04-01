package MMN15;

/**
 * This class bild bus arrival node.
 * 
 * @author Aleksey Yurovskiy
 * @ID 327153904
 */
public class BusArrivalNode
{
    private BusArrival _busArr;
    private BusArrivalNode _tail;

    /** This is constructor for BusArrivalNode.
     *  @param BusArrival b - object.
     */
    public BusArrivalNode (BusArrival b){
        _busArr = b;
        _tail = null;

    }

    /** This constructor for BusArrivalNode.
     *  @param BusArrival b - object;
     *         BusArrivalNode n - next object.
     */
    public BusArrivalNode (BusArrival b, BusArrivalNode n){
        _busArr = b;
        _tail = n;
    }

    /** This copy constructor for BusArrivalNode.
     *  @param BusArrivalNode b - object.
     */
    public BusArrivalNode (BusArrivalNode b){
        this._tail = b._tail;
        this._busArr = b._busArr;
    }

    /** This method return bus arrival object from BusArrivalNode.Time complexity O(1)
     *  @return BusArrival object
     */
    public BusArrival getBusArr‬‬(){
        return new BusArrival(_busArr);
    }

    /** This method return bus arrival object from next BusArrivalNode. Time complexity O(1)
     *  @return BusArrival object.
     */
    public BusArrivalNode getNext(){
        return _tail;
    }

    /** This method set new arrival bus in BusArrivalNode. Time complexity O(1)
     *  @param BusArrival b - object.
     */
    public void setBusArr (BusArrival b){
        this._busArr = b;
    }

    /** This method set new arrival for next bus. Time complexity O(1)
     *  @param BusArrivalNode next
     */
    public void setNext (BusArrivalNode next){
        this._tail = next;
    }
}
