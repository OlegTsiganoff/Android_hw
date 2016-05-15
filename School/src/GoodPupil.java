/**
 * Created by oleg on 14.03.2016.
 */
public class GoodPupil extends Pupil {

    public GoodPupil(String name, int age) { super(name, age);}

    @Override
    public void Study() {
        System.out.println("Good study!");
    }

    @Override
    public void Read() {
        System.out.println("Good reading!");
    }

    @Override
    public void Write() {
        System.out.println("Good writing!");
    }

    @Override
    public void Relax() {
        System.out.println("Good relaxing!");
    }
}
