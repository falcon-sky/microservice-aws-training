package com.dynamodb.app.module;

public class Parking {
  String carRegNo;
  String parkingNo;
  String parkingStatus;

  public String getCarRegNo() {
    return carRegNo;
  }

  public void setCarRegNo(String carRegNo) {
    this.carRegNo = carRegNo;
  }

  public String getParkingNo() {
    return parkingNo;
  }

  public void setParkingNo(String parkingNo) {
    this.parkingNo = parkingNo;
  }

  public String getParkingStatus() {
    return parkingStatus;
  }

  public void setParkingStatus(String parkingStatus) {
    this.parkingStatus = parkingStatus;
  }

}
