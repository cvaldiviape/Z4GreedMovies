package com.facility.core.service.room;

import com.facility.core.entity.RoomEntity;
import com.facility.core.entity.mapper.RoomMapper;
import com.facility.core.repositories.RoomRespository;
import com.shared.core.service.impl.GenericFindAllByListIdsService;
import com.shared.dto.external.facility.RoomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllRoomByListIdsImpl")
public class FindAllRoomByListIdsImpl extends GenericFindAllByListIdsService<RoomEntity, RoomDto, Integer> {

    private final RoomRespository roomRespository;
    private final RoomMapper roomMapper;

    public FindAllRoomByListIdsImpl(RoomRespository roomRespository, RoomMapper roomMapper) {
        this.roomRespository = roomRespository;
        this.roomMapper = roomMapper;
    }

    @Override
    public JpaRepository<RoomEntity, Integer> getJpaRepository() {
        return this.roomRespository;
    }

    @Override
    public Collection<RoomDto> toListDtos(Collection<RoomEntity> listEntities) {
        return this.roomMapper.toListDtos(listEntities);
    }

}