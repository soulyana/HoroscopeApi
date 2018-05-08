package me.soulyana.horoscopeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Horoscope {

    private String date;
    private String horoscope;
    private String sunsign;
    private String week;
//    private Date month;
//    private Date year;

    public Horoscope() {

    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
//
//    public Date getMonth() {
//        return month;
//    }
//
//    public void setMonth(Date month) {
//        this.month = month;
//    }
//
//    public Date getYear() {
//        return year;
//    }
//
//    public void setYear(Date year) {
//        this.year = year;
//    }

    @Override
    public String toString() {
        return "Horoscope{" +
                "date=" + date +
                ", horoscope='" + horoscope + '\'' +
                ", sunsign='" + sunsign + '\'' +
//                ", week=" + week +
//                ", month=" + month +
//                ", year=" + year +
                '}';
    }
}
