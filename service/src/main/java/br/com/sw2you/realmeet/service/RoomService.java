package br.com.sw2you.realmeet.service;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotFoundException;
import static java.util.Objects.requireNonNull;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDTO getRoom(Long id){
        requireNonNull(id);
        Room room = roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
        return new RoomDTO().name(room.getName(name)).id(room.getId(id)).seats(room.getSeats(seats));
    }
}
