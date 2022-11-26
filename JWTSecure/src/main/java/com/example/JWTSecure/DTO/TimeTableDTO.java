package com.example.JWTSecure.DTO;

import com.nimbusds.jose.util.Pair;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class TimeTableDTO implements Serializable{

    private List<SearchTimeTable> time_table;
//    private ArrayList<Map<LocalDate, String>> for_time;

}