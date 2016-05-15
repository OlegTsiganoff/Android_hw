import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 14.03.2016.
 */
public class ClassRoom {

    List<Pupil> pupils;

    public List<Pupil> getPupils() { return pupils; }
    public void setPupils(List<Pupil> inPupilsList) { pupils = inPupilsList; }

    public ClassRoom(List<Pupil> pupilsList)
    {
        pupils = pupilsList;
    }

    public void addPupil(Pupil pupil)
    {
        if(pupils == null)
            pupils = new ArrayList<Pupil>();
        pupils.add(pupil);
    }

    public void showResults()
    {
        for (Pupil p : pupils)
        {
            System.out.println("Name: " + p.getName());
            System.out.println("Age: " + p.getAge());
            System.out.println("Results: ");
            p.Study();
            p.Read();
            p.Write();
            p.Relax();
            System.out.println("-------------------------");
        }
    }
}
