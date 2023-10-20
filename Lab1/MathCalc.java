class MathCalc {
    public static void main(String[] args) {
        double earth = 7600.0;
        double sun = 865000.0;

        int radius_earth = (int) earth / 2;
        double volume_earth = (double) (4 / 3) * Math.PI * Math.pow(radius_earth, 3);

        int radius_sun = (int) sun / 2;
        double volume_sun = (double) (4 / 3) * Math.PI * Math.pow(radius_sun, 3);

        double ratio_sun_to_earth = volume_sun / volume_earth;
        System.out.println("The volume of the Earth is " + volume_earth + " cubic miles, the volume of the" +
                "sun is " + volume_sun + " cubic miles, and the ratio of the volume of the Sun to the volume " +
                "of the Earth is " + ratio_sun_to_earth);
    }
}