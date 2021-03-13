package com.cton.model;

import com.github.skjolber.packing.Space;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchDTO {
    private String boxName;
    private int volume;
    private int mass;
    private int length;
    private int width;
    private int hight;
    private int[] space;

}
