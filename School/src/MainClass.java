import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 14.03.2016.
 */
public class MainClass {

    public  static  void main(String... args)
    {
        ExcellentPupil excellentPupil = new ExcellentPupil("Steve Jobs", 10);
        GoodPupil goodPupil = new GoodPupil("Charles Darwin", 12);
        BadPupil badPupil = new BadPupil("Bruis Dickinson", 13);

        List<Pupil> pupils = new ArrayList<Pupil>();
        pupils.add(excellentPupil);
        pupils.add(goodPupil);
        pupils.add(badPupil);
        ClassRoom classRoom = new ClassRoom(pupils);
        classRoom.showResults();

    }
}
