package br.com.thonwelling.sptingBootTodoList.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapperMapping {
    @Autowired
    private static ModelMapper mapper = new ModelMapper();

    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destination){
        return mapper.map(origin, destination);
    }

    public static <Origin, Destination> List<Destination> parseObjects(List<Origin> origin, Class<Destination> destination){
        return origin.stream().map(origem -> mapper.map(origin, destination)).collect(Collectors.toList());
    }
}