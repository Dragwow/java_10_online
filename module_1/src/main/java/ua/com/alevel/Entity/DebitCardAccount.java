package ua.com.alevel.Entity;

public class DebitCardAccount extends EntityData{

        private String plasticCard;
        private String platinumCard;
        private String goldCard;

    public String getPlasticCard() {
        return plasticCard;
    }

    public void setPlasticCard(String plasticCard) {
        this.plasticCard = plasticCard;
    }
    public String getPlatinumCard(){
        return platinumCard;
    }

    public String getGoldCard() {
        return goldCard;
    }

    public void setGoldCard(String goldCard) {
        this.goldCard = goldCard;
    }

    public void setPlatinumCard(String platinumCard) {
        this.platinumCard = platinumCard;
    }
}
