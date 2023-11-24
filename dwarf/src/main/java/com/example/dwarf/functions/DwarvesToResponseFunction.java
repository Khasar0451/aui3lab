package com.example.aui2.functions;

import com.example.aui2.dto.GetDwarvesResponse;
import com.example.aui2.entity.Dwarf;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@Component
public class DwarvesToResponseFunction implements Function<List<Dwarf>, GetDwarvesResponse> {   //Function is interface to change list to response. Helpful in map as argument
    @Override
    public GetDwarvesResponse apply(List<Dwarf> entities){                  //list to be changed
        return GetDwarvesResponse.builder()                                 //building response
                .dwarves(entities.stream()                                  //I can't simply give List as dwarves field, because I need only specified fields from it. Therefore - stream
                        .map(dwarf -> GetDwarvesResponse.Dwarf.builder()    //building class that is inside GetDwarvesResponse, the one that only have two fields
                                .name(dwarf.getName())
                                .id(dwarf.getUuid())
                                .build())
                        .toList())                                          //stream to list
                .build();
    }
}
