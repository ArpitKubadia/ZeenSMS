package com.example.arpit.zeensms;

public class marathiTranslation {
    public String getMarathiTranslation(String weather)
    {
        switch(weather){
            case "clear sky":weather="स्पष्ट आकाश"; break;
            case "few clouds":weather="काही ढग";break;
            case "scattered clouds":weather="विखुरलेले ढग";break;
            case "broken clouds":weather="तुटलेली ढग";break;
            case "shower rain":weather="पाऊस";break;
            case "rain":weather="पाऊस";break;
            case "thunderstorm":weather="गडगडाटी वादळ";break;
            case "snow":weather="हिमवर्षाव";break;
            case "mist":weather="धुके";break;
            case "thunderstorm with light rain":weather="हलका पाऊसांसह गडगडाटी वादळ";break;
            case "thunderstorm with rain":weather="पाऊस सह गडगडाटा";break;
            case "thunderstorm with heavy rain":weather="भारी पाऊस सह गडगडाटा";break;
            case "light thunderstorm":weather="गडगडाटी वादळ";break;
            case "heavy thunderstorm":weather="जोरदार गडगडाटी वादळ";break;
            case "ragged thunderstorm":weather="जीर्ण वीज";break;
            case "thunderstorm with light drizzle":weather="रिमझिम सह वीज";break;
            case "thunderstorm with drizzle":weather="रिमझिम सह वीज";break;
            case "thunderstorm with heavy drizzle":weather="रिमझिम सह वीज";break;
            case "light intensity drizzle":weather="रिमझिम";break;
            case "drizzle":weather="रिमझिम";break;
            case "heavy intensity drizzle":weather="रिमझिम";break;
            case "light intensity drizzle rain":weather="रिमझिम";break;
            case "drizzle rain":weather="रिमझिम पाऊस";break;
            case "heavy intensity drizzle rain":weather="जड तीव्रता रिमझिम पाऊस";break;
            case "shower rain and drizzle":weather="पाऊस आणि रिमझल";break;
            case "heavy shower rain and drizzle":weather="पाऊस आणि रिमझल";break;
            case "shower drizzle":weather="पाऊस आणि रिमझल";break;
            case "light rain":weather="रिमझिम पाऊस";break;
            case "moderate rain":weather="मध्यम पाऊस";break;
            case "heavy intensity rain":weather="जोरदार पाऊस\n";break;
            case "very heavy rain":weather="अतिशय जड पाऊस";break;
            case "extreme rain":weather="अत्यंत पाऊस";break;
            case "freezing rain":weather="थंड पाऊस";break;
            case "light intensity shower rain":weather="रिमझिम पाऊस";break;
            case "heavy intensity shower rain":weather="जोरदार पाऊस";break;
            case "ragged shower rain":weather="वारा पाऊस";break;
            case "smoke":weather="धूर";break;
            case "haze":weather="अस्पष्टता";break;
            case "sand, dust whirls":weather="वाळू, धूळ वावटळ";break;
            case "fog":weather="धुके";break;
            case "sand":weather="वाळू";break;
            case "dust":weather="धूळ";break;
            case "volcanic ash":weather="ज्वालामुखीचा राख";break;
            case "squalls":weather="चपळ";break;
            case "tornado":weather="तुफानी";break;
            case "overcast clouds":weather="ढगाळ ढग";break;
            default:break;
        }
        return weather;
    }
}
