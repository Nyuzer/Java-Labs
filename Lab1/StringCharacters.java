class StringCharacters {
    public static void main(String[] args) {
        String text = "To be or not to be, that is the question;"
                +"Whether `tis nobler in the mind to suffer"
                +" the slings and arrows of outrageous fortune,"
                +" or to take arms against a sea of troubles,"
                +" and by opposing end them?";
        int spaces = 0, vowels = 0, letters = 0;
        for (int i = 0; i < text.length(); i++) {
            String temp = String.valueOf(text.charAt(i));
            if ("AEIOUY".contains(temp.toUpperCase())) {
                vowels++;
                continue;
            }
            if ("BCDFGHJKLMNPQRSTVXWZ".contains(temp.toUpperCase())) {
                letters++;
                continue;
            }
            if (temp.equals(" ")) spaces++;
        }
        System.out.println("Vowels " + vowels);
        System.out.println("Letters " + letters);
        System.out.println("Spaces " + spaces);
    }
}