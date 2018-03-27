package com.bratek.transit.model;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DailyReport {
    private long totalDistance;
    private double totalPrice;
}
