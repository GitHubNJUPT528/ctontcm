package Util;

public final class LatLng {

    public final double latitude;
    public final double longitude;
    public final double latitudeE6;
    public final double longitudeE6;


    public LatLng(double var1, double var3) {
        if (!Double.isNaN(var1) && !Double.isNaN(var3) && !Double.isInfinite(var1) && !Double.isInfinite(var3)) {
            double var5 = var1 * 1000000.0D;
            double var7 = var3 * 1000000.0D;
            this.latitudeE6 = var5;
            this.longitudeE6 = var7;
            this.latitude = var5 / 1000000.0D;
            this.longitude = var7 / 1000000.0D;
        } else {
            this.latitudeE6 = 0.0D;
            this.longitudeE6 = 0.0D;
            this.latitude = 0.0D;
            this.longitude = 0.0D;
        }
    }


    public String toString() {
        String var1 = new String("latitude: ");
        var1 = var1 + this.latitude;
        var1 = var1 + ", longitude: ";
        var1 = var1 + this.longitude;
        return var1;
    }
}