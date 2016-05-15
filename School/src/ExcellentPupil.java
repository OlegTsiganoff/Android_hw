/**
 * Created by oleg on 14.03.2016.
 */
public class ExcellentPupil extends Pupil {

    public ExcellentPupil(String name, int age) { super(name, age);}

    @Override
    public void Study() {
        System.out.println("Excellent study!");
    }

    @Override
    public void Read() {
        System.out.println("Excellent reading!");
    }

    @Override
    public void Write() {
        System.out.println("Excellent writing!");
    }

    @Override
    public void Relax() {
        System.out.println("Bad relaxing!");
    }
}
