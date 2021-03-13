package Util;


import java.math.BigDecimal;

public class NextUtil {
    private static double EARTH_RADIUS = 6378.137;
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }

    /*通过经纬度获取距离*/
    public static double getDistance(double lat1,double lng1,
                                     double lat2,double lng2){
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                        + Math.cos(radLat1) * Math.cos(radLat2)
                        * Math.pow(Math.sin(b / 2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        BigDecimal bigDecimal = new BigDecimal(s);
        double distance = bigDecimal.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
        return distance;
    }

    public static String getAzimuth(double lat1,double lng1,
                                    double lat2,double lng2){
        double result = 0.0;
        double ilat1 = 0.50 + lat1 * 360000.0;
        double ilat2 = 0.50 + lat2 * 360000.0;
        double ilng1 = 0.50 + lng1 * 360000.0;
        double ilng2 = 0.50 + lat2 * 360000.0;
        String location = "";
        lat1 = rad(lat1);
        lat2 = rad(lat2);
        lng1 = rad(lng1);
        lng2 = rad(lng2);

        if((ilat1 == ilat2) && (ilng1 == ilng2))
            location = "原地";
        else if(ilng1 == ilng2){
            if(ilat1 > ilat2)
                return String.valueOf(180.0);
        }else{
            double c = Math.acos(Math.sin(lat2) * Math.sin(lat1) + Math.cos(lat2)
                    * Math.cos(lat1) * Math.cos((lng2 - lng1)));
            double A = Math.asin(Math.cos(lat2) * Math.sin((lng2 - lng1))
                    / Math.sin(c));
            result = A * 180 / Math.PI;
            if ((ilat2 > ilat1) && (ilng2 > ilng1)) {
            } else if ((ilat2 < ilat1) && (ilng2 < ilng1)) {
                result = 180.0 - result;
            } else if ((ilat2 < ilat1) && (ilng2 > ilng1)) {
                result = 180.0 - result;
            } else if ((ilat2 > ilat1) && (ilng2 < ilng1)) {
                result += 360.0;
            }
        }
        double ss = result;
        if (ss >= 5 && 85 > ss) {
            location = "您的东北方";
        } else if(ss >= 85 && 95 > ss){
            location = "您的东方";
        }else if(ss >= 95 && 175 > ss){
            location = "您的东南方";
        }else if(ss >= 175 && 185 > ss){
            location = "您的南方";
        }else if(ss  >=185 && 265 > ss){
            location = "您的西南方";
        } else if(ss >= 265 && 275 > ss){
            location = "您的西方";
        }else if(ss >= 275 && 355 > ss){
            location = "您的西北方";
        }else{
            location = "您的北方";
        }
        return location;
    }
}
