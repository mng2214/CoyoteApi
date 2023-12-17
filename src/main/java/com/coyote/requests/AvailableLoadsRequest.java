package com.coyote.requests;

import com.models.CoyoteEnums;
import com.utils.LatLon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@ToString
@AllArgsConstructor
public class AvailableLoadsRequest {

    private Origin origin;
   // private Destination destination;
    private String equipmentType;
    private String mode;

    @Data
    @ToString
    public static class Origin {
        private Location location;
        private DeadheadRadius deadheadRadius;
        private Appointment appointment;

        @Data
        @ToString
        public static class Location {
            private Double latitude;
            private Double longitude;
        }

        @Data
        @ToString

        public static class DeadheadRadius {
            private int value;
            private String unit;
        }

        @Data
        @ToString

        public static class Appointment {
            private String appointmentStartDateTime;
            private String appointmentEndDateTime;
        }

    }

//    @Data
//    @ToString
//
//    public static class Destination {
//        private Location location;
//        private DeadheadRadius deadheadRadius;
//        private Appointment appointment;
//
//        @Data
//        @ToString
//
//        public static class Location {
//            private double latitude;
//            private double longitude;
//        }
//
//        @Data
//        @ToString
//
//        public static class DeadheadRadius {
//            private int value;
//            private String unit;
//        }
//
//        @Data
//        @ToString
//
//        public static class Appointment {
//            private String appointmentStartDateTime;
//            private String appointmentEndDateTime;
//
//
//        }
 //   }

    public static AvailableLoadsRequest reqBuilder() {
        Map<String, Double> locationData = LatLon.getLatLng("chicago", "il");

        Origin.Appointment appointment = new Origin.Appointment();
        appointment.setAppointmentStartDateTime("2023-12-18T10:00:00-06:00");
        appointment.setAppointmentEndDateTime("2023-12-20T20:00:00-06:00");

        Origin.DeadheadRadius deadheadRadius = new Origin.DeadheadRadius();
        deadheadRadius.setValue(200);
        deadheadRadius.setUnit("Miles");

        Origin.Location location = new Origin.Location();
        location.setLatitude(locationData.get("lat"));
        location.setLongitude(locationData.get("lon"));

        Origin origin = new Origin();
        origin.setLocation(location);
        origin.setDeadheadRadius(deadheadRadius);
        origin.setAppointment(appointment);
//
//        Map<String, Double> destData = LatLon.getLatLng("nashville", "tn");
//
//        Destination.Appointment appointmentDest = new Destination.Appointment();
//        appointmentDest.setAppointmentStartDateTime("2023-12-18T10:00:00-06:00");
//        appointmentDest.setAppointmentEndDateTime("2023-12-25T20:00:00-06:00");
//
//        Destination.DeadheadRadius deadheadRadiusDest = new Destination.DeadheadRadius();
//        deadheadRadiusDest.setValue(200);
//        deadheadRadiusDest.setUnit("Miles");
//
//        Destination.Location locationDest = new Destination.Location();
//        locationDest.setLatitude(destData.get("lat"));
//        locationDest.setLongitude(destData.get("lon"));
//
//        Destination destination = new Destination();
//        destination.setLocation(locationDest);
//        destination.setDeadheadRadius(deadheadRadiusDest);
//        destination.setAppointment(appointmentDest);

        return new AvailableLoadsRequest(origin, CoyoteEnums.EquipmentType.VR.toString(), CoyoteEnums.Mode.TL.toString());
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
