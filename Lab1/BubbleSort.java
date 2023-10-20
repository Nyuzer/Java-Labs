class BubbleSort {
    public static void main(String[] args) {
        String text = "To be or not to be, that is the question;"
                +"Whether `tis nobler in the mind to suffer"
                +" the slings and arrows of outrageous fortune,"
                +" or to take arms against a sea of troubles,"
                +" and by opposing end them?";
        String cleanText = "";
        String tempstr;
        for (char i: text.toCharArray()) {
            if (Character.isLetter(i)) cleanText = cleanText + i;
            else if (Character.isWhitespace(i)) cleanText = cleanText + i;
        }
        cleanText = cleanText.toLowerCase();
        String[] words = cleanText.split(" ");
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (words[j + 1].compareTo(words[j])<0) {
                    tempstr = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = tempstr;
                }
            }

        }
        for (String i: words) {
            System.out.println(i);
        }
    }
}