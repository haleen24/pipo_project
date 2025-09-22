package hse.pipo.controller

import hse.pipo.api.PipoApi
import hse.pipo.mapper.PipeAuthorityMapper
import hse.pipo.model.Environment
import hse.pipo.model.RegisterRequest
import hse.pipo.model.RegisterResponse
import hse.pipo.service.ConsumerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PipoController(
    private val consumerService: ConsumerService,
    private val pipeAuthorityMapper: PipeAuthorityMapper
) : PipoApi {
    override fun createConsumer(tenant: String, registerRequest: RegisterRequest): ResponseEntity<RegisterResponse> {
        val pipeAuthority = consumerService.getConnectionAuthority(tenant, registerRequest.env.value)
            ?: return ResponseEntity.internalServerError().build()
        val registerResponse = pipeAuthorityMapper.toRegisterResponse(pipeAuthority)
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse)
    }

    override fun deleteConsumer(login: String): ResponseEntity<Unit> {
        consumerService.deleteConsumer(login)
        return ResponseEntity.noContent().build()
    }
}