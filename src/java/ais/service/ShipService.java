package ais.service;

import java.util.*;
import javax.jws.*;

@WebService(serviceName="ShipService")
public class ShipService {
    
    Map<String, Ship> shipsMap = new HashMap<>();
    
    @WebMethod(operationName="addShip")
    public Ship addShip(
        @WebParam(name = "MMSI") String mmsi,
        @WebParam(name = "Name") String name,
        @WebParam(name = "Flag") String flag,
        @WebParam(name = "Type") String vtype,
        @WebParam(name = "Photo") byte[] photo,
        @WebParam(name = "GrossTonnage") int gtonnage){
        
        Ship newShip = new Ship(mmsi,name,flag,vtype,photo,gtonnage);
        shipsMap.put(mmsi, newShip); 
        
        return shipsMap.get(mmsi);
    }
    
    Map<String, Harbor> harborsMap = new HashMap<>();
    
    @WebMethod(operationName="addHarbor")
    public Harbor addHarbor(
        @WebParam(name = "Name") String name,
        @WebParam(name = "Country") String country,
        @WebParam(name = "Latitude") Float latitude,
        @WebParam(name = "Longitude") Float longitude){
        
        Harbor newHarbor = new Harbor(name,country,latitude,longitude);
        harborsMap.put(name, newHarbor); 
        
        return harborsMap.get(name);
    }

    @WebMethod(operationName = "downloadShipByMmsi")
    public Ship downloadShipByMmsi(
    @WebParam(name="MMSI") String mmsi)
    {
        return shipsMap.get(mmsi);
    }
    
    @WebMethod(operationName = "downloadHarborByName")
    public Harbor downloadHarborByName(
    @WebParam(name="name") String name)
    {
        return harborsMap.get(name);
    }
    
    @WebMethod(operationName = "countPosition")
    public String countPosition(
    @WebParam(name="name") String name,
    @WebParam(name="latitude") Float latitude,
    @WebParam(name="longitude") Float longitude,
    @WebParam(name="hlatitude") Float hLatitude,
    @WebParam(name="hlongitude") Float hLongitude,
    @WebParam(name="knots") Float knots)
    {
        float result;
        float x = (float) ((float) Math.pow((latitude - hLatitude), 2)+Math.pow((longitude - hLongitude), 2)); 
        float y = (float) Math.sqrt(x) * 111;
        float z = (float) (knots * 1.852);
        result = y / z;
        return Float.toString(result);
    }


}
