import java.util.ArrayList;

public class RepairSchedule
{
    /** Each element represents a repair by an individual mechanic in a bay. */
    private ArrayList<CarRepair> schedule;

    /** Number of mechanics available in this schedule. */
    private int numberOfMechanics;

    /** Constructs a RepairSchedule object.
     * Precondition: n >= 0
     */
    public RepairSchedule(int n)
    {
        numberOfMechanics = n;
        schedule = new ArrayList<CarRepair>();

    }

    public ArrayList<CarRepair> getSchedule()
    {
        return schedule;
    }

    /** Attempts to schedule a repair by a given mechanic in a given bay as described in part (a).
     * Precondition: 0 <= m < numberOfMechanics and b >= 0
     */
    public boolean addRepair(int m, int b)
    {
        boolean mechanicAvailable = true;
        boolean bayAvailable = true;
        for (CarRepair carRepair : schedule)
        {
            if(carRepair.getMechanicNum() == m)
            {
                mechanicAvailable = false;
            }
            if(carRepair.getBayNum() == b)
            {
                mechanicAvailable = false;
            }
        }
        if (bayAvailable && mechanicAvailable)
        {
            CarRepair repair = new CarRepair(m, b);
            schedule.add(repair);
            return true;
        }
        return false;
    }

    /** Returns an ArrayList containing the mechanic identifiers of all available mechanics,
     * as described in part (b).
     */
    public ArrayList<Integer> availableMechanics()
    {
        ArrayList<Integer> availableMechanics = new ArrayList<Integer> ();
        for(int i = 0; i < numberOfMechanics; i++)
        {
            int numAvailable = 0;
            for (CarRepair repair : schedule)
            {
                if(repair.getMechanicNum() == i )
                {
                    numAvailable++;
                }
            }
            if(numAvailable == 0)
            {
                availableMechanics.add(i);
            }
        }
        return availableMechanics;
    }

    /** Removes an element from schedule when a repair is complete. */
    public void carOut(int b)
    {
        for (int i = 0; i < schedule.size(); i++)
        {
            CarRepair carAtIdx = schedule.get(i);
            if (carAtIdx.getBayNum() == b)
            {
                schedule.remove(i);
            }
        }
    }
}