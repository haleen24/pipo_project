package hse.pipo.mapper

import hse.pipo.dto.PipeAuthority
import hse.pipo.model.RegisterResponse
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants.ComponentModel

@Mapper(componentModel = ComponentModel.SPRING)
interface PipeAuthorityMapper {
    fun toRegisterResponse(pipeAuthority: PipeAuthority): RegisterResponse
}