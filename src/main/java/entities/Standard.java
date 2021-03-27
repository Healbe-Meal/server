package entities;

public class Standard {
    final double kfa = 1.3;

    public double countEnergyInStandart(int weight, int age, boolean sex) {
        if (sex) {
            if (age <= 30) {
                return (0.062 * weight + 2.036) * kfa * 240;
            }

            if (age <= 60) {
                return (0.034 * weight + 3.538) * kfa * 240;
            }

            return (0.038 * weight + 2.755) * kfa * 240;
        }

        if (age < 30) {
            return (0.063 * weight + 2.896) * kfa * 240;
        }

        if (age <= 60) {
            return (0.484 * weight + 3.653) * kfa * 240;
        }

        return (0.491 * weight + 2.459) * kfa * 240;
    }

    public String countIMT (double weight, double height) {
        height = height / 100;
        double imt = weight / (height * height);

        if (imt <= 16.5) {
            return "Выраженный дефицит массы";
        }

        if (imt <= 18.49) {
            return "Недостаточная (дефицит) масса тела";
        }

        if (imt <= 24.99) {
            return "Норма";
        }

        if (imt <= 29.99) {
            return "Избыточная масса тела";
        }

        if (imt <= 34.99) {
            return "Ожирение первой степени";
        }

        if (imt <= 39.99) {
            return "Ожирение второй степени";
        }

        return "Ожирение третей степени";
    }
}
