package hse.pipo.service

import hse.pipo.adapter.PipeAdapter
import hse.pipo.dto.PipeAuthority
import org.springframework.stereotype.Service

@Service
class ConsumerServiceImpl(
    private val pipeAdapter: PipeAdapter
) : ConsumerService {
    override fun getConnectionAuthority(tenant: String, env: String): PipeAuthority? =
        pipeAdapter.createConsumerAuthority("$tenant//$env")

    override fun deleteConsumer(login: String) {
        pipeAdapter.deleteConsumer(login)
    }
}