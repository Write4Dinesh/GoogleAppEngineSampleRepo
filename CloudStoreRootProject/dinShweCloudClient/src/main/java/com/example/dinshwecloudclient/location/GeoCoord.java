package com.example.dinshwecloudclient.location;

public class GeoCoord {
private double longitude;
private double latitude;
private double altitude;
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getAltitude() {
	return altitude;
}
public void setAltitude(double altitude) {
	this.altitude = altitude;
}




@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	GeoCoord other = (GeoCoord) obj;
	if (altitude != other.altitude)
		return false;
	if (latitude != other.latitude)
		return false;
	if (longitude != other.longitude)
		return false;
	return true;
}
@Override
public String toString() {
	return "GeoCoord [longitude=" + longitude + ", latitude=" + latitude + ", altitude=" + altitude + "]";
}


}
