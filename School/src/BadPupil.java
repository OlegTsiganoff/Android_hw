/**
 * Created by oleg on 14.03.2016.
 */
public class BadPupil extends Pupil {

    public BadPupil(String name, int age) { super(name, age);}

    @Override
    public void Study() {

        System.out.println("Bad study!");
    }

    @Override
    public void Read() {
        System.out.println("Bad reading!");
    }

    @Override
    public void Write() {
        System.out.println("Bad writing!");
    }

    @Override
    public void Relax() {
        System.out.println("Excellent relaxing!");
    }
}
