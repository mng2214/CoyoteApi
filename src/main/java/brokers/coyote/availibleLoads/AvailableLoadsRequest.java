package brokers.coyote.availibleLoads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.lang.model.util.Elements;

@Data
@AllArgsConstructor
public class AvailableLoadsRequest {
    private String equipmentType;
    private String mode;
    @Data
    @AllArgsConstructor
    public static class Origin {
        private Location location;
        private DeadheadRadius deadheadRadius;
        private Appointment appointment;
    }

    @Data
    @AllArgsConstructor
    public static class Destination {
        private Location location;
        private DeadheadRadius deadheadRadius;
        private Appointment appointment;
    }

    @Data
    @AllArgsConstructor
    public static class Location {
        private double latitude;
        private double longitude;
    }

    @Data
    @AllArgsConstructor
    public static class DeadheadRadius {
        private int value;
        private String unit;
    }

    @Data
    @AllArgsConstructor
    public static class Appointment {
        private String appointmentStartDateTime;
        private String appointmentEndDateTime;
    }


    public static AvailableLoadsRequest reqBuilder () {
return null;
    }
}



    /*
{
"origin": {
"location": {
"latitude": 41.9316,
"longitude": -87.6921
},
"deadheadRadius": {
"value": 120,
"unit": "Miles"
},
"appointment": {
"appointmentStartDateTime": "2023-12-14T14:00:00-06:00",
"appointmentEndDateTime": "2023-12-15T12:00:00-06:00"
}
},
"destination": {
"location": {
"latitude": 42.9316,
"longitude": -88.6921
},
"deadheadRadius": {
"value": 120,
"unit": "Miles"
},
"appointment": {
"appointmentStartDateTime": "2023-12-14T18:00:00-06:00",
"appointmentEndDateTime": "2023-12-15T12:00:00-06:00"
}
},
"equipmentType": "V",
"mode": "TL_LTL"
}
     */
