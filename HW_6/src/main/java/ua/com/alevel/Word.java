package ua.com.alevel;

class Word {
    private String word;
    private long count;
    private double percentage;
    private long rating;

    public Word(String word, long count, double percentage) {
        this.word = word;
        this.count = count;
        this.percentage = percentage;
    }

    public String getWord() {
        return word;
    }

    public long getCount() {
        return count;
    }

    public double getPercentage() {
        return percentage;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
}
